package denimcoat.gears.syntax

import denimcoat.gears.providers.{Function1Provider, Function2Provider, Provider}

object DoubleProviderOpsEnabling {

  implicit class DoubleProviderOpsEnabler(provider: Provider[Double]) {

    def createFunction2Provider(oProvider: Provider[Double])(
      function: (Double, Double) => Double): Provider[Double] = {
      Function2Provider(provider, oProvider)(function)
    }

    def +(oProvider: Provider[Double]): Provider[Double] = createFunction2Provider(oProvider)(_ + _)

    def -(oProvider: Provider[Double]): Provider[Double] = createFunction2Provider(oProvider)(_ - _)

    def *(oProvider: Provider[Double]): Provider[Double] = createFunction2Provider(oProvider)(_ * _)

    def /(oProvider: Provider[Double]): Provider[Double] = createFunction2Provider(oProvider)(_ / _)

    def createFunction1Provider(function: Double => Double): Provider[Double] = {
      Function1Provider(provider)(function)
    }

    def +(value: Double): Provider[Double] = createFunction1Provider(_ + value)

    def -(value: Double): Provider[Double] = createFunction1Provider(_ - value)

    def *(value: Double): Provider[Double] = createFunction1Provider(_ * value)

    def /(value: Double): Provider[Double] = createFunction1Provider(_ / value)
  }

  implicit class DoubleValueOpsEnabler(value: Double) {
    def +(provider: Provider[Double]): Provider[Double] = Function1Provider(provider)(value + _)

    def -(provider: Provider[Double]): Provider[Double] = Function1Provider(provider)(value - _)

    def *(provider: Provider[Double]): Provider[Double] = Function1Provider(provider)(value * _)

    def /(provider: Provider[Double]): Provider[Double] = Function1Provider(provider)(value / _)
  }
}
