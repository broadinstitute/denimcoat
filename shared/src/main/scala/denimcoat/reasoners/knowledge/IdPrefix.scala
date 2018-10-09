package denimcoat.reasoners.knowledge

case class IdPrefix(string: String, category: Category) {
  def getId(idString: String): String = string + ":" + idString
  def apply(value: String): PrefixedId = PrefixedId(this, value)
}

object IdPrefix {
  def apply(string: String): IdPrefix = new IdPrefix(string.toLowerCase, Category.thing)

  val name: IdPrefix = IdPrefix("name", Category.thing)
  val omimDisease: IdPrefix = IdPrefix("omim.disease", Category.disease)
  val hp: IdPrefix = IdPrefix("hp", Category.phenotype)
  val mondo: IdPrefix = IdPrefix("mondo", Category.disease)
  val ncbigene: IdPrefix = IdPrefix("ncbigene", Category.gene)
  val reactomePathway: IdPrefix = IdPrefix("reactome.pathway", Category.pathway)
  val rs: IdPrefix = IdPrefix("rs", Category.variant)
  val hgncSymbol: IdPrefix = IdPrefix("hgnc.symbol", Category.gene)
  val chemblCompound: IdPrefix = IdPrefix("chembl.compound", Category.compound)
}
