package denimcoat.reasoners.knowledge

trait Identifiable {
  def ids: Seq[PrefixedId]

  def getId(prefix: IdPrefix): Option[PrefixedId] = ids.find(_.prefix == prefix)

  def getIds(prefix: IdPrefix): Seq[PrefixedId] = ids.filter(_.prefix == prefix)

  def id: PrefixedId = ids.head

  def name: String = {
    (ids.find(_.prefix == IdPrefix.none) orElse(ids.headOption)).map(_.toString).getOrElse("[no name]")
  }

  override def toString: String = ids.mkString(";")
}
