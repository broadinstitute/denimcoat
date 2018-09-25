package denimcoat.mvp

import denimcoat.reasoners.knowledge.{IdPrefix, Identifiable, Relation}

object Workflow {

  trait ItemSetInfo extends Identifiable {
    def prefix: IdPrefix
  }

  case class Derivation(previousSet: ItemSetInfo, relation: Relation)

  case class StartItemSetInfo(id: String, name: String, prefix: IdPrefix) extends ItemSetInfo {
  }

  case class ResultItemSetInfo(id: String, name: String, prefix: IdPrefix, derivation: Derivation)
    extends ItemSetInfo {
  }

  val startItemSetInfo: StartItemSetInfo = StartItemSetInfo("disease", "disease", IdPrefix.omimDisease)
  val resultItemSetInfo0: ResultItemSetInfo =
    ResultItemSetInfo("symptom", "symptom", IdPrefix.hp, Derivation(startItemSetInfo, Relation.hasSymptom))
  val resultItemSetInfo1: ResultItemSetInfo =
    ResultItemSetInfo("disease", "disease", IdPrefix.mondo, Derivation(resultItemSetInfo0, Relation.isSymptomOf))
  val resultItemSetInfo2: ResultItemSetInfo =
    ResultItemSetInfo("gene", "gene", IdPrefix.ncbigene, Derivation(resultItemSetInfo1, Relation.hasAssociatedGene))
  val resultItemSetInfo3: ResultItemSetInfo =
    ResultItemSetInfo("pathway", "pathway", IdPrefix.reactomePathway,
      Derivation(resultItemSetInfo2, Relation.isPartOfPathway))
  val resultItemSetInfo4: ResultItemSetInfo =
    ResultItemSetInfo("gene", "gene", IdPrefix.ncbigene, Derivation(resultItemSetInfo3, Relation.includesGene))
  val resultItemSetInfo5: ResultItemSetInfo =
    ResultItemSetInfo("gene", "gene", IdPrefix.hgncSymbol, Derivation(resultItemSetInfo4, Relation.isSameGeneAs))
  val resultItemSetInfo6: ResultItemSetInfo =
    ResultItemSetInfo("drug", "drug", IdPrefix.chemblCompound,
      Derivation(resultItemSetInfo5, Relation.isGeneTargetedByDrug))
  val resultItemSetInfo7: ResultItemSetInfo =
    ResultItemSetInfo("drug", "drug", IdPrefix.chemblCompound, Derivation(resultItemSetInfo6, Relation.isKnownDrug))

  val resultItemSetInfos: Seq[ResultItemSetInfo] = Seq(
    resultItemSetInfo0, resultItemSetInfo1, resultItemSetInfo2, resultItemSetInfo3, resultItemSetInfo4,
    resultItemSetInfo5, resultItemSetInfo6, resultItemSetInfo7
  )
  val itemSetInfos: Seq[ItemSetInfo] = startItemSetInfo +: resultItemSetInfos

  val examples: Map[ItemSetInfo, Seq[String]] = Map(
    startItemSetInfo -> Seq(
      "type 2 diabetes mellitus; omim.disease:125853", "Behcet's disease; omim.disease:109650"
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
    resultItemSetInfo4 -> Seq(
      "ncbigene:338", "ncbigene:3383", "ncbigene:355", "ncbigene:1649", "ncbigene:169792", "ncbigene:23274"
    ),
    resultItemSetInfo5 -> Seq(
      "hgnc.symbol:DDIT3", "hgnc.symbol:FAS", "hgnc.symbol:ICAM1", "hgnc.symbol:GLIS3", "hgnc.symbol:CLEC16A"
    ),
    resultItemSetInfo6 -> Seq(
      "chembl.compound:CHEMBL2146126", "chembl.compound:CHEMBL866", "chembl.compound:CHEMBL452231",
      "chembl.compound:CHEMBL386630", "chembl.compound:CHEMBL2108110", "chembl.compound:CHEMBL109",
      "chembl.compound:CHEMBL905"
    ),
    resultItemSetInfo7 -> Seq()
  )
}
