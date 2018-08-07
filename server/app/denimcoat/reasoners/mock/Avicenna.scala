package denimcoat.reasoners.mock

import java.net.URI
import java.util.Date

import denimcoat.reasoners.Reasoner
import denimcoat.reasoners.messages.{Edge, Node, Request, Response, Result}
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
          uri = Some(new URI(s"drug:${drug.cui}")),
          description = Some(s"The drug ${drug.name}."),
          symbol = Some(drug.name),
          node_property_list = Some(Seq.empty)
        )
        val results = drug.targets.map { target =>
          val targetNode = Node(
            id = target.cui,
            `type` = "target",
            name = target.name,
            uri = Some(new URI(s"target:${target.cui}")),
            description = Some(s"The target ${target.name}."),
            symbol = Some(target.name),
            node_property_list = Some(Seq.empty)
          )
          val drugTargetEdge = Edge(
            `type` = "hasTarget",
            source_id = drugNode.id,
            target_id = targetNode.id,
            is_defined_by = Some("Some smart dude"),
            provided_by = "Avicenna",
            confidence = Some(1.0f),
            edge_property_list = Some(Seq.empty),
            origin_list = Some(Seq.empty)
          )
          val diseaseNodes = target.symptoms.map { disease =>
            Node(
              id = disease.cui,
              `type` = "disease",
              name = disease.name,
              uri = Some(new URI(s"disease:${disease.cui}")),
              description = Some(s"The disease ${disease.name}."),
              symbol = Some(disease.name),
              node_property_list = Some(Seq.empty)
            )
          }.toSeq
          val targetDiseaseEdges = diseaseNodes.map { diseaseNode =>
            Edge(
              `type` = "isPartOfPathway",
              source_id = targetNode.id,
              target_id = diseaseNode.id,
              is_defined_by = Some("Some smart dude"),
              provided_by = "Avicenna",
              confidence = Some(1.0f),
              edge_property_list = Some(Seq.empty),
              origin_list = Some(Seq.empty)
            )
          }
          Result(
            `@id` = Some(new URI(s"drugtarget:${drug.cui}:${target.cui}")),
            text =
              Some(
                s"Drug ${drug.name} has target ${target.name} affecting ${target.symptoms.map(_.name).mkString(", ")}."
              ),
            confidence = Some(1.0f),
            node_list = Seq(drugNode, targetNode) ++ diseaseNodes,
            edge_list = Seq(drugTargetEdge) ++ targetDiseaseEdges
          )
        }.toSeq.head
        CoreResponse.successResponse(restatedQuestionText, message, results)
      case None =>
        CoreResponse.failureResponse(request)
    }
    Response(
      `@context` = Some(new URI(MockReasoners.baseUriContext)),
      `@id` = Some(MockReasoners.idUri(this.id)),
      `@type` = Some("Very awesome type of response"),
      schema_version = Some(Reasoner.apiVersion),
      tool_version = Some(version),
      datetime = Some(new Date()),
      original_question_text = Some(request.items.head),
      restated_question_text = Some(coreResponse.restatedQuestion),
      result_code = Some(coreResponse.resultCode),
      message = Some(coreResponse.message),
      result_list = coreResponse.resultList.get
    )
  }

  override def version: String = "0.5"
}
