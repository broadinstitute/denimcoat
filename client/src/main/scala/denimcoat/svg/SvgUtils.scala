package denimcoat.svg

import org.scalajs.dom.raw.SVGElement
import org.scalajs.dom.document

object SvgUtils {

  val svgNs = "http://www.w3.org/2000/svg"

  def getSvgElementById[E <: SVGElement](id: String): E = document.getElementById(id).asInstanceOf[E]

  def createSvgElement[E <: SVGElement](name: String): E = document.createElementNS(svgNs, name).asInstanceOf[E]

}
