package denimcoat.svg

import org.scalajs.dom.svg.{RectElement, SVG}

class RectangleFacade(val svg: SVG, val element: RectElement) extends StylableElementFacade[RectElement] {

  def x: Double = element.x.baseVal.value

  def x_=(x: Double): Unit = element.x.baseVal.value = x

  def y: Double = element.y.baseVal.value

  def y_=(y: Double): Unit = element.y.baseVal.value = y

  def width: Double = element.width.baseVal.value

  def width_=(width: Double): Unit = element.width.baseVal.value = width

  def height: Double = element.height.baseVal.value

  def height_=(height: Double): Unit = element.height.baseVal.value = height
}

object RectangleFacade {
  def create(svg: SVG): RectangleFacade =
    new RectangleFacade(svg, SvgUtils.createSvgElement[RectElement]("rect"))
}
