
import java.util.TreeMap;


public class ScheduleEachDay {
	 
	
	private TreeMap<String, String[]> scheduleTable = new TreeMap<String, String[]>();
	
	private ArrangeLessonSystem arrangeLesson;
	
	
	public ScheduleEachDay() {
		for(String className : SchoolInformations.getInstance().CLASSES) {
			
			int quantitiesLessonEachDay = SchoolInformations.MAX_LESSONS_IN_MORNING 
					+ SchoolInformations.MAX_LESSONS_IN_AFTERNOON;
			
			scheduleTable.put(className, new String[quantitiesLessonEachDay]);
			
			for(int i=0; i<scheduleTable.get(className).length; i++) {
				scheduleTable.get(className)[i] = "no one";
			}
		}
		
		this.arrangeLesson = new ArrangeLessonSystem(scheduleTable);
	}
	
	
	public void print() {
		 System.out.print("----------");
		 for(String className : SchoolInformations.getInstance().CLASSES) {
			 System.out.print(className);
			 System.out.print("----------");
		 }
		 
		 for(int i = 0; i < SchoolInformations.MAX_LESSONS_IN_AFTERNOON + SchoolInformations.MAX_LESSONS_IN_MORNING; i++ ) {
			 
			 System.out.println();
			 
			 System.out.print("----------");
			 
			 for(String className : SchoolInformations.getInstance().CLASSES) {
				 
				 System.out.print(scheduleTable.get(className)[i]);
				 
				 System.out.print("----------");
			 }
			 
		 }
		
		 
			
	}
	
	public void addTeacherLessonIntoScheduleTable(Teacher t) {
		
		for(SchoolClass _class : t.getClassesTeaching()){
			
			for(int i = 0; i < _class.getSpeciality().getMaxContinuesLessonCanTeach(); i++) {
				this.arrangeLesson.addLesson(_class, t);
			}
				
		}
		
	}
	
	
}
