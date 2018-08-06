package denimcoat.svg

import denimcoat.gears.Property
import denimcoat.gears.providers.{Provider, TriggeredRefreshProvider, Var}
import denimcoat.gears.syntax.AllImplicits._
import denimcoat.svg.ElementFacade.Visibility
import denimcoat.svg.Style.WhiteSpace
import denimcoat.viewmodels.{TextEditable, TextWithCursor}
import org.scalajs.dom.raw.{SVGGElement, SVGRect}
import org.scalajs.dom.svg.{G, SVG}

class TextEditBox(val svg: SVG, val element: G) extends ElementFacade[G] with TextEditable {

  private val textFacade = TextFacade.create(svg, id, 0.0, 0.0)
  private val cursorSpacerTextFacade = TextFacade.create(svg, id + "-spacer", 0.0, 0.0)
  private val textWithCursor: Var[TextWithCursor] = Var[TextWithCursor](TextWithCursor.empty)
  private val spacerBoxVar = TriggeredRefreshProvider[SVGRect](() => cursorSpacerTextFacade.element.getBBox())
  textWithCursor.addConsumer(spacerBoxVar.asConsumer)
  cursorSpacerTextFacade.addConsumer(spacerBoxVar.asConsumer)

  textFacade.style.whiteSpace := WhiteSpace.pre
  cursorSpacerTextFacade.style.whiteSpace := WhiteSpace.pre
  cursorSpacerTextFacade.visibility := Visibility.hidden

  appendChild(textFacade)
  appendChild(cursorSpacerTextFacade)

  private val cursor = LineFacade.create(svg, id + "-cursor", 0.0, 0.0, 0.0, 0.0)

  appendChild(cursor)

  cursor.style.stroke := "yellow"
  cursor.style.width := "2"

  val x: Property[Double] = textFacade.x
  cursorSpacerTextFacade.x := x
  x.addConsumer(spacerBoxVar.asConsumer)

  val y: Property[Double] = textFacade.y
  cursorSpacerTextFacade.y := y
  y.addConsumer(spacerBoxVar.asConsumer)

  private def spacerTextMangle(spacerTextRaw: String): String = {
    if (spacerTextRaw.isEmpty) {
      val thinCharacter = ":"
      thinCharacter
    } else if (spacerTextRaw.last.isWhitespace) {
      val characterAboutAsWideAsBlank = "x"
      spacerTextRaw.substring(0, spacerTextRaw.size - 1) + characterAboutAsWideAsBlank
    } else {
      spacerTextRaw
    }
  }

  cursor.x1 := spacerBoxVar.map(box => box.x + box.width)
  cursor.y1 := spacerBoxVar.map(box => box.y)
  cursor.x2 := spacerBoxVar.map(box => box.x + box.width)
  cursor.y2 := spacerBoxVar.map(box => box.y + box.height)

  textFacade.text := textWithCursor.map(_.text)
  cursorSpacerTextFacade.text := textWithCursor.map(twc => spacerTextMangle(twc.preCursorText))

  private def updateCursor(): Unit = {
    spacerBoxVar.trigger()
  }

  def text: String = textWithCursor.get.get.text

  def text_=(text: String): Unit = {
    textWithCursor.setValue(TextWithCursor.from(text))
    updateCursor()
  }

  override def edit(mod: TextWithCursor => TextWithCursor): Unit = {
    textWithCursor.modify(mod)
    updateCursor()
  }
}

object TextEditBox {
  def create(svg: SVG, id: Provider[String], x: Double, y: Double): TextEditBox = {
    val box = new TextEditBox(svg, SvgUtils.createSvgElement[SVGGElement]("g"))
    box.id := id
    box.x := x
    box.y := y
    box
  }
}