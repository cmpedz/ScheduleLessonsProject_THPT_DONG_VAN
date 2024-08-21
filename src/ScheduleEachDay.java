
import java.util.TreeMap;


public class ScheduleEachDay {
	 
	
	private final TreeMap<String, String[]> scheduleTable = new TreeMap<String, String[]>();
	
	private final TreeMap<String, Integer> currentLessonsTaughtEachTeacher = new TreeMap<String, Integer>();
	
	private final TreeMap<String, Integer[]> currentQuantitiesLessonsEachClassHas = new TreeMap<String, Integer[]>(); 
	
	private ArrangeLessonSystem arrangeLessonSystem;
	
	private ISchoolInformations iSchoolInformations = SchoolInformations.getInstance();
	
	public static final String DEFINE_EMPTY_VALUE = "";
	
	
	public ScheduleEachDay() {
		for(String className : iSchoolInformations.getClassesNameList()) {
			
			int quantitiesLessonEachDay = SchoolInformations.MAX_LESSONS_IN_MORNING 
					+ SchoolInformations.MAX_LESSONS_IN_AFTERNOON;
			
			String[] lessons = new String[quantitiesLessonEachDay];
			
			scheduleTable.put(className, lessons);
			
			for(int i = 0; i < scheduleTable.get(className).length; i++) {
				scheduleTable.get(className)[i] = DEFINE_EMPTY_VALUE;
			}
			
			currentQuantitiesLessonsEachClassHas.put(className, new Integer[SchoolInformations.MAX_STUDYING_SESSIONS]);
			
			for(int i = 0; i < SchoolInformations.MAX_STUDYING_SESSIONS; i++) {
				currentQuantitiesLessonsEachClassHas.get(className)[i] = 0;
			}
		}
		
		
		
		this.arrangeLessonSystem = new ArrangeLessonSystem(scheduleTable);
	}
	
	
	public TreeMap<String, String[]> getScheduleTable() {
		return scheduleTable;
	}
	
	public ArrangeLessonSystem getArrangeLessonSystem() {
		
		return this.arrangeLessonSystem;
		
	}
	
	public void resetData() {
		
		for(String className : currentQuantitiesLessonsEachClassHas.keySet()) {
			
			for(int i = 0; i < SchoolInformations.MAX_STUDYING_SESSIONS; i++) {
				
				currentQuantitiesLessonsEachClassHas.get(className)[i] = 0;
			}
		}
	}

	
	public void addTeacherLessonIntoScheduleTable(Teacher t, int prioritySpecialty) {
		
			if(currentLessonsTaughtEachTeacher.get(t.getNAME()) == null) {
				currentLessonsTaughtEachTeacher.put(t.getNAME(), 0);
			}
		
			for(SchoolClass _class : t.getClassesTeaching(prioritySpecialty)){
				
				String className = _class.getName();
				
				boolean isInMorning = _class.getSpeciality().isInMorning();
				
				int indexSessions = SchoolInformations.MORNING;
				
				if(isInMorning) {
					indexSessions = SchoolInformations.AFTERNOON;
				}
				
				boolean isHavingLeftOverLessons = _class.getLeftOverLessonPerWeek() > 0;
				
				int maxLessonCanHaveEachDay = QuantitiesLessonsPerClassStorage.getInstance().getMaxLessonsCanTeachEachDay(className, isInMorning);
				
				boolean isOverComeMaxLessonsCanHaveEachDay = currentQuantitiesLessonsEachClassHas.get(className)[indexSessions] > maxLessonCanHaveEachDay;
				
				for(int i = 0; i < _class.getSpeciality().getMaxContinuesLessonCanTeach() && 
						isHavingLeftOverLessons && !isOverComeMaxLessonsCanHaveEachDay ; i++) {
					
					boolean isAddingSuccessfully = this.arrangeLessonSystem.addLesson(_class, t, currentLessonsTaughtEachTeacher);
					
					if(isAddingSuccessfully) {
						
						currentQuantitiesLessonsEachClassHas.get(className)[indexSessions] += 1;
					}
					
					
				}
					
			}
		
	}


	public TreeMap<String, Integer> getCurrentLessonsTaughtEachTeacher() {
		return currentLessonsTaughtEachTeacher;
	}
	
	
	
	
}
