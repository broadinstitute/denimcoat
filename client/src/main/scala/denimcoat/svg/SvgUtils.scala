package denimcoat.svg

import org.scalajs.dom.raw.SVGElement
import org.scalajs.dom.document

object SvgUtils {

  val svgNs = "http://www.w3.org/2000/svg"

  def createSvgElement(name: String): SVGElement = document.createElementNS(svgNs, name).asInstanceOf[SVGElement]

}
