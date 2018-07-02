package denimcoat.viewmodels

case class TextWithCursor(text: String, cursor: Int) {

  def preCursorText: String = text.substring(0, cursor)

  def postCursorText: String = text.substring(cursor)

  def insert(insertion: String): TextWithCursor =
    TextWithCursor(preCursorText + insertion + postCursorText, cursor + insertion.size)

  def backspace: TextWithCursor = if (cursor > 0) {
    TextWithCursor(preCursorText.substring(0, preCursorText.size - 1) + postCursorText, cursor - 1)
  } else {
    this
  }

  def delete: TextWithCursor = if (cursor < text.size) {
    copy(text = preCursorText + postCursorText.substring(1))
  } else {
    this
  }

  def arrowLeft: TextWithCursor = if (cursor > 0) copy(cursor = cursor - 1) else this

  def arrowRight: TextWithCursor = if (cursor < text.size) copy(cursor = cursor + 1) else this

  def home: TextWithCursor = if (cursor > 0) copy(cursor = 0) else this

  def end: TextWithCursor = if (cursor < text.size) copy(cursor = text.size) else this

  def set(text: String): TextWithCursor = TextWithCursor.from(text)

  def clear: TextWithCursor = TextWithCursor.empty
}

object TextWithCursor {
  def empty: TextWithCursor = TextWithCursor("", 0)

  def from(string: String): TextWithCursor = TextWithCursor(string, string.size)
}