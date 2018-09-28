package denimcoat.svg

import denimcoat.MainJS
import denimcoat.gears.syntax.AllImplicits._
import denimcoat.mvp.Workflow
import denimcoat.mvp.Workflow.{Derivation, ItemSetInfo}
import denimcoat.svg.mvp.{ButtonId, ReasonerList, ReasonerSelectionPanel, SpaceLayout}
import denimcoat.util.SeqRotator
import denimcoat.viewmodels.KeyMapper
import org.scalajs.dom
import org.scalajs.dom.raw.MouseEvent
import org.scalajs.dom.svg.SVG

import scala.util.Random

object MainSvg {

  val id = "mainSvg"

  val svg: SVG = dom.document.getElementById(id).asInstanceOf[SVG]

  val nReasoners: Int = ReasonerList.list.size
  val nRows: Int = Workflow.itemSetInfos.size
  val nPredicatesPerRow: Int = 2
  val spaceLayout: SpaceLayout = SpaceLayout(nReasoners, nRows, nPredicatesPerRow)

  trait Row {
    def itemSetInfo: ItemSetInfo

    def svg: SVG

    def iRow: Int

    def label: TextFacade

    def items: Seq[String]

    def addExample(): Unit

    def clear(): Unit

    def rotateItems(offset: Int): Unit

    val buttonClickActions: Map[ButtonId, () => Unit] = Map(
      ButtonId.examples -> (() => addExample()),
      ButtonId.clear -> (() => clear()),
      ButtonId.fastBack -> (() => rotateItems(-5)),
      ButtonId.back -> (() => rotateItems(-1)),
      ButtonId.forward -> (() => rotateItems(1)),
      ButtonId.fastForward -> (() => rotateItems(5))
    )

    val buttons: Map[ButtonId, LabelledButton] = buttonClickActions.map { case (buttonId, action) =>
      val button: LabelledButton = LabelledButton.create(svg, (_: MouseEvent) => action())
      button.text := "[" + buttonId.label + "]"
      button.x := spaceLayout.xOfSmallButton(buttonId)
      button.y := spaceLayout.yOfSmallButton(iRow, buttonId)
      svg.appendChild(button.element)
      (buttonId, button)
    }

    def selectedItems: Seq[String]
  }

  class InputRow(val itemSetInfo: ItemSetInfo, val svg: SVG, val iRow: Int, val label: TextFacade,
                 val textEditBox: TextEditBox)
    extends Row {
    override def items: Seq[String] = Seq(textEditBox.text)

    override def selectedItems: Seq[String] = Seq(textEditBox.text)

    override def addExample(): Unit = {
      val examples = Workflow.examples(itemSetInfo)
      val iRandom = Random.nextInt(examples.size)
      textEditBox.text = examples(iRandom)
    }

    override def clear(): Unit = {
      textEditBox.text = ""
    }

    override def rotateItems(offset: Int): Unit = ()
  }

  object InputRow {
    def create(itemSetInfo: ItemSetInfo, svg: SVG, iRow: Int): InputRow = {
      val y = spaceLayout.yOfItemsRow(iRow)
      val label = TextFacade.create(svg, "inputRow" + iRow, spaceLayout.xItemsLabel, y)
      label.text := itemSetInfo.name + ":"
      svg.appendChild(label.element)
      val textEditBox = TextEditBox.create(svg, "textEditBow" + iRow, spaceLayout.xOfItem(0), y)
      svg.appendChild(textEditBox.element)
      new InputRow(itemSetInfo, svg, iRow, label, textEditBox)
    }
  }

