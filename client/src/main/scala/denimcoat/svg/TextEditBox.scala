package denimcoat.svg

import denimcoat.viewmodels.{TextEditable, TextWithCursor}
import org.scalajs.dom.svg.{SVG, Text}

class TextEditBox(svg: SVG, id: String, x0: Int, y0: Int) extends TextEditable {

  private val textFacade = TextFacade.create(svg, id, x0, y0)
  private val shadowTextFacade = TextFacade.create(svg, id + "-shadow", x0, y0)
  private var textWithCursor: TextWithCursor = TextWithCursor.empty

  svg.appendChild(shadowTextFacade.element)

  val shadowBox = shadowTextFacade.element.getBBox()

  val x1: Int = (shadowBox.x + shadowBox.width).toInt
  val y1: Int = (shadowBox.y).toInt
  val x2: Int = (shadowBox.x + shadowBox.width).toInt
  val y2: Int = (shadowBox.y + shadowBox.height).toInt

  private val cursor = LineFacade.create(svg, id+ "-cursor", x1, y1, x2, y2)

  svg.appendChild(cursor.element)

  cursor.style.stroke = "yellow"
  cursor.style.width = "2"

  def x: Int = textFacade.x

  def x_=(x: Int): Unit = textFacade.x = x

  def y: Int = textFacade.y

  def y_=(y: Int): Unit = textFacade.y = y

  def text: String = textWithCursor.text

  private def updateTextFacades: Unit = {
    textFacade.text = textWithCursor.text
    shadowTextFacade.text = textWithCursor.preCursorText
    val shadowBox = shadowTextFacade.element.getBBox()
    val x1: Int = (shadowBox.x + shadowBox.width).toInt
    val y1: Int = (shadowBox.y).toInt
    val x2: Int = (shadowBox.x + shadowBox.width).toInt
    val y2: Int = (shadowBox.y + shadowBox.height).toInt
    cursor.x1 = x1
    cursor.y1 = y1
    cursor.x2 = x2
    cursor.y2 = y2
  }

  def text_=(text: String): Unit = {
    textWithCursor = TextWithCursor.from(text)
    updateTextFacades
  }

  override def edit(mod: TextWithCursor => TextWithCursor): Unit = {
    textWithCursor = mod(textWithCursor)
    updateTextFacades
  }

  def element: Text = textFacade.element

}