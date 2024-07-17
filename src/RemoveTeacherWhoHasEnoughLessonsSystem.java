import java.util.ArrayList;

public class RemoveTeacherWhoHasEnoughLessonsSystem {
	
	private ArrayList<Teacher> teachersNeedRemove = new ArrayList<Teacher>();
	
	private ArrayList<SchoolClass> classesNeedRemove = new ArrayList<SchoolClass>();
	
	
    public void removeTeacherWhoMeetLessonsQuantities(ArrayList<Teacher> teachers) {
		
		for(Teacher t : teachers) {
			for(SchoolClass _class : t.getClassesTeaching()) {

				if(_class.getRemainingLessonPerWeek() <= 0) {
					
					classesNeedRemove.add(_class);
					
				}
			}
			
			//remove class
			for(SchoolClass _class : classesNeedRemove) {
				t.getClassesTeaching().remove(_class);
			}
			
			
		
			if(t.getClassesTeaching().size() == 0) {
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
