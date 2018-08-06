package denimcoat.reasoners.mock

import java.net.URI
import java.util.Date

import denimcoat.reasoners.Reasoner
import denimcoat.reasoners.messages.{DefaultRequest, Response, Result, ResultGraph}

object MockReasoners {

  def now: Date = new Date(System.currentTimeMillis())

  val baseUri = "http://www.broadinstitute.org/translator/teamIndigo"
  val baseUriContext: String = baseUri + "/reasoners/context"
  val baseUriId: String = baseUri + "/reasoners/id"
  val baseUriResultId: String = baseUri + "/results/reasoners"
  val typeDefault = "Some type of response"

  def contextUri(reasonerId: String): URI = new URI(baseUriContext + "/" + reasonerId)
  def idUri(reasonerId: String): URI = new URI(baseUriContext + "/" + reasonerId)
  def idResultUri(reasonerId: String, resultId: String): URI =
    new URI(baseUriResultId + "/" + reasonerId + "/" + resultId)

  val deepThought: Reasoner = new Reasoner {
    override val id: String = "deepThought"

    override def reason(request: DefaultRequest): Response = {
      Response(
        `@context` = contextUri(id),
        `@id` = idUri(id),
        `@type` = typeDefault,
        schema_version = Reasoner.apiVersion,
        tool_version = version,
        datetime = now,
        original_question_text = request.items.mkString(", "),
        restated_question_text = request.items.mkString(", "),
        result_code = "Ok",
        message ="Do I have an answer for you? Yes, I have!",
        result_list = Seq(
          Result(
            `@id` = idResultUri(id, "best"),
            text = "The answer is 42",
            confidence = 1.0f,
            result_graph = ResultGraph(Seq.empty, Seq.empty)
          )
        )
      )
    }

    override val version: String = "42"
  }

  val hal9000: Reasoner = new Reasoner {
    override val id: String = "hal9000"

    override def reason(request: DefaultRequest): Response = {
      Response(
        `@context` = contextUri(id),
        `@id` = idUri(id),
        `@type` = typeDefault,
        schema_version = "1.2.3",
        tool_version = version,
        datetime = now,
        original_question_text = request.items.mkString(", "),
        restated_question_text = request.items.mkString(", "),
        result_code = "Fatal",
        message = s"""I'm sorry, Dave, I'm afraid I can't do that.""",
        result_list = Seq.empty
      )
    }

    override val version: String = "9000"
  }

  val all: Map[String, Reasoner] = Set(deepThought, hal9000).map(reasoner => (reasoner.id, reasoner)).toMap
}
