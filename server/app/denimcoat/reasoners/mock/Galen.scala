package denimcoat.reasoners.mock

import java.net.URI
import java.util.Date

import denimcoat.reasoners.Reasoner
import denimcoat.reasoners.knowledge.{Category, Relation}
import denimcoat.reasoners.messages.{Edge, Node, Request, Response, Result, ResultGraph}

object Galen extends Reasoner {
  override def id: String = "galen"

  override def version: String = "0.1"

  type KBGraph = denimcoat.util.Graph[Entity, Category, Relation]
  type KBEdge = denimcoat.util.Graph.Edge[Entity, Relation]

  def getEntity(string: String): Option[Entity] = KnowledgeRepo.index.get(string)

  def restateQuestion(edge: KBEdge): String = {
    val relation = edge.relation
    s"What has relation ${relation.label} with ${relation.inCategory.label} ${edge.start.label}?"
  }

  def entityToNode(entity: Entity, category: Category): Node = {
    Node(
      id = entity.id,
      `type` = category.id,
      name = entity.label,
      uri = new URI(s"${category.id}:${entity.id}"),
      description = s"The ${category.label} ${entity.label}.",
      symbol = entity.id,
      node_property_list = Seq.empty
    )
  }

  override def reason(request: Request): Response = {
    val starts: Set[Entity] = request.items.toSet.flatMap(getEntity)
    val relation = request.relation
    val graphEdges = starts.flatMap(start => KnowledgeRepo.graph.edgesFrom(start, relation))
    val coreResponses = graphEdges.map { kbEdge: KBEdge =>
      val restatedQuestionText = restateQuestion(kbEdge)
      val relation = kbEdge.relation
      val subjectEntity = kbEdge.start
      val subjectCategory = relation.inCategory
      val objectEntity = kbEdge.end
      val objectCategory = relation.outCategory
      val message =
        s"${subjectCategory.label} ${subjectEntity.label} ${relation.label} " +
          s"${objectCategory.label} ${objectCategory.label}"
      val diseaseNode = entityToNode(subjectEntity, subjectCategory)
      val symptomNode = entityToNode(objectEntity, objectCategory)
      val diseaseSymptomEdge = Edge(
        `type` = relation.id,
        source_id = diseaseNode.id,
        target_id = symptomNode.id,
        is_defined_by = "Some smart dude",
        provided_by = "Hippocrates",
        confidence = 1.0f,
        edge_property_list = Seq.empty,
        origin_list = Seq.empty
      )
      val result = Result(
        `@id` = new URI(Seq(subjectCategory, objectCategory, subjectEntity, objectEntity).map(_.id).mkString(":")),
        text = message,
        confidence = 1.0f,
        result_graph =
          ResultGraph(
            node_list = Seq(diseaseNode, symptomNode),
            edge_list = Seq(diseaseSymptomEdge)
          )
      )
      CoreResponse.successResponse(restatedQuestionText, message, Seq(result))
    }
    Response(
      `@context` = new URI(MockReasoners.baseUriContext),
      `@id` = MockReasoners.idUri(this.id),
      `@type` = "Very awesome type of response",
      schema_version = Reasoner.apiVersion,
      tool_version = version,
      datetime = new Date(),
      original_question_text = request.items.mkString(", "),
      restated_question_text = coreResponses.map(_.restatedQuestion).mkString(", "),
      result_code = coreResponses.headOption.map(_.resultCode).getOrElse("No result found"),
      message = coreResponses.map(_.message).mkString(", "),
      result_list = coreResponses.flatMap(_.resultList).toSeq
    )
  }
}
