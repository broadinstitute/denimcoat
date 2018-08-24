package denimcoat.reasoners.mvp

object MonarchInitiativeUtils {

  val sampleUrl: String = "https://api.monarchinitiative.org/api/bioentity/phenotype/HP:0000855/diseases/?" +
    "unselect_evidence=false&exclude_automatic_assertions=false&fetch_objects=true&use_compact_associations=false"

  case class FacetCounts(subject_closure: Map[String, Int])

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

}
