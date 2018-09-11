package denimcoat.reasoners.mvp

import denimcoat.util.UrlUtils

object BioThingsExplorerUtils {

  val sampleUrl: String =
    "http://biothings.io/explorer/api/v2/directinput2output?" +
    "input_prefix=omim.disease&output_prefix=hp&input_value=125853&format=translator"
  val baseUrl: String = "http://biothings.io/explorer/api/v2/directinput2output"

  def buildUrl(inputPrefix: String, outputPrefix: String, inputValue: String, format: String): String = {
    val params =
      Map("input_prefix" -> inputPrefix, "output_prefix" -> outputPrefix, "input_value" -> inputValue,
        "format" -> format)
    UrlUtils.buildQueryUrl(baseUrl, params)
  }

  def buildUrlDiseaseToSymptoms(diseaseId: String): String = {
    val inputPrefix = "omim.disease"
    val outputPrefix = "hp"
    val format = "translator"
    buildUrl(inputPrefix, outputPrefix, diseaseId, format)
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
