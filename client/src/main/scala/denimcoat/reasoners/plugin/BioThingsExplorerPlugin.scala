package denimcoat.reasoners.plugin

import denimcoat.reasoners.knowledge.{IdPrefix, Relation}
import denimcoat.reasoners.mvp.BioThingsExplorerUtils
import denimcoat.reasoners.plugin.response.DefaultReasonerResponsePlugin
import denimcoat.svg.mvp.ReasonerList

object BioThingsExplorerPlugin extends ReasonerPlugin {
  override type ResponsePlugin = DefaultReasonerResponsePlugin

  override def responsePlugin: ResponsePlugin = DefaultReasonerResponsePlugin(reasonerId)

  override def reasonerId: String = ReasonerList.biothings.id

  override def mightBeAbleTo(inputPrefix: IdPrefix, outputPrefix: IdPrefix): Boolean = inputPrefix != outputPrefix

  override def createUrl(inputPrefix: IdPrefix, outputPrefix: IdPrefix, inputValue: String): Right[String, String] =
    Right(BioThingsExplorerUtils.buildUrl(inputPrefix: IdPrefix, outputPrefix: IdPrefix, inputValue: String))

  override def createRequestOpt(startItems: Seq[String], relation: Relation): None.type = None
}
