package denimcoat.reasoners.mock

import denimcoat.reasoners.Reasoner
import denimcoat.reasoners.messages.{Request, Response}

object Galen extends Reasoner {
  override def id: String = "galen"

  override def version: String = "0.1"

  def getEntity(string: String): Option[Entity] = ???

  override def reason(request: Request): Response = {
    val starts: Set[Entity] = request.items.toSet.flatMap(getEntity)
    ???
  }
}
