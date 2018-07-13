package denimcoat.reasoners.json

import java.util.Date

import denimcoat.reasoners.messages.Request
import play.api.libs.functional.syntax._
import play.api.libs.json.{JsPath, Reads}


object ReasonerRequestJsonReading {

  implicit val requestReads: Reads[Request] = (
    (JsPath \ "items").read[Seq[String]] and
      (JsPath \ "timestamp").read[Long].map(new Date(_))
    ) (Request(_, _))

}
