package denimcoat

import java.util.Date

import denimcoat.reasoners.messages.{Request => ReasonerRequest, Response => ReasonerResponse}
import org.scalajs.dom
import org.scalajs.dom.raw.{HTMLInputElement, XMLHttpRequest}
import org.scalajs.dom.{Event, EventTarget}
import org.singlespaced.d3js.{Selection, d3}

import scala.collection.mutable
import scala.scalajs.js
import scala.scalajs.js.Dynamic.global

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

  class ReasonerHttpRequest(val reasonerId: String) extends XMLHttpRequest {

  }

  var answers: Map[String, ReasonerResponse] = Map.empty

  def addAnswer(reasonerId: String, response: ReasonerResponse): Unit = {
    answers += reasonerId -> response
  }

  def displayAnswers(): Unit = {
    notYetImplemented("displayAnswers")
  } // TODO

  def receiveResponse(request: ReasonerHttpRequest): Event => Unit = { _: Event =>
    if (request.readyState == 4) {
      val responseJson = request.responseText
      notYetImplemented("receiveResponse")
      // TODO
      //      val answer = ??? // JSON.parse(responseJson)
      //      addAnswer(request.reasonerId, answer)
      displayAnswers()
    }
  }


  def submitReasonerRequest(reasonerId: String, url: String, request: ReasonerRequest,
                            responseHandler: ReasonerHttpRequest => Event => Unit,
                            useProxy: Boolean = false): Unit = {
    val http = new ReasonerHttpRequest(reasonerId)
    http.onreadystatechange = (_: Event) => responseHandler
    val proxyBaseUrl = "/proxy/"
    val urlActual = if (useProxy) proxyBaseUrl + url else url
    http.open("POST", urlActual, async = true)
    http.setRequestHeader("Content-type", "application/json")
    http.setRequestHeader("Accept", "application/json")
    notYetImplemented("submitReasonerRequest")
    val requestJson = "" // TODO
    http.send(requestJson)
  }

  def queryRtxReasoner(reasonerId: String, questionText: String): Unit ={
    notYetImplemented("queryRtxReasoner")
    // TODO
  }

  def queryIndigoReasoner(reasonerId: String, questionText: String): Unit ={
    notYetImplemented("queryIndigoReasoner")
    // TODO
  }

  def queryRobokopReasoner(reasonerId: String, questionText: String): Unit ={
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
      if(reasonerIds.isEmpty) {
        dom.window.alert("Please check at least one reasoner.")
      } else {
        reasonerIds.foreach{ reasonerId =>
          if (reasonerId == "rtx") {
            queryRtxReasoner(reasonerId, questionText);
          } else if (reasonerId == "indigo") {
            queryIndigoReasoner(reasonerId, questionText);
          } else if (reasonerId == "robokop") {
            queryRobokopReasoner(reasonerId, questionText);
          } else {
            queryDefaultReasoner(reasonerId, questionText);
          }
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    printTime(d3.select("#loadTime"))

    js.timers.setInterval(200) {
      printTime(d3.select("#nowTime"))
    }

    d3.select("#inputSubmitButton").on("click", (_: Any, _: Any, _: Any) => submitQuestion())

  }
}
