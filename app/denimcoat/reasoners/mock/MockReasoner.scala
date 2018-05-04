package denimcoat.reasoners.mock

import java.util.Date

import denimcoat.reasoners.Reasoner

object MockReasoner extends Reasoner {

  def now: Date = new Date(System.currentTimeMillis())

  override def reason(request: Reasoner.Request): Reasoner.Response = {
    Reasoner.Response(request.text, now)
  }
}
