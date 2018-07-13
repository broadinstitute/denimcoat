package denimcoat.mvp

object Workflow {

  case class Step(id: String, label: String) {
    def nextOpt: Option[Step] = Workflow.getNextStep(this)
    def next: Step = nextOpt.get
    def previousOpt: Option[Step] = Workflow.getPreviousStep(this)
    def previous: Step = previousOpt.get
  }

  object Step {
    val complexDisease = Step("complexDisease", "complex disease")
    val symptom = Step("symptom", "symptom")
    val rareDisease = Step("rareDisease", "rare disease")
  }

  val steps: Seq[Step] = Seq(Step.complexDisease, Step.symptom, Step.rareDisease)
  val firstStep: Step = steps.head
  val stepsById: Map[String, Step] = steps.map(step => (step.id, step)).toMap
  val stepsByLabel: Map[String, Step] = steps.map(step => (step.id, step)).toMap
  val nextByStep: Map[Step, Step] = steps.dropRight(1).zip(steps.drop(1)).toMap
  val previousByStep: Map[Step, Step] = steps.drop(1).zip(steps.dropRight(1)).toMap

  def getStep(string: String): Option[Step] = stepsById.get(string).orElse(stepsByLabel.get(string))
  def getNextStep(step: Step): Option[Step] = nextByStep.get(step)
  def getPreviousStep(step: Step): Option[Step] = previousByStep.get(step)
}
