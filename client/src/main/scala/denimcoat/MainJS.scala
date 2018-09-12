package denimcoat

import java.util.Date

import denimcoat.d3.{D3, Selection}
import denimcoat.mvp.Workflow
import denimcoat.mvp.Workflow.ResultItemSetInfo
import denimcoat.reasoners.extract.{DefaultResponseExtractor, ResponseExtractor}
import denimcoat.reasoners.messages.DefaultRequest
import denimcoat.reasoners.mvp.{BioThingsExplorerUtils, MonarchInitiativeUtils}
import denimcoat.reasoners.plugin.{DefaultReasonerPlugin, MonarchInitiativePlugin, ReasonerPlugin}
import denimcoat.svg.MainSvg
import denimcoat.svg.mvp.ReasonerList
import denimcoat.util.Entity
import denimcoat.viewmodels.KeyMapper
import denimcoat.viewmodels.KeyMapper.EditAction
import org.scalajs.dom
import org.scalajs.dom.Event
import org.scalajs.dom.raw.{HTMLElement, KeyboardEvent, XMLHttpRequest}

import scala.scalajs.js

object MainJS {

  val weAreInDebugMode: Boolean = true

  def alert(message: String): Unit = {
    dom.window.alert(message)
  }

  def alertWhenDebugging(message: String): Unit = {
    if(weAreInDebugMode) {
      alert(message)
    }
  }

  def printTime(selection: Selection[HTMLElement, _, _]): Unit = {
    val timeNow = new Date()
    selection.html(timeNow.toString)
  }

  def getSelectedReasonerIds(itemInfo: Workflow.ItemSetInfo): Seq[String] = {
    MainSvg.selectedReasoners(itemInfo)
  }

  def getDefaultReasonerUrl(reasonerId: String): String = "/reasoner/" + reasonerId

  var answers: Map[Workflow.ResultItemSetInfo, Map[String, Either[String, ResponseExtractor]]] =
    Workflow.resultItemSetInfos.map(itemSet =>
      (itemSet, Map.empty[String, Either[String, ResponseExtractor]])).toMap
  var items: Map[Workflow.ItemSetInfo, Seq[String]] =
    Workflow.itemSetInfos.map(itemSet => (itemSet, Seq.empty[String])).toMap

  def resetAnswers(resultItemSet: Workflow.ResultItemSetInfo): Unit = {
    answers += (resultItemSet -> Map.empty)
    items += (resultItemSet -> Seq.empty)
  }

  def addAnswer(itemSet: Workflow.ResultItemSetInfo, reasonerId: String,
                responseExtractorEither: Either[String, ResponseExtractor]): Unit = {
    val itemSetAnswers = answers(itemSet)
    answers += (itemSet -> (itemSetAnswers + (reasonerId -> responseExtractorEither)))
    responseExtractorEither match {
      case Left(_) => ()
      case Right(responseExtractor) =>
        val responseTargetNodeNames = responseExtractor.targetNodeNames
        items += itemSet -> (items(itemSet) ++ responseTargetNodeNames).distinct
    }
  }

  def displayAnswers(resultItemSetInfo: ResultItemSetInfo): Unit = {
    displayResultSet(resultItemSetInfo)
  }

  def receiveResponse(request: XMLHttpRequest, plugin: ReasonerPlugin,
                      resultItemSetInfo: ResultItemSetInfo): Event => Unit = { _: Event =>
    if (request.readyState == 4) {
      val responseJson = request.responseText
      val responseExtractorEither = plugin.getExtractorFor(responseJson)
      if(weAreInDebugMode) {
        dom.window.alert(responseExtractorEither.toString + "\n" + responseJson.substring(0, 100))
      }
      addAnswer(resultItemSetInfo, plugin.reasonerId, responseExtractorEither)
      displayAnswers(resultItemSetInfo)
    }
  }

  def submitReasonerRequest(plugin: ReasonerPlugin, resultItemSetInfo: ResultItemSetInfo, url: String,
                            requestOpt: Option[DefaultRequest],
                            responseHandler: (XMLHttpRequest, ReasonerPlugin, ResultItemSetInfo) => Event => Unit,
                            useProxy: Boolean = false): Unit = {
    val http = new XMLHttpRequest()
    http.onreadystatechange = responseHandler(http, plugin, resultItemSetInfo)
    val proxyBaseUrl = "/proxy/"
    val urlActual = if (useProxy) proxyBaseUrl + url else url
    val protocol = if (requestOpt.isEmpty) "GET" else "POST"
    http.open(protocol, urlActual, async = true)
    http.setRequestHeader("Content-type", "application/json")
    http.setRequestHeader("Accept", "application/json")
    http.setRequestHeader("Access-Control-Allow-Origin", "*")
    http.setRequestHeader("Access-Control-Allow-Methods", "POST, GET")
    http.setRequestHeader("Access-Control-Allow-Headers", "Content-Type")
    requestOpt match {
      case Some(request) =>
        val requestJson = JsonIO.encodeRequest(request)
        http.send(requestJson)
      case None => http.send()
    }
  }

