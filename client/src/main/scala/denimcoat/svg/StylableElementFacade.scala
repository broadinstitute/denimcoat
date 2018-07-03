package denimcoat.svg

import org.scalajs.dom.css.StyleDeclaration
import org.scalajs.dom.svg.{Element, Stylable}

trait StylableElementFacade[E <: Element with Stylable] extends ElementFacade[E] {

  def style: StyleDeclaration = element.style

}
