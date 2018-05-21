package denimcoat.reasoners.mock

import denimcoat.reasoners.mock.EntityCatalogue.{Disease, Drug, Entry, Target}

object QuestionParser {

  def cleanup(question: String): String = question.trim.toLowerCase.replaceAll("\\s+", " ")

  def parse(question: String): Set[EntityCatalogue.Entry] = {
    val cleanedQuestion = cleanup(question)
    EntityCatalogue.entries
      .filter(entry => cleanedQuestion.contains(entry.name) || cleanedQuestion.contains(entry.cui))
  }

  def findEntitiesAs[E <: Entry](question: String, entries: Set[E]): Set[E] = {
    val cleanedQuestion = cleanup(question)
    entries.filter(entry => cleanedQuestion.contains(entry.name) || cleanedQuestion.contains(entry.cui))
  }

  def findEntities(question: String, entries: Set[Entry] = EntityCatalogue.entries): Set[Entry] =
    findEntitiesAs[Entry](question, entries)

  def findDrugs(question: String, drugs: Set[Drug] = EntityCatalogue.drugs): Set[Drug] =
    findEntitiesAs[Drug](question, drugs)

  def findTargets(question: String, targets: Set[Target] = EntityCatalogue.targets): Set[Target] =
    findEntitiesAs[Target](question, targets)

  def findDiseases(question: String, diseases: Set[Disease] = EntityCatalogue.diseases): Set[Disease] =
    findEntitiesAs[Disease](question, diseases)


}
