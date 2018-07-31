package denimcoat.gears.providers

class Var[T] extends NotificationProviderImpl[T] {

  def setValue(value: T): Unit = revalidateValue(value)

  def unsetValue(): Unit = invalidateValue()

  override def setValueOpt(valueOpt: Option[T]): Unit = super.setValueOpt(valueOpt)

  def modify(function: T => T): Unit = {
    setValueOpt(valueOpt.map(function))
  }
}

object Var {
  def apply[T](): Var[T] = new Var[T]

  def apply[T](value: T): Var[T] = {
    val variable = new Var[T]
    variable.setValue(value)
    variable
  }
}
