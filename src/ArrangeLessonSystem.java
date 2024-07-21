import java.util.TreeMap;

public class ArrangeLessonSystem {
	
	public static final int CURRENT_LESSONS_HAS_IN_THE_MORNING = 0;
	
	public static final int CURRENT_LESSONS_HAS_IN_THE_AFTERNOON = 1;
	
	private TreeMap<String, Integer[]> checkAvailableEmptyLesson = new TreeMap<String, Integer[]>();
	
	private TreeMap<String, Pairs<String, Boolean>> isHavingMainCourse = new TreeMap<String, Pairs<String, Boolean>>();
	
	private TreeMap<String, String[]> scheduleTable;
	
	private ISchoolInformations iSchoolInformations = SchoolInformations.getInstance();
	
	public ArrangeLessonSystem(TreeMap<String, String[]> ScheduleTable) {
		
		for(String className : iSchoolInformations.getClassesNameList()) {
		
			
			checkAvailableEmptyLesson.put(className, new Integer[2]);
		
			checkAvailableEmptyLesson.get(className)[CURRENT_LESSONS_HAS_IN_THE_MORNING] = 0;
		
			checkAvailableEmptyLesson.get(className)[CURRENT_LESSONS_HAS_IN_THE_AFTERNOON] = 0;
			
			this.scheduleTable = ScheduleTable;
			
			isHavingMainCourse.put(className, new Pairs("",false));
		}
	}
	
	private int checkCapabilityOfAddClass(int quantitiesLessonsCurrentlyHas, int maxLessonHas, SchoolClass _class
			, String teacherName, boolean isMorning) {
		
		
		boolean isHavingEmptyLesson = quantitiesLessonsCurrentlyHas < maxLessonHas;
		
		if(isHavingEmptyLesson) {
			
			int count = 0;
			
			int indexLesson = 0;
			
			if(!isMorning) {
				indexLesson += SchoolInformations.MAX_LESSONS_IN_MORNING;
			}
			
			boolean canAddLesson = false;
	
			
			do {
				
				canAddLesson = scheduleTable.get(_class.getName())[indexLesson].equals("no one") &&
						checkIsTeacherTeachingAnotherClass(indexLesson, teacherName, _class.getSpeciality().getName())
						&& checkCanAddIfLessonIsMainCourse(_class);
				
				
				count++;
				indexLesson++;
				
			} while (!canAddLesson && count < maxLessonHas);
			
			if(canAddLesson) {
			   return indexLesson - 1;
			}
			
			return -1;
			
		}
		
		
		return -1;
		
		
	}
	
	public boolean checkCanAddIfLessonIsMainCourse(SchoolClass _class) {
		
		Pairs<String, Boolean> currentClassInfors = isHavingMainCourse.get(_class.getName());
		
		boolean isCurrentClassHavingMainCourse = currentClassInfors.getValue2();
		
		System.out.println("check main course needs adding : " + _class.getSpeciality().getName() + ", current main course we Have :" + currentClassInfors.getValue1());
		
		boolean isCourseAddedDistinctFromCurrentMainCourse = !_class.getSpeciality().getName().equals(currentClassInfors.getValue1());
		
		if(isCurrentClassHavingMainCourse && _class.getSpeciality().isIS_MAIN_COURSE() &&
				isCourseAddedDistinctFromCurrentMainCourse) {
			return false;
		}
		
		return true;
	}
	
	public boolean checkIsTeacherTeachingAnotherClass(int indexLessonNeedAdding, String teacherName, String specialityName) {
		
		if(indexLessonNeedAdding >= SchoolInformations.MAX_LESSONS_IN_MORNING + SchoolInformations.MAX_LESSONS_IN_AFTERNOON) {
			return false;
		}
		
		for(String className : iSchoolInformations.getClassesNameList()) {
			
			boolean isThisTeacherTeachingAnotherClass = 
					scheduleTable.get(className)[indexLessonNeedAdding]
							.equals(FormatDisplayAndExchangeData.getLessonDisplayFormat(teacherName, specialityName));
			
			if(isThisTeacherTeachingAnotherClass) {
				return false;
			}
			
		}
		
		return true;
	}

	
	
	public void addLesson(SchoolClass _class, Teacher teacher) {
		
		int quantitiesLessonsCurrentlyHas = 0;
		
		boolean isInMorning = _class.getSpeciality().isInMorning();
		
		int maxLessonHas = 0;
		
		String teacherName = teacher.getName();
		
		if(isInMorning) {
			
			quantitiesLessonsCurrentlyHas = 
					checkAvailableEmptyLesson.get(_class.getName())[CURRENT_LESSONS_HAS_IN_THE_MORNING];
			
			
			maxLessonHas = SchoolInformations.MAX_LESSONS_IN_MORNING;
			
			
		} else {
			
			
			quantitiesLessonsCurrentlyHas = 
					checkAvailableEmptyLesson.get(_class.getName())[CURRENT_LESSONS_HAS_IN_THE_AFTERNOON];
			
			maxLessonHas = SchoolInformations.MAX_LESSONS_IN_AFTERNOON;
		}
		
		
		int indexNeedAdd = checkCapabilityOfAddClass(quantitiesLessonsCurrentlyHas, maxLessonHas, 
				_class, teacherName, isInMorning);
	
		if(indexNeedAdd != -1) {
			
			String className = _class.getName();
			
			Speciality speciality = _class.getSpeciality();
			
			scheduleTable.get(className)[indexNeedAdd] = 
					FormatDisplayAndExchangeData.getLessonDisplayFormat(teacherName, speciality.getName());
			
			_class.setRemainingLessonPerWeek(_class.getRemainingLessonPerWeek() - 1);
			
			if(isInMorning) {
				checkAvailableEmptyLesson.get(className)[CURRENT_LESSONS_HAS_IN_THE_MORNING]++;
			} else {
				checkAvailableEmptyLesson.get(className)[CURRENT_LESSONS_HAS_IN_THE_AFTERNOON]++;
			}
			
			if(!isHavingMainCourse.get(className).getValue2()) {
				
				isHavingMainCourse.get(className).setValue1( speciality.getName());
				
				isHavingMainCourse.get(className).setValue2( speciality.isIS_MAIN_COURSE());
			}
			
			
		}
		
		
		
	}
	
}
