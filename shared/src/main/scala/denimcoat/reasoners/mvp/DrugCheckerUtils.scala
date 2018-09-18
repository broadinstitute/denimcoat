package denimcoat.reasoners.mvp

object DrugCheckerUtils {

  val sampleUrl: String =
    "http://ec2-34-227-29-65.compute-1.amazonaws.com/perl/isDrug.cgi?compounds=CHEMBL306380,CHEMBL388978," +
      "CHEMBL403989,CHEMBL374027,CHEMBL2105643,CHEMBL1096380,CHEMBL492399,CHEMBL1743082,CHEMBL1742994,CHEMBL428647"

  val baseUrl: String = "http://ec2-34-227-29-65.compute-1.amazonaws.com/perl/isDrug.cgi?compounds="

  def buildUrl(compounds: Iterable[String]): String = baseUrl + compounds.mkString(",")

  case class ResponseElement(molecule: String, isDrug: Boolean)

  type Response = Seq[ResponseElement]

}
