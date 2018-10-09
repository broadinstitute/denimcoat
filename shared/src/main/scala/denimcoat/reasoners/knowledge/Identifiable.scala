package denimcoat.reasoners.knowledge

trait Identifiable {
  def id: PrefixedId = IdPrefix.name(name)

  def name: String
}
