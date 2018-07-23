package denimcoat.util

case class RelationSet[A, B](a2bs: Map[A, Set[B]], b2as: Map[B, Set[A]]) {

  def getSources(b: B): Set[A] = b2as.getOrElse(b, Set.empty)
  def getTargets(a: A): Set[B] = a2bs.getOrElse(a, Set.empty)
  def reverse: RelationSet[B, A] = RelationSet(b2as, a2bs)

  def +(ab: (A, B)): RelationSet[A, B] = {
    val (a, b) = ab
    val sourcesNew = getSources(b) + a
    val targetsNew = getTargets(a) + b
    RelationSet(a2bs + (a -> targetsNew), b2as + (b -> sourcesNew))
  }

}

object RelationSet {
  def empty[A, B]: RelationSet[A, B] = RelationSet(Map.empty, Map.empty)
}
