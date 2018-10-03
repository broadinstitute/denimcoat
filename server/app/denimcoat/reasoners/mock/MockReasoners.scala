package denimcoat.reasoners.mock

import java.net.URI
import java.util.Date

import denimcoat.reasoners.Reasoner
import denimcoat.reasoners.messages.{DefaultRequestBody, DefaultResponse, Result}

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

}
