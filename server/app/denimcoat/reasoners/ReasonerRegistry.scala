package denimcoat.reasoners

import denimcoat.reasoners.mock.Galen

object ReasonerRegistry {

  var reasoners: Map[String, Reasoner] = Map.empty

  add(Galen)

  def add(reasoner: Reasoner): Unit = {
    reasoners += reasoner.id -> reasoner
  }

  def get(id: String): Option[Reasoner] = reasoners.get(id)

}
