package denimcoat.util

case class FloodThrottler(time: Long = 60000, maxNum: Int = 10) {

  var times: Seq[Long] = Seq.fill(maxNum)(0)

  def apply[T](task: => T): Option[T] = {
    val current = System.currentTimeMillis()
    if(current > times.head + time) {
      times = times.tail :+ current
      Some(task)
    } else {
      None
    }
  }

}
