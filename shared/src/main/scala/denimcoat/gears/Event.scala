package denimcoat.gears

import denimcoat.gears.Event.Cascade

import scala.util.Random

trait Event[+T] {
  def cascade: Cascade
  def valueOpt: Option[T]
}

object Event {


  trait Cascade {
    def time: Long
    def random: Long
  }

  case class InvalidationCascade(time: Long, random: Long) extends Cascade {
    def createNewEvent(): NoValidValue = NoValidValue(this)
  }

  case class RevalidationCascade(time: Long, random: Long) extends Cascade {
    def createNewEvent[T](value: T): ValidValue[T] = ValidValue(this, value)
  }

  object InvalidationCascade {
    def createNew(): InvalidationCascade = InvalidationCascade(System.currentTimeMillis(), Random.nextLong())
  }

  object RevalidationCascade {
    def createNew(): RevalidationCascade = RevalidationCascade(System.currentTimeMillis(), Random.nextLong())
  }

  case class NoValidValue(cascade: InvalidationCascade) extends Event[Nothing] {
    override def valueOpt: None.type = None
  }

  case class ValidValue[+T](cascade: RevalidationCascade, value: T) extends Event[T] {
    override def valueOpt: Some[T] = Some(value)
  }
}
