package denimcoat

import java.util.Date

import org.scalajs.dom.EventTarget
import org.singlespaced.d3js.{Selection, d3}

import scala.scalajs.js

object MainJS {

  def printTime(selection: Selection[EventTarget]): Unit = {
    val timeNow = new Date()
    selection.html(timeNow.toString)
  }

  def main(args: Array[String]): Unit = {
    printTime(d3.select("#loadTime"))

    js.timers.setInterval(200) {
      printTime(d3.select("#nowTime"))
    }

  }
}
