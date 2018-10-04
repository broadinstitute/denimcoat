package denimcoat.reasoners.plugin

import denimcoat.reasoners.knowledge.{IdPrefix, Relation}
import denimcoat.reasoners.messages.DefaultRequestBody
import denimcoat.reasoners.plugin.ReasonerPlugin.Request
import denimcoat.reasoners.plugin.response.ReasonerResponsePlugin

trait ReasonerPlugin {

  type ResponsePlugin <: ReasonerResponsePlugin

  def responsePlugin: ResponsePlugin

  def reasonerId: String

  def mightBeAbleTo(inputPrefix: IdPrefix, outputPrefix: IdPrefix): Boolean

  def createRequests(relation: Relation, inputPrefix: IdPrefix, outputPrefix: IdPrefix,
                     inputItems: Seq[String]): Either[String, Seq[Request]]
}

object ReasonerPlugin {
  case class Request(url: String, bodyOpt: Option[DefaultRequestBody])
}
