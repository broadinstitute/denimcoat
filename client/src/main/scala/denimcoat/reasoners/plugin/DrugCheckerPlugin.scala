package denimcoat.reasoners.plugin

import denimcoat.reasoners.knowledge.{IdPrefix, Relation}
import denimcoat.reasoners.mvp.DrugCheckerUtils
import denimcoat.reasoners.plugin.response.DrugCheckerResponsePlugin
import denimcoat.svg.mvp.ReasonerList

object DrugCheckerPlugin extends ReasonerPlugin {
  override type ResponsePlugin = DrugCheckerResponsePlugin.type

  override def responsePlugin: ResponsePlugin = DrugCheckerResponsePlugin

  override def reasonerId: String = ReasonerList.drugChecker.id

  override def mightBeAbleTo(inputPrefix: IdPrefix, outputPrefix: IdPrefix): Boolean =
    inputPrefix == IdPrefix.chemblCompound && outputPrefix == IdPrefix.chemblCompound

  override def createUrl(inputPrefix: IdPrefix, outputPrefix: IdPrefix, inputValue: String):
  Either[String, String] = {
    if (mightBeAbleTo(inputPrefix, outputPrefix)) {
      Right(DrugCheckerUtils.buildUrl(Seq(inputValue)))
    } else {
      Left(s"Don't know how to go from $inputPrefix to $outputPrefix")
    }
  }

  override def createRequestBodyOpt(startItems: Seq[String], relation: Relation): None.type = None
}
