package denimcoat.svg

import denimcoat.gears.syntax.AllImplicits._
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
    def items: Seq[String]
    def selectedItems: Seq[String]
  }

  class InputRow(val itemSetInfo: StartItemSetInfo, val svg: SVG, val iRow: Int, val label: TextFacade,
                 val textEditBox: TextEditBox)
    extends Row {
    override def items: Seq[String] = Seq(textEditBox.text)
    override def selectedItems: Seq[String] = Seq(textEditBox.text)
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
                  var itemBoxes: Seq[SelectableLabelBox])
    extends Row {
    def items: Seq[String] = itemBoxes.map(_.text.get.get)
    def items_=(items: Seq[String]): Unit = {
      itemBoxes.foreach(box => svg.removeChild(box.element))
      itemBoxes = items.zipWithIndex.map { case (item, index) =>
        val outputBox = SelectableLabelBox.create(svg)
        outputBox.text := item
        outputBox.x := xOfItem(index)
        outputBox.y := yOfRow(iRow)
        svg.appendChild(outputBox.element)
        outputBox
      }
    }
    override def selectedItems: Seq[String] = itemBoxes.filter(_.selected.get.get).map(_.text.get.get)
  }

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

  val resultRowsByInfo: Map[ResultItemSetInfo, ResultRow] = rowsByInfo.collect {
    case (resultItemSetInfo: ResultItemSetInfo, resultRow: ResultRow) => (resultItemSetInfo, resultRow)
  }

  val inputRow: InputRow = rowsByInfo(Workflow.startItemSetInfo).asInstanceOf[InputRow]

  val inputField: TextEditBox = inputRow.textEditBox

  def inputString: String = inputField.text

  def inputString_=(text: String): Unit = inputField.text = text

  def editInputString(edit: KeyMapper.Edit): Unit = inputField.edit(edit)

  def setOutputItems(resultItemSetInfo: ResultItemSetInfo, items: Seq[String]): Unit = {
    resultRowsByInfo(resultItemSetInfo).items = items
  }

}
