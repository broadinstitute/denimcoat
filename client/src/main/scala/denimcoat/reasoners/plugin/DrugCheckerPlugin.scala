package denimcoat.reasoners.plugin
import denimcoat.reasoners.knowledge.{IdPrefix, Relation}
import denimcoat.reasoners.messages.DefaultRequest
import denimcoat.reasoners.plugin.response.DrugCheckerResponsePlugin
import denimcoat.svg.mvp.ReasonerList

object DrugCheckerPlugin extends ReasonerPlugin {
  override type ResponsePlugin = DrugCheckerResponsePlugin.type

  override def responsePlugin: ResponsePlugin = ???

  override def reasonerId: String = ReasonerList.drugChecker.id

  override def mightBeAbleTo(inputPrefix: IdPrefix, outputPrefix: IdPrefix): Boolean = ???

  override def createUrl(inputPrefix: IdPrefix, outputPrefix: IdPrefix, inputValue: String): Either[String, String] = ???

  override def createRequestOpt(startItems: Seq[String], relation: Relation): Option[DefaultRequest] = ???
}
