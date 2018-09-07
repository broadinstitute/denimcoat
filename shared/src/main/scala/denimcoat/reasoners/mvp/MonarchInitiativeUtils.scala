package denimcoat.reasoners.mvp

import denimcoat.reasoners.knowledge.Category
import denimcoat.reasoners.messages.ResponseBase

object MonarchInitiativeUtils {

  val sampleUrl: String = "https://api.monarchinitiative.org/api/bioentity/phenotype/HP:0000855/diseases/?" +
    "unselect_evidence=false&exclude_automatic_assertions=false&fetch_objects=true&use_compact_associations=false"

  def constructUrl(inCategory: Category, inputEntityId: String, outCategory: Category):
  Either[String, String] = {
    val root = "https://api.monarchinitiative.org/api/bioentity/"
    val postfix =
      "?unselect_evidence=false&exclude_automatic_assertions=false&fetch_objects=true" +
        "&use_compact_associations=false"
    val coreOpt = (inCategory, outCategory) match {
      case (Category.disease, Category.symptom) => Right(s"disease/OMIM:$inputEntityId/phenotypes/")
      case (Category.symptom, Category.disease) => Right(s"phenotype/HP:$inputEntityId/diseases/")
      case _ =>
        Left(s"Don't know how to query Monarch Initiative to go from ${inCategory.name} to ${outCategory.name}.")
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
                         evidence_graph: EvidenceGraph, negated: Boolean,
                         publications: Option[Seq[Publication]], subject: Subject)

  case class Response(facet_counts: FacetCounts, associations: Seq[Association], objects: Seq[String], numFound: Int)
    extends ResponseBase

}
