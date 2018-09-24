package denimcoat.gears.providers

import denimcoat.gears.{Consumer, Event, Property}
import denimcoat.gears.syntax.AllImplicits._
import org.scalatest.FunSuite

class VarTest extends FunSuite {
  test("Var") {
    val myVar = Var("Hello, World!")
    val myProperty = Property[String](println)
    myProperty := myVar.map("I say: " + _) // should print last event
  }
}
