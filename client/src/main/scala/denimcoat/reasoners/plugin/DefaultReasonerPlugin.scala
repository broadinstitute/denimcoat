package denimcoat.reasoners.plugin
import denimcoat.reasoners.knowledge.{IdPrefix, PrefixedId, Relation}
import denimcoat.reasoners.messages.DefaultRequestBody
import denimcoat.reasoners.plugin.ReasonerPlugin.Request
import denimcoat.reasoners.plugin.response.DefaultReasonerResponsePlugin

case class DefaultReasonerPlugin(override val reasonerId: String) extends ReasonerPlugin {
  override type ResponsePlugin = DefaultReasonerResponsePlugin

  override def responsePlugin: ResponsePlugin = DefaultReasonerResponsePlugin(reasonerId)

  val url: String = "/reasoner/" + reasonerId

  override def mightBeAbleTo(inputPrefix: IdPrefix, outputPrefix: IdPrefix): Boolean = true

  override def createRequests(relation: Relation, inputPrefix: IdPrefix, outputPrefix: IdPrefix,
                              inputItems: Seq[PrefixedId]): Either[String, Seq[ReasonerPlugin.Request]] = {
    val request = Request(url, Some(DefaultRequestBody(inputItems.map(_.toString), relation)))
    Right(Seq(request))
  }
}
