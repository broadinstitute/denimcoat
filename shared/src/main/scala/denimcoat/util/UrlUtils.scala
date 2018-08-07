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

}
