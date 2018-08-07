package denimcoat.reasoners.mock

import denimcoat.reasoners.messages.{Request, Result}

case class CoreResponse(restatedQuestion: String, resultCode: String, message: String, resultList: Option[Result])

object CoreResponse {
  def successResponse(restatedQuestionText: String, message:String, results: Result): CoreResponse =
    CoreResponse(restatedQuestionText, "Ok", message, Some(results))
  def failureResponse(request: Request): CoreResponse =
    CoreResponse(request.items.mkString(", "), "Invalid", "Could not parse the question", None)
}