package denimcoat

import java.net.URI
import java.util.Date

import denimcoat.reasoners.knowledge.Relation
import denimcoat.reasoners.messages.{DefaultRequestBody => ReasonerRequest, DefaultResponse => ReasonerResponse}
import denimcoat.reasoners.mvp.{DrugCheckerUtils, MonarchInitiativeUtils, PathwayEnrichmentUtils}
import io.circe.{Decoder, Encoder, Error}
import io.circe.parser.decode
import io.circe.generic.auto._
import io.circe.syntax._

object JsonIO {

  implicit val dateEncoder: Encoder[Date] = (date: Date) => date.getTime.asJson
  implicit val dateDecoder: Decoder[Date] = implicitly[Decoder[Long]].map(new Date(_))
  implicit val uriDecoder: Decoder[URI] = implicitly[Decoder[String]].map(new URI(_))
  implicit val anyDecoder: Decoder[Any] = implicitly[Decoder[Any]]
  implicit val relationEncoder: Encoder[Relation] = (relation: Relation) => relation.id.asJson
  implicit val relationDecoder: Decoder[Relation] = implicitly[Decoder[String]].map(Relation.fromId).map(_.get)

  def errorToString(error: Error): String = error.getClass.getSimpleName + ": " + error.getMessage

  def decodeResponse(responseString: String): Either[String, ReasonerResponse] = {
    decode[ReasonerResponse](responseString).left.map(errorToString)
  }

  def encodeRequest(request: ReasonerRequest): String = request.asJson.toString

  def decodeMonarchResponse(responseString: String): Either[String, MonarchInitiativeUtils.Response] = {
    decode[MonarchInitiativeUtils.Response](responseString).left.map(errorToString)
  }

  implicit val isDrugDecoder: Decoder[Boolean] = implicitly[Decoder[String]].map(_.trim.toLowerCase == "yes")

  def decodeDrugCheckerResponse(responseString: String): Either[String, DrugCheckerUtils.Response] = {
    decode[DrugCheckerUtils.Response](responseString).left.map(errorToString)
  }

  def decodePathwayEnrichmentResponse(responseString: String): Either[String, PathwayEnrichmentUtils.Response] = {
    decode[PathwayEnrichmentUtils.Response](responseString).left.map(errorToString)
  }

}
