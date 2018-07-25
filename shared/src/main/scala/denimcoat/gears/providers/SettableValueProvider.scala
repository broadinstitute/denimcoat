package denimcoat.gears.providers

class SettableValueProvider[T] extends AbstractProvider[T] {

  def setValue(value: T): Unit = revalidateValue(value)

  def unsetValue(): Unit = invalidateValue()

}
