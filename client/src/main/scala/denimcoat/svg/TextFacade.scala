package denimcoat.svg

import org.scalajs.dom
import org.scalajs.dom.svg.{SVG, Text}
import org.singlespaced.d3js.d3

import scala.util.Try

class TextFacade(val svg: SVG, val element: Text) {

  def id: String = element.getAttribute("id")

  def id_=(id: String): Unit = element.setAttribute("id", id)

  def text: String = element.textContent

  def text_=(text: String): Unit = {
    element.textContent = text
    svg.forceRedraw()
  }

  def x: Int = Try(element.getAttribute("x").toInt).fold(Function.const(0), identity)

  def x_=(x: Int): Unit = element.setAttribute("x", x.toString)

  def y: Int = Try(element.getAttribute("y").toInt).fold(Function.const(0), identity)

  def y_=(y: Int): Unit = element.setAttribute("y", y.toString)

  def style: String = element.getAttribute("style")

  def style_=(style: String): Unit = {
    element.setAttribute("style", style)
    svg.forceRedraw()
  }

}

object TextFacade {

  def getById(svg: SVG, id: String): TextFacade =
    new TextFacade(svg, dom.document.getElementById(id).asInstanceOf[Text])

  def create(svg: SVG, id: String, x: Int, y: Int): TextFacade = {
    val text = new TextFacade(svg, dom.document.createElement("text").asInstanceOf[Text])
    text.id = id
    text.text = "Why?"
    text.style = "fill: yellow"
    text.x = x
    text.y = y
    text
  }
}