package denimcoat

import java.util.Date

import denimcoat.d3.{D3, Selection}
import denimcoat.mvp.Workflow
import denimcoat.mvp.Workflow.ResultItemSetInfo
import denimcoat.reasoners.messages.{DefaultRequest, DefaultResponse}
import denimcoat.reasoners.mvp.{BioThingsExplorerUtils, MonarchInitiativeUtils}
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

  def printTime(selection: Selection[HTMLElement, _, _]): Unit = {
    val timeNow = new Date()
    selection.html(timeNow.toString)
  }

  def getSelectedReasonerIds(itemInfo: Workflow.ItemSetInfo): Seq[String] = {
    MainSvg.selectedReasoners(itemInfo)
  }

  def getDefaultReasonerUrl(reasonerId: String): String = "/reasoner/" + reasonerId

  var answers: Map[Workflow.ResultItemSetInfo, Map[String, Either[String, DefaultResponse]]] =
    Workflow.resultItemSetInfos.map(itemSet =>
      (itemSet, Map.empty[String, Either[String, DefaultResponse]])).toMap
  var items: Map[Workflow.ItemSetInfo, Seq[String]] =
    Workflow.itemSetInfos.map(itemSet => (itemSet, Seq.empty[String])).toMap

  def resetAnswers(resultItemSet: Workflow.ResultItemSetInfo): Unit = {
    answers += (resultItemSet -> Map.empty)
    items += (resultItemSet -> Seq.empty)
  }

  def addAnswer(itemSet: Workflow.ResultItemSetInfo, reasonerId: String,
                responseEither: Either[String, DefaultResponse]): Unit = {
    val itemSetAnswers = answers(itemSet)
    answers += (itemSet -> (itemSetAnswers + (reasonerId -> responseEither)))
    responseEither match {
      case Left(_) => ()
      case Right(response) =>
        val responseTargetNodeNames = {
          val result = response.result_list
          val targetIds = result.edge_list.to[Set].map(edge => edge.target_id)
          val nodeNames = result.node_list.filter(node => targetIds.contains(node.id)).map { node =>
            Entity.fromStrings(Seq(node.name, node.id)).toString
          }
          nodeNames
        }
        items += itemSet -> (items(itemSet) ++ responseTargetNodeNames).distinct
    }
  }

  def displayAnswers(resultItemSetInfo: ResultItemSetInfo): Unit = {
    displayResultSet(resultItemSetInfo)
  }

  def receiveResponse(request: XMLHttpRequest, reasonerId: String,
                      resultItemSetInfo: ResultItemSetInfo): Event => Unit = { _: Event =>
    if (request.readyState == 4) {
      val responseJson = request.responseText
      val responseEither = JsonIO.decodeResponse(responseJson)
      addAnswer(resultItemSetInfo, reasonerId, responseEither)
      displayAnswers(resultItemSetInfo)
    }
  }

  def submitReasonerRequest(reasonerId: String, resultItemSetInfo: ResultItemSetInfo, url: String,
                            requestOpt: Option[DefaultRequest],
                            responseHandler: (XMLHttpRequest, String, ResultItemSetInfo) => Event => Unit,
                            useProxy: Boolean = false): Unit = {
    val http = new XMLHttpRequest()
    http.onreadystatechange = responseHandler(http, reasonerId, resultItemSetInfo)
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
    startItems.flatMap(Entity.parse(_).getId("omim.disease")).foreach { startItem =>
      val url = BioThingsExplorerUtils.buildUrlDiseaseToSymptoms(startItem)
      submitReasonerRequest(reasonerId, resultItemSetInfo, url, None, receiveResponse, useProxy = true)
    }
  }

  private def notYetImplemented(what: String): Unit = {
    dom.window.alert("Not yet implemented: " + what)
  }

  def queryMonarchInitiative(reasonerId: String, startItems: Seq[String],
                             resultItemSetInfo: ResultItemSetInfo): Unit = {
    startItems.flatMap(Entity.parse(_).getId("hp")).foreach { startItem =>
      val url = MonarchInitiativeUtils.phenotypeToDiseaseUrl(startItem)
      notYetImplemented("queryMonarchInitiative")
//      val url = BioThingsExplorerUtils.buildUrlDiseaseToSymptoms(startItem)
//      submitReasonerRequest(reasonerId, resultItemSetInfo, url, None, receiveResponse, useProxy = true)
    }
  }

  def queryDefaultReasoner(reasonerId: String, startItems: Seq[String],
                           resultItemSetInfo: ResultItemSetInfo): Unit = {
    val url = getDefaultReasonerUrl(reasonerId)
    val request = DefaultRequest(startItems, resultItemSetInfo.relationToPrevious)
    submitReasonerRequest(reasonerId, resultItemSetInfo, url, Some(request), receiveResponse)
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
          } else if(reasonerId == ReasonerList.monarch.id) {
            queryMonarchInitiative(reasonerId, selectedItems, resultItemSetInfo)
          } else {
            queryDefaultReasoner(reasonerId, selectedItems, resultItemSetInfo)
          }
        }
      }
    }
  }

  val exampleOneDisease = "type 2 diabetes mellitus; omim.disease:125853"
  val exampleTwoDisease = "Behcet's disease; omim.disease:109650"

  def setDiseaseExampleOne(datum: Any, index: Int, groupIndex: js.UndefOr[Int]): Unit = {
    MainSvg.inputString = exampleOneDisease
  }

  def setDiseaseExampleTwo(datum: Any, index: Int, groupIndex: js.UndefOr[Int]): Unit = {
    MainSvg.inputString = exampleTwoDisease
  }

  def clearDisease(datum: Any, index: Int, groupIndex: js.UndefOr[Int]): Unit = {
    MainSvg.inputString = ""
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

    D3.select("#diseaseExampleOneButton").on("click", setDiseaseExampleOne)
    D3.select("#diseaseExampleTwoButton").on("click", setDiseaseExampleTwo)
    D3.select("#diseaseClearButton").on("click", clearDisease)

    D3.select("body").asOf[HTMLElement].node.addEventListener("keypress", handleKeypress, useCapture = false)

    MainSvg.inputString = ""

  }
}
