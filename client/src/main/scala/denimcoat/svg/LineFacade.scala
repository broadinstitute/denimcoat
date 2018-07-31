package denimcoat.svg

import denimcoat.gears.Property
import denimcoat.gears.providers.Provider
import denimcoat.gears.syntax.AllImplicits._
import org.scalajs.dom.svg.{Line, SVG}

class LineFacade(val svg: SVG, val element: Line) extends StylableElementFacade[Line] {
  val x1: Property[Double] = Property[Double](x1 => element.setAttribute("x1", x1.toString))
  val y1: Property[Double] = Property[Double](y1 => element.setAttribute("y1", y1.toString))
  val x2: Property[Double] = Property[Double](x2 => element.setAttribute("x2", x2.toString))
  val y2: Property[Double] = Property[Double](y2 => element.setAttribute("y2", y2.toString))
}

object LineFacade {

  def getById(svg: SVG, id: String): LineFacade = {
    val line = new LineFacade(svg, SvgUtils.getSvgElementById[Line](id))
    line.id := id
    line
  }

  def create(svg: SVG, id: Provider[String], x1: Provider[Double], y1: Provider[Double],
             x2: Provider[Double], y2: Provider[Double]): LineFacade = {
    val line = new LineFacade(svg, SvgUtils.createSvgElement[Line]("line"))
    line.id := id
    line.x1 := x1
    line.y1 := y1
    line.x2 := x2
    line.y2 := y2
    line
  }


}