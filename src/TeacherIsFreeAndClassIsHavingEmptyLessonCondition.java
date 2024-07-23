import java.util.TreeMap;

public class TeacherIsFreeAndClassIsHavingEmptyLessonCondition extends ArrangeLessonCondition {

	public static final int CURRENT_LESSONS_HAS_IN_THE_MORNING = 0;
	
	public static final int CURRENT_LESSONS_HAS_IN_THE_AFTERNOON = 1;
	
	private final TreeMap<String, Integer[]> checkAvailableEmptyLesson = new TreeMap<String, Integer[]>();
	
	private ISchoolInformations iSchoolInformations = SchoolInformations.getInstance();
	
	private TreeMap<String, String[]> scheduleTable;
	
	private int indexLessonNeedingAdding = -1;
	
	public TeacherIsFreeAndClassIsHavingEmptyLessonCondition(TreeMap<String, String[]> scheduleTable) {

			this.scheduleTable = scheduleTable;

	}
	
	@Override
	public boolean checkIsMeetingCondition() {
		// TODO Auto-generated method stub
		
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
		
		
		boolean isHavingEmptyLesson = quantitiesLessonsCurrentlyHas < maxLessonHas;
		
		boolean canAddLesson = false;

		indexLessonNeedingAdding = -1;
		
		if(isHavingEmptyLesson) {
			
			int count = 0;
			
			int indexLesson = 0;
			
			if(!isInMorning) {
				indexLesson += SchoolInformations.MAX_LESSONS_IN_MORNING;
			}
			
			do {
				
				canAddLesson = scheduleTable.get(_class.getName())[indexLesson].equals("no one") &&
						checkIsTeacherTeachingAnotherClass(indexLesson, teacherName, _class.getSpeciality().getName());
				
				
				count++;
				indexLesson++;
				
			} while (!canAddLesson && count < maxLessonHas);
			
			if(canAddLesson) {
			   this.indexLessonNeedingAdding = indexLesson - 1;
			}
			
			
			
		}
		
		
		return canAddLesson;
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

	public int getIndexLessonNeedingAdding() {
		return this.indexLessonNeedingAdding;
	}
	
	public TreeMap<String, Integer[]> getCheckAvailableEmptyLesson() {
		return checkAvailableEmptyLesson;
	}

	@Override
	public void constructDataForEachClass(String className) {
		// TODO Auto-generated method stub
		checkAvailableEmptyLesson.put(className, new Integer[2]);
		
		checkAvailableEmptyLesson.get(className)[CURRENT_LESSONS_HAS_IN_THE_MORNING] = 0;
	
		checkAvailableEmptyLesson.get(className)[CURRENT_LESSONS_HAS_IN_THE_AFTERNOON] = 0;
	}	
	


	@Override
	public void changeDataAfterAddingNewLesson() {
		// increase current quantities lesson
		String className = _class.getName();
		
		boolean isInMorning = _class.getSpeciality().isInMorning();
		
		Integer[] currentLessonQuantities = getCheckAvailableEmptyLesson().get(className);
		
		if(isInMorning) {
			currentLessonQuantities[TeacherIsFreeAndClassIsHavingEmptyLessonCondition.CURRENT_LESSONS_HAS_IN_THE_MORNING]++;
		} else {
			currentLessonQuantities[TeacherIsFreeAndClassIsHavingEmptyLessonCondition.CURRENT_LESSONS_HAS_IN_THE_AFTERNOON]++;
		}
		
	}


}