  def queryBioThingsExplorer(reasonerId: String, startItems: Seq[String],
                             resultItemSetInfo: ResultItemSetInfo): Unit = {
    val inIdPrefix = resultItemSetInfo.previousItems.prefix
    val outIdPrefix = resultItemSetInfo.prefix
    startItems.flatMap(Entity.parse(_).getId(inIdPrefix.string)).foreach { startItem =>
      val url = BioThingsExplorerUtils.buildUrl(inIdPrefix, outIdPrefix, startItem)
      alertWhenDebugging(url)
      submitReasonerRequest(DefaultReasonerPlugin(reasonerId), resultItemSetInfo, url, None, receiveResponse,
        useProxy = true)
    }
  }

  private def notYetImplemented(what: String): Unit = {
    dom.window.alert("Not yet implemented: " + what)
  }

  def queryMonarchInitiative(reasonerId: String, startItems: Seq[String],
                             resultItemSetInfo: ResultItemSetInfo): Unit = {
    val inIdPrefix = resultItemSetInfo.previousItems.prefix
    val outIdPrefix = resultItemSetInfo.prefix
    startItems.flatMap(Entity.parse(_).getId(inIdPrefix.string)).foreach { startItem =>
      val urlEither = MonarchInitiativeUtils.constructUrl(inIdPrefix, startItem, outIdPrefix)
      urlEither match {
        case Right(url) =>
          submitReasonerRequest(MonarchInitiativePlugin, resultItemSetInfo, url, None, receiveResponse,
            useProxy = true)
        case Left(message) => dom.window.alert(message)
      }
    }
  }

  def queryDefaultReasoner(reasonerId: String, startItems: Seq[String],
                           resultItemSetInfo: ResultItemSetInfo): Unit = {
    val url = getDefaultReasonerUrl(reasonerId)
    alertWhenDebugging(url)
    val request = DefaultRequest(startItems, resultItemSetInfo.relationToPrevious)
    submitReasonerRequest(DefaultReasonerPlugin(reasonerId), resultItemSetInfo, url, Some(request), receiveResponse)
  }

  def displayResultSet(resultItemSetInfo: ResultItemSetInfo): Unit =
    MainSvg.setOutputItems(resultItemSetInfo, items(resultItemSetInfo))

  def submit(resultItemSetInfo: ResultItemSetInfo): Unit = {
    val inputItemsInfo = resultItemSetInfo.previousItems
    val selectedItems = MainSvg.rowsByInfo(inputItemsInfo).selectedItems.filter(_.trim.nonEmpty)
    if (selectedItems.isEmpty) {
      dom.window.alert("No item(s) entered or selected.")
    } else {
      val reasonerIds = getSelectedReasonerIds(resultItemSetInfo)
      if (reasonerIds.isEmpty) {
        dom.window.alert("Please check at least one reasoner.")
      } else {
        resetAnswers(resultItemSetInfo)
        displayAnswers(resultItemSetInfo)
        reasonerIds.foreach { reasonerId =>
          if (reasonerId == ReasonerList.biothings.id) {
            queryBioThingsExplorer(reasonerId, selectedItems, resultItemSetInfo)
          } else if (reasonerId == ReasonerList.monarch.id) {
            queryMonarchInitiative(reasonerId, selectedItems, resultItemSetInfo)
          } else {
            queryDefaultReasoner(reasonerId, selectedItems, resultItemSetInfo)
          }
        }
      }
    }
  }

  def handleKeypress(event: Event): Unit = {
    event match {
      case keyboardEvent: KeyboardEvent =>
        KeyMapper.getAction(keyboardEvent.key) match {
          case EditAction(_, edit) =>
            MainSvg.editInputString(edit)
            keyboardEvent.preventDefault()
          case KeyMapper.SpecialActions.enter =>
            submit(Workflow.resultItemSetInfo0)
            keyboardEvent.preventDefault()
            keyboardEvent.stopPropagation()
          case _ => ()
        }
      case _ => ()
    }
  }

  def main(args: Array[String]): Unit = {
    printTime(D3.select("#loadTime").asOf[HTMLElement])

    js.timers.setInterval(200) {
      printTime(D3.select("#nowTime").asOf[HTMLElement])
    }

    D3.select("body").asOf[HTMLElement].node.addEventListener("keypress", handleKeypress, useCapture = false)

    MainSvg.inputString = ""

  }
}
