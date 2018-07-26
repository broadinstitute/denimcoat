package denimcoat.gears.providers

import denimcoat.gears.{Consumer, Event}

trait Function1Provider[-T1, +R] extends Provider[R] with Consumer[T1] {
  def function: T1 => R
}

object Function1Provider {
  class Impl[-T1, R](val function: T1 => R) extends Function1Provider[T1, R] with NotificationProviderImpl[R] {
    override def receive(event: Event[T1]): Unit = {
      setValueOpt(event.valueOpt.map(function))
    }
  }
}