package denimcoat.mvp

import denimcoat.reasoners.knowledge.{IdPrefix, Identifiable, Relation}
import denimcoat.reasoners.mvp.MonarchInitiativeUtils

object Workflow {

  case class ItemSetInfo(id: String, name: String, prefix: IdPrefix, derivations: Seq[Derivation])
    extends Identifiable {
    def isStartItemSet: Boolean = derivations.isEmpty
  }

  object ItemSetInfo {
    def apply(id: String, name: String, prefix: IdPrefix): ItemSetInfo = {
      ItemSetInfo(id, name, prefix, Seq.empty)
    }
    def apply(id: String, name: String, prefix: IdPrefix, derivation: Derivation): ItemSetInfo = {
      ItemSetInfo(id, name, prefix, Seq(derivation))
    }
    def apply(id: String, name: String, prefix: IdPrefix, derivation: Derivation,
              derivations: Derivation*): ItemSetInfo = {
      ItemSetInfo(id, name, prefix, derivation +: derivations)
    }
  }

  case class Derivation(previousSet: ItemSetInfo, relation: Relation)

  val startItemSetInfo: ItemSetInfo = ItemSetInfo("disease", "disease", IdPrefix.omimDisease)
  val resultItemSetInfo0: ItemSetInfo =
    ItemSetInfo("symptom", "symptom", IdPrefix.hp, Derivation(startItemSetInfo, Relation.hasSymptom))
  val resultItemSetInfo1: ItemSetInfo =
    ItemSetInfo("disease", "disease", IdPrefix.mondo, Derivation(resultItemSetInfo0, Relation.isSymptomOf))
  val resultItemSetInfo2: ItemSetInfo =
    ItemSetInfo("gene", "gene", IdPrefix.ncbigene, Derivation(resultItemSetInfo1, Relation.hasAssociatedGene))
  val resultItemSetInfo3: ItemSetInfo =
    ItemSetInfo("pathway", "pathway", IdPrefix.reactomePathway,
      Derivation(resultItemSetInfo2, Relation.isPartOfPathway))
  val resultItemSetInfo4: ItemSetInfo =
    ItemSetInfo("gene", "gene", IdPrefix.ncbigene,
      Derivation(resultItemSetInfo2, Relation.isEnrichedGeneWith),
      Derivation(resultItemSetInfo3, Relation.includesGene))
  val resultItemSetInfo5: ItemSetInfo =
    ItemSetInfo("gene", "gene", IdPrefix.hgncSymbol, Derivation(resultItemSetInfo4, Relation.isSameGeneAs))
  val resultItemSetInfo6: ItemSetInfo =
    ItemSetInfo("drug", "drug", IdPrefix.chemblCompound,
      Derivation(resultItemSetInfo5, Relation.isGeneTargetedByDrug))
  val resultItemSetInfo7: ItemSetInfo =
    ItemSetInfo("drug", "drug", IdPrefix.chemblCompound, Derivation(resultItemSetInfo6, Relation.isKnownDrug))

  val itemSetInfos: Seq[ItemSetInfo] = Seq(
    startItemSetInfo, resultItemSetInfo0, resultItemSetInfo1, resultItemSetInfo2, resultItemSetInfo3,
    resultItemSetInfo4, resultItemSetInfo5, resultItemSetInfo6, resultItemSetInfo7
  )

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
