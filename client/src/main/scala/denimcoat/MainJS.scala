package denimcoat

import java.net.URI
import java.util.Date

import denimcoat.d3.{D3, Selection}
import denimcoat.reasoners.messages.{Request => ReasonerRequest, Response => ReasonerResponse}
import denimcoat.svg.MainSvg
import denimcoat.viewmodels.KeyMapper
import denimcoat.viewmodels.KeyMapper.EditAction
import io.circe.Decoder.Result
import org.scalajs.dom
import org.scalajs.dom.raw.{HTMLElement, HTMLInputElement, KeyboardEvent, XMLHttpRequest}
import org.scalajs.dom.Event

import scala.scalajs.js
import scala.scalajs.js.Dynamic.global
import io.circe._
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._
import io.circe.generic.semiauto._

object MainJS {

  @deprecated("This marks not implemented pieces of code", "Sun, June 17, 2018")
  def notYetImplemented(name: String): Unit = {
    global.console.log(s"$name is not yet implemented")
  }

  def printTime(selection: Selection[HTMLElement, _, _]): Unit = {
    val timeNow = new Date()
    selection.html(timeNow.toString)
  }

  def getReasonerIds: Seq[String] = {
    val inputElements = D3.selectAll(".reasoners").asOf[HTMLInputElement].nodes
    inputElements.filter(element => element.checked).map(element => element.value)
  }

  def getDefaultReasonerUrl(reasonerId: String): String = "/reasoner/" + reasonerId

  var symptomAnswers: Map[String, Either[Error, ReasonerResponse]] = Map.empty
  var symptoms: Set[String] = Set.empty

  def resetSymptomAnswers(): Unit = {
    symptomAnswers = Map.empty
    symptoms = Set.empty
  }

  def addSymptomAnswer(reasonerId: String, responseEither: Either[Error, ReasonerResponse]): Unit = {
    symptomAnswers += reasonerId -> responseEither
    responseEither match {
      case Left(error) => ()
      case Right(response) =>
        val responseTargetNodeNames = response.result_list.to[Set].flatMap { result =>
          val graph = result.result_graph
          val targetIds = graph.edge_list.to[Set].map(edge => edge.target_id)
          val nodeNames = graph.node_list.filter(node => targetIds.contains(node.id)).map(node => node.name)
          nodeNames
        }
        symptoms ++= responseTargetNodeNames
    }
  }

  def displayAnswers(): Unit = {
    displaySymptoms()
  }

  implicit val dateEncoder: Encoder[Date] = (date: Date) => date.getTime.asJson
  implicit val dateDecoder: Decoder[Date] = implicitly[Decoder[Long]].map(new Date(_))
  implicit val uriDecoder: Decoder[URI] = implicitly[Decoder[String]].map(new URI(_))
  implicit val anyDecoder: Decoder[Any] = implicitly[Decoder[Any]]

  def receiveResponse(request: XMLHttpRequest, reasonerId: String): Event => Unit = { _: Event =>
    if (request.readyState == 4) {
      val responseJson = request.responseText
      val responseEither = decode[ReasonerResponse](responseJson)
      addSymptomAnswer(reasonerId, responseEither)
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
    val requestJson = request.asJson.toString()
    http.send(requestJson)
  }

  def queryRtxReasoner(reasonerId: String, questionText: String): Unit = {
    notYetImplemented("queryRtxReasoner")
    // TODO
  }

  def queryIndigoReasoner(reasonerId: String, questionText: String): Unit = {
    notYetImplemented("queryIndigoReasoner")
    // TODO
  }

  def queryRobokopReasoner(reasonerId: String, questionText: String): Unit = {
    notYetImplemented("queryRobokopReasoner")
    // TODO
  }

  def queryDefaultReasoner(reasonerId: String, questionText: String): Unit = {
    val url = getDefaultReasonerUrl(reasonerId)
    val request = ReasonerRequest(questionText)
    submitReasonerRequest(reasonerId, url, request, receiveResponse)
  }

  def displaySymptoms(): Unit = MainSvg.setOutputItems(symptoms)

  def submitDiseaseClickHandler(datum: Any, index: Int, groupIndex: js.UndefOr[Int]): Unit = {
    submitDisease()
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
        resetSymptomAnswers()
        displayAnswers()
        reasonerIds.foreach { reasonerId =>
          if (reasonerId == "rtx") {
            queryRtxReasoner(reasonerId, questionText)
          } else if (reasonerId == "indigo") {
            queryIndigoReasoner(reasonerId, questionText)
          } else if (reasonerId == "robokop") {
            queryRobokopReasoner(reasonerId, questionText)
          } else {
            queryDefaultReasoner(reasonerId, questionText)
          }
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

    D3.select("body").asOf[HTMLElement].node.addEventListener("keypress", handleKeypress, false)

    MainSvg.diseaseString = ""

  }
}
