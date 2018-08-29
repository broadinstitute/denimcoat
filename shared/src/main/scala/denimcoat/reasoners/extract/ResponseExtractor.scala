package denimcoat.reasoners.extract

import denimcoat.reasoners.messages.ResponseBase

trait ResponseExtractor {
  type Response <: ResponseBase

  def response: Response
  def targetNodeNames: Seq[String]
}
