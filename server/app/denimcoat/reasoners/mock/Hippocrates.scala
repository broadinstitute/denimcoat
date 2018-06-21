package denimcoat.reasoners.mock

import java.net.URI
import java.util.Date

import denimcoat.reasoners.Reasoner
import denimcoat.reasoners.messages.{Request, Response}
import denimcoat.reasoners.mock.EntityCatalogue.Disease

object Hippocrates extends Reasoner {
  override def id: String = "hippocrates"

  override def version: String = "0.1"

  val questionPrefix = "What are symptoms of "

  val questionPostfix = "?"

  def parseQuestion(question: String): Option[Disease] = QuestionParser.findDiseases(question).headOption

  def restateQuestion(disease: String): String = questionPrefix + disease + questionPostfix

  override def reason(request: Request): Response = {
    val coreResponse = parseQuestion(request.text) match {
      case Some(disease) =>
        val restatedQuestionText = restateQuestion(disease.name)

        ???
      case None => CoreResponse.failureResponse(request)
    }
    Response(
      `@context` = new URI(MockReasoners.baseUriContext),
      `@id` = MockReasoners.idUri(this.id),
      `@type` = "Very awesome type of response",
      schema_version = Reasoner.apiVersion,
      tool_version = version,
      datetime = new Date(),
      original_question_text = request.text,
      restated_question_text = coreResponse.restatedQuestion,
      result_code = coreResponse.resultCode,
      message = coreResponse.message,
      result_list = coreResponse.resultList
    )
  }
}
