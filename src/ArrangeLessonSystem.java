
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
	
	
	public IArrangeLessonConditionsContainer getConditionsContainer() { return this.conditionsContainer; }
	
	private void addingConditionsForArrangeSystem() {
		// TODO Auto-generated method stub
		conditionsContainer.addNewCondition(new CheckIsHavingMainCourse());
		
		conditionsContainer.addNewCondition(new IsClassHavingEmptyLesson());
		
		conditionsContainer.addNewCondition(new DistributingGroupsEqually());
		
		conditionsContainer.addNewCondition(new IsClassHavingEmptyLesson());
		
		conditionsContainer.addNewCondition(new IsTeacherFree(this.scheduleTable));
		
		conditionsContainer.addNewCondition(new CheckingIsExpectedLesson(scheduleTable));
		
		conditionsContainer.addNewCondition(new IsHavingRelaxTimeAtTheNoon(scheduleTable));
		
		conditionsContainer.addNewCondition(new DistributionQuantitiesLessonsEqually());
		
		conditionsContainer.addNewCondition(new isClassHavingContinuousArrangement(scheduleTable));
		
		conditionsContainer.addNewCondition(new isOverComeMaxQuantitiesContinuesLessonPerSpecialty(scheduleTable));
		
			
	}

	public boolean addLesson(SchoolClass _class, Teacher teacher, TreeMap<String, Integer> lessonsTaughtEachTeacher) {
		
		boolean canAddClass = conditionsContainer.checkSatisfiedConditionsWithoutIndex(teacher, _class);
		
		int indexNeedAdd = conditionsContainer.checkSatisfiedConditionsWithIndex(teacher, _class);
		
		String teacherName = teacher.getNAME();
		
		
		if(canAddClass && indexNeedAdd != ArrangeLessonConditionsContainer.NOT_FOUND_LESSON) {
			
			String className = _class.getName();
			
			Speciality speciality =  _class.getSpeciality();
			
			scheduleTable.get(className)[indexNeedAdd] = 
					FormatDisplayAndExchangeData.getLessonDisplayFormat(teacher.getNAME(), speciality.getName());
			
			int quantitiesLessonsAdded = 1;
			
			teacher.decreaseSumLessonsTeach(quantitiesLessonsAdded);
			
			_class.setLeftOverLessonPerWeek(_class.getLeftOverLessonPerWeek() - 1);
			
			conditionsContainer.updateDataForCondition();
			
			int currentQuantitiesLessonsTaught = lessonsTaughtEachTeacher.get(teacherName);
			
			lessonsTaughtEachTeacher.put(teacherName, currentQuantitiesLessonsTaught + 1);
			
			return true;
			
		}
		
		return false;
			
	}
	
}
