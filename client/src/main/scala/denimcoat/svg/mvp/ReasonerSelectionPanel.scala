package denimcoat.svg.mvp

import denimcoat.gears.syntax.AllImplicits._
import denimcoat.gears.providers.Var
import denimcoat.svg.{ElementFacade, SvgUtils, TextFacade}
import org.scalajs.dom.svg.{G, SVG}

class ReasonerSelectionPanel(val svg: SVG, val element: G, val reasonerId: String) extends ElementFacade[G] {

  val x: Var[Double] = Var[Double]()
  val y: Var[Double] = Var[Double]()

  val reasonerIdLabel: TextFacade = TextFacade.create(svg, id, x + 20, y + 100)
  reasonerIdLabel.text := reasonerId
  reasonerIdLabel.angle.setValue(90.0)  // TODO


}

object ReasonerSelectionPanel {
  def create(svg: SVG, reasonerId: String): ReasonerSelectionPanel=
    new ReasonerSelectionPanel(svg, SvgUtils.createSvgElement[G]("g"), reasonerId)
}
