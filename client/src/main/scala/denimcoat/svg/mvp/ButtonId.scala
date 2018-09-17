package denimcoat.svg.mvp

case class ButtonId(label: String, group: ButtonId.Group) {

}

object ButtonId {

  case class Group(label: String)

  object Group {
    val content: Group = Group("content")
    val navigation: Group = Group("navigation")
    val all: Seq[Group] = Seq(content, navigation)
  }

  val examples: ButtonId = ButtonId("e.g.", Group.content)
  val clear: ButtonId = ButtonId("clear", Group.content)
  val fastBack: ButtonId = ButtonId("<<", Group.navigation)
  val back: ButtonId = ButtonId("<", Group.navigation)
  val forward: ButtonId = ButtonId(">", Group.navigation)
  val fastForward: ButtonId = ButtonId(">>", Group.navigation)

  val allByGroup: Map[Group, Seq[ButtonId]] = Map(
    Group.content -> Seq(examples, clear),
    Group.navigation -> Seq(fastBack, back, forward, fastForward)
  )

  val all: Set[ButtonId] = allByGroup.values.flatten.toSet
}