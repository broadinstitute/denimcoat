package denimcoat.reasoners.plugin

import denimcoat.reasoners.knowledge.{IdPrefix, PrefixedId, Relation}
import denimcoat.reasoners.mvp.BioThingsExplorerUtils
import denimcoat.reasoners.plugin.ReasonerPlugin.Request
import denimcoat.reasoners.plugin.response.DefaultReasonerResponsePlugin
import denimcoat.svg.mvp.ReasonerList

object BioThingsExplorerPlugin extends ReasonerPlugin {
  override type ResponsePlugin = DefaultReasonerResponsePlugin

  override def responsePlugin: ResponsePlugin = DefaultReasonerResponsePlugin(reasonerId)

  override def reasonerId: String = ReasonerList.biothings.id

  override def mightBeAbleTo(inputPrefix: IdPrefix, outputPrefix: IdPrefix): Boolean = inputPrefix != outputPrefix

  override def createRequests(relation: Relation, inputPrefix: IdPrefix, outputPrefix: IdPrefix,
                              inputItems: Seq[PrefixedId]): Either[String, Seq[ReasonerPlugin.Request]] = {
    val requests = inputItems.map { inputItem =>
      val url = BioThingsExplorerUtils.buildUrl(inputItem, outputPrefix)
      Request(url, None)
    }
    Right(requests)
  }
}
