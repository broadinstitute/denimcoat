package denimcoat

import java.util.Date

import org.scalajs.dom
import org.scalajs.dom.{Event, EventTarget}
import org.scalajs.dom.raw.XMLHttpRequest
import org.singlespaced.d3js.{Selection, d3}

import scala.scalajs.js
import scala.scalajs.js.JSON

object MainJS {

  def printTime(selection: Selection[EventTarget]): Unit = {
    val timeNow = new Date()
    selection.html(timeNow.toString)
  }

  class ReasonerHttpRequest(val reasonerId: String) extends XMLHttpRequest {

  }

  trait ReasonerRequest

  trait ReasonerResponse

  def submitReasonerRequest(reasonerId: String, url: String, request: ReasonerRequest, responseHandler: => Unit,
                            useProxy: Boolean = false): Unit = {
    val http = new ReasonerHttpRequest(reasonerId)
    http.onreadystatechange = (_: Event) => responseHandler
    val proxyBaseUrl = "/proxy/"
    val urlActual = if (useProxy) proxyBaseUrl + url else url
    http.open("POST", urlActual, async = true)
    http.setRequestHeader("Content-type", "application/json")
    http.setRequestHeader("Accept", "application/json")
    val requestJson = ???
    http.send(requestJson)
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
