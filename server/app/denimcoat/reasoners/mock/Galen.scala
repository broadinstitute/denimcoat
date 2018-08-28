package denimcoat.reasoners.mock

import java.net.URI
import java.util.Date

import denimcoat.reasoners.Reasoner
import denimcoat.reasoners.knowledge.{Category, Relation}
import denimcoat.reasoners.messages.{DefaultRequest, DefaultResponse, Edge, Node, Result}
import denimcoat.util.Entity

object Galen extends Reasoner {
  override def id: String = "galen"

  override def version: String = "0.1"

  type KBGraph = denimcoat.util.Graph[Entity, Category, Relation]
  type KBEdge = denimcoat.util.Graph.Edge[Entity, Relation]

  def getEntity(string: String): Option[Entity] = KnowledgeRepo.index.get(string)

  def restateQuestion(edge: KBEdge): String = {
    val relation = edge.relation
    s"What has relation ${relation.name} with ${relation.inCategory.name} ${edge.start.name}?"
  }

  def entityToNode(entity: Entity, category: Category): Node = {
    Node(
      id = entity.id,
      `type` = category.id,
      name = entity.name,
      uri = Some(new URI(s"${category.id}:${entity.id}")),
      description = Some(s"The ${category.name} ${entity.name}."),
      symbol = Some(entity.id),
      node_property_list = Some(Seq.empty)
    )
  }

  override def reason(request: DefaultRequest): DefaultResponse = {
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
        s"${subjectCategory.name} ${subjectEntity.name} ${relation.name} " +
          s"${objectCategory.name} ${objectCategory.name}"
      val diseaseNode = entityToNode(subjectEntity, subjectCategory)
      val symptomNode = entityToNode(objectEntity, objectCategory)
      val diseaseSymptomEdge = Edge(
        `type` = relation.id,
        source_id = diseaseNode.id,
        target_id = symptomNode.id,
        is_defined_by = Some("Some smart dude"),
        provided_by = "Hippocrates",
        confidence = Some(1.0f),
        edge_property_list = Some(Seq.empty),
        origin_list = Some(Seq.empty)
      )
      val result = Result(
        `@id` =
          Some(new URI(Seq(subjectCategory, objectCategory, subjectEntity, objectEntity).map(_.id).mkString(":"))),
        text = Some(message),
        confidence = Some(1.0f),
        node_list = Seq(diseaseNode, symptomNode),
        edge_list = Seq(diseaseSymptomEdge)
      )
      CoreResponse.successResponse(restatedQuestionText, message, result)
    }
    DefaultResponse(
      `@context` = Some(new URI(MockReasoners.baseUriContext)),
      `@id` = Some(MockReasoners.idUri(this.id)),
      `@type` = Some("Very awesome type of response"),
      schema_version = Some(Reasoner.apiVersion),
      tool_version = Some(version),
      datetime = Some(new Date()),
      original_question_text = Some(request.items.mkString(", ")),
      restated_question_text = Some(coreResponses.map(_.restatedQuestion).mkString(", ")),
      result_code = Some(coreResponses.headOption.map(_.resultCode).getOrElse("No result found")),
      message = Some(coreResponses.map(_.message).mkString(", ")),
      result_list = coreResponses.flatMap(_.resultList).toSeq.headOption.getOrElse(Result.empty)
    )
  }
}
