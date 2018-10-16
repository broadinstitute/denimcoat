package denimcoat.util

import denimcoat.reasoners.knowledge.{IdPrefix, Identifiable, PrefixedId}

case class Entity(ids: Seq[PrefixedId]) extends Identifiable {
  def ++(oEntity: Entity): Entity = Entity((ids ++ oEntity.ids).distinct)
}

object Entity {

  def normalizeId(id: String): String = {
    val colPos = id.indexOf(":")
    if (colPos < 1) {
      id
    } else {
      id.substring(0, colPos).toLowerCase() + id.substring(colPos)
    }
  }

  def fromStrings(strings: Seq[String]): Entity = Entity(strings.map(PrefixedId.parse))

  def parse(string: String): Entity = fromStrings(string.split(";").map(_.trim))

  trait Reducer {
    def areSame(entity1: Entity, entity2: Entity): Boolean

    def combine(entity1: Entity, entity2: Entity): Option[Entity] = {
      if (areSame(entity1, entity2)) {
        Some(Entity((entity1.ids ++ entity2.ids).distinct))
      } else {
        None
      }
    }

    def reduce(entities: Seq[Entity]): Seq[Entity] = {
      var entitiesRemaining: Seq[ Entity] = entities
      var entitiesReduced: Seq[Entity] = Seq.empty
      while(entitiesRemaining.nonEmpty) {
        var nextEntity = entitiesRemaining.head
        entitiesRemaining = entitiesRemaining.tail
        var index: Int = 1
        while(index < entitiesRemaining.size) {
          val entityAtIndex = entitiesRemaining(index)
          if(areSame(nextEntity, entityAtIndex)) {
            nextEntity ++= entityAtIndex
            val (entitiesRemainingPart1, entitiesRemainingPart2) = entitiesRemaining.splitAt(index)
            entitiesRemaining = entitiesRemainingPart1 ++ entitiesRemainingPart2.tail
          } else {
            index += 1
          }
        }
        entitiesReduced :+= nextEntity
      }
      entitiesReduced
    }
  }

  object Reducer {
    val byAnyId: Reducer = (entity1: Entity, entity2: Entity) => {
      entity1.ids.exists(id1 => entity2.ids.contains(id1))
    }
    val byIdsWithProperPrefix: Reducer = (entity1: Entity, entity2: Entity) => {
      entity1.ids.exists(id1 => id1.prefix != IdPrefix.none && entity2.ids.contains(id1))
    }

    case class ByIdsWithPrefixes(prefixes: Set[IdPrefix]) extends Reducer {
      override def areSame(entity1: Entity, entity2: Entity): Boolean = {
        entity1.ids.exists(id1 => prefixes.contains(id1.prefix) && entity2.ids.contains(id1))
      }
    }

  }

}