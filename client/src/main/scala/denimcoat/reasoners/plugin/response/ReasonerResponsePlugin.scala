package denimcoat.reasoners.plugin.response

import denimcoat.reasoners.extract.ResponseExtractor
import denimcoat.reasoners.messages.ResponseBase

trait ReasonerResponsePlugin {

  type Response <: ResponseBase
  type Extractor <: ResponseExtractor

  def reasonerId: String

  def decodeResponse(responseString: String): Either[String, Response]

  def getExtractorForBase(response: ResponseBase): Either[String,ResponseExtractor]

  def getExtractorFor(response: Response): ResponseExtractor

  def getExtractorFor(responseString: String): Either[String, ResponseExtractor] =
    decodeResponse(responseString).map(getExtractorFor)
}
