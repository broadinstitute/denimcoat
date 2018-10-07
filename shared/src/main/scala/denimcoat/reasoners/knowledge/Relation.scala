package denimcoat.reasoners.knowledge

trait Relation extends Identifiable {

  def inCategory: Category

  def outCategory: Category
}

object Relation {

  def apply(id: String, name: String, inCategory: Category, outCategory: Category): RelationImpl =
    RelationImpl(id: String, name: String, inCategory: Category, outCategory: Category)

  abstract case class Reversible(id: String, name: String, inCategory: Category, outCategory: Category)
    extends Relation {
    def reverse: Reversible
  }

  case class RelationImpl(id: String, name: String, inCategory: Category, outCategory: Category) extends Relation

  val hasSymptom: Reversible = new Reversible("hasSymptom", "has symptom", Category.disease, Category.phenotype) {
    override def reverse: Reversible = isSymptomOf
  }

  val isSymptomOf: Reversible = new Reversible("isSymptomOf", "is symptom of", Category.phenotype, Category.disease) {
    override def reverse: Reversible = hasSymptom
  }

  val isPromotedBy: Reversible = new Reversible("isPromotedByVariant", "is promoted by variant",
    Category.disease, Category.variant) {
    override def reverse: Reversible = promotes
  }

  val promotes: Reversible = new Reversible("promotes", "promotes", Category.variant, Category.disease) {
    override def reverse: Reversible = isPromotedBy
  }

  val hasAssociatedGene: Reversible =
    new Reversible("hasAssociatedGene", "has associated gene", Category.disease, Category.gene) {
    override def reverse: Reversible = isAssociatedWith
  }

  val isAssociatedWith: Reversible =
    new Reversible("isAssociatedWith", "is associated with", Category.gene, Category.disease) {
    override def reverse: Reversible = hasAssociatedGene
  }

  val isPartOfPathway: Reversible =
    new Reversible("isPartOfPathway", "is part of pathway", Category.gene, Category.pathway) {
      override def reverse: Reversible = includesGene
    }

  val includesGene: Reversible =
    new Reversible("includesGene", "includes gene", Category.pathway, Category.gene) {
      override def reverse: Reversible = isPartOfPathway
    }

  val isSameGeneAs: Reversible =
    new Reversible("isSameGeneAs", "is same gene as", Category.gene, Category.gene) {
      override def reverse: Reversible = this
    }

  val isGeneTargetedByDrug: Reversible =
    new Reversible("isGeneTargetedByDrug", "is gene targeted by drug", Category.gene, Category.compound) {
      override def reverse: Reversible = isDrugTargetingGene
    }

  val isDrugTargetingGene: Reversible =
    new Reversible("isDrugTargetingGene", "is drug targeting gene", Category.compound, Category.gene) {
      override def reverse: Reversible = isGeneTargetedByDrug
    }

  val isKnownDrug: Reversible =
    new Reversible("isKnownDrug", "is known drug", Category.compound, Category.compound) {
      override def reverse: Reversible = this
    }

  val isEnrichedGeneWith: Relation =
    Relation("isEnrichedGeneWith", "is enriched gene with", Category.gene, Category.gene)

  val knownRelations: Set[Relation] =
    Set[Relation](
      hasSymptom, isSymptomOf, isPromotedBy, promotes, hasAssociatedGene, isAssociatedWith, isPartOfPathway,
      includesGene, isSameGeneAs, isGeneTargetedByDrug, isDrugTargetingGene, isKnownDrug, isEnrichedGeneWith
    )

  val relationsById: Map[String, Relation] = knownRelations.map(relation => (relation.id, relation)).toMap

  def fromId(id: String): Option[Relation] = relationsById.get(id)
}
