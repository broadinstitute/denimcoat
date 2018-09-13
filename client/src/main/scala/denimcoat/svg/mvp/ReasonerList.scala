package denimcoat.svg.mvp

object ReasonerList {

  val includeMockReasoner: Boolean = false

  case class Entry(id: String, name: String)

  val hippocrates: Entry = Entry("hippocrates", "Hippocrates")
  val galen: Entry = Entry("galen", "Galen")
  val biothings: Entry = Entry("biothings", "BioThings")
  val monarch: Entry = Entry("monarch", "Monarch Initiative")

  val list: Seq[Entry] = if(includeMockReasoner) Seq(galen, biothings, monarch) else Seq(biothings, monarch)
  val ids : Seq[String] = list.map(_.id)
  val id2name: Map[String, String] = list.map(entry => (entry.id, entry.name)).toMap

}
