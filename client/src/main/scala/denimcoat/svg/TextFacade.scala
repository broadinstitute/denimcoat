package denimcoat.svg

import denimcoat.gears.Property
import denimcoat.gears.providers.Provider
import denimcoat.gears.syntax.AllImplicits._
import org.scalajs.dom.svg.{SVG, Text}

class TextFacade(val svg: SVG, val element: Text) extends StylableElementFacade[Text] {
  val text: Property[String] = Property[String](element.textContent = _)
  val x: Property[Double] = Property[Double](x => element.setAttribute("x", x.toString))
  val y: Property[Double] = Property[Double](y => element.setAttribute("y", y.toString))
}

object TextFacade {

  def getById(svg: SVG, id: String): TextFacade =
    new TextFacade(svg, SvgUtils.getSvgElementById[Text](id))

  def create(svg: SVG, id: Provider[String], x: Provider[Double], y: Provider[Double]): TextFacade = {
    val text = new TextFacade(svg, SvgUtils.createSvgElement[Text]("text"))
    text.id := id
    text.x := x
    text.y := y
    text
  }
}