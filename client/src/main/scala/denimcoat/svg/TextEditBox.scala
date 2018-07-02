package denimcoat.svg

import denimcoat.svg.ElementFacade.Visibility
import denimcoat.viewmodels.{TextEditable, TextWithCursor}
import org.scalajs.dom
import org.scalajs.dom.raw.SVGGElement
import org.scalajs.dom.svg.{SVG, Text}

class TextEditBox(val svg: SVG, val element: SVGGElement) extends ElementFacade[SVGGElement] with TextEditable {

  private val textFacade = TextFacade.create(svg, id, 0, 0)
  private val spacerTextFacade = TextFacade.create(svg, id + "-shadow", 0, 0)
  private var textWithCursor: TextWithCursor = TextWithCursor.empty

  spacerTextFacade.visibility = Visibility.hidden

  appendChild(textFacade)
  appendChild(spacerTextFacade)

  private val cursor = LineFacade.create(svg, id + "-cursor", 0, 0, 0, 0)

  appendChild(cursor)

  cursor.style.stroke = "yellow"
  cursor.style.width = "2"

  def x: Double = textFacade.x

  def x_=(x: Double): Unit = {
    textFacade.x = x
    spacerTextFacade.x = x
    updateCursor
  }

  def y: Double = textFacade.y

  def y_=(y: Double): Unit = {
    textFacade.y = y
    spacerTextFacade.y = y
    updateCursor
  }

  def text: String = textWithCursor.text

  private def updateCursor: Unit = {
    if (element.ownerSVGElement != null) {
      textFacade.text = textWithCursor.text
      val spacerTextRaw = textWithCursor.preCursorText
      spacerTextFacade.text = if (spacerTextRaw.trim.size > 0) spacerTextRaw else spacerTextRaw + ":"
      val spacerBox = spacerTextFacade.element.getBBox()
      val x1: Double = spacerBox.x + spacerBox.width
      val y1: Double = spacerBox.y
      val x2: Double = spacerBox.x + spacerBox.width
      val y2: Double = spacerBox.y + spacerBox.height
      cursor.x1 = x1
      cursor.y1 = y1
      cursor.x2 = x2
      cursor.y2 = y2
    }
  }

  def text_=(text: String): Unit = {
    textWithCursor = TextWithCursor.from(text)
    updateCursor
  }

  override def edit(mod: TextWithCursor => TextWithCursor): Unit = {
    textWithCursor = mod(textWithCursor)
    updateCursor
  }
}

object TextEditBox {
  def create(svg: SVG, id: String, x: Double, y: Double): TextEditBox = {
    val box = new TextEditBox(svg, SvgUtils.createSvgElement[SVGGElement]("g"))
    box.id = id
    box.x = x
    box.y = y
    box
  }
}