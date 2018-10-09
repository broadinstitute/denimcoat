package denimcoat.reasoners.knowledge

case class PrefixedId(prefix: IdPrefix, value: String) {

  override def toString: String = prefix.string + ":" + value

}

object PrefixedId {
  def parse(string: String): Either[String, PrefixedId] = {
    val colonPos = string.indexOf(":")
    ??? // TODO
  }
}
