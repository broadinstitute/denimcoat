package denimcoat.reasoners.knowledge

case class Category(id: String, name: String, prefix: String) extends Identifiable {

}

object Category {

  def apply(name: String, prefix: String): Category = Category(name, name, prefix)

  val disease = Category("disease", "omim.disease")
  val symptom = Category("symptom", "HP")
  val gene = Category("gene", "ncbigene")
  val variant = Category("variant", "rs")
}
