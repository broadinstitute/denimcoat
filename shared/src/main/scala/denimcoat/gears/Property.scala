package denimcoat.gears

import denimcoat.gears.providers.{Provider, SettableValueProvider}

class Property[T](val setterAction: T => Unit, val unsetterAction: () => Unit) {

  protected val setterConsumer: Consumer[T] = (event: Event[T]) => setValueOption(event.valueOpt)

  protected var setterProviderOpt: Option[Provider[T]] = None

  protected val getterProvider: SettableValueProvider[T] = new SettableValueProvider[T]

  def asProvider: Provider[T] = getterProvider

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
}
