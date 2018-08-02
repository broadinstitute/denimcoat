package denimcoat.gears.syntax

import denimcoat.gears.providers.{Function1Provider, Provider}

trait MonadicOpsEnabling {

  implicit class MonadicOpsEnabler[T](provider: Provider[T]) {
    def map[R](function: T => R): Function1Provider[T, R] = Function1Provider(provider)(function)
  }

}

object MonadicOpsEnabling extends MonadicOpsEnabling