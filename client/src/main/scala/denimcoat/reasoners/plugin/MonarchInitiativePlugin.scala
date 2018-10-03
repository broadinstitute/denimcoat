package denimcoat.reasoners.plugin
import denimcoat.reasoners.knowledge.{IdPrefix, Relation}
import denimcoat.reasoners.mvp.MonarchInitiativeUtils
import denimcoat.reasoners.plugin.response.MonarchInitiativeResponsePlugin
import denimcoat.svg.mvp.ReasonerList

object MonarchInitiativePlugin extends ReasonerPlugin {
  override type ResponsePlugin = MonarchInitiativeResponsePlugin.type

  override def responsePlugin: ResponsePlugin = MonarchInitiativeResponsePlugin

  override def reasonerId: String = ReasonerList.monarch.id

  override def mightBeAbleTo(inputPrefix: IdPrefix, outputPrefix: IdPrefix): Boolean =
    MonarchInitiativeUtils.canDo(inputPrefix, outputPrefix)

  override def createRequests(relation: Relation, inputPrefix: IdPrefix, outputPrefix: IdPrefix,
                              inputItems: Seq[String]): Either[String, Seq[ReasonerPlugin.Request]] = {
    val urlEithers = inputItems.map { inputItem =>
      MonarchInitiativeUtils.constructUrl(inputPrefix, inputItem, outputPrefix) }

  }

  override def createUrl(inputPrefix: IdPrefix, outputPrefix: IdPrefix, inputValue: String): Either[String, String] =
    MonarchInitiativeUtils.constructUrl(inputPrefix, inputValue, outputPrefix)

  override def createRequestBodyOpt(startItems: Seq[String], relation: Relation): None.type = None
}
