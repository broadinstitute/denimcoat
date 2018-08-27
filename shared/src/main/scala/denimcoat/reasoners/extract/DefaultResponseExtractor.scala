package denimcoat.reasoners.extract

import denimcoat.reasoners.messages.DefaultResponse

class DefaultResponseExtractor(override val response: DefaultResponse) extends ResponseExtractor {
  type Response = DefaultResponse
}
