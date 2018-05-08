package denimcoat.reasoners.json

import denimcoat.reasoners.Reasoner
import play.api.libs.json.{Json, Writes}


object ReasonerResponseJsonWriting {

  implicit val responseWrites: Writes[Reasoner.Response] = (response: Reasoner.Response) => Json.obj(
    "text" -> response.text,
    "timestamp" -> response.timestamp.getTime
  )
}
