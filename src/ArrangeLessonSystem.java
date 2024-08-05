
import java.util.ArrayList;
import java.util.TreeMap;

public class ArrangeLessonSystem { 
	
	private TreeMap<String, String[]> scheduleTable;
	
	private ISchoolInformations iSchoolInformations = SchoolInformations.getInstance();
	
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
		conditionsContainer.addNewCondition(new CheckIsHavingMainCourse());
		
		conditionsContainer.addNewCondition(new IsClassHavingEmptyLesson());
		
		conditionsContainer.addNewCondition(new DistributingGroupsEqually());
		
		conditionsContainer.addNewCondition(new IsClassHavingEmptyLesson());
		
		conditionsContainer.addNewCondition(new IsTeacherFree(this.scheduleTable));
		
		conditionsContainer.addNewCondition(new CheckingIsExpectedLesson(scheduleTable));
		
		conditionsContainer.addNewCondition(new IsHavingRelaxTimeAtTheNoon(scheduleTable));
		
			
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
