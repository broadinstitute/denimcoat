package denimcoat.util

import denimcoat.reasoners.knowledge.{IdPrefix, Identifiable, PrefixedId}

case class Entity(name: String, override val id: PrefixedId, names: Set[String], ids: Map[IdPrefix, PrefixedId])
  extends Identifiable {

  override def toString: String = {
    val idStrings = ids.values.map(_.toString)
    (names ++ idStrings).mkString("; ")
  }

  def nameOpt: Option[String] = names.headOption

  def getId(key: String): Option[PrefixedId] = ids.get(IdPrefix(key))
}

object Entity {

  def normalizeId(id: String): String = {
    val colPos = id.indexOf(":")
    if(colPos < 1) {
      id
    } else {
      id.substring(0, colPos).toLowerCase() + id.substring(colPos)
    }
  }

  def apply(name: String, names: String*)(id: PrefixedId, ids: PrefixedId*): Entity = {
    Entity(name +: names, id +: ids)
  }

  def apply(namesSeq: Seq[String], idsSeq: Seq[PrefixedId]): Entity = {
    val nameOpt = namesSeq.headOption
    val idOpt = idsSeq.headOption
    val ids = idsSeq.map(id => (id.prefix, id)).toMap
    val name = nameOpt.orElse(idOpt.map(_.toString)).get
    val id = idOpt.orElse(nameOpt.map(IdPrefix.name.apply)).get
    Entity(name, id, namesSeq.toSet, ids)
  }

  def fromStrings(strings: Seq[String]): Entity = {
    val (idStrings, namesSeq) = strings.partition(_.contains(":"))
    val idsSeq = idStrings.map(PrefixedId.parse)
    Entity(namesSeq, idsSeq)
  }

  def parse(string: String): Entity = fromStrings(string.split(";").map(_.trim))


}