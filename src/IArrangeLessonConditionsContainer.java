
public interface IArrangeLessonConditionsContainer {
	
	public void addNewCondition(ArrangeLessonCondition condition);
	
	public void constructDataForCondition(String className);
	
	public void updateDataForCondition();
	
	public int checkSatisfiedConditionsWithIndex(Teacher teacher, SchoolClass _class);
	
	public boolean checkSatisfiedConditionsWithoutIndex(Teacher teacher, SchoolClass _class);
	
	public void resetData();

}
