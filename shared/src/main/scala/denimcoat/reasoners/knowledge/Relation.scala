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

  val hasSymptom: Reversible = new Reversible("hasSymptom", "has symptom", Category.disease, Category.symptom) {
    override def reverse: Reversible = isSymptomOf
  }

  val isSymptomOf: Reversible = new Reversible("isSymptomOf", "is symptom of", Category.symptom, Category.disease) {
    override def reverse: Reversible = hasSymptom
  }

  val isPromotedBy: Reversible = new Reversible("isPromotedByVariant", "is promoted by variant",
    Category.disease, Category.variant) {
    override def reverse: Reversible = promotes
  }

  val promotes: Reversible = new Reversible("promotes", "promotes", Category.variant, Category.disease) {
    override def reverse: Reversible = isPromotedBy
  }

  val knownRelations: Set[Relation] = Set[Relation](hasSymptom, isSymptomOf, isPromotedBy, promotes)

  val relationsById: Map[String, Relation] = knownRelations.map(relation => (relation.id, relation)).toMap

  def fromId(id: String): Option[Relation] = relationsById.get(id)
}
