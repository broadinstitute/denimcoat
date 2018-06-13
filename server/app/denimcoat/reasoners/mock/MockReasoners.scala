package denimcoat.reasoners.mock

import java.net.URI
import java.util.Date

import denimcoat.reasoners.Reasoner
import denimcoat.reasoners.messages.{Request, Response, Result, ResultGraph}

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

    override def reason(request: Request): Response = {
      Response(
        context = contextUri(id),
        id = idUri(id),
        `type` = typeDefault,
        schemaVersion = Reasoner.apiVersion,
        toolVersion = version,
        datetime = now,
        originalQuestionText = request.text,
        restatedQuestionText = request.text,
        resultCode = "Ok",
        message ="Do I have an answer for you? Yes, I have!",
        resultList = Seq(
          Result(
            id = idResultUri(id, "best"),
            text = "The answer is 42",
            confidence = 1.0f,
            resultGraph = ResultGraph(Seq.empty, Seq.empty)
          )
        )
      )
    }

    override val version: String = "42"
  }

  val hal9000: Reasoner = new Reasoner {
    override val id: String = "hal9000"

    override def reason(request: Request): Response = {
      Response(
        context = contextUri(id),
        id = idUri(id),
        `type` = typeDefault,
        schemaVersion = "1.2.3",
        toolVersion = version,
        datetime = now,
        originalQuestionText = request.text,
        restatedQuestionText = request.text,
        resultCode = "Fatal",
        message = s"""I'm sorry, Dave, I'm afraid I can't do that.""",
        resultList = Seq.empty
      )
    }

    override val version: String = "9000"
  }

  val all: Map[String, Reasoner] = Set(deepThought, hal9000).map(reasoner => (reasoner.id, reasoner)).toMap
}
