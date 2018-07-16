package denimcoat.util

import denimcoat.util.Graph.Edge

case class Graph[N, C, R](nodes: Set[N], n2c: Map[N, C], c2n: Map[C, Set[N]], edges: Set[Edge[N, R]],
                       outEdges: Map[N, Set[Edge[N, R]]], inEdges: Map[N, Set[Edge[N, R]]]) {

  def getCategory(node: N): Option[C] = n2c.get(node)

  def getNodesOfCategory(category: C): Set[N] = c2n.getOrElse(category, Set.empty)

  def withNode(node: N, category: C): Graph[N, C, R] = {
    val nodesNew = nodes + node
    val n2cNew = n2c + (node -> category)
    val c2nNew = c2n + (category -> (getNodesOfCategory(category) + node))
    copy(nodes = nodesNew, n2c = n2cNew, c2n = c2nNew)
  }

  def edgesFrom(start: N): Set[Edge[N, R]] = outEdges.getOrElse(start, Set.empty)

  def edgesFrom(start: N, relation: R): Set[Edge[N, R]] = edgesFrom(start).filter(_.relation == relation)

  def edgesTo(end: N): Set[Edge[N, R]] = inEdges.getOrElse(end, Set.empty)

  def edgesTo(end: N, relation: R): Set[Edge[N, R]] = edgesTo(end).filter(_.relation == relation)

  def withEdge(start: N, relation: R, end: N): Graph[N, C, R] = {
    val nodesNew = nodes + start + end
    val edgeNew = Edge[N, R](start, relation, end)
    val edgesNew = edges + edgeNew
    val outEdgesNew = outEdges + (start -> (edgesFrom(start) + edgeNew))
    val inEdgesNew = inEdges + (end -> (edgesTo(start) + edgeNew))
    copy(nodes = nodesNew, edges = edgesNew, outEdges = outEdgesNew, inEdges = inEdgesNew)
  }

  def withEdges(start: N, relation: R, ends: Iterable[N]): Graph[N, C, R] = {
    var graph = this
    for(end <- ends) {
      graph = graph.withEdge(start, relation, end)
    }
    graph
  }

  def withEdges(start: N, relation: R, endsHead: N, endsTail: N*): Graph[N, C, R] =
    withEdges(start, relation, endsHead +: endsTail)

}

object Graph {

  def empty[N, C, R]: Graph[N, C, R] = Graph(Set.empty, Map.empty, Map.empty, Set.empty, Map.empty, Map.empty)

  case class Edge[N, R](start: N, relation: R, end: N)

}
