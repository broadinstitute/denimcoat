package denimcoat.util

case class NamesAndIds(names: Set[String], ids: Map[String, String]) {

  override def toString: String = {
    val idStrings = ids.map {
      case (key, value) => key +  ":" + value
    }
    (names ++ idStrings).mkString("; ")
  }

  def nameOpt: Option[String] = names.headOption

  def getId(key: String): Option[String] = ids.get(key)

}

object NamesAndIds {

  def apply(name: String, names: String*)(id: (String, String), ids: (String, String)*): NamesAndIds = {
    NamesAndIds((name +: names).toSet, (id +: ids).toMap)
  }

  def fromStrings(strings: Iterable[String]): NamesAndIds = {
    val grouped = strings.groupBy(_.contains(':'))
    val names = grouped(false).toSet
    val ids = grouped(true).map { part =>
      val colonPos = part.indexOf(':')
      val key = part.substring(0, colonPos).trim
      val value = part.substring(colonPos + 1).trim
      (key, value)
    }.toMap
    NamesAndIds(names, ids)
  }

  def parse(string: String): NamesAndIds = fromStrings(string.split(";").map(_.trim))


}