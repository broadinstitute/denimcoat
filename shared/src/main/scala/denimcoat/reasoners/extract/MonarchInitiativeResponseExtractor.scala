package denimcoat.reasoners.extract

import denimcoat.reasoners.mvp.MonarchInitiativeUtils

class MonarchInitiativeResponseExtractor(override val response: MonarchInitiativeUtils.Response)
  extends ResponseExtractor {
  type Response = MonarchInitiativeUtils.Response

  override def targetNodeNames: Seq[String] = {
    ???
  }
}
