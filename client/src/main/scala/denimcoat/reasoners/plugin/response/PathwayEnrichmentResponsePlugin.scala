package denimcoat.reasoners.plugin.response

import denimcoat.JsonIO
import denimcoat.reasoners.extract.{PathwayEnrichmentExtractor, ResponseExtractor}
import denimcoat.reasoners.mvp.PathwayEnrichmentUtils
import denimcoat.svg.mvp.ReasonerList

object PathwayEnrichmentResponsePlugin extends ReasonerResponsePlugin {
  override type Response = PathwayEnrichmentUtils.Response
  override type Extractor = PathwayEnrichmentExtractor

  override def reasonerId: String = ReasonerList.pathwayEnrichment.id

  override def decodeResponse(responseString: String): Either[String, Response] =
    JsonIO.decodePathwayEnrichmentResponse(responseString)

  override def getExtractorForBase(response: AnyRef): Either[String, ResponseExtractor] = response match {
    case pathwayEnrichmentResponse: Response => Right(getExtractorFor(pathwayEnrichmentResponse))
    case _ => Left(s"Expected pathway enrichment response, but got ${response.getClass.getCanonicalName}.")
  }

  override def getExtractorFor(response: Response): ResponseExtractor = new PathwayEnrichmentExtractor(response)
}
