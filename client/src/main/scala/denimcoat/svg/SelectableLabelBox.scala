package denimcoat.svg

import org.scalajs.dom.raw.MouseEvent
import org.scalajs.dom.svg.{G, SVG}

class SelectableLabelBox(val svg: SVG, val element: G) extends ElementFacade[G] {

  private val label = TextFacade.create(svg, "blub", 0, 0)

  appendChild(label)

  element.onclick = (_: MouseEvent) => {
    selected = !selected
  }

  def x: Double = label.x

  def x_=(x: Double): Unit = label.x = x

  def y: Double = label.y

  def y_=(y: Double): Unit = label.y = y

  def text: String = label.text

  def text_=(text: String): Unit = label.text = text

  var selectedFlag: Boolean = false

  def selected: Boolean = selectedFlag

  def selected_=(selected: Boolean): Unit = {
    selectedFlag = selected
    label.style.fill = if (selectedFlag) "red" else "yellow"
  }
}

object SelectableLabelBox {
  def create(svg: SVG): SelectableLabelBox = new SelectableLabelBox(svg, SvgUtils.createSvgElement[G]("g"))
}
