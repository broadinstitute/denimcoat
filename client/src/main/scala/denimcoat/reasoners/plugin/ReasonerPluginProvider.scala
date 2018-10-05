package denimcoat.reasoners.plugin

import denimcoat.svg.mvp.ReasonerList

object ReasonerPluginProvider {

  def getReasonerPlugin(reasonerId: String): ReasonerPlugin = {
    reasonerId match {
      case ReasonerList.biothings.id => BioThingsExplorerPlugin
      case ReasonerList.monarch.id => MonarchInitiativePlugin
      case ReasonerList.drugChecker.id => DrugCheckerPlugin
      case ReasonerList.pathwayEnrichment.id => PathwayEnrichmentPlugin
      case _ => DefaultReasonerPlugin(reasonerId)
    }
  }

}
