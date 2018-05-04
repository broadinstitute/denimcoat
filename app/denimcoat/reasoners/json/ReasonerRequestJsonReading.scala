package denimcoat.reasoners.json

import java.util.Date

import play.api.libs.json.{JsPath, Reads}
import denimcoat.reasoners.Reasoner
import play.api.libs.functional.syntax._


object ReasonerRequestJsonReading {

  implicit val requestReads: Reads[Reasoner.Request] = (
    (JsPath \ "text").read[String] and
      (JsPath \ "timestamp").read[Long].map(new Date(_))
    ) (Reasoner.Request.apply _)

}
