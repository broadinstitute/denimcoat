package denimcoat.reasoners.extract

import denimcoat.reasoners.mvp.PathwayEnrichmentUtils

class PathwayEnrichmentExtractor(override val response: PathwayEnrichmentUtils.Response) extends ResponseExtractor {
  type Response = PathwayEnrichmentUtils.Response
  override def targetNodeNames: Seq[String] = response.flatMap(_.genes).distinct
}
