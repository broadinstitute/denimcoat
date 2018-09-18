package denimcoat.reasoners.plugin.response
import denimcoat.JsonIO
import denimcoat.reasoners.extract.{DrugCheckerResponseExtractor, ResponseExtractor}
import denimcoat.reasoners.mvp.DrugCheckerUtils
import denimcoat.svg.mvp.ReasonerList

object DrugCheckerResponsePlugin extends ReasonerResponsePlugin {
  override type Response = DrugCheckerUtils.Response
  override type Extractor = DrugCheckerResponseExtractor

  override def reasonerId: String = ReasonerList.drugChecker.id

  override def decodeResponse(responseString: String): Either[String, Response] =
    JsonIO.decodeDrugCheckerResponse(responseString)

  override def getExtractorForBase(response: AnyRef): Either[String, ResponseExtractor] = response match {
    case drugCheckerResponse: Response => Right(getExtractorFor(drugCheckerResponse))
    case _ => Left(s"Expected drug checker response, but got ${response.getClass.getCanonicalName}.")
  }

  override def getExtractorFor(response: Response): ResponseExtractor = new DrugCheckerResponseExtractor(response)
}
