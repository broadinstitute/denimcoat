package denimcoat.svg

import denimcoat.gears.Property
import denimcoat.svg.Style.WhiteSpace
import org.scalajs.dom.css.StyleDeclaration
import org.scalajs.dom.svg.{Element, Stylable}

class Style(val style: StyleDeclaration) {
  val fill: Property[String] = Property[String](style.fill = _)
  val stroke: Property[String] = Property[String](style.stroke = _)
  val width: Property[String] = Property[String](style.width = _)
  val whiteSpace: Property[WhiteSpace] = Property[WhiteSpace](whiteSpace => style.whiteSpace = whiteSpace.toString)
}

object Style {

  def apply(style: StyleDeclaration): Style = new Style(style)
  def apply(element: Element with Stylable): Style = apply(element.style)

  sealed trait WhiteSpace

  object WhiteSpace {

    case object normal extends WhiteSpace

    case object nowrap extends WhiteSpace

    case object pre extends WhiteSpace

    case object `pre-line` extends WhiteSpace

    case object `pre-wrap` extends WhiteSpace

    case object initial extends WhiteSpace

    case object inherit extends WhiteSpace

    val all: Set[WhiteSpace] = Set(normal, nowrap, pre, `pre-line`, `pre-wrap`, initial, inherit)
    val dict: Map[String, WhiteSpace] = all.map(wss => (wss.toString, wss)).toMap
  }
}
