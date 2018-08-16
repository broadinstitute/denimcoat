package denimcoat.svg

import denimcoat.gears.Property
import denimcoat.gears.providers.Var
import org.scalajs.dom.raw.MouseEvent
import org.scalajs.dom.svg.{G, SVG}
import denimcoat.gears.syntax.AllImplicits._

class SelectableLabelBox(val svg: SVG, val element: G) extends ElementFacade[G] {

  private val label = TextFacade.create(svg, "blub", 0.0, 0.0)

  appendChild(label)

  val selectedVar: Var[Boolean] = Var(false)

  element.onclick = (_: MouseEvent) => {
    selectedVar.modify(!_)
  }

  val x: Property[Double] = label.x
  val y: Property[Double] = label.y
  val text: Property[String] = label.text

  label.style.fill := selectedVar.map(if(_) "red" else "yellow")
}

object SelectableLabelBox {
  def create(svg: SVG): SelectableLabelBox = new SelectableLabelBox(svg, SvgUtils.createSvgElement[G]("g"))
}
