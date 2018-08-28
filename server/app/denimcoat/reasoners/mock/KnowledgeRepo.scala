package denimcoat.reasoners.mock

import denimcoat.reasoners.knowledge.{Category, Relation}
import denimcoat.util.{Entity, Index}

object KnowledgeRepo {

  trait EntitySet {
    var entities: Set[Entity] = Set.empty

    def category: Category

    def newEntity(string: String): Entity = {
      val entity = Entity.parse(string)
      entities += entity
      entity
    }

  }

  object Diseases extends EntitySet {
    val category: Category = Category.disease
    val typeOneDiabetesMellitus: Entity = newEntity("type 1 diabetes mellitus")
    val typeTwoDiabetesMellitus: Entity = newEntity("type 2 diabetes mellitus")
    val behcet: Entity = newEntity("Behcet's disease")
    val ms: Entity = newEntity("multiple sklerosis")
  }

  object Symptoms extends EntitySet {
    val category: Category = Category.symptom
    val inflammation: Entity = newEntity("inflammation")
    val fever: Entity = newEntity("fever")
    val pain: Entity = newEntity("pain")
    val oralAphthousUlcers: Entity = newEntity("ulcers aphthous oral")
    val uveitis: Entity = newEntity("uveitis")
    val genitalUlceration: Entity = newEntity("genital ulceration")
    val hyperglycemia: Entity = newEntity("hyperglycemia")
    val polydipsia: Entity = newEntity("polydipsia")
    val polyphagia: Entity = newEntity("polyphagia")
    val cnsLesions: Entity = newEntity("CNS lesions")
  }

  object Variants extends EntitySet {
    val category: Category = Category.variant
    val rs3135388T: Entity = newEntity("rs3135388(T)")
    val rs12722489G: Entity = newEntity("rs12722489(G)")
    val rs2104286A: Entity = newEntity("rs2104286(A)")
  }

  val entitySets: Set[EntitySet] = Set(Diseases, Symptoms, Variants)

  val relationMap: Map[Entity, Map[Relation, Set[Entity]]] = {
    import KnowledgeRepo.{Diseases => D, Symptoms => S, Variants => V}
    import denimcoat.reasoners.knowledge.{Relation => R}
    Map(
      D.typeOneDiabetesMellitus -> Map(
        R.hasSymptom -> Set(S.hyperglycemia, S.polydipsia, S.polyphagia),
        R.isPromotedBy -> Set(V.rs2104286A)
      ),
      D.typeTwoDiabetesMellitus -> Map(R.hasSymptom -> Set(S.hyperglycemia, S.polydipsia, S.polyphagia)),
      D.behcet -> Map(
        R.hasSymptom -> Set(S.oralAphthousUlcers, S.inflammation, S.genitalUlceration, S.uveitis, S.cnsLesions)
      ),
      D.ms -> Map(
        R.hasSymptom -> Set(S.cnsLesions),
        R.isPromotedBy -> Set(V.rs3135388T, V.rs12722489G, V.rs2104286A)
      )
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
    for ((start, relationsEndsMap) <- relationMap) {
      for ((relation, ends) <- relationsEndsMap) {
        for (end <- ends) {
          graph = graph.withEdge(start, relation, end)
          relation match {
            case reversible: Relation.Reversible => graph = graph.withEdge(end, reversible.reverse, start)
            case _ => ()
          }
        }
      }
    }
    graph
  }

  val index: Index[Entity] = Index[Entity](Seq(_.id, _.name))

  for (entity <- graph.nodes) {
    index.add(entity)
  }
}