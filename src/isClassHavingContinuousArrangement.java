import java.util.TreeMap;

public class isClassHavingContinuousArrangement extends ArrangeLessonConditionWithIndex {

	public isClassHavingContinuousArrangement(TreeMap<String, String[]> scheduleTable) {
		super(scheduleTable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkConditionWithIndexLesson(int indexLesson) {
		// TODO Auto-generated method stub
		boolean isFirstLessonInTheMorning = indexLesson == 0;
		
		boolean isFirstLessonInTheAfternoon = indexLesson == SchoolInformations.MAX_LESSONS_IN_MORNING;
		
		if(isFirstLessonInTheAfternoon || isFirstLessonInTheMorning) return true;
		
		int previousLessonIndex = indexLesson - 1;
		
		String previousLesson = this.scheduleTable.get(_class.getName())[previousLessonIndex];
		
		boolean isPreviousLessonEmpty = previousLesson.equals(ScheduleEachDay.DEFINE_EMPTY_VALUE);
		
		return !isPreviousLessonEmpty;
	}

}
