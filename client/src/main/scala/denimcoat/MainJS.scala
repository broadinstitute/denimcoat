package denimcoat

import java.util.Date

import denimcoat.d3.{D3, Selection}
import denimcoat.mvp.Workflow
import denimcoat.mvp.Workflow.ResultItemSetInfo
import denimcoat.reasoners.knowledge.Relation
import denimcoat.reasoners.messages.{Request => ReasonerRequest, Response => ReasonerResponse}
import denimcoat.svg.MainSvg
import denimcoat.viewmodels.KeyMapper
import denimcoat.viewmodels.KeyMapper.EditAction
import org.scalajs.dom
import org.scalajs.dom.html.Button
import org.scalajs.dom.raw.{HTMLElement, HTMLInputElement, KeyboardEvent, XMLHttpRequest}
import org.scalajs.dom.{Event, MouseEvent}

import scala.scalajs.js

object MainJS {

  def printTime(selection: Selection[HTMLElement, _, _]): Unit = {
    val timeNow = new Date()
    selection.html(timeNow.toString)
  }

  def getReasonerIds: Seq[String] = {
    val inputElements = D3.selectAll(".reasoners").asOf[HTMLInputElement].nodes
    inputElements.filter(element => element.checked).map(element => element.value)
  }

  def getDefaultReasonerUrl(reasonerId: String): String = "/reasoner/" + reasonerId

  var answers: Map[Workflow.ResultItemSetInfo, Map[String, Either[String, ReasonerResponse]]] =
    Workflow.resultItemSetInfos.map(itemSet => (itemSet, Map.empty[String, Either[String, ReasonerResponse]])).toMap
  var items: Map[Workflow.ItemSetInfo, Seq[String]] =
    Workflow.itemSetInfos.map(itemSet => (itemSet, Seq.empty[String])).toMap

  def resetAnswers(resultItemSet: Workflow.ResultItemSetInfo): Unit = {
    answers += (resultItemSet -> Map.empty)
    items += (resultItemSet -> Seq.empty)
  }

  def addAnswer(itemSet: Workflow.ResultItemSetInfo, reasonerId: String,
                responseEither: Either[String, ReasonerResponse]): Unit = {
    val itemSetAnswers = answers(itemSet)
    answers += (itemSet -> (itemSetAnswers + (reasonerId -> responseEither)))
    responseEither match {
      case Left(_) => ()
      case Right(response) =>
        val responseTargetNodeNames = response.result_list.to[Set].flatMap { result =>
          val graph = result.result_graph
          val targetIds = graph.edge_list.to[Set].map(edge => edge.target_id)
          val nodeNames = graph.node_list.filter(node => targetIds.contains(node.id)).map(node => node.name)
          nodeNames
        }
        items += itemSet -> (items(itemSet) ++ responseTargetNodeNames).distinct
    }
  }

  def displayAnswers(): Unit = {
    displayResultSet0()
  }

  def receiveResponse(request: XMLHttpRequest, reasonerId: String): Event => Unit = { _: Event =>
    if (request.readyState == 4) {
      val responseJson = request.responseText
      val responseEither = JsonIO.decodeResponse(responseJson)
      addAnswer(Workflow.resultItemSetInfo0, reasonerId, responseEither)
      displayAnswers()
    }
  }

  def submitReasonerRequest(reasonerId: String, url: String, request: ReasonerRequest,
                            responseHandler: (XMLHttpRequest, String) => Event => Unit,
                            useProxy: Boolean = false): Unit = {
    val http = new XMLHttpRequest()
    http.onreadystatechange = responseHandler(http, reasonerId)
    val proxyBaseUrl = "/proxy/"
    val urlActual = if (useProxy) proxyBaseUrl + url else url
    http.open("POST", urlActual, async = true)
    http.setRequestHeader("Content-type", "application/json")
    http.setRequestHeader("Accept", "application/json")
    http.setRequestHeader("Access-Control-Allow-Origin", "*")
    http.setRequestHeader("Access-Control-Allow-Methods", "POST, GET")
    http.setRequestHeader("Access-Control-Allow-Headers", "Content-Type")
    val requestJson = JsonIO.encodeRequest(request)
    http.send(requestJson)
  }

  def queryDefaultReasoner(reasonerId: String, startItems: Seq[String], relation: Relation): Unit = {
    val url = getDefaultReasonerUrl(reasonerId)
    val request = ReasonerRequest(startItems, relation)
    submitReasonerRequest(reasonerId, url, request, receiveResponse)
  }

  // TODO generalize
  def displayResultSet0(): Unit = MainSvg.setOutputItems(items(Workflow.resultItemSetInfo0))

  def submitDiseaseClickHandler(datum: Any, index: Int, groupIndex: js.UndefOr[Int]): Unit = {
    submitDisease()
  }

  def submit(resultItemSetInfo: ResultItemSetInfo): Unit = {
    val inputItems = resultItemSetInfo.previousItems

    dom.window.alert(s"Submit $resultItemSetInfo.")
  }

  def submitDisease(): Unit = {
    val questionText = MainSvg.diseaseString.trim
    if (questionText == "") {
      dom.window.alert("Please enter a disease to submit.")
    } else {
      val reasonerIds = getReasonerIds
      if (reasonerIds.isEmpty) {
        dom.window.alert("Please check at least one reasoner.")
      } else {
        resetAnswers(Workflow.resultItemSetInfo0)
        displayAnswers()
        reasonerIds.foreach { reasonerId =>
          queryDefaultReasoner(reasonerId, Seq(questionText), Relation.hasSymptom)
        }
      }
    }
  }

  val exampleOneDisease = "type 2 diabetes mellitus"
  val exampleTwoDisease = "Behcet's disease"

  def setDiseaseExampleOne(datum: Any, index: Int, groupIndex: js.UndefOr[Int]): Unit = {
    MainSvg.diseaseString = exampleOneDisease
  }

  def setDiseaseExampleTwo(datum: Any, index: Int, groupIndex: js.UndefOr[Int]): Unit = {
    MainSvg.diseaseString = exampleTwoDisease
  }

  def clearDisease(datum: Any, index: Int, groupIndex: js.UndefOr[Int]): Unit = {
    MainSvg.diseaseString = ""
  }

  def handleKeypress(event: Event): Unit = {
    event match {
      case keyboardEvent: KeyboardEvent =>
        KeyMapper.getAction(keyboardEvent.key) match {
          case EditAction(_, edit) =>
            MainSvg.editInputString(edit)
            keyboardEvent.preventDefault()
          case KeyMapper.SpecialActions.enter =>
            submitDisease()
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

    D3.select("#diseaseSubmitButton").on("click", submitDiseaseClickHandler: (Any, Int, js.UndefOr[Int]) => Unit)
    D3.select("#diseaseExampleOneButton").on("click", setDiseaseExampleOne)
    D3.select("#diseaseExampleTwoButton").on("click", setDiseaseExampleTwo)
    D3.select("#diseaseClearButton").on("click", clearDisease)

    val submitButtonSetElement = dom.document.getElementById("submitButtonSet")
    Workflow.resultItemSetInfos.foreach { resultItemSetInfo =>
      val button = dom.document.createElement("button").asInstanceOf[Button]
      button.textContent = resultItemSetInfo.relationToPrevious.label
      button.onclick = (_: MouseEvent) => submit(resultItemSetInfo)
      submitButtonSetElement.appendChild(button)
    }


    D3.select("body").asOf[HTMLElement].node.addEventListener("keypress", handleKeypress, useCapture = false)

    MainSvg.diseaseString = ""

  }
}
