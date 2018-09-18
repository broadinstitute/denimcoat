package denimcoat.reasoners.extract

import denimcoat.reasoners.mvp.DrugCheckerUtils

class DrugCheckerResponseExtractor(override val response: DrugCheckerUtils.Response) extends ResponseExtractor {
  type Response = DrugCheckerUtils.Response

  override def targetNodeNames: Seq[String] = response.filter(_.isDrug).map(_.molecule).map("CHEMBL:" + _)
}
