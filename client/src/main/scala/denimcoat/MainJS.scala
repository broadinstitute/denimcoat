package denimcoat

import java.util.Date

import denimcoat.d3.{D3, Selection}
import denimcoat.mvp.Workflow
import denimcoat.mvp.Workflow.{Derivation, ItemSetInfo}
import denimcoat.reasoners.extract.ResponseExtractor
import denimcoat.reasoners.messages.DefaultRequestBody
import denimcoat.reasoners.plugin.ReasonerPluginProvider
import denimcoat.reasoners.plugin.response.ReasonerResponsePlugin
import denimcoat.svg.MainSvg
import denimcoat.util.{Entity, FloodThrottler, UrlUtils}
import denimcoat.viewmodels.KeyMapper
import denimcoat.viewmodels.KeyMapper.EditAction
import org.scalajs.dom
import org.scalajs.dom.Event
import org.scalajs.dom.raw.{HTMLElement, KeyboardEvent, XMLHttpRequest}

import scala.scalajs.js
import scala.util.Try

object MainJS {

  val urlQuery: Map[String, String] = UrlUtils.parseQueryPart(dom.window.location.href)

  val weAreInDebugMode: Boolean =
    urlQuery.get("debug").flatMap(string => Try(string.toBoolean).toOption).getOrElse(false)

  val alertThrottler: FloodThrottler = FloodThrottler()

  def alert(message: String): Unit = {
    alertThrottler(dom.window.alert(message))
  }

  def alertWhenDebugging(message: => String): Unit = {
    if (weAreInDebugMode) {
      alert(message)
    }
  }

  def printTime(selection: Selection[HTMLElement, _, _]): Unit = {
    val timeNow = new Date()
    selection.html(timeNow.toString)
  }

  def getSelectedReasonerIds(itemInfo: Workflow.ItemSetInfo, derivation: Derivation): Seq[String] = {
    MainSvg.selectedReasoners(itemInfo, derivation)
  }

  def getDefaultReasonerUrl(reasonerId: String): String = "/reasoner/" + reasonerId

  var answers: Map[Workflow.ItemSetInfo, Map[String, Either[String, ResponseExtractor]]] =
    Workflow.itemSetInfos.map(itemSet =>
      (itemSet, Map.empty[String, Either[String, ResponseExtractor]])).toMap
  var items: Map[Workflow.ItemSetInfo, Seq[Entity]] =
    Workflow.itemSetInfos.map(itemSet => (itemSet, Seq.empty[Entity])).toMap

  def resetAnswers(resultItemSet: Workflow.ItemSetInfo): Unit = {
    answers += (resultItemSet -> Map.empty)
    items += (resultItemSet -> Seq.empty)
  }

  val reducer: Entity.Reducer = Entity.Reducer.byAnyId

  def addAnswer(itemSet: Workflow.ItemSetInfo, reasonerId: String,
                responseExtractorEither: Either[String, ResponseExtractor]): Unit = {
    val itemSetAnswers = answers(itemSet)
    answers += (itemSet -> (itemSetAnswers + (reasonerId -> responseExtractorEither)))
    responseExtractorEither match {
      case Left(_) => ()
      case Right(responseExtractor) =>
        items += itemSet -> reducer.reduce(items(itemSet) ++ responseExtractor.entities)
    }
  }

  def displayAnswers(itemSetInfo: ItemSetInfo): Unit = {
    displayResultSet(itemSetInfo)
  }

  def receiveResponse(request: XMLHttpRequest, plugin: ReasonerResponsePlugin,
                      resultItemSetInfo: ItemSetInfo): Event => Unit = { _: Event =>
    if (request.readyState == 4) {
      val responseJson = request.responseText
      val responseExtractorEither = plugin.getExtractorFor(responseJson)
        alertWhenDebugging(responseExtractorEither.toString + "\n" + responseJson.substring(0, 100))
      addAnswer(resultItemSetInfo, plugin.reasonerId, responseExtractorEither)
      displayAnswers(resultItemSetInfo)
    }
  }

  def submitReasonerRequest(plugin: ReasonerResponsePlugin, itemSetInfo: ItemSetInfo, url: String,
                            requestOpt: Option[DefaultRequestBody],
                            responseHandler: (XMLHttpRequest, ReasonerResponsePlugin, ItemSetInfo) => Event => Unit,
                            useProxy: Boolean = false): Unit = {
    val http = new XMLHttpRequest()
    http.onreadystatechange = responseHandler(http, plugin, itemSetInfo)
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

  def query(reasonerId: String, startItems: Seq[Entity], itemSetInfo: ItemSetInfo,
            derivation: Derivation): Unit = {
    val plugin = ReasonerPluginProvider.getReasonerPlugin(reasonerId)
    val inIdPrefix = derivation.previousSet.prefix
    val outIdPrefix = itemSetInfo.prefix
    val inputItems = startItems.flatMap(_.getId(inIdPrefix))
    val requestsEither = plugin.createRequests(derivation.relation, inIdPrefix, outIdPrefix, inputItems)
    requestsEither match {
      case Left(message) => alert(message)
      case Right(requests) =>
        alertWhenDebugging(requests.map(_.url).mkString("\n"))
        requests.foreach { request =>
          submitReasonerRequest(plugin.responsePlugin, itemSetInfo, request.url, request.bodyOpt, receiveResponse,
            useProxy = true)
        }
    }
  }

  def displayResultSet(itemSetInfo: ItemSetInfo): Unit =
    MainSvg.setOutputItems(itemSetInfo, items(itemSetInfo).map(_.toString))

  def submit(itemSetInfo: ItemSetInfo, derivation: Derivation): Unit = {
    val inputItemsInfo = derivation.previousSet
    val selectedItems = MainSvg.rowsByInfo(inputItemsInfo).selectedItems.filter(_.trim.nonEmpty)
    if (selectedItems.isEmpty) {
      alert("No item(s) entered or selected.")
    } else {
      val reasonerIds = getSelectedReasonerIds(itemSetInfo, derivation)
      if (reasonerIds.isEmpty) {
        alert("Please check at least one reasoner.")
      } else {
        resetAnswers(itemSetInfo)
        displayAnswers(itemSetInfo)
        reasonerIds.foreach {
          query(_, selectedItems.map(Entity.parse), itemSetInfo, derivation)
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
            submit(Workflow.resultItemSetInfo0, Workflow.resultItemSetInfo0.derivations.head)
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
