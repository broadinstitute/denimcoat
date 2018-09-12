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
  val resultItemSetInfo3: ResultItemSetInfo =
    ResultItemSetInfo("pathway", "pathway", IdPrefix.reactomePathway, resultItemSetInfo2, Relation.isPartOfPathway)

  val resultItemSetInfos: Seq[ResultItemSetInfo] =
    Seq(resultItemSetInfo0, resultItemSetInfo1, resultItemSetInfo2, resultItemSetInfo3)
  val itemSetInfos: Seq[ItemSetInfo] = startItemSetInfo +: resultItemSetInfos

  val examples: Map[ItemSetInfo, Seq[String]] = Map(
    startItemSetInfo -> Seq(
      "type 2 diabetes mellitus; omim.disease:125853", "Behcet's disease; omim.disease:109650",
      "Gastrointestinal hemorrhage; hp:0002239"
    ),
    resultItemSetInfo0 -> Seq(
      "Insulin resistance; hp:0000855", "Type II diabetes mellitus; hp:0005978", "Meningitis; hp:0001287",
      "Gastrointestinal hemorrhage; hp:0002239", "Multiple myeloma; hp:0006775"
    ),
    resultItemSetInfo1 -> Seq(
      "Tay-Sachs disease; mondo:0010100", "type 1 diabetes mellitus; mondo:0005147",
      "Behcet's syndrome; mondo:0007191", "diabetes mellitus (disease); mondo:0005015"
    ),
    resultItemSetInfo2 -> Seq(
      "ncbigene:338", "ncbigene:3383", "ncbigene:355", "ncbigene:1649", "ncbigene:169792", "ncbigene:23274"
    ),
    resultItemSetInfo3 -> Seq(
      "MAPK signaling pathway; reactome.pathway:KEGG-path:maphsa04010",
      "Innate Immune System; reactome.pathway:REACT:R-HSA-168249"
    ),
  )
}
