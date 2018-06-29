package denimcoat.svg

import denimcoat.viewmodels.TextWithCursor
import org.scalajs.dom.svg.{SVG, Text}

class TextEditBox(svg: SVG, id: String, x0: Int, y0: Int) {

  private val textFacade = TextFacade.create(svg, id, x0, y0)
  private var textWithCursor: TextWithCursor = TextWithCursor.empty

  def x: Int = textFacade.x

  def x_=(x: Int): Unit = textFacade.x = x

  def y: Int = textFacade.y

  def y_=(y: Int): Unit = textFacade.y = y

  def edit(mod: TextWithCursor => TextWithCursor): Unit = {
    textWithCursor = mod(textWithCursor)
    textFacade.text = textWithCursor.text
  }

  def element: Text = textFacade.element

}