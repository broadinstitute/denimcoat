package denimcoat.reasoners.json

import denimcoat.reasoners.Reasoner
import play.api.libs.json.{Json, Writes}


object ReasonerResponseJsonWriting {

  implicit val resultNodeWrites: Writes[Reasoner.Node] = (node: Reasoner.Node) => Json.obj(
    // TODO
  )

  implicit val resultEdgeWrites: Writes[Reasoner.Edge] = (_: Reasoner.Edge) => Json.obj() // TODO

  implicit val resultGraphWrites: Writes[Reasoner.ResultGraph] = (graph: Reasoner.ResultGraph) => Json.obj(
    "node_list" -> graph.nodeList,
    "edge_list" -> graph.edgeList
  )

  implicit val resultWrites: Writes[Reasoner.Result] = (result: Reasoner.Result) => Json.obj(
    "@id" -> result.id.toString,
    "text" -> result.text,
    "confidence" -> result.confidence,
    "result_graph" -> result.resultGraph
  )

  implicit val responseWrites: Writes[Reasoner.Response] = (response: Reasoner.Response) => Json.obj(
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
