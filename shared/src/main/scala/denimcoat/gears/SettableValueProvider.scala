package denimcoat.gears

class SettableValueProvider[T] extends Provider[T] {

  var valueOpt: Option[T] = None
  var consumers: Set[Consumer[T]] = Set.empty

  def setValue(value: T): Unit = {
    valueOpt = Some(value)
    val event = Event.ValidValue.createNew(value)
    consumers.foreach(_.receive(event))
  }

  def unsetValue(): Unit = {
    valueOpt = None
    val event = Event.NoValidValue.createNew
    consumers.foreach(_.receive(event))
  }

  override def get: Option[T] = valueOpt

  override def addConsumer(consumer: Consumer[T]): Unit = consumers += consumer

  override def removeConsumer(consumer: Consumer[T]): Unit = consumers -= consumer
}
