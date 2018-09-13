package denimcoat.reasoners.plugin
import denimcoat.reasoners.knowledge.{IdPrefix, Relation}
import denimcoat.reasoners.messages.DefaultRequest
import denimcoat.reasoners.plugin.response.DefaultReasonerResponsePlugin

case class DefaultReasonerPlugin(override val reasonerId: String) extends ReasonerPlugin {
  override type ResponsePlugin = DefaultReasonerResponsePlugin

  override def responsePlugin: ResponsePlugin = DefaultReasonerResponsePlugin(reasonerId)

  val url: String = "/reasoner/" + reasonerId

  override def mightBeAbleTo(inputPrefix: IdPrefix, outputPrefix: IdPrefix): Boolean = true

  override def createUrl(inputPrefix: IdPrefix, outputPrefix: IdPrefix, inputValue: String): Right[String, String] =
    Right(url)

  override def createRequestOpt(startItems: Seq[String], relation: Relation): Some[DefaultRequest] =
    Some(DefaultRequest(startItems, relation))
}
