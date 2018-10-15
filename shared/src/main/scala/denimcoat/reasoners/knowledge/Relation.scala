package denimcoat.reasoners.knowledge

trait Relation extends Identifiable {
  override def ids: Seq[PrefixedId] = Seq(IdPrefix.none(name))

  def inCategory: Category

  def outCategory: Category
}

object Relation {

  def apply(name: String, inCategory: Category, outCategory: Category): RelationImpl =
    RelationImpl(name, inCategory, outCategory)

  abstract case class Reversible(override val name: String, inCategory: Category,
                                 outCategory: Category) extends Relation {
    def reverse: Reversible
  }

  case class RelationImpl(override val name: String, inCategory: Category, outCategory: Category) extends Relation

  val hasSymptom: Reversible = new Reversible("has symptom", Category.disease, Category.phenotype) {
    override def reverse: Reversible = isSymptomOf
  }

  val isSymptomOf: Reversible = new Reversible("is symptom of", Category.phenotype, Category.disease) {
    override def reverse: Reversible = hasSymptom
  }

  val isPromotedBy: Reversible = new Reversible("is promoted by variant", Category.disease, Category.variant) {
    override def reverse: Reversible = promotes
  }

  val promotes: Reversible = new Reversible("promotes", Category.variant, Category.disease) {
    override def reverse: Reversible = isPromotedBy
  }

  val hasAssociatedGene: Reversible =
    new Reversible("has associated gene", Category.disease, Category.gene) {
      override def reverse: Reversible = isAssociatedWith
    }

  val isAssociatedWith: Reversible =
    new Reversible("is associated with", Category.gene, Category.disease) {
      override def reverse: Reversible = hasAssociatedGene
    }

  val isPartOfPathway: Reversible =
    new Reversible("is part of pathway", Category.gene, Category.pathway) {
      override def reverse: Reversible = includesGene
    }

  val includesGene: Reversible =
    new Reversible("includes gene", Category.pathway, Category.gene) {
      override def reverse: Reversible = isPartOfPathway
    }

  val isSameGeneAs: Reversible =
    new Reversible("is same gene as", Category.gene, Category.gene) {
      override def reverse: Reversible = this
    }

  val isGeneTargetedByDrug: Reversible =
    new Reversible("is gene targeted by drug", Category.gene, Category.compound) {
      override def reverse: Reversible = isDrugTargetingGene
    }

  val isDrugTargetingGene: Reversible =
    new Reversible("is drug targeting gene", Category.compound, Category.gene) {
      override def reverse: Reversible = isGeneTargetedByDrug
    }

  val isKnownDrug: Reversible =
    new Reversible("is known drug", Category.compound, Category.compound) {
      override def reverse: Reversible = this
    }

  val isEnrichedGeneWith: Relation =
    Relation("is enriched gene with", Category.gene, Category.gene)

  val knownRelations: Set[Relation] =
    Set[Relation](
      hasSymptom, isSymptomOf, isPromotedBy, promotes, hasAssociatedGene, isAssociatedWith, isPartOfPathway,
      includesGene, isSameGeneAs, isGeneTargetedByDrug, isDrugTargetingGene, isKnownDrug, isEnrichedGeneWith
    )

  val relationsById: Map[PrefixedId, Relation] =
    knownRelations.flatMap(relation => relation.ids.map(id => (id, relation))).toMap

  def fromId(id: PrefixedId): Option[Relation] = relationsById.get(id)
}
