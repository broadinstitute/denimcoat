package denimcoat.reasoners.plugin.response

import denimcoat.reasoners.extract.ResponseExtractor

trait ReasonerResponsePlugin {

  type Response <: AnyRef
  type Extractor <: ResponseExtractor

  def reasonerId: String

  def decodeResponse(responseString: String): Either[String, Response]

  def getExtractorForBase(response: AnyRef): Either[String,ResponseExtractor]

  def getExtractorFor(response: Response): ResponseExtractor

  def getExtractorFor(responseString: String): Either[String, ResponseExtractor] =
    decodeResponse(responseString).map(getExtractorFor)
}
