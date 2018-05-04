package denimcoat.reasoners.json

import denimcoat.reasoners.Reasoner
import play.api.libs.json.{Json, Writes}


object ReasonerResponseJsonWriting {

  implicit val responseWrites: Writes[Reasoner.Response] = (response: Reasoner.Response) => Json.obj(
    "text" -> response.text,
    "timstampe" -> response.timestamp.getTime
  )
}
