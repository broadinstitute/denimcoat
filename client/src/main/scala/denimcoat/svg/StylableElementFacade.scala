package denimcoat.svg

import org.scalajs.dom.raw.{CSSStyleDeclaration, SVGElement, SVGStylable}

trait StylableElementFacade[E <: SVGElement with SVGStylable] extends ElementFacade[E] {

  def style: CSSStyleDeclaration = element.style

}
