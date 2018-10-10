package denimcoat.reasoners.mvp

import denimcoat.reasoners.knowledge.{IdPrefix, PrefixedId}

object MonarchInitiativeUtils {

  // https://api.monarchinitiative.org/api/bioentity/disease/DOID:9352/phenotypes?rows=100&unselect_evidence=false&exclude_automatic_assertions=false&fetch_objects=true&use_compact_associations=false

  val sampleUrl: String = "https://api.monarchinitiative.org/api/bioentity/phenotype/HP:0000855/diseases?" +
    "unselect_evidence=false&exclude_automatic_assertions=false&fetch_objects=true&use_compact_associations=false"

  def canDo(inIdPrefix: IdPrefix, outIdPrefix: IdPrefix): Boolean = {
    (inIdPrefix, outIdPrefix) match {
      case (IdPrefix.omimDisease, IdPrefix.hp) => true
      case (IdPrefix.hp, IdPrefix.mondo) => true
      case (IdPrefix.ncbigene, IdPrefix.reactomePathway) => true
      case (IdPrefix.reactomePathway, IdPrefix.ncbigene) => true
      case _ => false
    }
  }

  def constructUrl(inIdPrefix: IdPrefix, inputId: PrefixedId, outIdPrefix: IdPrefix):
  Either[String, String] = {
    val root = "https://api.monarchinitiative.org/api/bioentity/"
    val postfix =
      "?unselect_evidence=false&exclude_automatic_assertions=false&fetch_objects=true" +
        "&use_compact_associations=false"
    val inputValue = inputId.value
    val coreOpt = (inIdPrefix, outIdPrefix) match {
      case (IdPrefix.omimDisease, IdPrefix.hp) => Right(s"disease/OMIM:$inputValue/phenotypes")
      case (IdPrefix.hp, IdPrefix.mondo) => Right(s"phenotype/HP:$inputValue/diseases")
      case (IdPrefix.ncbigene, IdPrefix.reactomePathway) => Right(s"gene/NCBIGENE:$inputValue/pathways")
      case (IdPrefix.reactomePathway, IdPrefix.ncbigene) => Right(s"pathway/NCBIGENE:$inputValue/genes")
      case _ =>
        Left(s"Don't know how to query Monarch Initiative to go from ${inIdPrefix.string} to ${outIdPrefix.string}.")
    }
    coreOpt.map(core => root + core + postfix)
  }

  case class FacetCounts(subject_closure: Option[Map[String, Int]])

  case class MIObject(label: String, id: String)

  case class Relation(label: String, id: String, reverse: Option[Boolean])

  case class Node(id: String, lbl: Option[String])

  case class Edge(sub: String, obj: String, pred: String)

  case class EvidenceGraph(nodes: Seq[Node], edges: Seq[Edge])

  case class Publication(id: String)

  case class Subject(label: String, id: String)

  case class Association(`object`: MIObject, relation: Relation, provided_by: Seq[String], id: String,
                         evidence_graph: EvidenceGraph,
                         publications: Option[Seq[Publication]], subject: Subject)

  case class Response(facet_counts: FacetCounts, associations: Seq[Association], objects: Seq[String], numFound: Int)
}
