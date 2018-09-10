package denimcoat.reasoners.extract

import denimcoat.reasoners.mvp.MonarchInitiativeUtils
import denimcoat.util.Entity

class MonarchInitiativeResponseExtractor(override val response: MonarchInitiativeUtils.Response)
  extends ResponseExtractor {
  type Response = MonarchInitiativeUtils.Response

  override def targetNodeNames: Seq[String] = {
    response.associations.map(_.`object`).map(obj => obj.label + "; " + Entity.normalizeId(obj.id))
  }
}
