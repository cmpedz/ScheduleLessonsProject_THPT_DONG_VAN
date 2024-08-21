import java.util.ArrayList;

public class RemoveTeacherWhoHasEnoughLessonsSystem {
	
	private ArrayList<Teacher> teachersNeedRemove = new ArrayList<Teacher>();
	
	private ArrayList<SchoolClass> classesNeedRemove = new ArrayList<SchoolClass>();
	
	
    public void removeTeacherWhoMeetLessonsQuantities(ArrayList<Teacher> teachers) {
		
		for(Teacher t : teachers) {
			
			removeClassFunc(t, Teacher.HIGH_PRIORITY_TYPE);
			
			removeClassFunc(t, Teacher.LOW_PRIORITY_TYPE);
			
			
		}
		
		removeTeachersFunc(teachers);
		
		
		resetData();
	}
    
    private void removeClassFunc(Teacher t, int priority) {
    	
    	for(SchoolClass _class : t.getClassesTeaching(priority)) {

			if(_class.getLeftOverLessonPerWeek() <= 0) {
				
				classesNeedRemove.add(_class);
				
			}
		}
		
		for(SchoolClass _class : classesNeedRemove) {
			t.removeClassFromTaughtClasses(_class);
		}
		
    }
    
    private void removeTeachersFunc(ArrayList<Teacher> teachers) {
    	
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
    }
    
    
    private void resetData() {
    	this.classesNeedRemove.clear();
    	this.teachersNeedRemove.clear();
    }

}
