package denimcoat.util

import denimcoat.reasoners.knowledge.Identifiable

case class Entity(name: String, id: String, names: Set[String], ids: Map[String, String]) extends Identifiable {

  override def toString: String = {
    val idStrings = ids.map {
      case (key, value) => key + ":" + value
    }
    (names ++ idStrings).mkString("; ")
  }

  def nameOpt: Option[String] = names.headOption

  def getId(key: String): Option[String] = ids.get(key)
}

object Entity {

  def apply(name: String, names: String*)(id: (String, String), ids: (String, String)*): Entity = {
    Entity(name +: names, id +: ids)
  }

  def apply(namesSeq: Seq[String], idsSeq: Seq[(String, String)]): Entity = {
    val nameOpt = namesSeq.headOption
    val idOpt = idsSeq.headOption.map(_._2)
    val name = nameOpt.orElse(idOpt).get
    val id = idOpt.orElse(nameOpt).get
    Entity(name, id, namesSeq.toSet, idsSeq.toMap)
  }

  def fromStrings(strings: Seq[String]): Entity = {
    val (idStrings, namesSeq) = strings.partition(_.contains(":"))
    val idsSeq = idStrings.map { idString =>
      val colonPos = idString.indexOf(':')
      val key = idString.substring(0, colonPos).trim
      val value = idString.substring(colonPos + 1).trim
      (key, value)
    }
    Entity(namesSeq, idsSeq)
  }

  def parse(string: String): Entity = fromStrings(string.split(";").map(_.trim))


}