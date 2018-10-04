package denimcoat.reasoners.plugin

import denimcoat.reasoners.knowledge.{IdPrefix, Relation}
import denimcoat.reasoners.mvp.MonarchInitiativeUtils
import denimcoat.reasoners.plugin.ReasonerPlugin.Request
import denimcoat.reasoners.plugin.response.MonarchInitiativeResponsePlugin
import denimcoat.svg.mvp.ReasonerList

object MonarchInitiativePlugin extends ReasonerPlugin {
  override type ResponsePlugin = MonarchInitiativeResponsePlugin.type

  override def responsePlugin: ResponsePlugin = MonarchInitiativeResponsePlugin

  override def reasonerId: String = ReasonerList.monarch.id

  override def mightBeAbleTo(inputPrefix: IdPrefix, outputPrefix: IdPrefix): Boolean =
    MonarchInitiativeUtils.canDo(inputPrefix, outputPrefix)

  override def createRequests(relation: Relation, inputPrefix: IdPrefix, outputPrefix: IdPrefix,
                              inputItems: Seq[String]): Either[String, Seq[ReasonerPlugin.Request]] = {
    if (inputItems.isEmpty) {
      Right(Seq.empty)
    } else {
      val urlEithers = inputItems.map { inputItem =>
        MonarchInitiativeUtils.constructUrl(inputPrefix, inputItem, outputPrefix)
      }
      if (urlEithers.exists(_.isRight)) {
        val requests = urlEithers.collect {
          case Right(url) => Request(url, None)
        }
        Right(requests)
      } else {
        val messages = urlEithers.collect {
          case Left(message) => message
        }
        val combinedMessage = messages.distinct.mkString("; ")
        Left(combinedMessage)
      }
    }
  }
}
