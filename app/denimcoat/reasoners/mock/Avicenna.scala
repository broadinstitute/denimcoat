package denimcoat.reasoners.mock

import java.net.URI
import java.util.Date

import denimcoat.reasoners.Reasoner

object Avicenna extends Reasoner {

  override def id: String = "avicenna"

  def peel(string: String, prefix: String, postfix: String): Option[String] = {
    if(string.substring(0, prefix.size) == prefix && string.substring(string.size - postfix.size) == postfix) {
      Some(string.substring(prefix.size, string.size - postfix.size))
    } else {
      None
    }
  }

  val questionPrefix = "What are targets of "

  val questionPostfix = "?"

  def parseQuestion(question: String): Option[String] = {
      peel(question, questionPrefix, questionPostfix)
        .orElse(peel(question, "What does ", " do?"))
  }

  def restateQuestion(drug: String): String = questionPrefix + drug + questionPostfix

  case class TargetInfo(target: String, pathways: Set[String])

  case class DrugInfo(drug: String, targets: Set[TargetInfo])

  val aspirinInfo =
    DrugInfo("aspirin", Set(TargetInfo("prostaglandinsynthesase", Set("pain", "inflammation", "fever"))))

  val knownDrugs: Map[String, DrugInfo] = Set(aspirinInfo).map(info => (info.drug, info)).toMap

  case class CoreResponse(restatedQuestion: String, resultCode: String, message: String,
                          resultList: Seq[Reasoner.Result])

  override def reason(request: Reasoner.Request): Reasoner.Response = {
    val coreResponse = parseQuestion(request.text) match {
      case Some(drug) => knownDrugs.get(drug) match {
        case Some(drugInfo) =>
          val restatedQuestionText = restateQuestion(drug)
          val message = s"Drug $drug has target(s) ${
            drugInfo.targets.map { targetInfo =>
              s"${
                targetInfo.target
              } (affecting ${targetInfo.pathways.mkString(", ")})"
            }.mkString("",", ", ".")
          }"
          val results = drugInfo.targets.map { targetInfo =>
            val drugNode = Reasoner.Node(
              id = s"drug:$drug",
              category = "drug",
              name = drug,
              uri = new URI(s"drug:$drug"),
              description = s"The drug $drug.",
              symbol = drug,
              nodePropertyList = Seq.empty
            )
            val target = targetInfo.target
            val targetNode = Reasoner.Node(
              id = s"target:$target",
              category = "target",
              name = target,
              uri = new URI(s"target:$target"),
              description = s"The target $target.",
              symbol = target,
              nodePropertyList = Seq.empty
            )
            val drugTargetEdge = Reasoner.Edge(
              predicate = "hasTarget",
              subject = drugNode.id,
              `object` = targetNode.id,
              isDefinedBy = "Some smart dude",
              providedBy = "Avicenna",
              confidence = 1.0f,
              edgePropertyList = Seq.empty,
              originList = Seq.empty
            )
            val pathwayNodes = targetInfo.pathways.map { pathway =>
              Reasoner.Node(
                id = s"pathway:$pathway",
                category = "pathway",
                name = pathway,
                uri = new URI(s"pathway:$pathway"),
                description = s"The pathway $pathway.",
                symbol = pathway,
                nodePropertyList = Seq.empty
              )
            }.toSeq
            val targetPathwayEdges = pathwayNodes.map { pathwayNode =>
              Reasoner.Edge(
                predicate = "isPartOfPathway",
                subject = targetNode.id,
                `object` = pathwayNode.id,
                isDefinedBy = "Some smart dude",
                providedBy = "Avicenna",
                confidence = 1.0f,
                edgePropertyList = Seq.empty,
                originList = Seq.empty
              )
            }
            Reasoner.Result(
              id = new URI(s"drugtarget:$drug:${targetInfo.target}"),
              text = s"Drug $drug has target ${targetInfo.target} affecting ${targetInfo.pathways.mkString(", ")}.",
              confidence = 1.0f,
              resultGraph =
                Reasoner.ResultGraph(
                  nodeList = Seq(drugNode, targetNode) ++ pathwayNodes,
                  edgeList = Seq(drugTargetEdge) ++ targetPathwayEdges
                )
            )
          }.toSeq
          CoreResponse(restatedQuestionText, "Ok", message, results)
        case None =>
          CoreResponse(request.text, "Not found", s"Don't know drug $drug.", Seq.empty)
      }
      case None =>
        CoreResponse(request.text, "Invalid", "Could not parse the question", Seq.empty)
    }
    Reasoner.Response(
      context = new URI(MockReasoners.baseUriContext),
      id = MockReasoners.idUri(this.id),
      `type` = "Very awesome type of response",
      schemaVersion = Reasoner.apiVersion,
      toolVersion = version,
      datetime = new Date(),
      originalQuestionText = request.text,
      restatedQuestionText = coreResponse.restatedQuestion,
      resultCode = coreResponse.resultCode,
      message = coreResponse.message,
      resultList = coreResponse.resultList
    )
  }

  override def version: String = "0.5"
}
