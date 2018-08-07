package denimcoat.reasoners.mock

import java.net.URI
import java.util.Date

import denimcoat.reasoners.Reasoner
import denimcoat.reasoners.messages.{Edge, Node, Request, Response, Result, ResultGraph}
import denimcoat.reasoners.mock.EntityCatalogue.Drug

object Avicenna extends Reasoner {

  override def id: String = "avicenna"

  val questionPrefix = "What are targets of "

  val questionPostfix = "?"

  def parseQuestion(question: String): Option[Drug] = QuestionParser.findDrugs(question).headOption

  def restateQuestion(drug: String): String = questionPrefix + drug + questionPostfix

  override def reason(request: Request): Response = {
    val coreResponse = parseQuestion(request.items.head) match {
      case Some(drug) =>
        val restatedQuestionText = restateQuestion(drug.name)
        val message = s"Drug ${drug.name} has target(s) ${
          drug.targets.map { target =>
            s"${target.name} (affecting ${target.symptoms.map(_.name).mkString(", ")})"
          }.mkString("", ", ", ".")
        }"
        val drugNode = Node(
          id = drug.cui,
          `type` = "drug",
          name = drug.name,
          uri = new URI(s"drug:${drug.cui}"),
          description = s"The drug ${drug.name}.",
          symbol = drug.name,
          node_property_list = Seq.empty
        )
        val results = drug.targets.map { target =>
          val targetNode = Node(
            id = target.cui,
            `type` = "target",
            name = target.name,
            uri = new URI(s"target:${target.cui}"),
            description = s"The target ${target.name}.",
            symbol = target.name,
            node_property_list = Seq.empty
          )
          val drugTargetEdge = Edge(
            `type` = "hasTarget",
            source_id = drugNode.id,
            target_id = targetNode.id,
            is_defined_by = "Some smart dude",
            provided_by = "Avicenna",
            confidence = 1.0f,
            edge_property_list = Seq.empty,
            origin_list = Seq.empty
          )
          val diseaseNodes = target.symptoms.map { disease =>
            Node(
              id = disease.cui,
              `type` = "disease",
              name = disease.name,
              uri = new URI(s"disease:${disease.cui}"),
              description = s"The disease ${disease.name}.",
              symbol = disease.name,
              node_property_list = Seq.empty
            )
          }.toSeq
          val targetDiseaseEdges = diseaseNodes.map { diseaseNode =>
            Edge(
              `type` = "isPartOfPathway",
              source_id = targetNode.id,
              target_id = diseaseNode.id,
              is_defined_by = "Some smart dude",
              provided_by = "Avicenna",
              confidence = 1.0f,
              edge_property_list = Seq.empty,
              origin_list = Seq.empty
            )
          }
          Result(
            `@id` = new URI(s"drugtarget:${drug.cui}:${target.cui}"),
            text =
              s"Drug ${drug.name} has target ${target.name} affecting ${target.symptoms.map(_.name).mkString(", ")}.",
            confidence = 1.0f,
            result_graph =
              ResultGraph(
                node_list = Seq(drugNode, targetNode) ++ diseaseNodes,
                edge_list = Seq(drugTargetEdge) ++ targetDiseaseEdges
              )
          )
        }.toSeq
        CoreResponse.successResponse(restatedQuestionText, message, results)
      case None =>
        CoreResponse.failureResponse(request)
    }
    Response(
      `@context` = new URI(MockReasoners.baseUriContext),
      `@id` = MockReasoners.idUri(this.id),
      `@type` = "Very awesome type of response",
      schema_version = Reasoner.apiVersion,
      tool_version = version,
      datetime = new Date(),
      original_question_text = request.items.head,
      restated_question_text = coreResponse.restatedQuestion,
      result_code = coreResponse.resultCode,
      message = coreResponse.message,
      result_list = coreResponse.resultList
    )
  }

  override def version: String = "0.5"
}
