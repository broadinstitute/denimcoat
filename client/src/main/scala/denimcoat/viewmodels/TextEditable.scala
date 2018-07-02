package denimcoat.viewmodels

trait TextEditable {

  def edit(mod: TextWithCursor => TextWithCursor)

}
