package denimcoat.svg

import denimcoat.gears.Property
import org.scalajs.dom.svg.{RectElement, SVG}

class RectangleFacade(val svg: SVG, val element: RectElement) extends StylableElementFacade[RectElement] {

  val x: Property[Double] = Property[Double](x => element.x.baseVal.value = x)
  val y: Property[Double] = Property[Double](y => element.y.baseVal.value = y)
  val width: Property[Double] = Property[Double](width => element.width.baseVal.value = width)
  val heightProp: Property[Double] = Property[Double](height => element.height.baseVal.value = height)
}

object RectangleFacade {
  def create(svg: SVG): RectangleFacade =
    new RectangleFacade(svg, SvgUtils.createSvgElement[RectElement]("rect"))
}
