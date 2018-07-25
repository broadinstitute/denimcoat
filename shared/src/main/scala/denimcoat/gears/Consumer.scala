package denimcoat.gears

trait Consumer[-T] {
  def receive(event: Event[T]): Unit
}

object Consumer {

}
