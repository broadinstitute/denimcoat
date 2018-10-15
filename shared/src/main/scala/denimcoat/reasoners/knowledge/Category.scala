package denimcoat.reasoners.knowledge

case class Category(override val name: String) extends Identifiable {
  override def id: PrefixedId = IdPrefix.none(name)

  override def ids: Seq[PrefixedId] = Seq(IdPrefix.none(name))
}

object Category {

  val thing: Category = Category("thing")
  val disease: Category = Category("disease")
  val phenotype: Category = Category("phenotype")
  val gene: Category = Category("gene")
  val pathway: Category = Category("pathway")
  val variant: Category = Category("variant")
  val compound: Category = Category("compound")
}
