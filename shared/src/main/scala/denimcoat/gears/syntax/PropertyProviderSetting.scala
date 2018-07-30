package denimcoat.gears.syntax

import denimcoat.gears.Property
import denimcoat.gears.providers.{Val, Provider}

trait PropertyProviderSetting {

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