package denimcoat.svg.utils

case class Rectangle(x1: Double, y1: Double, x2: Double, y2: Double) {
  def width: Double = x2 - x1
  def height: Double = y2 - y1
}

object Rectangle {
  def fromXYWH(x: Double, y: Double, width: Double, height: Double): Rectangle =
    Rectangle(x, y, x + width, y + height)
}

