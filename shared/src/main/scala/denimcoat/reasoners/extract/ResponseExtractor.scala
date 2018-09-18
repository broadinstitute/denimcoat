package denimcoat.reasoners.extract

trait ResponseExtractor {
  type Response

  def response: Response
  def targetNodeNames: Seq[String]
}
