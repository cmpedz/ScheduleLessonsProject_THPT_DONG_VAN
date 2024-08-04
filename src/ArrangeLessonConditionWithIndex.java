import java.util.TreeMap;

public abstract class ArrangeLessonConditionWithIndex extends ArrangeLessonCondition {
	
	protected TreeMap<String, String[]> scheduleTable = new TreeMap<String, String[]>();

	public abstract boolean checkConditionWithIndexLesson(int indexLesson);
	
	public ArrangeLessonConditionWithIndex(TreeMap<String, String[]> scheduleTable) {
		this.scheduleTable = scheduleTable;
	}
	
	public int getConditionType() {
		return ArrangeLessonConditionsContainer.CONDITION_WITH_INDEX;
	}
}
