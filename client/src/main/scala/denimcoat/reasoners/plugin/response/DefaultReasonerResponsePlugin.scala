package denimcoat.reasoners.plugin.response

import denimcoat.JsonIO
import denimcoat.reasoners.extract.{DefaultResponseExtractor, ResponseExtractor}
import denimcoat.reasoners.messages.DefaultResponse

case class DefaultReasonerResponsePlugin(reasonerId: String) extends ReasonerResponsePlugin {
  override type Response = DefaultResponse
  override type Extractor = DefaultResponseExtractor

  override def decodeResponse(responseString: String): Either[String, DefaultResponse] =
    JsonIO.decodeResponse(responseString)

  override def getExtractorForBase(response: AnyRef): Either[String, ResponseExtractor] = {
    response match {
      case defaultResponse: DefaultResponse => Right(getExtractorFor(defaultResponse))
      case _ => Left(s"Expected DefaultResponse, but got ${response.getClass.getCanonicalName}.")
    }
  }

  override def getExtractorFor(response: DefaultResponse): DefaultResponseExtractor =
    new DefaultResponseExtractor(response)
}
