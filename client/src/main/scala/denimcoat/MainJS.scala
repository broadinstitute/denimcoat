package denimcoat

import java.net.URI
import java.util.Date

import denimcoat.reasoners.messages.{Request => ReasonerRequest, Response => ReasonerResponse}
import io.circe.Decoder.Result
import org.scalajs.dom
import org.scalajs.dom.raw.{HTMLInputElement, XMLHttpRequest}
import org.scalajs.dom.{Event, EventTarget}
import org.singlespaced.d3js.{Selection, d3}

import scala.collection.mutable
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

  def printTime(selection: Selection[EventTarget]): Unit = {
    val timeNow = new Date()
    selection.html(timeNow.toString)
  }

  def getNodesFromSelection(selection: Selection[EventTarget]): Seq[EventTarget] = {
    selection.asInstanceOf[js.Dynamic].selectDynamic("nodes").asInstanceOf[mutable.Seq[EventTarget]].toList
  }

  def getReasonerIds: Seq[String] = {
    val selection: Selection[EventTarget] = d3.selectAll(".reasoners")
    val selectionArray = selection.asInstanceOf[js.Array[js.Object]]
    val selectionSeq: mutable.Seq[js.Object] = selectionArray
    val inputElements = selectionSeq.flatMap { innerSelection =>
      val innerArray = innerSelection.asInstanceOf[js.Array[js.Object]]
      val innerSeq: mutable.Seq[js.Object] = innerArray
      innerSeq.map(_.asInstanceOf[HTMLInputElement])
    }
    inputElements.filter(element => element.checked).map(element => element.value)
  }

  def getDefaultReasonerUrl(reasonerId: String): String = "/reasoner/" + reasonerId

  var answers: Map[String, Either[Error, ReasonerResponse]] = Map.empty
  var targetNodeNames: Set[String] = Set.empty

  def addAnswer(reasonerId: String, responseEither: Either[Error, ReasonerResponse]): Unit = {
    answers += reasonerId -> responseEither
    responseEither match {
      case Left(error) => ()
      case Right(response) =>
        val responseTargetNodeNames = response.result_list.to[Set].flatMap { result =>
          val graph = result.result_graph
          val targetIds = graph.edge_list.to[Set].map(edge => edge.target_id)
          val nodeNames = graph.node_list.filter(node => targetIds.contains(node.id)).map(node => node.name)
          nodeNames
        }
        targetNodeNames ++= responseTargetNodeNames
    }
  }

  def displayAnswers(): Unit = {
    d3.select("#output").property("value", targetNodeNames.mkString(", "))
    d3.select("#answersRaw").property("value", answers.toString)
    notYetImplemented("displayAnswers")
  } // TODO

  implicit val dateEncoder: Encoder[Date] = (date: Date) => date.getTime.asJson
  implicit val dateDecoder: Decoder[Date] = implicitly[Decoder[Long]].map(new Date(_))
  implicit val uriDecoder: Decoder[URI] = implicitly[Decoder[String]].map(new URI(_))
  implicit val anyDecoder: Decoder[Any] = implicitly[Decoder[Any]]

  def receiveResponse(request: XMLHttpRequest, reasonerId: String): Event => Unit = { _: Event =>
    if (request.readyState == 4) {
      val responseJson = request.responseText
      dom.window.alert(responseJson)
      val responseEither = decode[ReasonerResponse](responseJson)
      dom.window.alert(responseEither.toString)
      addAnswer(reasonerId, responseEither)
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
    notYetImplemented("submitReasonerRequest")
    val requestJson = request.asJson.toString()
    dom.window.alert(urlActual + "\n" + requestJson)
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


  def submitQuestion(): Unit = {
    val questionText = d3.select("#input").property("value").asInstanceOf[String].trim()
    if (questionText == "") {
      dom.window.alert("Please enter a question to submit.")
    } else {
      val reasonerIds = getReasonerIds
      if (reasonerIds.isEmpty) {
        dom.window.alert("Please check at least one reasoner.")
      } else {
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

  val exampleInput = "What are targets of ibuprofen?"

  def setExample(): Unit = {
    d3.select("#input").property("value", exampleInput)
  }

  def clearInput(): Unit = {
    d3.select("#input").property("value", "")
  }

  def main(args: Array[String]): Unit = {
    printTime(d3.select("#loadTime"))

    js.timers.setInterval(200) {
      printTime(d3.select("#nowTime"))
    }

    d3.select("#inputSubmitButton").on("click", (_: Any, _: Any, _: Any) => submitQuestion())
    d3.select("#inputExampleButton").on("click", (_: Any, _: Any, _: Any) => setExample())
    d3.select("#inputClearButton").on("click", (_: Any, _: Any, _: Any) => clearInput())

  }
}
