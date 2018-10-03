package denimcoat.reasoners.mock

import denimcoat.reasoners.messages.{DefaultRequestBody, Result}

case class CoreResponse(restatedQuestion: String, resultCode: String, message: String, resultList: Option[Result])

object CoreResponse {
  def successResponse(restatedQuestionText: String, message:String, results: Result): CoreResponse =
    CoreResponse(restatedQuestionText, "Ok", message, Some(results))
  def failureResponse(request: DefaultRequestBody): CoreResponse =
    CoreResponse(request.items.mkString(", "), "Invalid", "Could not parse the question", None)
}