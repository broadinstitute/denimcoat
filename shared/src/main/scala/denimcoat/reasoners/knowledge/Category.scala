package denimcoat.reasoners.knowledge

case class Category(id: String, label: String) extends Identifiable {

}

object Category {

  def apply(name: String): Category = Category(name, name)

  val disease = Category("disease")
  val symptom = Category("symptom")
}
