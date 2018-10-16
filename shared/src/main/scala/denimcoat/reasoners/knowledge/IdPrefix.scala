package denimcoat.reasoners.knowledge

case class IdPrefix(string: String) {
  def getId(idString: String): String = string + ":" + idString

  def apply(value: String): PrefixedId = PrefixedId(this, value)
}

object IdPrefix {
  val none: IdPrefix = IdPrefix("")
  val omimDisease: IdPrefix = IdPrefix("omim.disease")
  val hp: IdPrefix = IdPrefix("hp")
  val mondo: IdPrefix = IdPrefix("mondo")
  val ncbigene: IdPrefix = IdPrefix("ncbigene")
  val reactomePathway: IdPrefix = IdPrefix("reactome.pathway")
  val rs: IdPrefix = IdPrefix("rs")
  val hgncSymbol: IdPrefix = IdPrefix("hgnc.symbol")
  val chemblCompound: IdPrefix = IdPrefix("chembl.compound")

  def getCategory(prefix: IdPrefix): Category = {
    prefix match {
      case IdPrefix.none => Category.thing
      case IdPrefix.omimDisease => Category.disease
      case IdPrefix.hp => Category.phenotype
      case IdPrefix.mondo => Category.disease
      case IdPrefix.ncbigene => Category.gene
      case IdPrefix.reactomePathway => Category.pathway
      case IdPrefix.rs => Category.variant
      case IdPrefix.hgncSymbol => Category.gene
      case IdPrefix.chemblCompound => Category.compound
      case _ => Category.thing
    }
  }
}
