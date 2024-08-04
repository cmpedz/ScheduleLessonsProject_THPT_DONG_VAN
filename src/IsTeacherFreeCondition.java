import java.util.Map;
import java.util.TreeMap;

public class IsTeacherFreeCondition extends ArrangeLessonConditionWithIndex {


	public IsTeacherFreeCondition(TreeMap<String, String[]>scheduleTable) {
		super(scheduleTable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkConditionWithIndexLesson(int indexLesson) {
		// TODO Auto-generated method stub
		
		int indexLessonNeedAdding = indexLesson;
		
		SchoolInformations iSchoolInformations = SchoolInformations.getInstance();
		
		if(indexLessonNeedAdding >= SchoolInformations.MAX_LESSONS_IN_MORNING + SchoolInformations.MAX_LESSONS_IN_AFTERNOON) {
			return false;
		}
		
		boolean isThisLessonEmptyInThisClass = 
				this.scheduleTable.get(_class.getName())[indexLessonNeedAdding]
						.equals(ScheduleEachDay.DEFINE_EMPTY_VALUE);
		
		if(!isThisLessonEmptyInThisClass) {
			return false;
		}
		
		for(String className : iSchoolInformations.getClassesNameList()) {
			
			String currentTeacherName = FormatDisplayAndExchangeData.
					separateTeacherNameFromALessonDisplayFormat(this.scheduleTable.get(className)[indexLessonNeedAdding]);
			
			String teacherNameNeedAdding = this.teacher.getNAME().trim();
			
			boolean isThisTeacherTeachingAnotherClass = currentTeacherName.equals(teacherNameNeedAdding);
			
			
			
			if(isThisTeacherTeachingAnotherClass) {
				return false;
			}
			
		}
		
		return true;
	
	}

}
