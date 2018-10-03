package denimcoat.reasoners.plugin

import denimcoat.reasoners.knowledge.{IdPrefix, Relation}
import denimcoat.reasoners.messages.DefaultRequestBody
import denimcoat.reasoners.plugin.response.ReasonerResponsePlugin

trait ReasonerPlugin {

  type ResponsePlugin <: ReasonerResponsePlugin

  def responsePlugin: ResponsePlugin

  def reasonerId: String

  def mightBeAbleTo(inputPrefix: IdPrefix, outputPrefix: IdPrefix): Boolean

  def createUrl(inputPrefix: IdPrefix, outputPrefix: IdPrefix, inputValue: String): Either[String, String]

  def createRequestBodyOpt(startItems: Seq[String], relation: Relation): Option[DefaultRequestBody]
}

object ReasonerPlugin {
  case class Request(url: String, bodyOpt: Option[DefaultRequestBody])
}
