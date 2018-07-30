package denimcoat.gears.syntax

import denimcoat.gears.Property
import denimcoat.gears.providers.{Function1Provider, Function2Provider, Provider}

object PropertyDoubleOpsEnabling {

  implicit class PropertyDoubleOpsEnabler(property: Property[Double]) {

    def createFunction2Provider(oProvider: Provider[Double])(
      function: (Double, Double) => Double): Provider[Double] = {
      Function2Provider(property.asProvider, oProvider)(function)
    }

    def +(oProvider: Provider[Double]): Provider[Double] = createFunction2Provider(oProvider)(_ + _)

    def -(oProvider: Provider[Double]): Provider[Double] = createFunction2Provider(oProvider)(_ - _)

    def *(oProvider: Provider[Double]): Provider[Double] = createFunction2Provider(oProvider)(_ * _)

    def /(oProvider: Provider[Double]): Provider[Double] = createFunction2Provider(oProvider)(_ / _)

    def createFunction2Provider(oProperty: Property[Double])(
      function: (Double, Double) => Double): Provider[Double] =
      createFunction2Provider(oProperty.asProvider)(function)

    def +(oProperty: Property[Double]): Provider[Double] = createFunction2Provider(oProperty)(_ + _)

    def -(oProperty: Property[Double]): Provider[Double] = createFunction2Provider(oProperty)(_ - _)

    def *(oProperty: Property[Double]): Provider[Double] = createFunction2Provider(oProperty)(_ * _)

    def /(oProperty: Property[Double]): Provider[Double] = createFunction2Provider(oProperty)(_ / _)

    def createFunction1Provider(function: Double => Double): Provider[Double] = {
      Function1Provider(property.asProvider)(function)
    }

    def +(value: Double): Provider[Double] = createFunction1Provider(_ + value)

    def -(value: Double): Provider[Double] = createFunction1Provider(_ - value)

    def *(value: Double): Provider[Double] = createFunction1Provider(_ * value)

    def /(value: Double): Provider[Double] = createFunction1Provider(_ / value)
  }

}
