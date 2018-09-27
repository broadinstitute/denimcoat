package denimcoat.svg.mvp

import denimcoat.svg.mvp.SpaceLayout.Spacing

case class SpaceLayout(nReasoners: Int, nRows: Int, nPredicatesPerRow: Int, spacing: Spacing = Spacing.default) {

  val yFirstItemsRow: Double = 180.0

  val yDiffPerSubRow: Double = 25.0

  val yDiffPerRow: Double = (2 + nPredicatesPerRow) * yDiffPerSubRow

  def yOfPredicateRow(iRow: Int, iPredicate: Int): Double =
    yOfItemsRow(iRow) - (1 + iPredicate) * yDiffPerSubRow

  def yOfItemsRow(iRow: Int): Double = yFirstItemsRow + yDiffPerRow * iRow

  def yOfNavigationRow(iRow: Int): Double = yOfItemsRow(iRow) + yDiffPerSubRow

  def iOfSmallButtonGroup(buttonId: ButtonId): Int = ButtonId.Group.all.indexOf(buttonId.group)

  def yOfSmallButton(iRow: Int, buttonId: ButtonId): Double = yOfItemsRow(iRow) + 25.0 * iOfSmallButtonGroup(buttonId)

  val xOfFirstSmallButton: Double = 40.0 + nReasoners * spacing.widthReasonerPanel

  def iOfSmallButton(buttonId: ButtonId): Int = ButtonId.allByGroup(buttonId.group).indexOf(buttonId)

  def xOfSmallButton(buttonId: ButtonId): Double = xOfFirstSmallButton + 40.0 * iOfSmallButton(buttonId)

  val yReasonerPanel: Double = 30

  def xOfReasonerPanel(iPanel: Int): Double = 10 + iPanel * spacing.widthReasonerPanel

  val nButtonsPerRowMax: Int = ButtonId.allByGroup.values.map(_.size).max

  val xItemsLabel: Double = xOfFirstSmallButton + 10.0 + 40.0 * nButtonsPerRowMax

  val xQueryButtons: Double = xOfFirstSmallButton - 20.0

  val xOfExampleButton: Double = xOfFirstSmallButton

  val xOfClearButton: Double = xOfExampleButton + 40.0

  def xOfItem(iItem: Int): Double = xItemsLabel + 100.0 + 170.0 * iItem

}

object SpaceLayout {

  case class Spacing(widthReasonerPanel: Double)

  object Spacing {
    val default: Spacing = Spacing(
      widthReasonerPanel = 20.0
    )
  }

}
