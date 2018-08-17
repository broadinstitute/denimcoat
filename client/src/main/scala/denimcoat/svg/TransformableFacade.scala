package denimcoat.svg

import org.scalajs.dom.svg.{Element, Transform, Transformable}

trait TransformableFacade[E <: Element with Transformable] extends ElementFacade[E] {

  def addRotation(angle: Double, cx: Double, cy: Double): Unit = {
    addTransform(TransformableFacade.createRotation(angle, cx, cy))
  }

  def onlyRotate(angle: Double, cx: Double, cy: Double): Unit = {
    setSingleTransform(TransformableFacade.createRotation(angle, cx, cy))
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

  def createRotation(angle: Double, cx: Double, cy: Double): Transform = {
    val transform = new Transform
    transform.setRotate(angle, cx, cy)
    transform
  }

}
