package denimcoat.gears.providers

import denimcoat.gears.{Consumer, Event}

trait NotificationProviderImpl[T] extends Provider[T] {

  var valueOpt: Option[T] = None
  var consumers: Set[Consumer[T]] = Set.empty
  var lastEvent: Event[T] = Event.InvalidationCascade.createNew().createNewEvent()

  protected def notifyAllConsumers(event: Event[T]): Unit = {
    consumers.foreach(_.receive(event))
  }

  protected def invalidateValue(): Unit = {
    if(valueOpt.nonEmpty) {
      valueOpt = None
      val event = Event.InvalidationCascade.createNew().createNewEvent()
      lastEvent = event
      notifyAllConsumers(event)
    }
  }

  protected def revalidateValue(value: T): Unit = {
    if (valueOpt.isEmpty || valueOpt.get != value) {
      if(valueOpt.nonEmpty) { invalidateValue() }
      valueOpt = Some(value)
      val event = Event.RevalidationCascade.createNew().createNewEvent(value)
      lastEvent = event
      notifyAllConsumers(event)
    }
  }

  protected def setValueOpt(valueOpt: Option[T]): Unit = valueOpt.fold(invalidateValue())(revalidateValue)

  def get: Option[T] = valueOpt

  def addConsumer(consumer: Consumer[T]): Unit = {
    if(!consumers(consumer)) {
      consumers += consumer
      consumer.receive(lastEvent)
    }
  }

  def removeConsumer(consumer: Consumer[T]): Unit = consumers -= consumer

}
