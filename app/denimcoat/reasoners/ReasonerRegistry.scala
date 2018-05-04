package denimcoat.reasoners

import denimcoat.reasoners.mock.MockReasoner

object ReasonerRegistry {

  val reasoners: Map[String, Reasoner] = Map("mock" -> MockReasoner)

  def get(id: String): Option[Reasoner] = reasoners.get(id)

}
