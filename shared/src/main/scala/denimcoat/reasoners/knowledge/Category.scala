package denimcoat.reasoners.knowledge

case class Category(id: String, name: String) extends Identifiable {

}

object Category {

  def apply(name: String): Category = Category(name, name)

  val disease: Category = Category("disease")
  val phenotype: Category = Category("phenotype")
  val gene: Category = Category("gene")
  val pathway: Category = Category("pathway")
  val variant: Category = Category("variant")
}
