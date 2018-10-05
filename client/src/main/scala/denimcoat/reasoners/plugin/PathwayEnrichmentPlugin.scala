package denimcoat.reasoners.plugin

import denimcoat.reasoners.knowledge.{IdPrefix, Relation}
import denimcoat.reasoners.mvp.PathwayEnrichmentUtils
import denimcoat.reasoners.plugin.ReasonerPlugin.Request
import denimcoat.reasoners.plugin.response.PathwayEnrichmentResponsePlugin
import denimcoat.svg.mvp.ReasonerList

object PathwayEnrichmentPlugin extends ReasonerPlugin {
  override type ResponsePlugin = PathwayEnrichmentResponsePlugin.type

  override def responsePlugin: ResponsePlugin = PathwayEnrichmentResponsePlugin

  override def reasonerId: String = ReasonerList.pathwayEnrichment.id

  override def mightBeAbleTo(inputPrefix: IdPrefix, outputPrefix: IdPrefix): Boolean = {
    IdPrefix.ncbigene == inputPrefix && IdPrefix.ncbigene == outputPrefix
  }

  override def createRequests(relation: Relation, inputPrefix: IdPrefix, outputPrefix: IdPrefix,
                              inputItems: Seq[String]): Either[String, Seq[ReasonerPlugin.Request]] = {
    if (mightBeAbleTo(inputPrefix, outputPrefix)) {
      val request = Request(PathwayEnrichmentUtils.buildUrl(inputItems), None)
      Right(Seq(request))
    } else {
      Left(s"Don't know how to go from $inputPrefix to $outputPrefix")
    }
  }
}
