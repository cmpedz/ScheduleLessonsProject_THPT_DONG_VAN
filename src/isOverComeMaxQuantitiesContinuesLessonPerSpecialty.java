import java.util.TreeMap;

public class isOverComeMaxQuantitiesContinuesLessonPerSpecialty extends ArrangeLessonConditionWithIndex{

	public isOverComeMaxQuantitiesContinuesLessonPerSpecialty(TreeMap<String, String[]> scheduleTable) {
		super(scheduleTable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkConditionWithIndexLesson(int indexLesson) {
		
		String specialtyNeedAdding = _class.getCourse().getName();
		
		int maxContinuesSameLessons =  _class.getCourse().getMaxContinuesLessonCanTeach();
		
		String className = _class.getName();
		
		String[] lessonsClassHas = scheduleTable.get(className);
		
		int quantitiesLessonsSameSpecialtyNeedAdding = 1;
		
		for(String lesson : lessonsClassHas) {
			
			if(lesson.equals(ScheduleEachDay.DEFINE_EMPTY_VALUE)) continue;
			
			String currentSpecialty = FormatDisplayAndExchangeData.separateSpecialtyFromALessonDisplayFormat(lesson);
			
			if(currentSpecialty.equals(specialtyNeedAdding)) {
				quantitiesLessonsSameSpecialtyNeedAdding ++;
			}
		}
		
		if( quantitiesLessonsSameSpecialtyNeedAdding > maxContinuesSameLessons) {
			return false;
		}
		
		return true;
	}
	
}
