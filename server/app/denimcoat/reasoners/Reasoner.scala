package denimcoat.reasoners

import denimcoat.reasoners.messages.{DefaultRequestBody, DefaultResponse}

trait Reasoner {

  def id: String

  def version: String

  def reason(request: DefaultRequestBody): DefaultResponse

}

object Reasoner {

  val apiVersion: String = "0.9"

}
