package denimcoat.reasoners

import denimcoat.reasoners.messages.{DefaultRequest, DefaultResponse}

trait Reasoner {

  def id: String

  def version: String

  def reason(request: DefaultRequest): DefaultResponse

}

object Reasoner {

  val apiVersion: String = "0.9"

}
