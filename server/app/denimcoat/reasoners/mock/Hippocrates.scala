package denimcoat.reasoners.mock

import java.net.URI
import java.util.Date

import denimcoat.reasoners.Reasoner
import denimcoat.reasoners.messages.{Edge, Node, Request, Response, Result}
import denimcoat.reasoners.mock.EntityCatalogue.{Disease, Symptom}

object Hippocrates extends Reasoner {
  override def id: String = "hippocrates"

  override def version: String = "0.1"

  val questionPrefix = "What are symptoms of "

  val questionPostfix = "?"

  def parseQuestion(question: String): Option[Disease] = QuestionParser.findDiseases(question).headOption

  def restateQuestion(disease: String): String = questionPrefix + disease + questionPostfix

  override def reason(request: Request): Response = {
    val coreResponse = request.items.flatMap(parseQuestion).map { disease: Disease =>
      val restatedQuestionText = restateQuestion(disease.name)
      val message = s"Disease ${disease.name} has symptom(s) ${
        disease.symptoms.map { symptom =>
          s"${symptom.name}"
        }.mkString("", ", ", ".")
      }"
      val diseaseNode = Node(
        id = disease.cui,
        `type` = "disease",
        name = disease.name,
        uri = Some(new URI(s"disease:${disease.cui}")),
        description = Some(s"The disease ${disease.name}."),
        symbol = Some(disease.name),
        node_property_list = Some(Seq.empty)
      )
      val results = disease.symptoms.map { symptom: Symptom =>
        val symptomNode = Node(
          id = symptom.cui,
          `type` = "symptom",
          name = symptom.name,
          uri = Some(new URI(s"symptom:${symptom.cui}")),
          description = Some(s"The symptom ${symptom.name}."),
          symbol = Some(symptom.name),
          node_property_list = Some(Seq.empty)
        )
        val diseaseSymptomEdge = Edge(
          `type` = "hasSymptom",
          source_id = diseaseNode.id,
          target_id = symptomNode.id,
          is_defined_by = Some("Some smart dude"),
          provided_by = "Hippocrates",
          confidence = Some(1.0f),
          edge_property_list = Some(Seq.empty),
          origin_list = Some(Seq.empty)
        )
        Result(
          `@id` = Some(new URI(s"diseasesymptom:${disease.cui}:${symptom.cui}")),
          text = Some(s"Disease ${disease.name} has symptom ${symptom.name}."),
          confidence = Some(1.0f),
          node_list = Seq(diseaseNode, symptomNode),
          edge_list = Seq(diseaseSymptomEdge)
        )
      }.toSeq
      CoreResponse.successResponse(restatedQuestionText, message, results.head)
    }
    Response(
      `@context` = Some(new URI(MockReasoners.baseUriContext)),
      `@id` = Some(MockReasoners.idUri(this.id)),
      `@type` = Some("Very awesome type of response"),
      schema_version = Some(Reasoner.apiVersion),
      tool_version = Some(version),
      datetime = Some(new Date()),
      original_question_text = Some(request.items.mkString(", ")),
      restated_question_text = Some(coreResponse.map(_.restatedQuestion).mkString(", ")),
      result_code = coreResponse.headOption.map(_.resultCode),
      message = Some(coreResponse.map(_.message).mkString(", ")),
      result_list = coreResponse.flatMap(_.resultList).headOption.getOrElse(Result.empty)
    )
  }
}
