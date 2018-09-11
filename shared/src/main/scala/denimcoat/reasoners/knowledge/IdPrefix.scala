package denimcoat.reasoners.knowledge

case class IdPrefix(string: String, category: Category) {

}

object IdPrefix {
  val omimDisease: IdPrefix = IdPrefix("omim.disease", Category.disease)
  val hp: IdPrefix = IdPrefix("hp", Category.phenotype)
  val mondo: IdPrefix = IdPrefix("mondo", Category.disease)
  val ncbigene: IdPrefix = IdPrefix("ncbigene", Category.gene)
  val rs: IdPrefix = IdPrefix("rs", Category.variant)
}
