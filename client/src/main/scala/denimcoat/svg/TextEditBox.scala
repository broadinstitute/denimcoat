package denimcoat.svg

import denimcoat.gears.providers.{Provider, Var}
import denimcoat.gears.syntax.AllImplicits._
import denimcoat.svg.ElementFacade.Visibility
import denimcoat.svg.Style.WhiteSpace
import denimcoat.viewmodels.{TextEditable, TextWithCursor}
import org.scalajs.dom.raw.{SVGGElement, SVGRect}
import org.scalajs.dom.svg.{G, SVG}

class TextEditBox(val svg: SVG, val element: G) extends ElementFacade[G] with TextEditable {

  //  private val frame = RectangleFacade.create(svg)
  private val textFacade = TextFacade.create(svg, id, 0, 0)
  private val cursorSpacerTextFacade = TextFacade.create(svg, id + "-spacer", 0, 0)
  private var textWithCursor: TextWithCursor = TextWithCursor.empty

  //  frame.width = 100
  //  frame.height = 30

  textFacade.style.whiteSpace := WhiteSpace.pre
  cursorSpacerTextFacade.style.whiteSpace := WhiteSpace.pre
  cursorSpacerTextFacade.visibility := Visibility.hidden

  //  appendChild(frame)
  appendChild(textFacade)
  appendChild(cursorSpacerTextFacade)

  private val cursor = LineFacade.create(svg, id + "-cursor", 0.0, 0.0, 0.0, 0.0)

  appendChild(cursor)

  cursor.style.stroke := "yellow"
  cursor.style.width := "2"

  def x: Double = textFacade.x.get.get

  def x_=(x: Double): Unit = {
    //    frame.x = x
    textFacade.x := x
    cursorSpacerTextFacade.x := x
    updateCursor()
  }

  def y: Double = textFacade.y.get.get

  def y_=(y: Double): Unit = {
    //    frame.y = y
    textFacade.y := y
    cursorSpacerTextFacade.y := y
    updateCursor()
  }

  def text: String = textWithCursor.text

  val spacerBoxVar = new Var[SVGRect]

  private def updateCursor(): Unit = {
    if (element.ownerSVGElement != null) {
      textFacade.text := textWithCursor.text
      val spacerTextRaw = textWithCursor.preCursorText
      cursorSpacerTextFacade.text := (
        if (spacerTextRaw.isEmpty) {
          val thinCharacter = ":"
          thinCharacter
        } else if (spacerTextRaw.last.isWhitespace) {
          val characterAboutAsWideAsBlank = "x"
          spacerTextRaw.substring(0, spacerTextRaw.size - 1) + characterAboutAsWideAsBlank
        } else {
          spacerTextRaw
        }
        )
      spacerBoxVar.setValue(cursorSpacerTextFacade.element.getBBox())
      cursor.x1 := spacerBoxVar.map(box => box.x + box.width)
      cursor.y1 := spacerBoxVar.map(box => box.y)
      cursor.x2 := spacerBoxVar.map(box => box.x + box.width)
      cursor.y2 := spacerBoxVar.map(box => box.y + box.height)
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