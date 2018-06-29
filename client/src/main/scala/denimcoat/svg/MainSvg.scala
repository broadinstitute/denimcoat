package denimcoat.svg

import denimcoat.viewmodels.KeyMapper
import org.scalajs.dom
import org.scalajs.dom.svg.SVG

object MainSvg {

  val id = "mainSvg"

  val svg: SVG = dom.document.getElementById(id).asInstanceOf[SVG]

  val x0 = 30
  val x1 = 120
  val y0 = 50
  val y1 = 100

  val inputLabelText = "Disease:"
  val outputLabelText = "Symptoms:"

  val inputLabel: TextFacade = TextFacade.create(svg, "inputLabel", x0, y0)
  inputLabel.text = inputLabelText
  svg.appendChild(inputLabel.element)
  val inputField: TextEditBox = new TextEditBox(svg, "inputField", x1, y0)
  svg.appendChild(inputField.element)
  val outputLabel: TextFacade = TextFacade.create(svg, "outputText", x0, y1)
  outputLabel.text = outputLabelText
  svg.appendChild(outputLabel.element)
  val outputField: TextFacade = TextFacade.create(svg, "outputText", x1, y1)
  svg.appendChild(outputField.element)


  def inputString: String = inputField.text
  def inputString_=(text: String): Unit = inputField.text = text
  def editInputString(edit: KeyMapper.Edit): Unit = inputField.edit(edit)

  def setOutputText(text: String): Unit = outputField.text = text

}
