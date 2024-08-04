
import java.util.ArrayList;
import java.util.TreeMap;

public class ArrangeLessonSystem { 
	
	private TreeMap<String, String[]> scheduleTable;
	
	private ISchoolInformations iSchoolInformations = SchoolInformations.getInstance();
	
	public static final int INDEX_EMPTY_LESSON_AND_TEACHER_IS_FREE = 0;
	
	public static final int INDEX_MAIN_COURSE_CONDITION = 1;
	
	public static final int INDEX_DiSTRIBUTION_GROUPS_CONDITION = 2;
	
	public static final int MAX_CONDITIONS = 3;
	
	private IArrangeLessonConditionsContainer conditionsContainer;
	
	public ArrangeLessonSystem(TreeMap<String, String[]> ScheduleTable) {
		
		this.scheduleTable = ScheduleTable;
		
		conditionsContainer = new ArrangeLessonConditionsContainer();
		
		addingConditionsForArrangeSystem();
		
		for(String className : iSchoolInformations.getClassesNameList()) {
			
			
			conditionsContainer.constructDataForCondition(className);
		
		}
	}
	
	
	
	private void addingConditionsForArrangeSystem() {
		// TODO Auto-generated method stub
		conditionsContainer.addNewCondition(new CheckIsHavingMainCourseCondition());
		
		conditionsContainer.addNewCondition(new IsClassHavingEmptyLessonCondition());
		
		conditionsContainer.addNewCondition(new DistributingGroupsEqually());
		
		conditionsContainer.addNewCondition(new IsClassHavingEmptyLessonCondition());
		
		conditionsContainer.addNewCondition(new IsTeacherFreeCondition(this.scheduleTable));
		
			
	}
	
	

	public void addLesson(SchoolClass _class, Teacher teacher) {
		
		boolean canAddClass = conditionsContainer.checkSatisfiedConditionsWithoutIndex(teacher, _class);
		
		int indexNeedAdd = conditionsContainer.checkSatisfiedConditionsWithIndex(teacher, _class);
		
		
		if(canAddClass && indexNeedAdd != ArrangeLessonConditionsContainer.NOT_FOUND_LESSON) {
			
			String className = _class.getName();
			
			Speciality speciality =  _class.getSpeciality();
			
			scheduleTable.get(className)[indexNeedAdd] = 
					FormatDisplayAndExchangeData.getLessonDisplayFormat(teacher.getNAME(), speciality.getName());
			
			_class.setRemainingLessonPerWeek(_class.getRemainingLessonPerWeek() - 1);
			
			conditionsContainer.updateDataForCondition();
			
		}
			
	}
	
}
