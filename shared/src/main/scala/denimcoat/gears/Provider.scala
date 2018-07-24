package denimcoat.gears

trait Provider[+T] extends Provider.Base {
  def get: Option[T]
  def addConsumer(consumer: Consumer[T])
  def removeConsumer(consumer: Consumer[T])
}

object Provider {
  trait Base {
    def get: Option[Any]
  }
}
