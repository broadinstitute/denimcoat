package denimcoat.svg

import org.scalajs.dom.svg.{Line, SVG, Text}

import scala.util.Try

class LineFacade(val svg: SVG, val element: Line) extends ElementFacade[Line] {
  def x1: Int = Try(element.getAttribute("x1").toInt).fold(Function.const(0), identity)

  def x1_=(x: Int): Unit = element.setAttribute("x1", x.toString)

  def y1: Int = Try(element.getAttribute("y1").toInt).fold(Function.const(0), identity)

  def y1_=(y: Int): Unit = element.setAttribute("y1", y.toString)

  def x2: Int = Try(element.getAttribute("x2").toInt).fold(Function.const(0), identity)

  def x2_=(x: Int): Unit = element.setAttribute("x2", x.toString)

  def y2: Int = Try(element.getAttribute("y2").toInt).fold(Function.const(0), identity)

  def y2_=(y: Int): Unit = element.setAttribute("y2", y.toString)
}

object LineFacade {

  def getById(svg: SVG, id: String): LineFacade =
    new LineFacade(svg, SvgUtils.getSvgElementById[Line](id))

  def create(svg: SVG, id: String, x1: Int, y1: Int, x2: Int, y2: Int): LineFacade = {
    val line = new LineFacade(svg, SvgUtils.createSvgElement[Line]("line"))
    line.id = id
    line.x1 = x1
    line.y1 = y1
    line.x2 = x2
    line.y2 = y2
    line
  }


}