package denimcoat.reasoners

import denimcoat.reasoners.mock.{Avicenna, Hippocrates, MockReasoners}

object ReasonerRegistry {

  var reasoners: Map[String, Reasoner] = Map.empty

  add(MockReasoners.deepThought)
  add(MockReasoners.hal9000)
  add(Avicenna)
  add(Hippocrates)

  def add(reasoner: Reasoner): Unit = {
    reasoners += reasoner.id -> reasoner
  }

  def get(id: String): Option[Reasoner] = reasoners.get(id)

}
