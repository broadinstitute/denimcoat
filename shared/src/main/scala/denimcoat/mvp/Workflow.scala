package denimcoat.mvp

import denimcoat.reasoners.knowledge.{IdPrefix, Identifiable, Relation}

object Workflow {

  trait ItemSetInfo extends Identifiable {
    def prefix: IdPrefix

    def previousItemsOpt: Option[ItemSetInfo]

    def relationToPreviousOpt: Option[Relation]
  }

  case class StartItemSetInfo(id: String, name: String, prefix: IdPrefix) extends ItemSetInfo {
    override val previousItemsOpt: Option[ItemSetInfo] = None
    override val relationToPreviousOpt: Option[Relation] = None
  }

  case class ResultItemSetInfo(id: String, name: String, prefix: IdPrefix, previousItems: ItemSetInfo,
                               relationToPrevious: Relation)
    extends ItemSetInfo {
    override val previousItemsOpt: Option[ItemSetInfo] = Some(previousItems)
    override val relationToPreviousOpt: Option[Relation] = Some(relationToPrevious)
  }

  val startItemSetInfo: StartItemSetInfo = StartItemSetInfo("disease", "disease", IdPrefix.omimDisease)
  val resultItemSetInfo0: ResultItemSetInfo =
    ResultItemSetInfo("symptom", "symptom", IdPrefix.hp, startItemSetInfo, Relation.hasSymptom)
  val resultItemSetInfo1: ResultItemSetInfo =
    ResultItemSetInfo("disease", "disease", IdPrefix.mondo, resultItemSetInfo0, Relation.isSymptomOf)
  val resultItemSetInfo2: ResultItemSetInfo =
    ResultItemSetInfo("gene", "gene", IdPrefix.ncbigene, resultItemSetInfo1, Relation.hasAssociatedGene)

  val resultItemSetInfos: Seq[ResultItemSetInfo] = Seq(resultItemSetInfo0, resultItemSetInfo1, resultItemSetInfo2)
  val itemSetInfos: Seq[ItemSetInfo] = startItemSetInfo +: resultItemSetInfos

  val examples: Map[ItemSetInfo, Seq[String]] = Map(
    startItemSetInfo -> Seq(
      "type 2 diabetes mellitus; omim.disease:125853", "Behcet's disease; omim.disease:109650"
    ),
    resultItemSetInfo0 -> Seq("Insulin resistance; hp:0000855"),
    resultItemSetInfo1 -> Seq(
      "type 2 diabetes mellitus; omim.disease:125853", "Behcet's disease; omim.disease:109650"
    ),
    resultItemSetInfo2 -> Seq("gene:1234567")
  )
}
