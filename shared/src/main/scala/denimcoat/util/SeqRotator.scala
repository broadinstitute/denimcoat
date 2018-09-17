package denimcoat.util

object SeqRotator {

  def rotate[A](seq: Seq[A], offset: Int): Seq[A] = {
    if(offset > 0) {
      val forward = offset % seq.size
      if(forward != 0) {
        seq.drop(forward) ++ seq.take(forward)
      } else {
        seq
      }
    } else if(offset < 0) {
      val backward = (-offset) % seq.size
      if(backward != 0) {
        seq.takeRight(backward) ++ seq.dropRight(backward)
      } else {
        seq
      }
    } else {
      seq
    }
  }

}
