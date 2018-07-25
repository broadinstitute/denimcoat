package denimcoat.gears.providers

trait Function1Provider[-T1, +R] extends Provider[R] {
  def function: T1 => R
}

object Function1Provider {
  class Impl[-T1, R](val function: T1 => R) extends Function1Provider[T1, R] with NotificationProviderImpl[R]
}