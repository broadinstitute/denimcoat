package denimcoat.gears.providers

import denimcoat.gears.Event.RevalidationCascade
import denimcoat.gears.{Consumer, Event}

trait Val[+T] extends Provider[T] {
  def value: T

  override def get: Option[T] = Some(value)
}

object Val {
  def apply[T](value: T): Val[T] = Impl[T](value)

  case class Impl[T](value: T) extends Val[T] {
    val eventOnEnter: Event.ValidValue[T] = RevalidationCascade.createNew().createNewEvent(value)
    var consumers: Set[Consumer[T]] = Set.empty

    override def addConsumer(consumer: Consumer[T]): Unit = {
      if (!consumers(consumer)) {
        consumer.receive(eventOnEnter)
        consumers += consumer
      }
    }

    override def removeConsumer(consumer: Consumer[T]): Unit = consumers -= consumer
  }

}
