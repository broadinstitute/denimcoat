package denimcoat.svg

import org.scalajs.dom.svg.{Element, SVG, Transform, Transformable}

trait TransformableFacade[E <: Element with Transformable] extends ElementFacade[E] {

  def addRotation(angle: Double, cx: Double, cy: Double): Unit = {
    addTransform(TransformableFacade.createRotation(svg, angle, cx, cy))
  }

  def onlyRotate(angle: Double, cx: Double, cy: Double): Unit = {
    setSingleTransform(TransformableFacade.createRotation(svg, angle, cx, cy))
  }

  def addTransform(transform: Transform): Unit = {
    element.transform.baseVal.appendItem(transform)
  }

  def clearTransforms(): Unit = {
    element.transform.baseVal.clear()
  }

  def setSingleTransform(transform: Transform): Unit = {
    element.transform.baseVal.initialize(transform)
  }

  def setTransformOpt(transformOpt: Option[Transform]): Unit = {
    transformOpt.fold(clearTransforms())(setSingleTransform)
  }

}

object TransformableFacade {

  def createRotation(svg: SVG, angle: Double, cx: Double, cy: Double): Transform = {
    val transform = svg.createSVGTransform()
    transform.setRotate(angle, cx, cy)
    transform
  }

}
