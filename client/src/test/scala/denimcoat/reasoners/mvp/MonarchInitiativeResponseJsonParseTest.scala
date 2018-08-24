package denimcoat.reasoners.mvp

import denimcoat.JsonIO
import org.scalatest.FunSuite

class MonarchInitiativeResponseJsonParseTest extends FunSuite {

  test("decode sample response") {
    val responseEither = JsonIO.decodeMonarchResponse(MonarchInitiativeSampleResponseJson.responseString)
    responseEither match {
      case Left(message) => fail(message)
      case Right(response) => println(response)
    }
  }

}
