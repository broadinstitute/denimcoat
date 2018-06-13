package denimcoat.reasoners

import denimcoat.reasoners.messages.{Request, Response}

trait Reasoner {

  def id: String

  def version: String

  def reason(request: Request): Response

}

object Reasoner {

  val apiVersion: String = "0.9"

}
