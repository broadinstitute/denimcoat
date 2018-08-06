package denimcoat.reasoners.messages

import java.net.URI
import java.util.Date

import denimcoat.reasoners.knowledge.Relation

sealed trait Request

case class DefaultRequest(items: Seq[String], relation: Relation, timestamp: Date) extends Request

object DefaultRequest {
  def apply(items: Seq[String], relation: Relation): DefaultRequest = DefaultRequest(items, relation, new Date())
}

case class BioThingsRequest() extends Request

case class NodeProperty(`type`: String, name: String, value: Any, uri: URI)

case class Node(id: String, `type`: String, name: String, uri: URI, description: String, symbol: String,
                node_property_list: Seq[NodeProperty])

case class EdgeProperty(`type`: String, name: String, value: Any, uri: URI)

case class Origin(id: String, `type`: String, name: String)

case class Edge(`type`: String, source_id: String, target_id: String, is_defined_by: String, provided_by: String,
                confidence: Float, edge_property_list: Seq[EdgeProperty], origin_list: Seq[Origin])

case class ResultGraph(node_list: Seq[Node], edge_list: Seq[Edge])

case class Result(`@id`: URI, text: String, confidence: Float, result_graph: ResultGraph)

case class Response(`@context`: URI, `@id`: URI, `@type`: String, schema_version: String, tool_version: String,
                    datetime: Date, original_question_text: String, restated_question_text: String, result_code: String,
                    message: String, result_list: Seq[Result])

