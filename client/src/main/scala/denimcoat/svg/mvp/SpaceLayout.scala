package denimcoat.svg.mvp

import denimcoat.svg.mvp.SpaceLayout.Spacing

case class SpaceLayout(nReasoners: Int, nRows: Int, spacing: Spacing = Spacing.default) {

  val yFirstItemsRow: Double = 180.0

  def yOfButtonsRow(iRow: Int): Double = yFirstItemsRow - 25.0 + 50.0 * iRow

  def yOfItemsRow(iRow: Int): Double = yFirstItemsRow + 50.0 * iRow

  val yReasonerPanel: Double = 30

  def xOfReasonerPanel(iPanel: Int): Double = 10 + iPanel * spacing.widthReasonerPanel

  val xItemsLabel: Double = 40.0 + nReasoners * spacing.widthReasonerPanel

  val xQueryButtons: Double = xItemsLabel - 20.0

  val xOfExampleButton: Double = xItemsLabel + 90.0

  val xOfClearButton: Double = xOfExampleButton + 30.0

  def xOfItem(iItem: Int): Double = xOfClearButton + 60.0 + 170.0 * iItem

}

object SpaceLayout {

  case class Spacing(widthReasonerPanel: Double)

  object Spacing {
    val default: Spacing = Spacing(
      widthReasonerPanel = 20.0
    )
  }

}