  class ResultRow(val itemSetInfo: ItemSetInfo, val svg: SVG, val iRow: Int, val label: TextFacade,
                  val queryButtons: Seq[LabelledButton], var itemBoxes: Seq[SelectableLabelBox])
    extends Row {
    def items: Seq[String] = itemBoxes.map(_.text.get.get)

    def items_=(items: Seq[String]): Unit = {
      itemBoxes.foreach(box => svg.removeChild(box.element))
      itemBoxes = items.map { item =>
        val outputBox = SelectableLabelBox.create(svg)
        outputBox.text := item
        //        outputBox.x := xOfItem(index)
        outputBox.y := spaceLayout.yOfItemsRow(iRow)
        svg.appendChild(outputBox.element)
        outputBox
      }
      if (itemBoxes.nonEmpty) {
        itemBoxes.head.x := spaceLayout.xOfItem(0)
        if (itemBoxes.size > 1) {
          itemBoxes.sliding(2).foreach { case Seq(box1, box2) =>
            val width = box1.element.getBBox().width
            val padding = 20
            val offset = width + padding
            box2.x := box1.x + offset
          }
        }
      }
    }

    override def selectedItems: Seq[String] = itemBoxes.filter(_.selectedVar.get.get).map(_.text.get.get)

    override def addExample(): Unit = {
      val examples = Workflow.examples(itemSetInfo)
      items = (items ++ examples).distinct
    }

    override def clear(): Unit = {
      items = Seq.empty
    }

    override def rotateItems(offset: Int): Unit = {
      items = SeqRotator.rotate(items, offset)
    }
  }

  object ResultRow {
    def create(itemSetInfo: ItemSetInfo, svg: SVG, iRow: Int): ResultRow = {
      val yItems = spaceLayout.yOfItemsRow(iRow)
      val label = TextFacade.create(svg, "resultRow" + iRow, spaceLayout.xItemsLabel, yItems)
      label.text := itemSetInfo.name + ":"
      svg.appendChild(label.element)
      val buttons = itemSetInfo.derivations.zipWithIndex.map { case (derivation, iPredicate) =>
        val button = LabelledButton.create(svg, (_: MouseEvent) => MainJS.submit(itemSetInfo, derivation))
        button.text := "[" + derivation.relation.name + "]"
        button.x := spaceLayout.xQueryButtons
        button.y := spaceLayout.yOfPredicateRow(iRow, iPredicate)
        svg.appendChild(button.element)
        button
      }
      val items = Seq.empty[SelectableLabelBox]
      new ResultRow(itemSetInfo, svg, iRow, label, buttons, items)
    }
  }

  val reasonerSelectionPanels: Seq[ReasonerSelectionPanel] =
    ReasonerList.list.zipWithIndex.map { case (ReasonerList.Entry(reasonerId, name), iReasoner) =>
      val panel = ReasonerSelectionPanel.create(svg, reasonerId, name, spaceLayout, iReasoner)
      svg.appendChild(panel.element)
      panel
    }

  val reasonerSelectionPanelsById: Map[String, ReasonerSelectionPanel] =
    reasonerSelectionPanels.map(panel => (panel.reasonerId, panel)).toMap

  def selectedReasoners(itemInfo: Workflow.ItemSetInfo, derivation: Derivation): Seq[String] = {
    reasonerSelectionPanels.filter(_.selected(itemInfo, derivation)).map(_.reasonerId)
  }

  val rows: Seq[Row] = Workflow.itemSetInfos.zipWithIndex.map { case (itemSetInfo, iRow) =>
    if(itemSetInfo.isStartItemSet) {
      InputRow.create(itemSetInfo, svg, iRow)
    } else {
      ResultRow.create(itemSetInfo, svg, iRow)
    }
  }

  val rowsByInfo: Map[ItemSetInfo, Row] = rows.map(row => (row.itemSetInfo, row)).toMap

  val resultRowsByInfo: Map[ItemSetInfo, ResultRow] = rowsByInfo.collect {
    case (itemSetInfo: ItemSetInfo, resultRow: ResultRow) => (itemSetInfo, resultRow)
  }

  val inputRow: InputRow = rowsByInfo(Workflow.startItemSetInfo).asInstanceOf[InputRow]

  val inputField: TextEditBox = inputRow.textEditBox

  def inputString: String = inputField.text

  def inputString_=(text: String): Unit = inputField.text = text

  def editInputString(edit: KeyMapper.Edit): Unit = inputField.edit(edit)

  def setOutputItems(itemSetInfo: ItemSetInfo, items: Seq[String]): Unit = {
    resultRowsByInfo(itemSetInfo).items = items
  }

}
