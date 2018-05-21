package denimcoat.reasoners.mock

object EntityCatalogue {

  case class Group(name: String)

  val drug = Group("drug")
  val target = Group("target")
  val disease = Group("disease")

  trait Entry {
    def name: String

    def cui: String
  }

  case class Drug(name: String, cui: String, targets: Set[Target]) extends Entry {
    addDrug(this)
  }

  case class Target(name: String, cui: String, diseases: Set[Disease]) extends Entry {
    addTarget(this)
  }

  case class Disease(name: String, cui: String) extends Entry {
    addDisease(this)
  }

  def entries: Set[Entry] = drugs ++ targets ++ diseases

  var drugs: Set[Drug] = Set.empty
  var targets: Set[Target] = Set.empty
  var diseases: Set[Disease] = Set.empty

  def addDrug(drug: Drug): Unit = drugs += drug

  def addTarget(target: Target): Unit = targets += target

  def addDisease(disease: Disease): Unit = diseases += disease

  val inflammation = Disease("inflammation", "C0021368")
  val fever = Disease("fever", "C0015967")
  val pain = Disease("pain", "C0030193")

  val cyclooxygenase = Target("cyclooxygenase", "C17015", Set(inflammation, fever, pain))

  val acetaminophen = Drug("acetaminophen", "C0000970", Set(cyclooxygenase))
  val aspirin = Drug("aspirin", "C0004057", Set(cyclooxygenase))
  val ibuprofen = Drug("ibuprofen", "C0020740", Set(cyclooxygenase))

  def byCui(cui: String): Option[Entry] = entries.find(_.cui == cui)

  def drugByCui(cui: String): Option[Drug] = drugs.find(_.cui == cui)

  def targetByCui(cui: String): Option[Target] = targets.find(_.cui == cui)

  def diseaseByCui(cui: String): Option[Disease] = diseases.find(_.cui == cui)

  def byName(name: String): Option[Entry] = entries.find(_.name == name)

  def drugByName(name: String): Option[Drug] = drugs.find(_.name == name)

  def targetByName(name: String): Option[Target] = targets.find(_.name == name)

  def diseaseByName(name: String): Option[Disease] = diseases.find(_.name == name)

}
