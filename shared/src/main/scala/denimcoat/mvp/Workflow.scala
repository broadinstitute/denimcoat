package denimcoat.mvp

import denimcoat.reasoners.knowledge.{Category, Identifiable, Relation}

object Workflow {

  trait ItemSetInfo extends Identifiable {
    def category: Category
    def previousItemsOpt: Option[ItemSetInfo]
    def relationToPreviousOpt: Option[Relation]
  }

  case class StartItemSetInfo(id: String, label: String, category: Category) extends ItemSetInfo {
    override val previousItemsOpt: Option[ItemSetInfo] = None
    override val relationToPreviousOpt: Option[Relation] = None
  }

  case class ResultItemSetInfo(id: String, label: String, category: Category, previousItems: ItemSetInfo,
                               relationToPrevious: Relation)
  extends ItemSetInfo {
    override val previousItemsOpt: Option[ItemSetInfo] = Some(previousItems)
    override val relationToPreviousOpt: Option[Relation] = Some(relationToPrevious)
  }

  val startItemSetInfo: StartItemSetInfo = StartItemSetInfo("disease", "disease", Category.disease)
  val resultItemSetInfo0: ResultItemSetInfo =
    ResultItemSetInfo("symptom", "symptom", Category.symptom, startItemSetInfo, Relation.hasSymptom)
  val resultItemSetInfo1: ResultItemSetInfo =
    ResultItemSetInfo("disease", "disease", Category.disease, resultItemSetInfo0,
      Relation.isSymptomOf)
  val resultItemSetInfo2: ResultItemSetInfo =
    ResultItemSetInfo("variant", "variant", Category.variant, resultItemSetInfo1,
      Relation.isPromotedBy)

  val resultItemSetInfos: Seq[ResultItemSetInfo] = Seq(resultItemSetInfo0, resultItemSetInfo1, resultItemSetInfo2)
  val itemSetInfos: Seq[ItemSetInfo] = startItemSetInfo +: resultItemSetInfos
}
