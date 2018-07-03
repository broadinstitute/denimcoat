package denimcoat.svg

import org.scalajs.dom.svg.Element
import org.scalajs.dom.document

object SvgUtils {

  val svgNs = "http://www.w3.org/2000/svg"

  def getSvgElementById[E <: Element](id: String): E = document.getElementById(id).asInstanceOf[E]

  def createSvgElement[E <: Element](name: String): E = document.createElementNS(svgNs, name).asInstanceOf[E]

}
