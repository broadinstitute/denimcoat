package denimcoat.svg

import org.scalajs.dom
import org.scalajs.dom.svg.SVG

object MainSvg {

  val id = "mainSvg"

  val svg: SVG = dom.document.getElementById(id).asInstanceOf[SVG]

  val inputText: TextFacade = TextFacade.create(svg, "inputText", 100, 100)

  inputText.fill = "yellow"

  svg.appendChild(inputText.element)

  def setInputText(text: String): Unit = inputText.text = text

}
