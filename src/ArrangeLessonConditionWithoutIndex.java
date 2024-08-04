
public abstract class ArrangeLessonConditionWithoutIndex extends ArrangeLessonCondition{
	
	public abstract boolean checkIsMeetingCondition();
	
	public abstract void constructDataForEachClass(String className);
	
	public abstract void changeDataAfterAddingNewLesson();
	
	public int getConditionType() {
		return ArrangeLessonConditionsContainer.CONDITION_WITHOUT_INDEX;
	}
}
