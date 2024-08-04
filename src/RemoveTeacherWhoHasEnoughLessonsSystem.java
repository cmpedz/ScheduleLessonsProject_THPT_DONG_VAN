import java.util.ArrayList;

public class RemoveTeacherWhoHasEnoughLessonsSystem {
	
	private ArrayList<Teacher> teachersNeedRemove = new ArrayList<Teacher>();
	
	private ArrayList<SchoolClass> classesNeedRemove = new ArrayList<SchoolClass>();
	
	
    public void removeTeacherWhoMeetLessonsQuantities(ArrayList<Teacher> teachers, int priority) {
		
		for(Teacher t : teachers) {
			
			for(SchoolClass _class : t.getClassesTeaching(priority)) {

				if(_class.getRemainingLessonPerWeek() <= 0) {
					
					classesNeedRemove.add(_class);
					
				}
			}
			
			//remove class
			for(SchoolClass _class : classesNeedRemove) {
				t.getClassesTeaching(priority).remove(_class);
			}
			
			
		}
		
		for(Teacher t : teachers) {
			
			boolean isTeacherHavingNoLessons = t.getClassesTeaching(Teacher.LOW_PRIORITY_TYPE).size() == 0 &&
												t.getClassesTeaching(Teacher.HIGH_PRIORITY_TYPE).size() == 0;
			
			
				
				if(isTeacherHavingNoLessons) {
					teachersNeedRemove.add(t);
				}
			
		}
		
		
		//remove teacher
		for(Teacher t : teachersNeedRemove) {
			
			teachers.remove(t);
		}
		
		resetData();
	}
    
    
    
    private void resetData() {
    	this.classesNeedRemove.clear();
    	this.teachersNeedRemove.clear();
    }

}
