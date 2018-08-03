package denimcoat.gears.providers

import denimcoat.gears.{Consumer, Event}

import scala.util.Try

trait TriggeredRefreshProvider[+T] extends Provider[T] {
  def trigger(): Unit

  def asConsumer[S]: Consumer[S] = (_: Event[S]) => trigger()
}

object TriggeredRefreshProvider {

  def apply[T](generator: () => T): TriggeredRefreshProvider[T] = new Impl[T](generator)

  class Impl[T](val generator: () => T) extends TriggeredRefreshProvider[T] {

    private def optFromGenerator: Option[T] = Try(generator()).toOption

    val delegate: Var[T] = Var(optFromGenerator)

    override def trigger(): Unit = delegate.setValueOpt(optFromGenerator)

    override def get: Option[T] = delegate.get

    override def addConsumer(consumer: Consumer[T]): Unit = delegate.addConsumer(consumer)

    override def removeConsumer(consumer: Consumer[T]): Unit = delegate.removeConsumer(consumer)
  }

}
