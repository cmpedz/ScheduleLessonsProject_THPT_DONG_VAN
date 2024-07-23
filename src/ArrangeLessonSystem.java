import java.util.ArrayList;
import java.util.TreeMap;

public class ArrangeLessonSystem { 
	
	private TreeMap<String, String[]> scheduleTable;
	
	private ISchoolInformations iSchoolInformations = SchoolInformations.getInstance();
	
	public static final int INDEX_EMPTY_LESSON_AND_TEACHER_IS_FREE = 0;
	
	public static final int INDEX_MAIN_COURSE_CONDITION = 1;
	
	public static final int INDEX_DiSTRIBUTION_GROUPS_CONDITION = 2;
	
	public static final int MAX_CONDITIONS = 3;
	
	private ArrangeLessonCondition[] conditions;
	
	public ArrangeLessonSystem(TreeMap<String, String[]> ScheduleTable) {
		
		this.scheduleTable = ScheduleTable;
		
		conditions = new ArrangeLessonCondition[MAX_CONDITIONS];
		
		addingConditionsForArrangeSystem();
		
		for(String className : iSchoolInformations.getClassesNameList()) {
			
			for(ArrangeLessonCondition condition : conditions) {
				condition.constructDataForEachClass(className);
			}
		
		}
	}
	
	
	
	private void addingConditionsForArrangeSystem() {
		// TODO Auto-generated method stub
		conditions[INDEX_MAIN_COURSE_CONDITION] = new CheckCanBeAddingdIfClassIsHavingMainCourseCondition();
		
		conditions[INDEX_EMPTY_LESSON_AND_TEACHER_IS_FREE] = new TeacherIsFreeAndClassIsHavingEmptyLessonCondition(scheduleTable);
		
		conditions[INDEX_DiSTRIBUTION_GROUPS_CONDITION] = new DistributingGroupsEqually();
			
	}



	public void addLesson(SchoolClass _class, Teacher teacher) {
		
		boolean canAddClass = true;
		
		boolean isInMorning = _class.getSpeciality().isInMorning();
		
		for(ArrangeLessonCondition conditions : conditions) {
			
			conditions.set_class(_class);
			
			conditions.setTeacher(teacher);
			
			if(!conditions.checkIsMeetingCondition()) {
				canAddClass = false;
				break;
			}
			
			
		}
		
		TeacherIsFreeAndClassIsHavingEmptyLessonCondition basicCondition = 
				(TeacherIsFreeAndClassIsHavingEmptyLessonCondition)conditions[INDEX_EMPTY_LESSON_AND_TEACHER_IS_FREE];
		
		int indexNeedAdd = -1;
		
		if(basicCondition != null) {
			indexNeedAdd = basicCondition.getIndexLessonNeedingAdding();
		}
	
		if(canAddClass) {
			
			String className = _class.getName();
			
			Speciality speciality = _class.getSpeciality();
			
			scheduleTable.get(className)[indexNeedAdd] = 
					FormatDisplayAndExchangeData.getLessonDisplayFormat(teacher.getName(), speciality.getName());
			
			_class.setRemainingLessonPerWeek(_class.getRemainingLessonPerWeek() - 1);
			
			for(ArrangeLessonCondition condition : conditions) {
				condition.changeDataAfterAddingNewLesson();
			}
			
		}
			
	}
	
}
