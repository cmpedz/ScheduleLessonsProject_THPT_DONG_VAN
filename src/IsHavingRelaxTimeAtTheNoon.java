import java.util.TreeMap;

public class IsHavingRelaxTimeAtTheNoon extends ArrangeLessonConditionWithIndex{

	public IsHavingRelaxTimeAtTheNoon(TreeMap<String, String[]> scheduleTable) {
		super(scheduleTable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkConditionWithIndexLesson(int indexLesson) {
		// TODO Auto-generated method stub
		int firstLessonInTheAfternoonIndex = SchoolInformations.MAX_LESSONS_IN_MORNING;
		
		boolean isInMorning = _class.getCourse().isInMorning();
		
		boolean isFirstLessonInTheAfternoon = indexLesson == firstLessonInTheAfternoonIndex;
		
		if(isInMorning || !isFirstLessonInTheAfternoon) return true;
		
		String teacherName = teacher.getNAME();
		
		for(String className : SchoolInformations.getInstance().getClassesNameList()) {
			
			int lastLessonInTheMorningIndex = 4;
			
			String lastLessonInTheMorning = scheduleTable.get(className)[lastLessonInTheMorningIndex];
		
			
			String teacherWhoTaughtLastLesson = FormatDisplayAndExchangeData.separateTeacherNameFromALessonDisplayFormat(lastLessonInTheMorning);
			
			boolean didTeacherTeachLastLessonInTheMorning = teacherName.equals(teacherWhoTaughtLastLesson);
			
			if(didTeacherTeachLastLessonInTheMorning) return false;
		}
		
		
		return true;
	}

}
