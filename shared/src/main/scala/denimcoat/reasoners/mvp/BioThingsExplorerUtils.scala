package denimcoat.reasoners.mvp

import denimcoat.reasoners.knowledge.IdPrefix
import denimcoat.util.UrlUtils

object BioThingsExplorerUtils {

  val sampleUrl: String =
    "http://biothings.io/explorer/api/v2/directinput2output?" +
    "input_prefix=omim.disease&output_prefix=hp&input_value=125853&format=translator"
  val baseUrl: String = "http://biothings.io/explorer/api/v2/directinput2output"

  def buildUrl(inputPrefix: IdPrefix, outputPrefix: IdPrefix, inputValue: String,
               format: String = "translator"): String = {
    val params =
      Map("input_prefix" -> inputPrefix.string, "output_prefix" -> outputPrefix.string, "input_value" -> inputValue,
        "format" -> format)
    UrlUtils.buildQueryUrl(baseUrl, params)
  }

  def buildUrlDiseaseToSymptoms(diseaseId: String): String = {
    val inputPrefix = IdPrefix.omimDisease
    val outputPrefix = IdPrefix.hp
    buildUrl(inputPrefix, outputPrefix, diseaseId)
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
