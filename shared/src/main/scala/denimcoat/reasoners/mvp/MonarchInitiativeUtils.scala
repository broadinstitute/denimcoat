package denimcoat.reasoners.mvp

object MonarchInitiativeUtils {

  val sampleUrl: String = "https://api.monarchinitiative.org/api/bioentity/phenotype/HP:0000855/diseases/?" +
    "unselect_evidence=false&exclude_automatic_assertions=false&fetch_objects=true&use_compact_associations=false"


  case class Response(blub: String)

}
