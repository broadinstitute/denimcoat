package denimcoat.viewmodels

object KeyMapper {

  type Edit = TextWithCursor => TextWithCursor

  trait KeyAction {
    def key: String
  }
  case class EditAction(key: String, edit: Edit) extends KeyAction
  case class SpecialAction(key: String) extends KeyAction


  object SpecialActions {
    val backspace: EditAction = EditAction("Backspace", _.backspace)
    val delete: EditAction = EditAction("Delete", _.delete)
    val arrowLeft: EditAction = EditAction("ArrowLeft", _.arrowLeft)
    val arrowRight: EditAction = EditAction("ArrowRight", _.arrowRight)
    val home: EditAction = EditAction("Home", _.home)
    val end: EditAction = EditAction("End", _.end)
    val arrowUp: SpecialAction = SpecialAction("ArrowUp")
    val arrowDown: SpecialAction = SpecialAction("ArrowDown")
    val pageUp: SpecialAction = SpecialAction("PageUp")
    val pageDown: SpecialAction = SpecialAction("PageDown")
    val enter: SpecialAction = SpecialAction("Enter")
    val all: Set[KeyAction] =
      Set(backspace, delete, arrowLeft, arrowRight, home, end, arrowUp, arrowDown, pageUp, pageDown, enter)
    val map: Map[String, KeyAction] = all.map(action => (action.key, action)).toMap
  }

  case class Insertion(textToInsert: String) extends Edit {
    override def apply(twc: TextWithCursor): TextWithCursor = twc.insert(textToInsert)
  }

  def getAction(key: String): KeyAction = {
    SpecialActions.map.getOrElse(key, EditAction(key, Insertion(key)))
  }

}
