package denimcoat.reasoners.mvp

import java.nio.charset.{Charset, StandardCharsets}
import java.nio.file.{Files, Path, Paths}

import org.scalatest.FunSuite

class MonarchInitiativeUtilsTest extends FunSuite {

  test("Hello, World!") {
    println("Hello, World!")
  }

  test("Read Sample response.") {
    val path = Paths.get("testdata/api.monarchinitiative.org.json")
    val string = new String(Files.readAllBytes(path), StandardCharsets.UTF_8)
    println("Monarch response length: " + string.size)
  }

}
