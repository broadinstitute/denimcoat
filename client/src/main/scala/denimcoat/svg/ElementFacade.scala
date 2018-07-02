package denimcoat.svg

import org.scalajs.dom.raw.{Attr, SVGElement}
import org.scalajs.dom.svg.SVG

trait ElementFacade[E <: SVGElement] {
  def svg: SVG

  def element: E

  def id: String = element.getAttribute("id")

  def id_=(id: String): Unit = element.setAttribute("id", id)

}

