package denimcoat

import java.util.Date

import org.scalajs.dom.EventTarget
import org.scalajs.dom
import org.singlespaced.d3js.{Selection, d3}

import scala.scalajs.js
import scala.scalajs.js.JSON
import scala.scalajs.js.annotation.JSName

object MainJS {

  def printTime(selection: Selection[EventTarget]): Unit = {
    val timeNow = new Date()
    selection.html(timeNow.toString)
  }

  def submitQuestion(): Unit = {
    val questionText = d3.select("#input").property("value").asInstanceOf[String].trim()
    if (questionText == "") {
      dom.window.alert("Please enter a question to submit.")
    } else {
      dom.window.alert(questionText)
    }
  }

  case class User(id: Int, name:String)

  def ohWow(): Unit = {
    val user = User(42, "Trillian")
    val userJson = JSON.stringify(user.asInstanceOf[js.Any], js.Array[js.Any](), 2)
    dom.window.alert(userJson)
  }

  def main(args: Array[String]): Unit = {
    ohWow()

    printTime(d3.select("#loadTime"))

    js.timers.setInterval(200) {
      printTime(d3.select("#nowTime"))
    }

    d3.select("#inputSubmitButton").on("click", (_: Any, _: Any, _: Any) => submitQuestion())

  }
}
