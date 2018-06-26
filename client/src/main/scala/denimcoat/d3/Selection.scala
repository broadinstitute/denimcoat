package denimcoat.d3

import denimcoat.d3.Selection.Multiplicity
import org.scalajs.dom.raw.{EventTarget, HTMLElement, HTMLInputElement}
import org.singlespaced.d3js.{Selection => D3Selection}

import scala.collection.mutable
import scala.scalajs.js


case class Selection[E <: EventTarget, M <: Multiplicity, D](d3Selection: D3Selection[E]) {

  def asOf[EE]: Selection[EE, M, D] = this.asInstanceOf[Selection[EE, M, D]]

  def html[T >: E <: HTMLElement](implicit ev: M =:= Multiplicity.Mono): String = {
    d3Selection.html()
  }

  def html[T >: E <: HTMLElement](html: String): Selection[E, M, D] = {
    Selection[E, M, D](d3Selection.html(html))
  }

  def nodes: Seq[E] = {
    val selectionArray = d3Selection.asInstanceOf[js.Array[js.Object]]
    val selectionSeq: mutable.Seq[js.Object] = selectionArray
    selectionSeq.flatMap { innerSelection =>
      val innerArray = innerSelection.asInstanceOf[js.Array[js.Object]]
      val innerSeq: mutable.Seq[js.Object] = innerArray
      innerSeq.map(_.asInstanceOf[E])
    }
  }
}

object Selection {
  sealed trait Multiplicity
  object Multiplicity {
    sealed trait Mono extends Multiplicity
    sealed trait Poly extends Multiplicity
  }
}
