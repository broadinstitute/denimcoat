package denimcoat.util

object UrlUtils {

  def buildQueryUrl(base: String, params: Map[String, String]): String = {
    if(params.isEmpty) {
      base
    } else {
      val paramsEncoded = params.map {
        case (key, value) => key + "=" + value  //  URL-encoding
      }
      base + "?" + paramsEncoded.mkString("&")
    }
  }

  def parseQueryPart(url: String): Map[String, String] = {
    val queryPos = url.indexOf("?")
    if(queryPos < 0) {
      Map.empty
    } else {
      val queryString = url.split("\\?").last.split("#").head
      queryString.split("&").map(_.split("=").toSeq).collect {
        case Seq(key: String, value: String) => (key, value)
      }.toMap
    }
  }

}
