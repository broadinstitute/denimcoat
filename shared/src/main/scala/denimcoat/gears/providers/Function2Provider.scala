package denimcoat.gears.providers

import denimcoat.gears.{Consumer, Event}

trait Function2Provider[-T1, -T2, +R] extends Provider[R] {
  def function: (T1, T2) => R

  def receive1(event: Event[T1]): Unit

  def receive2(event: Event[T2]): Unit

  val consumer1: Consumer[T1] = (event: Event[T1]) => receive1(event)
  val consumer2: Consumer[T2] = (event: Event[T2]) => receive2(event)
}

object Function2Provider {

  class Impl[T1, T2, R](val function: (T1, T2) => R)
    extends Function2Provider[T1, T2, R] with NotificationProviderImpl[R] {
    var input1Opt: Option[T1] = None
    var input2Opt: Option[T2] = None

    override def receive1(event: Event[T1]): Unit = {
      input1Opt = event.valueOpt
      eval()
    }

    override def receive2(event: Event[T2]): Unit = {
      input2Opt = event.valueOpt
      eval()
    }

    protected def eval(): Unit = {
      val valueOptNew = input1Opt.flatMap(input1 => input2Opt.map(input2 => function(input1, input2)))
      setValueOpt(valueOptNew)
    }
  }

}