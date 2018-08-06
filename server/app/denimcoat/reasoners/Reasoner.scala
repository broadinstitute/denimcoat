package denimcoat.reasoners

import denimcoat.reasoners.messages.{DefaultRequest, Response}

trait Reasoner {

  def id: String

  def version: String

  def reason(request: DefaultRequest): Response

}

object Reasoner {

  val apiVersion: String = "0.9"

}
