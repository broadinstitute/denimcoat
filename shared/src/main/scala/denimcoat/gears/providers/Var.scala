package denimcoat.gears.providers

import denimcoat.gears.{Consumer, Event}

class Var[T] extends NotificationProviderImpl[T] with Consumer[T] {

  def setValue(value: T): Unit = revalidateValue(value)

  def unsetValue(): Unit = invalidateValue()

  override def setValueOpt(valueOpt: Option[T]): Unit = super.setValueOpt(valueOpt)

  def modify(function: T => T): Unit = {
    setValueOpt(valueOpt.map(function))
  }

  override def receive(event: Event[T]): Unit = setValueOpt(event.valueOpt)
}

object Var {
  def apply[T](): Var[T] = new Var[T]

  def apply[T](value: T): Var[T] = {
    val variable = new Var[T]
    variable.setValue(value)
    variable
  }

  def apply[T](valueOpt: Option[T]): Var[T] = {
    val variable = new Var[T]
    variable.setValueOpt(valueOpt)
    variable
  }
}
