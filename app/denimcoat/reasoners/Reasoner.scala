package denimcoat.reasoners

import java.util.Date

import denimcoat.reasoners.Reasoner.{Request, Response}

trait Reasoner {

  def reason(request: Request): Response

}

object Reasoner {

  case class Request(text: String, timestamp: Date)

  case class Response(text: String, timestamp: Date)

}
