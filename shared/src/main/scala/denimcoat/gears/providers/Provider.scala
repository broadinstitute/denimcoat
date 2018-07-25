package denimcoat.gears.providers

import denimcoat.gears.Consumer

trait Provider[+T] extends Provider.Base {

  def get: Option[T]

  def addConsumer(consumer: Consumer[T]): Unit

  def removeConsumer(consumer: Consumer[T]): Unit
}

object Provider {

  trait Base {
    def get: Option[Any]
  }

}
