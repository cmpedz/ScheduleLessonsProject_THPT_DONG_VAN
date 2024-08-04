
import java.util.TreeMap;


public class ScheduleEachDay {
	 
	
	private final TreeMap<String, String[]> scheduleTable = new TreeMap<String, String[]>();
	
	private ArrangeLessonSystem arrangeLesson;
	
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
		
		this.arrangeLesson = new ArrangeLessonSystem(scheduleTable);
	}
	
	
	public TreeMap<String, String[]> getScheduleTable() {
		return scheduleTable;
	}

	
	public void addTeacherLessonIntoScheduleTable(Teacher t, int prioritySpecialty) {
		
			for(SchoolClass _class : t.getClassesTeaching(prioritySpecialty)){
				
				for(int i = 0; i < _class.getSpeciality().getMaxContinuesLessonCanTeach() && 
						_class.getRemainingLessonPerWeek() > 0; i++) {
					this.arrangeLesson.addLesson(_class, t);
				}
					
			}
		
	}
	
	
}
