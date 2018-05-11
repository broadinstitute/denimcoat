package denimcoat.reasoners.json

import denimcoat.reasoners.Reasoner
import play.api.libs.json.{JsValue, Json, Writes}


object ReasonerResponseJsonWriting {

  implicit val resultWrites: Writes[Reasoner.Result] = (result: Reasoner.Result) => Json.obj(
    "@id" -> result.id.toString,
    "text" -> result.text,
    "confidence" -> result.confidence
  )

  implicit val responseWrites: Writes[Reasoner.Response] = (response: Reasoner.Response) => Json.obj(
   "@context" -> response.context.toString,
    "@id" -> response.id.toString,
    "@type" -> response.aType,
    "schema_version" -> response.schemaVersion,
    "tool_version" -> response.toolVersion,
    "datetime" -> response.datetime,
    "original_question_text" -> response.originalQuestionText,
    "restated_question_text" -> response.restatedQuestionText,
    "result_code" -> response.resultCode,
    "message" -> response.message,
    "result_list" -> response.resultList
  )
}
