package denimcoat.reasoners.plugin.response

import denimcoat.JsonIO
import denimcoat.reasoners.extract.{MonarchInitiativeResponseExtractor, ResponseExtractor}
import denimcoat.reasoners.messages.ResponseBase
import denimcoat.reasoners.mvp.MonarchInitiativeUtils
import denimcoat.svg.mvp.ReasonerList

object MonarchInitiativeResponsePlugin extends ReasonerResponsePlugin {
  override type Response = MonarchInitiativeUtils.Response
  override type Extractor = MonarchInitiativeResponseExtractor

  override def reasonerId: String = ReasonerList.monarch.id

  override def decodeResponse(responseString: String): Either[String, MonarchInitiativeUtils.Response] =
    JsonIO.decodeMonarchResponse(responseString)

  override def getExtractorForBase(response: ResponseBase): Either[String, ResponseExtractor] = {
    response match {
      case monarchResponse: Response => Right(getExtractorFor(monarchResponse))
      case _ => Left(s"Expected Monarch Initiative response, but got ${response.getClass.getCanonicalName}.")
    }
  }

  override def getExtractorFor(response: MonarchInitiativeUtils.Response): ResponseExtractor =
    new MonarchInitiativeResponseExtractor(response)
}
