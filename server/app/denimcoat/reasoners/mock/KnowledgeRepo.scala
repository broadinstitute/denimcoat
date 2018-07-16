package denimcoat.reasoners.mock

import denimcoat.reasoners.knowledge.{Category, Identifiable, Relation}
import denimcoat.util.Index

object KnowledgeRepo {

  trait EntitySet {
    var entities: Set[Entity] = Set.empty

    def category: Category

    def newEntity(id: String, label: String): Entity = {
      val entity = Entity(id, label)
      entities += entity
      entity
    }

    def newEntity(id: String): Entity = newEntity(id, id)
  }

  object Diseases extends EntitySet {
    val category: Category = Category.disease
    val typeTwoDiabetesMellitus: Entity = newEntity("typeTwoDiabetesMellitus", "type 2 diabetes mellitus")
    val behcet: Entity = newEntity("behcetsDisease", "Behcet's disease")
  }

  object Symptoms extends EntitySet {
    val category: Category = Category.symptom
    val inflammation: Entity = newEntity("inflammation")
    val fever: Entity = newEntity("fever")
    val pain: Entity = newEntity("pain")
    val oralAphthousUlcers: Entity = newEntity("ulcersAphtousOral", "ulcers aphthous oral")
    val uveitis: Entity = newEntity("uveitis")
    val genitalUlceration: Entity = newEntity("genitalUlceration", "genital ulceration")
    val hyperglycemia: Entity = newEntity("hyperglycemia")
    val polydipsia: Entity = newEntity("polydipsia")
    val polyphagia: Entity = newEntity("polyphagia")
  }

  val entitySets: Set[EntitySet] = Set(Diseases, Symptoms)

  val relationMap: Map[Entity, Map[Relation, Set[Entity]]] = {
    import KnowledgeRepo.{Diseases => D, Symptoms => S}
    import denimcoat.reasoners.knowledge.{Relation => R}
    Map(
      D.typeTwoDiabetesMellitus -> Map(R.hasSymptom -> Set(S.hyperglycemia, S.polydipsia, S.polyphagia)),
      D.behcet -> Map(R.hasSymptom -> Set(S.oralAphthousUlcers, S.inflammation, S.genitalUlceration))
    )
  }

  type Graph = denimcoat.util.Graph[Entity, Category, Relation]
  type Edge = denimcoat.util.Graph.Edge[Entity, Category]

  val graph: Graph = {
    var graph = denimcoat.util.Graph.empty[Entity, Category, Relation]
    for (entitySet <- Seq(Diseases, Symptoms)) {
      for (entity <- entitySet.entities) {
        graph = graph.withNode(entity, entitySet.category)
      }
    }
    for((start, relationsEndsMap) <- relationMap) {
      for((relation, ends) <-  relationsEndsMap) {
        for(end <- ends) {
          graph = graph.withEdge(start, relation, end)
          relation match {
            case reversible : Relation.Reversible => graph = graph.withEdge(end, reversible.reverse, start)
            case _ => ()
          }
        }
      }
    }
    graph
  }

  val index = Index[Entity](Seq(_.id, _.label))

  for(entity <- graph.nodes) {
    index.add(entity)
  }
}