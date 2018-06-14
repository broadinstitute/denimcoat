package denimcoat

import java.util.Date

import denimcoat.reasoners.messages.{Request => ReasonerRequest, Response => ReasonerResponse}
import org.scalajs.dom
import org.scalajs.dom.html.Html
import org.scalajs.dom.raw.{HTMLInputElement, XMLHttpRequest}
import org.scalajs.dom.{Event, EventTarget}
import org.singlespaced.d3js.{Selection, d3}

import scala.collection.mutable
import scala.scalajs.js

object MainJS {

  def printTime(selection: Selection[EventTarget]): Unit = {
    val timeNow = new Date()
    selection.html(timeNow.toString)
  }

  def getNodesFromSelection(selection: Selection[EventTarget]): Seq[EventTarget] = {
    selection.asInstanceOf[js.Dynamic].applyDynamic("nodes")().asInstanceOf[mutable.Seq[EventTarget]].toList
  }

  def getReasonerIds: Seq[String] = {
    val selection: Selection[EventTarget] = d3.selectAll(".reasoners")
    val nodes = getNodesFromSelection(selection)
    nodes.map(_.asInstanceOf[HTMLInputElement]).filter(element => element.checked).map(element => element.value)
  }

  def getDefaultReasonerUrl(reasonerId: String): String = "/reasoner/" + reasonerId

  class ReasonerHttpRequest(val reasonerId: String) extends XMLHttpRequest {

  }

  var answers: Map[String, ReasonerResponse] = Map.empty

  def addAnswer(reasonerId: String, response: ReasonerResponse): Unit = {
    answers += reasonerId -> response
  }

  def displayAnswers(): Unit = {} // TODO

  def receiveResponse(request: ReasonerHttpRequest): Event => Unit = { _: Event =>
    if (request.readyState == 4) {
      val responseJson = request.responseText
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
    val requestJson = "" // TODO
    http.send(requestJson)
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
      dom.window.alert(questionText)
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
