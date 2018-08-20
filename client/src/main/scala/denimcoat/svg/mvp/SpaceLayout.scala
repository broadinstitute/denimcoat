package denimcoat.svg.mvp

import denimcoat.svg.mvp.SpaceLayout.Spacing

case class SpaceLayout(nReasoners: Int, nRows: Int, spacing: Spacing = Spacing.default) {


}

object SpaceLayout {

  def apply(nReasoners: Int, nRows: Int, spacing: Spacing = Spacing.default): SpaceLayout =
    SpaceLayout(nReasoners, nRows, spacing)

  case class Spacing(widthReasonerPanel: Double)

  object Spacing {
    val default: Spacing = Spacing(
      widthReasonerPanel = 20.0
    )
  }

}
