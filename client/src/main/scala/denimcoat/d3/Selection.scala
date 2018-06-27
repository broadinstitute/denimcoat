package denimcoat.d3

import denimcoat.d3.Selection.Multiplicity
import org.scalajs.dom.raw.{EventTarget, HTMLElement}
import org.singlespaced.d3js.{Selection => D3Selection}

import scala.collection.mutable
import scala.scalajs.js


case class Selection[E <: EventTarget, M <: Multiplicity, D](d3Selection: D3Selection[D]) {

  def asOf[EE <: EventTarget]: Selection[EE, M, D] = this.asInstanceOf[Selection[EE, M, D]]

  def append(name: String): Selection[E, M, D] = Selection[E, M, D](d3Selection.append(name))

  def attr(name: String, value: Double): Selection[E, M, D] = Selection[E, M, D](d3Selection.attr(name, value))
  def attr(name: String, value: String): Selection[E, M, D] = Selection[E, M, D](d3Selection.attr(name, value))
  def attr(name: String, value: Boolean): Selection[E, M, D] = Selection[E, M, D](d3Selection.attr(name, value))

  def html[T >: E <: HTMLElement](implicit ev: M =:= Multiplicity.Mono): String = {
    d3Selection.html()
  }

  def html[T >: E <: HTMLElement](html: String): Selection[E, M, D] = {
    Selection[E, M, D](d3Selection.html(html))
  }

  def node(implicit ev: M =:= Multiplicity.Mono): E = d3Selection.node().asInstanceOf[E]

  def nodes: Seq[E] = {
    val selectionArray = d3Selection.asInstanceOf[js.Array[js.Object]]
    val selectionSeq: mutable.Seq[js.Object] = selectionArray
    selectionSeq.flatMap { innerSelection =>
      val innerArray = innerSelection.asInstanceOf[js.Array[js.Object]]
      val innerSeq: mutable.Seq[js.Object] = innerArray
      innerSeq.map(_.asInstanceOf[E])
    }
  }

  def on[R](name: String, handler: (D, Int, js.UndefOr[Int]) => Unit): Selection[E, M, D] =
    Selection[E, M, D](d3Selection.on(name, handler))

  def text(text: String): Selection[E, M, D] = Selection[E, M, D](d3Selection.text(text))

  def appendTextElement(x: Int, y: Int, text: String): Selection[E, M, D] = {
    append("text").attr("x", x).attr("y", y).text(text)
  }

}

object Selection {
  sealed trait Multiplicity
  object Multiplicity {
    sealed trait Mono extends Multiplicity
    sealed trait Poly extends Multiplicity
  }
}
