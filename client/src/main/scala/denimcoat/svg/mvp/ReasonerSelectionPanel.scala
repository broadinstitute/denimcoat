package denimcoat.svg.mvp

import denimcoat.gears.providers.Var
import denimcoat.gears.syntax.AllImplicits._
import denimcoat.mvp.Workflow
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

  val selectionBoxes: Seq[SelectionBox] = (0 until spaceLayout.nRows).filter{ iRow =>
    Workflow.itemSetInfos(iRow) match {
      case _ : Workflow.StartItemSetInfo => false
      case resultItemSetInfo: Workflow.ResultItemSetInfo =>
        reasonerPlugin.mightBeAbleTo(resultItemSetInfo.previousItems.prefix, resultItemSetInfo.prefix)
    }
  }.map { iRow =>
    val box = SelectableLabelBox.create(svg)
    box.text := TextConstants.reasonerSelectionCheckMark
    box.x := x
    box.y := spaceLayout.yOfPredicateRow(iRow)
    element.appendChild(box.element)
    val itemInfo = Workflow.itemSetInfos(iRow)
    new SelectionBox(itemInfo, box)
  }

  val checkboxesByItemInfo: Map[Workflow.ItemSetInfo, SelectionBox] =
    selectionBoxes.map(box => (box.itemInfo, box)).toMap

  def selected(itemInfo: Workflow.ItemSetInfo): Boolean =
    checkboxesByItemInfo.get(itemInfo).exists(_.selected)
}

object ReasonerSelectionPanel {
  def create(svg: SVG, reasonerId: String, reasonerName: String,
             spaceLayout: SpaceLayout, iPanel: Int): ReasonerSelectionPanel=
    new ReasonerSelectionPanel(svg, SvgUtils.createSvgElement[G]("g"), reasonerId, reasonerName,
      spaceLayout, iPanel)

  class SelectionBox(val itemInfo: Workflow.ItemSetInfo, val checkbox: SelectableLabelBox) {
    def selected: Boolean = checkbox.selectedVar.valueOpt.getOrElse(false)
  }
}
