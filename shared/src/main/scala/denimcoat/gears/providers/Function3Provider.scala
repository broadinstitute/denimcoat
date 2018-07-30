package denimcoat.gears.providers

import denimcoat.gears.{Consumer, Event}

trait Function3Provider[-T1, -T2, -T3, +R] extends Provider[R] {
  def function: (T1, T2, T3) => R

  def receive1(event: Event[T1]): Unit

  def receive2(event: Event[T2]): Unit

  def receive3(event: Event[T3]): Unit

  val consumer1: Consumer[T1] = (event: Event[T1]) => receive1(event)
  val consumer2: Consumer[T2] = (event: Event[T2]) => receive2(event)
  val consumer3: Consumer[T3] = (event: Event[T3]) => receive3(event)
}

object Function3Provider {

  def apply[T1, T2, T3, R](function: (T1, T2, T3) => R): Function3Provider[T1, T2, T3, R] = new Impl(function)

  def apply[T1, T2, T3, R](provider1: Provider[T1], provider2: Provider[T2],
                           provider3: Provider[T3])(function: (T1, T2, T3) => R): Function3Provider[T1, T2, T3, R] = {
    val resultProvider = new Impl[T1, T2, T3, R](function)
    provider1.addConsumer(resultProvider.consumer1)
    provider2.addConsumer(resultProvider.consumer2)
    provider3.addConsumer(resultProvider.consumer3)
    resultProvider
  }

  class Impl[T1, T2, T3, R](val function: (T1, T2, T3) => R)
    extends Function3Provider[T1, T2, T3, R] with NotificationProviderImpl[R] {
    var input1Opt: Option[T1] = None
    var input2Opt: Option[T2] = None
    var input3Opt: Option[T3] = None

    override def receive1(event: Event[T1]): Unit = {
      input1Opt = event.valueOpt
      eval()
    }

    override def receive2(event: Event[T2]): Unit = {
      input2Opt = event.valueOpt
      eval()
    }

    override def receive3(event: Event[T3]): Unit = {
      input3Opt = event.valueOpt
      eval()
    }

    protected def eval(): Unit = {
      val valueOptNew = for {
        input1 <- input1Opt
        input2 <- input2Opt
        input3 <- input3Opt
      } yield function(input1, input2, input3)
      setValueOpt(valueOptNew)
    }
  }

}