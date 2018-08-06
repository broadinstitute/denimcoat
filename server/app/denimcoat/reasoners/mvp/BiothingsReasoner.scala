package denimcoat.reasoners.mvp

import java.net.URL

import denimcoat.reasoners.Reasoner
import denimcoat.reasoners.messages.{DefaultRequest, Response}

object BiothingsReasoner extends Reasoner {
  override def id: String = "biothings"

  override def version: String = "2"

  override def reason(request: DefaultRequest): Response = {
    val url = new URL("http://biothings.io/explorer/api/v2/directinput2output?input_prefix=omim.disease&output_prefix=hp&input_value=125853&format=translator")

    ???
  }
}
