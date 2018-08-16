package denimcoat.svg

import denimcoat.gears.Property
import denimcoat.gears.syntax.AllImplicits._
import org.scalajs.dom.raw.MouseEvent
import org.scalajs.dom.svg.{G, SVG}

class LabelledButton(val svg: SVG, val element: G, clickAction: MouseEvent => Unit) extends ElementFacade[G] {

  private val label = TextFacade.create(svg, "blub", 0.0, 0.0)

  appendChild(label)

  element.onclick = (mouseEvent: MouseEvent) => {
    clickAction(mouseEvent)
  }

  val x: Property[Double] = label.x
  val y: Property[Double] = label.y
  val text: Property[String] = label.text

}

object LabelledButton {
  def create(svg: SVG, clickAction: MouseEvent => Unit): LabelledButton =
    new LabelledButton(svg, SvgUtils.createSvgElement[G]("g"), clickAction)
}
