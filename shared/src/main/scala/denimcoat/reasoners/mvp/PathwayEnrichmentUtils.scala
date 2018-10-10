package denimcoat.reasoners.mvp

import denimcoat.reasoners.knowledge.PrefixedId

object PathwayEnrichmentUtils {

  val sampleUrl: String =
    "http://ec2-34-227-29-65.compute-1.amazonaws.com/perl/pathDIP.cgi?genes=ncbigene:111,ncbigene:208," +
      "ncbigene:326,ncbigene:348,ncbigene:351,ncbigene:355,ncbigene:467,ncbigene:488,ncbigene:489,ncbigene:596," +
      "ncbigene:598,ncbigene:635,ncbigene:640,ncbigene:641,ncbigene:718,ncbigene:836,ncbigene:841,ncbigene:847," +
      "ncbigene:857,ncbigene:875,ncbigene:894,ncbigene:969,ncbigene:1036,ncbigene:1056,ncbigene:1129,ncbigene:1294," +
      "ncbigene:1356,ncbigene:1374,ncbigene:1401,ncbigene:1512,ncbigene:1535,ncbigene:1544,ncbigene:1588," +
      "ncbigene:1649,ncbigene:1889,ncbigene:1906,ncbigene:1909,ncbigene:1910,ncbigene:1956,ncbigene:2623," +
      "ncbigene:2641,ncbigene:2642,ncbigene:2645,ncbigene:2646,ncbigene:2784,ncbigene:2820,ncbigene:2876," +
      "ncbigene:2888,ncbigene:2944,ncbigene:3039,ncbigene:3087,ncbigene:3098,ncbigene:3117,ncbigene:3119," +
      "ncbigene:3123,ncbigene:3159,ncbigene:3162,ncbigene:3172,ncbigene:3240,ncbigene:3263,ncbigene:3291," +
      "ncbigene:3375,ncbigene:3383,ncbigene:3397,ncbigene:3458,ncbigene:3479,ncbigene:3559,ncbigene:3569" +
      ",ncbigene:3586,ncbigene:3630,ncbigene:3636,ncbigene:3643,ncbigene:3651,ncbigene:3667,ncbigene:3710," +
      "ncbigene:3767,ncbigene:3784,ncbigene:3952,ncbigene:3953,ncbigene:3990,ncbigene:4000,ncbigene:4090," +
      "ncbigene:4143,ncbigene:4512,ncbigene:4513,ncbigene:4514,ncbigene:4535,ncbigene:4536,ncbigene:4538," +
      "ncbigene:4540,ncbigene:4541,ncbigene:4544,ncbigene:4556,ncbigene:4558,ncbigene:4564,ncbigene:4566," +
      "ncbigene:4567,ncbigene:4572,ncbigene:4574,ncbigene:4575,ncbigene:4578,ncbigene:4760,ncbigene:4790," +
      "ncbigene:4825,ncbigene:4842,ncbigene:4843,ncbigene:4846,ncbigene:4853,ncbigene:4854,ncbigene:4938," +
      "ncbigene:4968,ncbigene:5066,ncbigene:5078,ncbigene:5080,ncbigene:5116,ncbigene:5126,ncbigene:5167," +
      "ncbigene:5184,ncbigene:5465,ncbigene:5468,ncbigene:5506,ncbigene:5579,ncbigene:5588,ncbigene:5611," +
      "ncbigene:5629,ncbigene:5663,ncbigene:5664,ncbigene:5770,ncbigene:5891,ncbigene:5970,ncbigene:6277," +
      "ncbigene:6364,ncbigene:6424,ncbigene:6462,ncbigene:6480,ncbigene:6513,ncbigene:6514,ncbigene:6517," +
      "ncbigene:6556,ncbigene:6616,ncbigene:6647,ncbigene:6648,ncbigene:6772,ncbigene:6774,ncbigene:6833," +
      "ncbigene:6927,ncbigene:6928,ncbigene:6934,ncbigene:7040,ncbigene:7076,ncbigene:7124,ncbigene:7132," +
      "ncbigene:7133,ncbigene:7325,ncbigene:7351,ncbigene:7373,ncbigene:7422,ncbigene:7438,ncbigene:7466," +
      "ncbigene:7486,ncbigene:7840,ncbigene:8081,ncbigene:8462,ncbigene:8660,ncbigene:9131,ncbigene:9370," +
      "ncbigene:9451,ncbigene:9479,ncbigene:9559,ncbigene:9861,ncbigene:9927,ncbigene:10019,ncbigene:10239," +
      "ncbigene:10296,ncbigene:10363,ncbigene:10644,ncbigene:10891,ncbigene:11132,ncbigene:11155,ncbigene:23274," +
      "ncbigene:23411,ncbigene:23600,ncbigene:25894,ncbigene:26060,ncbigene:26191,ncbigene:26291,ncbigene:29949," +
      "ncbigene:50604,ncbigene:50943,ncbigene:50982,ncbigene:51218,ncbigene:54901,ncbigene:54977,ncbigene:55315," +
      "ncbigene:55600,ncbigene:56729,ncbigene:56999,ncbigene:60468,ncbigene:60685,ncbigene:63892,ncbigene:79068," +
      "ncbigene:79719,ncbigene:83795,ncbigene:114904,ncbigene:145741,ncbigene:146227,ncbigene:169026," +
      "ncbigene:169792,ncbigene:221895,ncbigene:246289,ncbigene:246778,ncbigene:388125,ncbigene:100188782," +
      "ncbigene:100271924,ncbigene:100380873,ncbigene:100506742"

  val baseUrl: String = "http://ec2-34-227-29-65.compute-1.amazonaws.com/perl/pathDIP.cgi?genes="

  def buildUrl(geneIds: Seq[PrefixedId]): String = baseUrl + geneIds.mkString(",")

  case class ResponsePerPathway(genes: Seq[String], name: String)

  type Response = Seq[ResponsePerPathway]

}
