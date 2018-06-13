package denimcoat.reasoners.mock

import java.net.URI
import java.util.Date

import denimcoat.reasoners.Reasoner
import denimcoat.reasoners.messages.{Edge, Node, Request, Response, Result, ResultGraph}
import denimcoat.reasoners.mock.EntityCatalogue.Drug

object Avicenna extends Reasoner {

  override def id: String = "avicenna"

  val questionPrefix = "What are targets of "

  val questionPostfix = "?"

  def parseQuestion(question: String): Option[Drug] = QuestionParser.findDrugs(question).headOption

  def restateQuestion(drug: String): String = questionPrefix + drug + questionPostfix

  case class CoreResponse(restatedQuestion: String, resultCode: String, message: String,
                          resultList: Seq[Result])

  override def reason(request: Request): Response = {
    val coreResponse = parseQuestion(request.text) match {
      case Some(drug) =>
        val restatedQuestionText = restateQuestion(drug.name)
        val message = s"Drug ${drug.name} has target(s) ${
          drug.targets.map { target =>
            s"${target.name} (affecting ${target.diseases.map(_.name).mkString(", ")})"
          }.mkString("", ", ", ".")
        }"
        val results = drug.targets.map { target =>
          val drugNode = Node(
            id = drug.cui,
            `type` = "drug",
            name = drug.name,
            uri = new URI(s"drug:${drug.cui}"),
            description = s"The drug ${drug.name}.",
            symbol = drug.name,
            nodePropertyList = Seq.empty
          )
          val targetNode = Node(
            id = target.cui,
            `type` = "target",
            name = target.name,
            uri = new URI(s"target:${target.cui}"),
            description = s"The target ${target.name}.",
            symbol = target.name,
            nodePropertyList = Seq.empty
          )
          val drugTargetEdge = Edge(
            `type` = "hasTarget",
            sourceId = drugNode.id,
            targetId = targetNode.id,
            isDefinedBy = "Some smart dude",
            providedBy = "Avicenna",
            confidence = 1.0f,
            edgePropertyList = Seq.empty,
            originList = Seq.empty
          )
          val diseaseNodes = target.diseases.map { disease =>
            Node(
              id = disease.cui,
              `type` = "disease",
              name = disease.name,
              uri = new URI(s"disease:${disease.cui}"),
              description = s"The disease ${disease.name}.",
              symbol = disease.name,
              nodePropertyList = Seq.empty
            )
          }.toSeq
          val targetDiseaseEdges = diseaseNodes.map { diseaseNode =>
            Edge(
              `type` = "isPartOfPathway",
              sourceId = targetNode.id,
              targetId = diseaseNode.id,
              isDefinedBy = "Some smart dude",
              providedBy = "Avicenna",
              confidence = 1.0f,
              edgePropertyList = Seq.empty,
              originList = Seq.empty
            )
          }
          Result(
            id = new URI(s"drugtarget:${drug.cui}:${target.cui}"),
            text =
              s"Drug ${drug.name} has target ${target.name} affecting ${target.diseases.map(_.name).mkString(", ")}.",
            confidence = 1.0f,
            resultGraph =
              ResultGraph(
                nodeList = Seq(drugNode, targetNode) ++ diseaseNodes,
                edgeList = Seq(drugTargetEdge) ++ targetDiseaseEdges
              )
          )
        }.toSeq
        CoreResponse(restatedQuestionText, "Ok", message, results)
      case None =>
        CoreResponse(request.text, "Invalid", "Could not parse the question", Seq.empty)
    }
    Response(
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
