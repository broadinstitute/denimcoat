package denimcoat.reasoners.extract

import denimcoat.util.Entity

trait ResponseExtractor {
  type Response

  def response: Response
  def targetNodeNames: Seq[String]
  def entities: Seq[Entity] = targetNodeNames.map(Entity.parse)
}
