package denimcoat.svg

import org.scalajs.dom.svg.{Element, Stylable}

trait StylableElementFacade[E <: Element with Stylable] extends ElementFacade[E] {

  val style: Style = Style(element)

}

