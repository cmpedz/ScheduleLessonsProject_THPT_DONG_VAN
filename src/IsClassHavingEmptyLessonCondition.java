import java.util.TreeMap;

public class IsClassHavingEmptyLessonCondition extends ArrangeLessonConditionWithoutIndex{
	public static final int CURRENT_LESSONS_HAS_IN_THE_MORNING = 0;
	
	public static final int CURRENT_LESSONS_HAS_IN_THE_AFTERNOON = 1;
	
	private final TreeMap<String, Integer[]> quantitiesLessonEachClass = new TreeMap<String, Integer[]>();
	
	
	@Override
	public boolean checkIsMeetingCondition() {
		// TODO Auto-generated method stub
		
		int quantitiesCurrentLessonsHas = 0;
		
		boolean isInMorning = _class.getSpeciality().isInMorning();
		
		int maxLessonHas = 0;
		
		if(isInMorning) {
			
			quantitiesCurrentLessonsHas = 
					quantitiesLessonEachClass.get(_class.getName())[CURRENT_LESSONS_HAS_IN_THE_MORNING];
			
			maxLessonHas = SchoolInformations.MAX_LESSONS_IN_MORNING;
			
		} else {
			quantitiesCurrentLessonsHas = 
					quantitiesLessonEachClass.get(_class.getName())[CURRENT_LESSONS_HAS_IN_THE_AFTERNOON];
			
			maxLessonHas = SchoolInformations.MAX_LESSONS_IN_AFTERNOON;
				
		}
		
		
		boolean isHavingEmptyLesson = quantitiesCurrentLessonsHas < maxLessonHas;
		
		
		
		
		return isHavingEmptyLesson;
	}
	
	
	
	
	public TreeMap<String, Integer[]> getQuantitiesLessonEachClass() {
		return quantitiesLessonEachClass;
	}

	@Override
	public void constructDataForEachClass(String className) {
		// TODO Auto-generated method stub
		quantitiesLessonEachClass.put(className, new Integer[2]);
		
		quantitiesLessonEachClass.get(className)[CURRENT_LESSONS_HAS_IN_THE_MORNING] = 0;
	
		quantitiesLessonEachClass.get(className)[CURRENT_LESSONS_HAS_IN_THE_AFTERNOON] = 0;
	}	
	


	@Override
	public void changeDataAfterAddingNewLesson() {
		// increase current quantities lesson
		String className = _class.getName();
		
		boolean isInMorning = _class.getSpeciality().isInMorning();
		
		Integer[] currentLessonQuantities = this.quantitiesLessonEachClass.get(className);
		
		if(isInMorning) {
			currentLessonQuantities[IsClassHavingEmptyLessonCondition.CURRENT_LESSONS_HAS_IN_THE_MORNING]++;
		} else {
			currentLessonQuantities[IsClassHavingEmptyLessonCondition.CURRENT_LESSONS_HAS_IN_THE_AFTERNOON]++;
		}
		
	}



}
