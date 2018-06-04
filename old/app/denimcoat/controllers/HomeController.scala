package denimcoat.controllers

import denimcoat.reasoners.{Reasoner, ReasonerRegistry}
import javax.inject._
import play.api.libs.json.{JsError, JsString, JsValue, Json}
import play.api.mvc._
import denimcoat.reasoners.json.ReasonerRequestJsonReading.requestReads
import denimcoat.reasoners.json.ReasonerResponseJsonWriting.responseWrites
import play.api.libs.ws.{WSClient, WSResponse, writeableOf_JsValue}

import scala.concurrent.ExecutionContext.Implicits.global

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents, ws: WSClient) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(denimcoat.views.html.index())
  }

  def reasoner(id: String): Action[JsValue] = Action(parse.json) { request: Request[JsValue] =>
    ReasonerRegistry.get(id) match {
      case Some(reasoner) =>
        val reasonerRequestResult = request.body.validate[Reasoner.Request]
        reasonerRequestResult.fold(
          errors => {
            BadRequest(Json.obj("status" ->"KO", "message" -> JsError.toJson(errors)))
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
