package denimcoat.reasoners.mock

import denimcoat.reasoners.messages.{DefaultRequest, Result}

case class CoreResponse(restatedQuestion: String, resultCode: String, message: String,
                        resultList: Seq[Result])

object CoreResponse {
  def successResponse(restatedQuestionText: String, message:String, results: Seq[Result]): CoreResponse =
    CoreResponse(restatedQuestionText, "Ok", message, results)
  def failureResponse(request: DefaultRequest): CoreResponse =
    CoreResponse(request.items.mkString(", "), "Invalid", "Could not parse the question", Seq.empty)
}