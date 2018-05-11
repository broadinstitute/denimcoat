package denimcoat.reasoners

import java.net.URI
import java.util.Date

import denimcoat.reasoners.Reasoner.{Request, Response}

trait Reasoner {

  def id: String

  def reason(request: Request): Response

}

object Reasoner {

  case class Request(text: String, timestamp: Date)

  case class Result(id: URI, text: String, confidence: Float)

  case class Response(context: URI, id: URI, aType: String, schemaVersion: String, toolVersion: String, datetime: Date,
                      originalQuestionText: String, restatedQuestionText: String, resultCode: String, message: String,
                      resultList: Seq[Result])

}
