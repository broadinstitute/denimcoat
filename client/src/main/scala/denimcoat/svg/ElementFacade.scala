package denimcoat.svg

import denimcoat.svg.ElementFacade.Visibility
import org.scalajs.dom.raw.{Attr, SVGElement}
import org.scalajs.dom.svg.SVG

trait ElementFacade[E <: SVGElement] {
  def svg: SVG

  def element: E

  def appendChild[EC <: SVGElement](child: ElementFacade[EC]): Unit = {
    element.appendChild(child.element)
  }

  def id: String = element.getAttribute("id")

  def id_=(id: String): Unit = element.setAttribute("id", id)

  def visibility: Visibility = Visibility.dict(element.getAttribute("visibility"))

  def visibility_=(visibility: Visibility): Unit = element.setAttribute("visibility", visibility.toString)

}

object ElementFacade {

  sealed trait Visibility
  object Visibility {
    case object visible extends Visibility
    case object hidden extends Visibility
    case object collapse extends Visibility
    case object inherit extends Visibility
    val all: Set[Visibility] = Set(visible, hidden, collapse, inherit)
    val dict: Map[String, Visibility] = all.map(vis => (vis.toString, vis)).toMap
  }

}

