package denimcoat.reasoners.mvp

import denimcoat.reasoners.knowledge.{IdPrefix, PrefixedId}
import denimcoat.util.UrlUtils

object BioThingsExplorerUtils {

  val sampleUrl: String =
    "http://biothings.io/explorer/api/v2/directinput2output?" +
    "input_prefix=omim.disease&output_prefix=hp&input_value=125853&format=translator"
  val baseUrl: String = "http://biothings.io/explorer/api/v2/directinput2output"

  def buildUrl(inputId: PrefixedId, outputPrefix: IdPrefix, format: String = "translator"): String = {
    val params =
      Map("input_prefix" -> inputId.prefix.string, "output_prefix" -> outputPrefix.string,
        "input_value" -> inputId.value, "format" -> format)
    UrlUtils.buildQueryUrl(baseUrl, params)
  }

  def fixDoublePrefixedId(id: String): String = {
    val parts = id.split(":")
    if(parts.size > 2 && parts(0) == parts(1)) {
      parts.drop(1).mkString(":")
    } else {
      id
    }
  }
}
