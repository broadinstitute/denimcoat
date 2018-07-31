package denimcoat.gears.syntax

import denimcoat.gears.providers.{Function1Provider, Function2Provider, Provider}

trait StringProviderOpsEnabling {

  implicit class StringProviderOpsEnabler(provider: Provider[String]) {

    def createFunction2Provider(oProvider: Provider[String])(
      function: (String, String) => String): Provider[String] = {
      Function2Provider(provider, oProvider)(function)
    }

    def +(oProvider: Provider[String]): Provider[String] = createFunction2Provider(oProvider)(_ + _)

    def createFunction1Provider(function: String => String): Provider[String] = {
      Function1Provider(provider)(function)
    }

    def +(value: String): Provider[String] = createFunction1Provider(_ + value)
  }

  implicit class DoubleValueOpsEnabler(value: String) {
    def +(provider: Provider[String]): Provider[String] = Function1Provider(provider)(value + _)
  }
}

object StringProviderOpsEnabling extends StringProviderOpsEnabling
