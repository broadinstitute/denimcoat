package denimcoat.reasoners.messages

import java.net.URI
import java.util.Date

import denimcoat.reasoners.knowledge.Relation

case class Request(items: Seq[String], relation: Relation, timestamp: Date)

object Request {
  def apply(items: Seq[String], relation: Relation): Request = Request(items, relation, new Date())
}

case class NodeProperty(`type`: String, name: String, value: Any, uri: URI)

case class Node(id: String, `type`: String, name: String, uri: Option[URI], description: Option[String],
                symbol: Option[String], node_property_list: Option[Seq[NodeProperty]])

case class EdgeProperty(`type`: String, name: String, value: Any, uri: URI)

case class Origin(id: String, `type`: String, name: String)

case class Edge(`type`: String, source_id: String, target_id: String, is_defined_by: Option[String],
                provided_by: String, confidence: Option[Float], edge_property_list: Option[Seq[EdgeProperty]],
                origin_list: Option[Seq[Origin]])

case class Result(`@id`: Option[URI], text: Option[String], confidence: Option[Float], node_list: Seq[Node],
                  edge_list: Seq[Edge])

case class Response(`@context`: Option[URI], `@id`: Option[URI], `@type`: Option[String],
                    schema_version: Option[String], tool_version: Option[String], datetime: Option[Date],
                    original_question_text: Option[String], restated_question_text: Option[String],
                    result_code: Option[String], message: Option[String], result_list: Result)

