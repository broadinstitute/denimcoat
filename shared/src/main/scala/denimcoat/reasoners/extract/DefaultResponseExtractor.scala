package denimcoat.reasoners.extract

import denimcoat.reasoners.messages.DefaultResponse
import denimcoat.reasoners.mvp.BioThingsExplorerUtils
import denimcoat.util.Entity

class DefaultResponseExtractor(override val response: DefaultResponse) extends ResponseExtractor {
  type Response = DefaultResponse

  override def targetNodeNames: Seq[String] = {
    val result = response.result_list
    val targetIds = result.edge_list.to[Set].map(edge => edge.target_id)
    val nodeNames = result.node_list.filter(node => targetIds.contains(node.id)).map { node =>
      Entity.fromStrings(node.name.toList :+ BioThingsExplorerUtils.fixDoublePrefixedId(node.id)).toString
    }
    nodeNames
  }
}
