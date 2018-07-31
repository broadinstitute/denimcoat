package denimcoat.svg

import denimcoat.gears.providers.Provider
import denimcoat.svg.ElementFacade.Visibility
import denimcoat.viewmodels.{TextEditable, TextWithCursor}
import org.scalajs.dom
import org.scalajs.dom.raw.SVGGElement
import org.scalajs.dom.svg.{G, SVG, Text}
import denimcoat.gears.syntax.AllImplicits._

class TextEditBox(val svg: SVG, val element: G) extends ElementFacade[G] with TextEditable {

//  private val frame = RectangleFacade.create(svg)
  private val textFacade = TextFacade.create(svg, id, 0, 0)
  private val cursorSpacerTextFacade = TextFacade.create(svg, id + "-spacer", 0, 0)
  private var textWithCursor: TextWithCursor = TextWithCursor.empty

//  frame.width = 100
//  frame.height = 30

  textFacade.style.whiteSpace = "pre"
  cursorSpacerTextFacade.style.whiteSpace = "pre"
  cursorSpacerTextFacade.visibility := Visibility.hidden

//  appendChild(frame)
  appendChild(textFacade)
  appendChild(cursorSpacerTextFacade)

  private val cursor = LineFacade.create(svg, id + "-cursor", 0, 0, 0, 0)

  appendChild(cursor)

  cursor.style.stroke = "yellow"
  cursor.style.width = "2"

  def x: Double = textFacade.x

  def x_=(x: Double): Unit = {
//    frame.x = x
    textFacade.x = x
    cursorSpacerTextFacade.x = x
    updateCursor()
  }

  def y: Double = textFacade.y

  def y_=(y: Double): Unit = {
//    frame.y = y
    textFacade.y = y
    cursorSpacerTextFacade.y = y
    updateCursor()
  }

  def text: String = textWithCursor.text

  private def updateCursor(): Unit = {
    if (element.ownerSVGElement != null) {
      textFacade.text = textWithCursor.text
      val spacerTextRaw = textWithCursor.preCursorText
      cursorSpacerTextFacade.text = if(spacerTextRaw.isEmpty) {
        val thinCharacter = ":"
        thinCharacter
      } else if(spacerTextRaw.last.isWhitespace) {
        val characterAboutAsWideAsBlank = "x"
        spacerTextRaw.substring(0, spacerTextRaw.size -1) + characterAboutAsWideAsBlank
      } else {
        spacerTextRaw
      }
      val spacerBox = cursorSpacerTextFacade.element.getBBox()
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
    updateCursor()
  }

  override def edit(mod: TextWithCursor => TextWithCursor): Unit = {
    textWithCursor = mod(textWithCursor)
    updateCursor()
  }
}

object TextEditBox {
  def create(svg: SVG, id: Provider[String], x: Double, y: Double): TextEditBox = {
    val box = new TextEditBox(svg, SvgUtils.createSvgElement[SVGGElement]("g"))
    box.id := id
    box.x = x
    box.y = y
    box
  }
}