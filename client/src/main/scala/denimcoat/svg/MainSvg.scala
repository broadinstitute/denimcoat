package denimcoat.svg

import denimcoat.mvp.Workflow
import denimcoat.mvp.Workflow.{ItemSetInfo, ResultItemSetInfo, StartItemSetInfo}
import denimcoat.viewmodels.KeyMapper
import org.scalajs.dom
import org.scalajs.dom.svg.SVG

object MainSvg {

  val id = "mainSvg"

  val svg: SVG = dom.document.getElementById(id).asInstanceOf[SVG]

  def yOfRow(row: Int): Double = 50.0 + 50.0 * row

  val xLabel = 30.0

  def xOfItem(iItem: Int): Double = 200.0 + 170.0 * iItem

  trait Row {
    def itemSetInfo : ItemSetInfo
    def svg: SVG
    def iRow: Int
    def label: TextFacade
  }

  class InputRow(val itemSetInfo: StartItemSetInfo, val svg: SVG, val iRow: Int, val label: TextFacade,
                 val textEditBox: TextEditBox)
    extends Row {
  }

  object InputRow {
    def create(itemSetInfo: StartItemSetInfo, svg: SVG, iRow: Int): InputRow = {
      val y = yOfRow(iRow)
      val label = TextFacade.create(svg, "inputRow" + iRow, xLabel, y)
      label.text = itemSetInfo.label + ":"
      svg.appendChild(label.element)
      val textEditBox = TextEditBox.create(svg, "textEditBow" + iRow, xOfItem(0), y)
      svg.appendChild(textEditBox.element)
      new InputRow(itemSetInfo, svg, iRow, label, textEditBox)
    }
  }

  class ResultRow(val itemSetInfo: ResultItemSetInfo, val svg: SVG, val iRow: Int, val label: TextFacade,
                  var items: Seq[SelectableLabelBox])
    extends Row

  object ResultRow {
    def create(itemSetInfo: ResultItemSetInfo, svg: SVG, iRow: Int): ResultRow = {
      val y = yOfRow(iRow)
      val label = TextFacade.create(svg, "resultRow" + iRow, xLabel, y)
      label.text = itemSetInfo.label + ":"
      svg.appendChild(label.element)
      val items = Seq.empty[SelectableLabelBox]
      new ResultRow(itemSetInfo, svg, iRow, label, items)
    }
  }

  val rows: Seq[Row] = Workflow.itemSetInfos.zipWithIndex.map { case (itemSetInfo, iRow) =>
    itemSetInfo match {
      case startItemSetInfo: StartItemSetInfo => InputRow.create(startItemSetInfo, svg, iRow)
      case resultItemSetInfo: ResultItemSetInfo => ResultRow.create(resultItemSetInfo, svg, iRow)
    }
  }

  val rowsByInfo: Map[ItemSetInfo, Row] = rows.map(row => (row.itemSetInfo, row)).toMap

  var outputBoxes: Seq[SelectableLabelBox] = rowsByInfo(Workflow.resultItemSetInfo0).asInstanceOf[ResultRow].items

  val inputField: TextEditBox = rowsByInfo(Workflow.startItemSetInfo).asInstanceOf[InputRow].textEditBox

  def diseaseString: String = inputField.text

  def diseaseString_=(text: String): Unit = inputField.text = text

  def editInputString(edit: KeyMapper.Edit): Unit = inputField.edit(edit)

  def setOutputItems(items: Seq[String]): Unit = {
    outputBoxes.foreach(box => svg.removeChild(box.element))
    outputBoxes = items.zipWithIndex.map { case (item, index) =>
      val outputBox = SelectableLabelBox.create(svg)
      outputBox.text = item
      outputBox.x = xOfItem(index)
      outputBox.y = yOfRow(1)
      svg.appendChild(outputBox.element)
      outputBox
    }
  }

}
