package denimcoat.reasoners.knowledge

trait Relation extends Identifiable {

  def inCategory: Category

  def outCategory: Category
}

object Relation {

  abstract case class Reversible(id: String, name: String, inCategory: Category, outCategory: Category)
    extends Relation {
    def reverse: Reversible
  }

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

  val knownRelations: Set[Relation] =
    Set[Relation](hasSymptom, isSymptomOf, isPromotedBy, promotes, hasAssociatedGene, isAssociatedWith)

  val relationsById: Map[String, Relation] = knownRelations.map(relation => (relation.id, relation)).toMap

  def fromId(id: String): Option[Relation] = relationsById.get(id)
}
