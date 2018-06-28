package denimcoat.svg

import org.scalajs.dom
import org.scalajs.dom.svg.SVG

object MainSvg {

  val id = "mainSvg"

  val svg: SVG = dom.document.getElementById(id).asInstanceOf[SVG]

  val x0 = 30
  val y0 = 50
  val y1 = 100

  val inputText: TextFacade = TextFacade.create(svg, "inputText", x0, y0)
  inputText.fill = "yellow"
  svg.appendChild(inputText.element)
  val outputText: TextFacade = TextFacade.create(svg, "outputText", x0, y1)
  outputText.fill = "yellow"
  svg.appendChild(outputText.element)

  def setInputText(text: String): Unit = inputText.text = text
  def setOutputText(text: String): Unit = outputText.text = text

}
