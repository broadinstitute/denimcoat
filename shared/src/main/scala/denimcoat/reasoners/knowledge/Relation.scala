package denimcoat.reasoners.knowledge

trait Relation extends Identifiable {

  def inCategory: Category

  def outCategory: Category
}

object Relation {

  abstract case class Reversible(id: String, label: String, inCategory: Category, outCategory: Category)
    extends Relation {
    def reverse: Reversible
  }

  val hasSymptom: Reversible = new Reversible("hasSymptom", "has symptom", Category.disease, Category.symptom) {
    override def reverse: Reversible = isSymptomOf
  }

  val isSymptomOf: Reversible = new Reversible("isSymptomOf", "is symptom of", Category.symptom, Category.disease) {
    override def reverse: Reversible = hasSymptom
  }

  val knownRelations: Set[Relation] = Set[Relation](hasSymptom, isSymptomOf)

  val relationsById: Map[String, Relation] = knownRelations.map(relation => (relation.id, relation)).toMap

  def fromId(id: String): Option[Relation] = relationsById.get(id)
}
