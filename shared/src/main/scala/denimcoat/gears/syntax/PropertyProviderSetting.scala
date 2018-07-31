package denimcoat.gears.syntax

import denimcoat.gears.Property
import denimcoat.gears.providers.{Provider, Val}

import scala.language.implicitConversions

trait PropertyProviderSetting {

  implicit def value2val[T](value: T): Provider[T] = Val[T](value)

  implicit class PropertyProviderSetter[T](property: Property[T]) {
    def :=(provider: Provider[T]): Unit = {
      property.setProvider(provider)
    }

    def :=(value: T): Unit = {
      property.setProvider(Val(value))
    }
  }
}

object PropertyProviderSetting extends PropertyProviderSetting