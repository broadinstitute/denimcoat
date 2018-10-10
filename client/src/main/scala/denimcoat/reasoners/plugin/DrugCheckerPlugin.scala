package denimcoat.reasoners.plugin

import denimcoat.reasoners.knowledge.{IdPrefix, PrefixedId, Relation}
import denimcoat.reasoners.mvp.DrugCheckerUtils
import denimcoat.reasoners.plugin.ReasonerPlugin.Request
import denimcoat.reasoners.plugin.response.DrugCheckerResponsePlugin
import denimcoat.svg.mvp.ReasonerList

object DrugCheckerPlugin extends ReasonerPlugin {
  override type ResponsePlugin = DrugCheckerResponsePlugin.type

  override def responsePlugin: ResponsePlugin = DrugCheckerResponsePlugin

  override def reasonerId: String = ReasonerList.drugChecker.id

  override def mightBeAbleTo(inputPrefix: IdPrefix, outputPrefix: IdPrefix): Boolean =
    inputPrefix == IdPrefix.chemblCompound && outputPrefix == IdPrefix.chemblCompound

  override def createRequests(relation: Relation, inputPrefix: IdPrefix, outputPrefix: IdPrefix,
                              inputItems: Seq[PrefixedId]): Either[String, Seq[ReasonerPlugin.Request]] = {
    if (mightBeAbleTo(inputPrefix, outputPrefix)) {
      val request = Request(DrugCheckerUtils.buildUrl(inputItems), None)
      Right(Seq(request))
    } else {
      Left(s"Don't know how to go from $inputPrefix to $outputPrefix")
    }
  }
}
