
import java.util.TreeMap;


public class ScheduleEachDay {
	 
	
	private final TreeMap<String, String[]> scheduleTable = new TreeMap<String, String[]>();
	
	private final TreeMap<String, Integer> currentLessonsTaughtEachTeacher = new TreeMap<String, Integer>();
	
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
		}
		
		this.arrangeLessonSystem = new ArrangeLessonSystem(scheduleTable);
	}
	
	
	public TreeMap<String, String[]> getScheduleTable() {
		return scheduleTable;
	}
	
	public ArrangeLessonSystem getArrangeLessonSystem() {
		
		return this.arrangeLessonSystem;
		
	}

	
	public void addTeacherLessonIntoScheduleTable(Teacher t, int prioritySpecialty) {
		
			if(currentLessonsTaughtEachTeacher.get(t.getNAME()) == null) {
				currentLessonsTaughtEachTeacher.put(t.getNAME(), 0);
			}
		
			for(SchoolClass _class : t.getClassesTeaching(prioritySpecialty)){
				
				for(int i = 0; i < _class.getSpeciality().getMaxContinuesLessonCanTeach() && 
						_class.getRemainingLessonPerWeek() > 0; i++) {
					this.arrangeLessonSystem.addLesson(_class, t, currentLessonsTaughtEachTeacher);
				}
					
			}
		
	}


	public TreeMap<String, Integer> getCurrentLessonsTaughtEachTeacher() {
		return currentLessonsTaughtEachTeacher;
	}
	
	
	
	
}
