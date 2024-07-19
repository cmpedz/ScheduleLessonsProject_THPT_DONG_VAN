import java.util.TreeMap;

public class ArrangeLessonSystem {
	
	public static final int CURRENT_LESSONS_HAS_IN_THE_MORNING = 0;
	
	public static final int CURRENT_LESSONS_HAS_IN_THE_AFTERNOON = 1;
	
	private TreeMap<String, Integer[]> checkAvailableEmptyLesson = new TreeMap<String, Integer[]>();
	
	private TreeMap<String, String[]> scheduleTable;
	
	public ArrangeLessonSystem(TreeMap<String, String[]> ScheduleTable) {
		
		for(String className : SchoolInformations.getInstance().CLASSES) {
		
			
			checkAvailableEmptyLesson.put(className, new Integer[2]);
		
			checkAvailableEmptyLesson.get(className)[CURRENT_LESSONS_HAS_IN_THE_MORNING] = 0;
		
			checkAvailableEmptyLesson.get(className)[CURRENT_LESSONS_HAS_IN_THE_AFTERNOON] = 0;
			
			this.scheduleTable = ScheduleTable;
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
						checkIsTeacherTeachingAnotherClass(indexLesson, teacherName, _class.getSpeciality().getName());
				
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
	
	public boolean checkIsTeacherTeachingAnotherClass(int indexLessonNeedAdding, String teacherName, String specialityName) {
		
		if(indexLessonNeedAdding >= SchoolInformations.MAX_LESSONS_IN_MORNING + SchoolInformations.MAX_LESSONS_IN_AFTERNOON) {
			return false;
		}
		
		for(String className : SchoolInformations.getInstance().CLASSES) {
			
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
			
			scheduleTable.get(_class.getName())[indexNeedAdd] = 
					FormatDisplayAndExchangeData.getLessonDisplayFormat(teacherName, _class.getSpeciality().getName());
			
			_class.setRemainingLessonPerWeek(_class.getRemainingLessonPerWeek() - 1);
			
			if(isInMorning) {
				checkAvailableEmptyLesson.get(_class.getName())[CURRENT_LESSONS_HAS_IN_THE_MORNING]++;
			} else {
				checkAvailableEmptyLesson.get(_class.getName())[CURRENT_LESSONS_HAS_IN_THE_AFTERNOON]++;
			}
			
			
		}
		
		
		
	}
	
}
