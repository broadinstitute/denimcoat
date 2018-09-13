package denimcoat.reasoners.plugin

import denimcoat.reasoners.knowledge.{IdPrefix, Relation}
import denimcoat.reasoners.messages.DefaultRequest
import denimcoat.reasoners.plugin.response.ReasonerResponsePlugin

trait ReasonerPlugin {

  type ResponsePlugin <: ReasonerResponsePlugin

  def responsePlugin: ResponsePlugin

  def reasonerId: String

  def mightBeAbleTo(inputPrefix: IdPrefix, outputPrefix: IdPrefix): Boolean

  def createUrl(inputPrefix: IdPrefix, outputPrefix: IdPrefix, inputValue: String): Either[String, String]

  def createRequestOpt(startItems: Seq[String], relation: Relation): Option[DefaultRequest]
}
