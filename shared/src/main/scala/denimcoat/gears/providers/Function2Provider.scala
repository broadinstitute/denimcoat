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

  def apply[T1, T2, R](function: (T1, T2) => R): Function2Provider[T1, T2, R] = new Impl[T1, T2, R](function)

  def apply[T1, T2, R](provider1: Provider[T1],
                       provider2: Provider[T2])(function: (T1, T2) => R): Function2Provider[T1, T2, R] = {
    val resultProvider = new Impl[T1, T2, R](function)
    provider1.addConsumer(resultProvider.consumer1)
    provider2.addConsumer(resultProvider.consumer2)
    resultProvider
  }

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
      val valueOptNew = for {
        input1 <- input1Opt
        input2 <- input2Opt
      } yield function(input1, input2)
      setValueOpt(valueOptNew)
    }
  }

}