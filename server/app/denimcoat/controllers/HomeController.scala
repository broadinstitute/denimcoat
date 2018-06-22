package denimcoat.controllers

import denimcoat.reasoners.ReasonerRegistry
import denimcoat.reasoners.json.ReasonerRequestJsonReading.requestReads
import denimcoat.reasoners.json.ReasonerResponseJsonWriting.responseWrites
import denimcoat.reasoners.messages.{Request => ReasonerRequest}
import javax.inject._
import play.api.libs.json.{JsError, JsString, JsValue, Json}
import play.api.libs.ws.{WSClient, WSResponse}
import play.api.mvc._

import scala.concurrent.ExecutionContext.Implicits.global


@Singleton
class HomeController @Inject()(cc: ControllerComponents, ws: WSClient) extends AbstractController(cc) {

  def index = Action {
    Ok(views.html.index())
  }

  def reasoner(id: String): Action[JsValue] = Action(parse.json) { request: Request[JsValue] =>
    ReasonerRegistry.get(id) match {
      case Some(reasoner) =>
        val reasonerRequestResult = request.body.validate[ReasonerRequest]
        reasonerRequestResult.fold(
          errors => {
            BadRequest(Json.obj("status" -> "KO", "message" -> JsError.toJson(errors)))
          },
          reasonerRequest => {
            val reasonerResponse = reasoner.reason(reasonerRequest)
            Ok(Json.toJson(reasonerResponse))
          }
        )
      case None => BadRequest(Json.obj("status" -> "KO", "message" -> JsString(s"No reasoner found for '$id'")))
    }
  }

  def proxy(url: String): Action[JsValue] = Action(parse.json).async { request: Request[JsValue] =>
    ws.url(url).post(request.body).map { response: WSResponse =>
      Ok(response.body)
    }
  }


}
