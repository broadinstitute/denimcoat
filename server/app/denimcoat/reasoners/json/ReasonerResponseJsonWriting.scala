package denimcoat.reasoners.json

import denimcoat.reasoners.messages._
import play.api.libs.json.{Json, Writes}


object ReasonerResponseJsonWriting {

  implicit val resultNodeProptertyWrites: Writes[NodeProperty] =
    (property: NodeProperty) => Json.obj(
      "type" -> property.`type`,
      "name" -> property.name,
      "value" -> property.value.toString,
      "uri" -> property.uri.toString
    )

  implicit val resultNodeWrites: Writes[Node] = (node: Node) => Json.obj(
    "id" -> node.id,
    "type" -> node.`type`,
    "name" -> node.name,
    "uri" -> node.uri.toString,
    "description" -> node.description,
    "symbol" -> node.symbol,
    "node_property_list" -> node.node_property_list
  )

  implicit val resultEdgePropertyWrites: Writes[EdgeProperty] =
    (property: EdgeProperty) => Json.obj(
      "type" -> property.`type`,
      "name" -> property.name,
      "value" -> property.value.toString,
      "uri" -> property.uri.toString
    )

  implicit val resultOriginWrites: Writes[Origin] = (origin: Origin) => Json.obj(
    "id" -> origin.id,
    "type" -> origin.`type`,
    "name" -> origin.name
  )

  implicit val resultEdgeWrites: Writes[Edge] = (edge: Edge) => Json.obj(
    "type" -> edge.`type`,
    "source_id" -> edge.source_id,
    "target_id" -> edge.target_id,
    "is_defined_by" -> edge.is_defined_by,
    "provided_by" -> edge.provided_by,
    "confidence" -> edge.confidence,
    "edge_property_list" -> edge.edge_property_list,
    "origin_list" -> edge.origin_list
  )

  implicit val resultWrites: Writes[Result] = (result: Result) => Json.obj(
    "@id" -> result.`@id`.toString,
    "text" -> result.text,
    "confidence" -> result.confidence,
    "node_list" -> result.node_list,
    "edge_list" -> result.edge_list
  )

  implicit val responseWrites: Writes[Response] = (response: Response) => Json.obj(
    "@context" -> response.`@context`.toString,
    "@id" -> response.`@id`.toString,
    "@type" -> response.`@type`,
    "schema_version" -> response.schema_version,
    "tool_version" -> response.tool_version,
    "datetime" -> response.datetime,
    "original_question_text" -> response.original_question_text,
    "restated_question_text" -> response.restated_question_text,
    "result_code" -> response.result_code,
    "message" -> response.message,
    "result_list" -> response.result_list
  )
}
