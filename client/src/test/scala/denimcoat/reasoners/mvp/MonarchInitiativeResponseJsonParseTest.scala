package denimcoat.reasoners.mvp

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

import org.scalatest.FunSuite

class MonarchInitiativeResponseJsonParseTest extends FunSuite {

  test("Hello, World!") {
    println("Hello, World!")
  }

  test("Read Sample response.") {
    val sampleDataFile = "api.monarchinitiative.org.json"
    val stream = getClass.getResourceAsStream(sampleDataFile)
    println("Monarch response length: " + stream.toString)
  }

}
