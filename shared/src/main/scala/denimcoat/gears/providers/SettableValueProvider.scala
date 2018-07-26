package denimcoat.gears.providers

class SettableValueProvider[T] extends NotificationProviderImpl[T] {

  def setValue(value: T): Unit = revalidateValue(value)

  def unsetValue(): Unit = invalidateValue()

  override def setValueOpt(valueOpt: Option[T]): Unit = super.setValueOpt(valueOpt)

}
