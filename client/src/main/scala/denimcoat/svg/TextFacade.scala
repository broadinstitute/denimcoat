package denimcoat.svg

import org.scalajs.dom.svg.{SVG, Text}

import scala.util.Try

class TextFacade(val svg: SVG, val element: Text) extends StylableElementFacade[Text] {

  def text: String = element.textContent

  def text_=(text: String): Unit = element.textContent = text

  def x: Double = Try(element.getAttribute("x").toDouble).fold(Function.const(0.0), identity)

  def x_=(x: Double): Unit = element.setAttribute("x", x.toString)

  def y: Double = Try(element.getAttribute("y").toDouble).fold(Function.const(0.0), identity)

  def y_=(y: Double): Unit = element.setAttribute("y", y.toString)

  def fill: String = element.getAttribute("fill")

  def fill_=(fill: String): Unit = element.setAttribute("fill", fill)

}

object TextFacade {

  def getById(svg: SVG, id: String): TextFacade =
    new TextFacade(svg, SvgUtils.getSvgElementById[Text](id))

  def create(svg: SVG, id: String, x: Double, y: Double): TextFacade = {
    val text = new TextFacade(svg, SvgUtils.createSvgElement[Text]("text"))
    text.id = id
    text.x = x
    text.y = y
    text
  }
}