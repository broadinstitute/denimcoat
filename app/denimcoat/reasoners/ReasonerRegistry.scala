package denimcoat.reasoners

import denimcoat.reasoners.mock.MockReasoners

object ReasonerRegistry {

  val reasoners: Map[String, Reasoner] = MockReasoners.all

  def get(id: String): Option[Reasoner] = reasoners.get(id)

}
