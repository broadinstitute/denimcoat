package denimcoat.reasoners.mock

import java.net.URI
import java.util.Date

import denimcoat.reasoners.Reasoner
import denimcoat.reasoners.messages.{Edge, Node, Request, Response, Result, ResultGraph}
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
        uri = new URI(s"disease:${disease.cui}"),
        description = s"The disease ${disease.name}.",
        symbol = disease.name,
        node_property_list = Seq.empty
      )
      val results = disease.symptoms.map { symptom: Symptom =>
        val symptomNode = Node(
          id = symptom.cui,
          `type` = "symptom",
          name = symptom.name,
          uri = new URI(s"symptom:${symptom.cui}"),
          description = s"The symptom ${symptom.name}.",
          symbol = symptom.name,
          node_property_list = Seq.empty
        )
        val diseaseSymptomEdge = Edge(
          `type` = "hasSymptom",
          source_id = diseaseNode.id,
          target_id = symptomNode.id,
          is_defined_by = "Some smart dude",
          provided_by = "Hippocrates",
          confidence = 1.0f,
          edge_property_list = Seq.empty,
          origin_list = Seq.empty
        )
        Result(
          `@id` = new URI(s"diseasesymptom:${disease.cui}:${symptom.cui}"),
          text =
            s"Disease ${disease.name} has symptom ${symptom.name}.",
          confidence = 1.0f,
          result_graph =
            ResultGraph(
              node_list = Seq(diseaseNode, symptomNode),
              edge_list = Seq(diseaseSymptomEdge)
            )
        )
      }.toSeq
      CoreResponse.successResponse(restatedQuestionText, message, results)
    }
    Response(
      `@context` = new URI(MockReasoners.baseUriContext),
      `@id` = MockReasoners.idUri(this.id),
      `@type` = "Very awesome type of response",
      schema_version = Reasoner.apiVersion,
      tool_version = version,
      datetime = new Date(),
      original_question_text = request.items.mkString(", "),
      restated_question_text = coreResponse.map(_.restatedQuestion).mkString(", "),
      result_code = coreResponse.head.resultCode,
      message = coreResponse.map(_.message).mkString(", "),
      result_list = coreResponse.flatMap(_.resultList)
    )
  }
}
