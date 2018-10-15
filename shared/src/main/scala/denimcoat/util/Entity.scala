package denimcoat.util

import denimcoat.reasoners.knowledge.{Identifiable, PrefixedId}

case class Entity(ids: Seq[PrefixedId]) extends Identifiable

object Entity {

  def normalizeId(id: String): String = {
    val colPos = id.indexOf(":")
    if(colPos < 1) {
      id
    } else {
      id.substring(0, colPos).toLowerCase() + id.substring(colPos)
    }
  }

  def fromStrings(strings: Seq[String]): Entity = Entity(strings.map(PrefixedId.parse))

  def parse(string: String): Entity = fromStrings(string.split(";").map(_.trim))


}