import java.util.TreeMap;

public class DistributionQuantitiesLessonsEqually extends ArrangeLessonConditionWithoutIndex{
	
	private TreeMap<String, Integer> lessonsTaughtEachDay = new TreeMap<String, Integer>();
	

	@Override
	public boolean checkIsMeetingCondition() {
		// TODO Auto-generated method stub
		
		String teacherName = teacher.getNAME();
		
		constructMemoryIfNull(teacherName);
		
		int lessonsTaughtQuantities = lessonsTaughtEachDay.get(teacherName);
		
		boolean isOverAverageLessonsTaughtPerDay = lessonsTaughtQuantities >= teacher.getAverageLessonsTeachEachDay();
		
		
		return !isOverAverageLessonsTaughtPerDay;
	}
	
	private void constructMemoryIfNull(String teacherName) {
		
		if(lessonsTaughtEachDay.get(teacherName) == null) {
			
			lessonsTaughtEachDay.put(teacherName, 0);
		}
	}

	@Override
	public void constructDataForEachClass(String teacherName) {
		// TODO Auto-generated method stub
	}

	@Override
	public void changeDataAfterAddingNewLesson() {
		// TODO Auto-generated method stub
		String teacherName = teacher.getNAME();
		
		constructMemoryIfNull(teacherName);
		
		int lessonsTaughtEachDayAfterIncreased = lessonsTaughtEachDay.get(teacherName) + 1;
		
		lessonsTaughtEachDay.put(teacherName, lessonsTaughtEachDayAfterIncreased);
		
	}

}
