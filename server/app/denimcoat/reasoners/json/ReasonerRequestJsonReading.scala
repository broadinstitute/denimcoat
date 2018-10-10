package denimcoat.reasoners.json

import java.util.Date

import denimcoat.reasoners.knowledge.{IdPrefix, Relation}
import denimcoat.reasoners.messages.DefaultRequestBody
import play.api.libs.functional.syntax._
import play.api.libs.json._


object ReasonerRequestJsonReading {

  implicit val relationReads: Reads[Relation] = {
    case JsString(string) => Relation.fromId(IdPrefix.name(string)) match {
      case Some(relation) => JsSuccess(relation)
      case None => JsError(s"No relation with id '$string' found.")

    }
    case json => JsError(s"Expected relation id as JSON string, but found '$json'")
  }

  implicit val requestReads: Reads[DefaultRequestBody] = (
    (JsPath \ "items").read[Seq[String]] and
      (JsPath \ "relation").read[Relation] and
      (JsPath \ "timestamp").read[Long].map(new Date(_))
    ) (DefaultRequestBody(_, _, _))

}
