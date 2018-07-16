package denimcoat.util

class Index[V](var extracters: Seq[V => String],
               var normalizers: Seq[String => String] = Seq(_.trim, _.trim.toLowerCase)) {

  var entries: Map[String, V] = Map.empty

  def add(item: V): Unit = {
    for (extracter <- extracters) {
      val string = extracter(item)
      for (normalizer <- normalizers) {
        val key = normalizer(string)
        if (!entries.contains(key)) {
          entries += key -> item
        }
      }
    }
  }

  def get(string: String): Option[V] = {
    var itemOpt: Option[V] = None
    val normalizerIter = normalizers.iterator
    while (itemOpt.isEmpty && normalizerIter.hasNext) {
      val normalizer = normalizerIter.next()
      val key = normalizer(string)
      itemOpt = entries.get(key)
    }
    itemOpt
  }
}

object Index {
  def apply[V](extracters: Seq[V => String],
               normalizers: Seq[String => String] = Seq(_.trim, _.trim.toLowerCase)): Index[V] =
    new Index(extracters, normalizers)
}