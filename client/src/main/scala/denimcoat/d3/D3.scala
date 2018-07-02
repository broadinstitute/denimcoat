package denimcoat.d3

import denimcoat.d3.Selection.Multiplicity
import org.scalajs.dom.EventTarget
import org.singlespaced.d3js.d3

object D3 {

  def select(selector: String): Selection[EventTarget, Multiplicity.Mono, EventTarget] = {
    Selection[EventTarget, Multiplicity.Mono, EventTarget](d3.select(selector))
  }

  def selectAll(selector: String): Selection[EventTarget, Multiplicity.Poly, EventTarget] = {
    Selection[EventTarget, Multiplicity.Poly, EventTarget](d3.selectAll(selector))
  }

}
