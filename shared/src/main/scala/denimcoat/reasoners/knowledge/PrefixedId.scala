package denimcoat.reasoners.knowledge

case class PrefixedId(prefix: IdPrefix, value: String) {

  override def toString: String = if(prefix == IdPrefix.none) {
    value
  } else {
    prefix.string + ":" + value
  }

}

object PrefixedId {
  def parse(string: String): PrefixedId = {
    val colonPos = string.indexOf(':')
    if(colonPos < 0) {
      IdPrefix.none(string)
    } else {
      val key = string.substring(0, colonPos).trim.toLowerCase()
      val value = string.substring(colonPos + 1).trim
      IdPrefix(key).apply(value)
    }
  }
}
