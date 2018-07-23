package denimcoat.noticache

import denimcoat.util.RelationSet

import scala.util.Random

object NotiCache {

  trait Id {
    def time: Long

    def random: Long
  }

  trait ProducerId extends Id

  object ProducerId {
    def createNew: ProducerId = ConsumerProducerId.createNew
  }

  trait ConsumerId extends Id

  object ConsumerId {
    def createNew: ConsumerId = ConsumerProducerId.createNew
  }

  case class ConsumerProducerId(time: Long, random: Long) extends ProducerId with ConsumerId

  object ConsumerProducerId {
    def createNew: ConsumerProducerId = ConsumerProducerId(System.currentTimeMillis(), Random.nextLong())
  }

  var values: Map[ProducerId, Any] = Map.empty
  var dependencies: RelationSet[ProducerId, ConsumerId] = RelationSet.empty

  def invalidate(producerId: ProducerId): Unit = ??? // TODO
  def put(producerId: ProducerId, value: Any): Unit = values = values + (producerId -> value)
  def get(producerId: ProducerId): Option[Any] = values.get(producerId)

}
