package denimcoat.reasoners.json

import denimcoat.reasoners.Reasoner
import denimcoat.reasoners.messages.{Edge, EdgeProperty, Node, NodeProperty, Origin, Response, Result, ResultGraph}
import play.api.libs.json.{JsObject, JsValue, Json, Writes}


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
    "node_property_list" -> node.nodePropertyList
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
    "source_id" -> edge.sourceId,
    "target_id" -> edge.targetId,
    "is_defined_by" -> edge.isDefinedBy,
    "provided_by" -> edge.providedBy,
    "confidence" -> edge.confidence,
    "edge_property_list" -> edge.edgePropertyList,
    "origin_list" -> edge.originList
  )

  implicit val resultGraphWrites: Writes[ResultGraph] = (graph: ResultGraph) => Json.obj(
    "node_list" -> graph.nodeList,
    "edge_list" -> graph.edgeList
  )

  implicit val resultWrites: Writes[Result] = (result: Result) => Json.obj(
    "@id" -> result.id.toString,
    "text" -> result.text,
    "confidence" -> result.confidence,
    "result_graph" -> result.resultGraph
  )

  implicit val responseWrites: Writes[Response] = (response: Response) => Json.obj(
   "@context" -> response.context.toString,
    "@id" -> response.id.toString,
    "@type" -> response.`type`,
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
