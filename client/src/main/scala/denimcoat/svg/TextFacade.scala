package denimcoat.svg

import denimcoat.gears.{Consumer, Event, Property}
import denimcoat.gears.providers.{Function3Provider, Provider, Var}
import denimcoat.gears.syntax.AllImplicits._
import org.scalajs.dom.svg.{SVG, Text, Transform}

class TextFacade(val svg: SVG, val element: Text)
  extends StylableElementFacade[Text] with TransformableFacade[Text] {
  val text: Property[String] = Property[String](element.textContent = _)
  val x: Property[Double] = Property[Double](x => element.setAttribute("x", x.toString))
  val y: Property[Double] = Property[Double](y => element.setAttribute("y", y.toString))
  val angle: Var[Double] = Var[Double]()

  val rotation: Provider[Transform] = Function3Provider(x, y, angle)(
    (x: Double, y: Double, angle: Double) => TransformableFacade.createRotation(svg, angle, x, y)
  )
  val rotationUpdater: Consumer[Transform] = (event: Event[Transform]) => setTransformOpt(event.valueOpt)

  rotation.addConsumer(rotationUpdater)

}

object TextFacade {

  def getById(svg: SVG, id: String): TextFacade =
    new TextFacade(svg, SvgUtils.getSvgElementById[Text](id))

  def create(svg: SVG, id: Provider[String], x: Provider[Double], y: Provider[Double]): TextFacade = {
    val text = new TextFacade(svg, SvgUtils.createSvgElement[Text]("text"))
    text.id := id
    text.x := x
    text.y := y
    text
  }
}