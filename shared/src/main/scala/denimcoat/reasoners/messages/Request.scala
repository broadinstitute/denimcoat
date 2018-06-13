package denimcoat.reasoners.messages

import java.net.URI
import java.util.Date

case class Request(text: String, timestamp: Date)

object Request {
  def apply(text: String): Request = Request(text, new Date())
}

case class NodeProperty(`type`: String, name: String, value: Any, uri: URI)

case class Node(id: String, `type`: String, name: String, uri: URI, description: String, symbol: String,
                nodePropertyList: Seq[NodeProperty])

case class EdgeProperty(`type`: String, name: String, value: Any, uri: URI)

case class Origin(id: String, `type`: String, name: String)

case class Edge(`type`: String, sourceId: String, targetId: String, isDefinedBy: String, providedBy: String,
                confidence: Float, edgePropertyList: Seq[EdgeProperty], originList: Seq[Origin])

case class ResultGraph(nodeList: Seq[Node], edgeList: Seq[Edge])

case class Result(id: URI, text: String, confidence: Float, resultGraph: ResultGraph)

case class Response(context: URI, id: URI, `type`: String, schemaVersion: String, toolVersion: String,
                    datetime: Date, originalQuestionText: String, restatedQuestionText: String, resultCode: String,
                    message: String, resultList: Seq[Result])

