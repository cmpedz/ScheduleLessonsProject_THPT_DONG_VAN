import java.util.ArrayList;
import java.util.TreeMap;

public class ArrangeLessonConditionsContainer implements IArrangeLessonConditionsContainer{
	
	public static final int MAX_TYPE_CONDITIONS = 2;
	
	public static final int CONDITION_WITHOUT_INDEX = 0;
	
	public static final int CONDITION_WITH_INDEX = 1;
	
	public static final int NOT_FOUND_LESSON = -1;
	
	private ArrayList<ArrayList<ArrangeLessonCondition>> conditionTypes
							= new ArrayList<ArrayList<ArrangeLessonCondition>>();
	
	public ArrangeLessonConditionsContainer() {
		
		for(int i = 0; i < MAX_TYPE_CONDITIONS; i++) {
			
			ArrayList<ArrangeLessonCondition> conditionsEachType = 
					new ArrayList<ArrangeLessonCondition>();
			
			conditionTypes.add(conditionsEachType);
		}
		
	}
	

	public ArrayList<ArrayList<ArrangeLessonCondition>> getConditionTypes() {
		return conditionTypes;
	}

	public ArrayList<ArrangeLessonCondition> getSpecifiedConditions(int conditionType) {
		
		return conditionTypes.get(conditionType);
		
	}

	@Override
	public void addNewCondition(ArrangeLessonCondition condition) {
		// TODO Auto-generated method stub
		
		conditionTypes.get(condition.getConditionType()).add(condition);
		
	}

	@Override
	public void constructDataForCondition(String className) {
		// TODO Auto-generated method stub
		ArrayList<ArrangeLessonCondition> conditionsWithoutIndex =
				conditionTypes.get(CONDITION_WITHOUT_INDEX);
		
		for(ArrangeLessonCondition condition : conditionsWithoutIndex) {
			
			ArrangeLessonConditionWithoutIndex conditionWithoutIndex = (ArrangeLessonConditionWithoutIndex) condition;
			
			conditionWithoutIndex.constructDataForEachClass(className);
			
		}
		
		
	}

	@Override
	public void updateDataForCondition() {
		// TODO Auto-generated method stub
		
		ArrayList<ArrangeLessonCondition> conditionsWithoutIndex =
				conditionTypes.get(CONDITION_WITHOUT_INDEX);
		
		for(ArrangeLessonCondition condition : conditionsWithoutIndex) {
			
			ArrangeLessonConditionWithoutIndex conditionWithoutIndex = (ArrangeLessonConditionWithoutIndex) condition;
			
			conditionWithoutIndex.changeDataAfterAddingNewLesson();
			
		}
		
	}

	
	public int checkSatisfiedConditionsWithIndex(Teacher teacher, SchoolClass _class) {
		
		
		int count = 0;
		
		int indexLesson = 0;
		
		boolean canAddLesson = false;
		
		boolean isInMorning = _class.getSpeciality().isInMorning();
		
		int maxLessonHas = 0;
		
		if(isInMorning) {	
			maxLessonHas = SchoolInformations.MAX_LESSONS_IN_MORNING;
		} else {
			
			maxLessonHas = SchoolInformations.MAX_LESSONS_IN_AFTERNOON;
		}
		
		
		if(!isInMorning) {
			indexLesson += SchoolInformations.MAX_LESSONS_IN_MORNING;
		}
		
		do {
			
			ArrayList<ArrangeLessonCondition> conditionsWithIndex = 
					conditionTypes.get(CONDITION_WITH_INDEX);
			
			for(ArrangeLessonCondition condition : conditionsWithIndex) {
				
				ArrangeLessonConditionWithIndex conditionWithIndex = (ArrangeLessonConditionWithIndex)condition;
				
				conditionWithIndex.set_class(_class);
				
				conditionWithIndex.setTeacher(teacher);
				
				canAddLesson = conditionWithIndex.checkConditionWithIndexLesson(indexLesson);
				
				if(!canAddLesson) {
					break;
				}
				
			}
			
			count++;
			
			indexLesson++;
			
		} while (!canAddLesson && count < maxLessonHas);
		
		if(canAddLesson) {
		   return indexLesson - 1;
		}
		
		return NOT_FOUND_LESSON;
		
		
	}
	
	public boolean checkSatisfiedConditionsWithoutIndex(Teacher teacher, SchoolClass _class) {
		
		ArrayList<ArrangeLessonCondition> conditionsWithoutIndex =
				conditionTypes.get(CONDITION_WITHOUT_INDEX);
		
		for(ArrangeLessonCondition condition : conditionsWithoutIndex) {
			
			ArrangeLessonConditionWithoutIndex conditionWithoutIndex = (ArrangeLessonConditionWithoutIndex) condition;
			
			conditionWithoutIndex.set_class(_class);
			
			conditionWithoutIndex.setTeacher(teacher);
			
			if(!conditionWithoutIndex.checkIsMeetingCondition()) {
				return false;
			}
			
		}
		
		return true;
		
	}
}
