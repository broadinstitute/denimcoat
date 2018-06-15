package denimcoat

import scala.collection.mutable
import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

object JsInspecter {

  def inspect(obj: js.Object): String = {
    if(Array.isArray(obj)) {
      val elements = obj.asInstanceOf[js.Array[Any]].to[Seq]
      elements.mkString(", ")
    } else {
      val keys = Object.keys(obj).asInstanceOf[mutable.Seq[String]]
      keys.mkString(", ")
    }
  }

}

@js.native
@JSGlobal
object Object extends js.Object {
  def keys(obj: js.Object): js.Array[String] = js.native
}

@js.native
@JSGlobal
object Array extends js.Object {
  def isArray(obj: js.Object): Boolean = js.native
  def getOwnPropertyNames(obj: js.Object): js.Array[String] = js.native
}

@js.native
@JSGlobal
object JSON extends js.Object {
  def stringify(obj: js.Object): String = js.native
  def getOwnPropertyNames(obj: js.Object): js.Array[String] = js.native
}

