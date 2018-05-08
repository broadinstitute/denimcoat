package denimcoat.reasoners.mock

import java.util.Date

import denimcoat.reasoners.Reasoner

object MockReasoners {

  def now: Date = new Date(System.currentTimeMillis())

  val deepThought: Reasoner = new Reasoner {
    override val id: String = "deepThought"

    override def reason(request: Reasoner.Request): Reasoner.Response = {
      Reasoner.Response(s"""The answer to "${request.text}" is 42.""", now)
    }
  }

  val hal9000: Reasoner = new Reasoner {
    override val id: String = "hal9000"

    override def reason(request: Reasoner.Request): Reasoner.Response = {
      Reasoner.Response(s"""I'm sorry, Dave, I'm afraid I can't do that.""", now)
    }
  }

  val all: Map[String, Reasoner] = Set(deepThought, hal9000).map(reasoner => (reasoner.id, reasoner)).toMap
}
