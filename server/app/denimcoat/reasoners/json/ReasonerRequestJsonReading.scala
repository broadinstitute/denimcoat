package denimcoat.reasoners.json

import java.util.Date

import denimcoat.reasoners.knowledge.Relation
import denimcoat.reasoners.messages.Request
import play.api.libs.functional.syntax._
import play.api.libs.json.{JsError, JsPath, JsResult, JsString, JsSuccess, JsValue, Reads}


object ReasonerRequestJsonReading {

  implicit val relationReads: Reads[Relation] = new Reads[Relation] {
    override def reads(json: JsValue): JsResult[Relation] = json match {
      case JsString(string) => Relation.fromId(string) match {
        case Some(relation) => JsSuccess(relation)
        case None => JsError(s"No relation with id '$string' found.")

      }
      case _ => JsError(s"Expected relation id as JSON string, but found '$json'")
    }
  }

  implicit val requestReads: Reads[Request] = (
    (JsPath \ "items").read[Seq[String]] and
      (JsPath \ "relation").read[Relation] and
      (JsPath \ "timestamp").read[Long].map(new Date(_))
    ) (Request(_, _, _))

}
