import java.util.ArrayList;
import java.util.TreeMap;

public class ArrangeLessonSystem { 
	
	public static final int XÃ_HỘI = 0;
	
	public static final int TỰ_NHIÊN = 1;	
	
	private TreeMap<String, Pairs<Group, Integer>[]> quantitiesEachGroup = new TreeMap<String, Pairs<Group,Integer>[]>();
	
	private TreeMap<String, String[]> scheduleTable;
	
	private ISchoolInformations iSchoolInformations = SchoolInformations.getInstance();
	
	public static final int INDEX_EMPTY_LESSON_AND_TEACHER_IS_FREE = 0;
	
	public static final int INDEX_MAIN_COURSE_CONDITION = 1;
	
	public static final int MAX_CONDITIONS = 2;
	
	private ArrangeLessonCondition[] conditions;
	
	public ArrangeLessonSystem(TreeMap<String, String[]> ScheduleTable) {
		
		this.scheduleTable = ScheduleTable;
		
		conditions = new ArrangeLessonCondition[MAX_CONDITIONS];
		
		addingConditionsForArrangeSystem();
		
		for(String className : iSchoolInformations.getClassesNameList()) {
			
			for(ArrangeLessonCondition condition : conditions) {
				condition.constructDataForEachClass(className);
			}
		
			quantitiesEachGroup.put(className, new Pairs[2]);
			
			quantitiesEachGroup.get(className)[XÃ_HỘI] = new Pairs<Group, Integer>(Group.TỔ_XÃ_HỘI, 0);
			
			quantitiesEachGroup.get(className)[TỰ_NHIÊN] = new Pairs<Group, Integer>(Group.TỔ_TỰ_NHIÊN, 0);
		}
	}
	
	
	
	private void addingConditionsForArrangeSystem() {
		// TODO Auto-generated method stub
		conditions[INDEX_MAIN_COURSE_CONDITION] = new CheckCanBeAddingdIfClassIsHavingMainCourseCondition();
		
		conditions[INDEX_EMPTY_LESSON_AND_TEACHER_IS_FREE] = new TeacherIsFreeAndClassIsHavingEmptyLessonCondition(scheduleTable);
			
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
			
			increaseCurrentQuantitieLessons(isInMorning, className);
			
			saveMainCourseName(className, speciality);
			
		}
		
		
		
	}
	
	private void increaseCurrentQuantitieLessons(boolean isInMorning, String className) {
		
		TeacherIsFreeAndClassIsHavingEmptyLessonCondition condition1 = (TeacherIsFreeAndClassIsHavingEmptyLessonCondition)conditions[INDEX_EMPTY_LESSON_AND_TEACHER_IS_FREE];
		
		Integer[] currentLessonQuantities = condition1.getCheckAvailableEmptyLesson().get(className);
		
		
		//increase current quantities lesson
		if(isInMorning) {
			currentLessonQuantities[TeacherIsFreeAndClassIsHavingEmptyLessonCondition.CURRENT_LESSONS_HAS_IN_THE_MORNING]++;
		} else {
			currentLessonQuantities[TeacherIsFreeAndClassIsHavingEmptyLessonCondition.CURRENT_LESSONS_HAS_IN_THE_AFTERNOON]++;
		}
	}
	
	private void saveMainCourseName(String className, Speciality speciality) {
		
		CheckCanBeAddingdIfClassIsHavingMainCourseCondition condition0 = (CheckCanBeAddingdIfClassIsHavingMainCourseCondition)conditions[INDEX_MAIN_COURSE_CONDITION];
		
		TreeMap<String, Pairs<String, Boolean>> isHavingMainCourse = condition0.getIsHavingMainCourse();
		
		
		if(!isHavingMainCourse.get(className).getValue2()) {
			
			isHavingMainCourse.get(className).setValue1( speciality.getName());
			
			isHavingMainCourse.get(className).setValue2( speciality.isIS_MAIN_COURSE());
		}
	}
	
}
