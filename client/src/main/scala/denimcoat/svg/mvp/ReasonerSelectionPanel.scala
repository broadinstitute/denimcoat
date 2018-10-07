package denimcoat.svg.mvp

import denimcoat.gears.providers.Var
import denimcoat.gears.syntax.AllImplicits._
import denimcoat.mvp.Workflow
import denimcoat.mvp.Workflow.{Derivation, ItemSetInfo}
import denimcoat.reasoners.plugin.{ReasonerPlugin, ReasonerPluginProvider}
import denimcoat.svg.mvp.ReasonerSelectionPanel.SelectionBox
import denimcoat.svg.{ElementFacade, SelectableLabelBox, SvgUtils, TextFacade}
import org.scalajs.dom.svg.{G, SVG}

class ReasonerSelectionPanel(val svg: SVG, val element: G,
                             val reasonerId: String, val reasonerName: String,
                             spaceLayout: SpaceLayout, iPanel: Int) extends ElementFacade[G] {

  val x: Var[Double] = Var[Double]()
  val y: Var[Double] = Var[Double]()

  x.setValue(spaceLayout.xOfReasonerPanel(iPanel))
  y.setValue(spaceLayout.yReasonerPanel)

  val reasonerIdLabel: TextFacade = TextFacade.create(svg, id, x + 10, y + 100)
  reasonerIdLabel.text := reasonerName
  reasonerIdLabel.angle.setValue(-90.0)
  element.appendChild(reasonerIdLabel.element)

  val reasonerPlugin: ReasonerPlugin = ReasonerPluginProvider.getReasonerPlugin(reasonerId)

  val selectionBoxes: Seq[Seq[SelectionBox]] = Workflow.itemSetInfos.zipWithIndex.map { case (itemSetInfo, iRow) =>
    itemSetInfo.derivations.zipWithIndex.map { case (derivation, iPredicate) =>
      val y = spaceLayout.yOfPredicateRow(iRow, iPredicate)
      (y, derivation)
    }.filter { case (_: Double, derivation: Derivation) =>
      reasonerPlugin.mightBeAbleTo(derivation.previousSet.prefix, itemSetInfo.prefix)
    }.map { case (y: Double, derivation: Derivation) =>
      val box = SelectableLabelBox.create(svg)
      box.text := TextConstants.reasonerSelectionCheckMark
      box.x := x
      box.y := y
      element.appendChild(box.element)
      new SelectionBox(itemSetInfo, derivation, box)
    }
  }

  val checkboxesByItemInfo: Map[(Workflow.ItemSetInfo, Workflow.Derivation), SelectionBox] =
    selectionBoxes.flatten.map(box => ((box.itemInfo, box.derivation), box)).toMap

  def selected(itemInfo: Workflow.ItemSetInfo, derivation: Derivation): Boolean =
    checkboxesByItemInfo.get((itemInfo, derivation)).exists(_.selected)
}

object ReasonerSelectionPanel {
  def create(svg: SVG, reasonerId: String, reasonerName: String,
             spaceLayout: SpaceLayout, iPanel: Int): ReasonerSelectionPanel =
    new ReasonerSelectionPanel(svg, SvgUtils.createSvgElement[G]("g"), reasonerId, reasonerName,
      spaceLayout, iPanel)

  class SelectionBox(val itemInfo: Workflow.ItemSetInfo, val derivation: Derivation,
                     val checkbox: SelectableLabelBox) {
    def selected: Boolean = checkbox.selectedVar.valueOpt.getOrElse(false)
  }

}
