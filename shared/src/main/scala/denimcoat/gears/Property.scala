package denimcoat.gears

import denimcoat.gears.providers.{Provider, Var}

class Property[T](val setterAction: T => Unit, val unsetterAction: () => Unit) extends Provider[T] {

  protected val setterConsumer: Consumer[T] = (event: Event[T]) => setValueOption(event.valueOpt)

  protected var setterProviderOpt: Option[Provider[T]] = None

  protected val getterProvider: Var[T] = new Var[T]

  protected def set(value: T): Unit = {
    setterAction(value)
    getterProvider.setValue(value)
  }

  protected def unset(): Unit = {
    unsetterAction()
    getterProvider.unsetValue()
  }

  protected def setValueOption(valueOpt: Option[T]): Unit = {
    valueOpt.fold(unsetterAction())(setterAction)
    getterProvider.setValueOpt(valueOpt)
  }

  def setProviderOpt(providerOpt: Option[Provider[T]]): Unit = {
    if (providerOpt != setterProviderOpt) {
      setterProviderOpt.foreach(_.removeConsumer(setterConsumer))
      setterProviderOpt = providerOpt
      setterProviderOpt.foreach(_.addConsumer(setterConsumer))
    }
  }

  def setProvider(provider: Provider[T]): Unit = setProviderOpt(Some(provider))

  def unsetProvider(): Unit = setProviderOpt(None)

  override def get: Option[T] = getterProvider.get

  override def addConsumer(consumer: Consumer[T]): Unit = getterProvider.addConsumer(consumer)

  override def removeConsumer(consumer: Consumer[T]): Unit = getterProvider.removeConsumer(consumer)
}

object Property {

  def apply[T](setterAction: T => Unit, unsetterAction: () => Unit = () => ()): Property[T] =
    new Property[T](setterAction, unsetterAction)
}
