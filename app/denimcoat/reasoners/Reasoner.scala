package denimcoat.reasoners

import java.net.URI
import java.util.Date

import denimcoat.reasoners.Reasoner.{Request, Response}

trait Reasoner {

  def id: String

  def version: String

  def reason(request: Request): Response

}

object Reasoner {

  val apiVersion: String = "0.6"

  case class Request(text: String, timestamp: Date)

  case class NodeProperty(`type`: String, name: String, value: Any, uri: URI)

  case class Node(id: String, category: String, name: String, uri: URI, description: String, symbol: String,
                  nodePropertyList: Seq[NodeProperty])

  case class EdgeProperty(`type`: String, name: String, value: Any, uri: URI)

  case class Origin(id: String, `type`: String, name: String)

  case class Edge(predicate: String, subject: String, `object`: String, isDefinedBy: String, providedBy: String,
                  confidence: Float, edgePropertyList: Seq[EdgeProperty], originList: Seq[Origin])

  case class ResultGraph(nodeList: Seq[Node], edgeList: Seq[Edge])

  case class Result(id: URI, text: String, confidence: Float, resultGraph: ResultGraph)

  case class Response(context: URI, id: URI, `type`: String, schemaVersion: String, toolVersion: String,
                      datetime: Date, originalQuestionText: String, restatedQuestionText: String, resultCode: String,
                      message: String, resultList: Seq[Result])

}
