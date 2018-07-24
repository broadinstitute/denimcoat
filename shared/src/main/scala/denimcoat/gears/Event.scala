package denimcoat.gears

import scala.util.Random

trait Event[+T] {
  def time: Long

  def random: Long

  def valueOpt: Option[T]
}

object Event {

  case class NoValidValue(time: Long, random: Long) extends Event[Nothing] {
    override def valueOpt: None.type = None
  }

  object NoValidValue {
    def createNew: NoValidValue = NoValidValue(System.currentTimeMillis(), Random.nextLong())
  }

  case class ValidValue[+T](time: Long, random: Long, value: T) extends Event[T] {
    override def valueOpt: Some[T] = Some(value)
  }

  object ValidValue {
    def createNew[T](value: T): ValidValue[T] = ValidValue(System.currentTimeMillis(), Random.nextLong(), value)
  }



}
