import java.util.ArrayList;

public class ScheduleEachWeek {
	
	public static final int MAX_QUANTITIES_DAY_WORKING = 6;
	
	private final ScheduleEachDay[] scheduleEachDays = new ScheduleEachDay[MAX_QUANTITIES_DAY_WORKING];
	
	private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	
	private RemoveTeacherWhoHasEnoughLessonsSystem removeTeacherSystem = new RemoveTeacherWhoHasEnoughLessonsSystem();
	
	private SchoolInformations schInformations = SchoolInformations.getInstance();
	
	public ScheduleEachWeek() {
		super();
		
		for( int i = 0; i < scheduleEachDays.length; i++) {
			scheduleEachDays[i] = new ScheduleEachDay();
		}
		
	}
	
	public void arrangeLessons() {
		
		for(int i = 0; i < Teacher.MAX_PRIORITY_TYPES; i++) {
			
			arrangeLessonsEachPriorityType(i);
			
		}
		
		arrangeLowPriorityLessonsIntoAfternoon();
	}
	
	private void arrangeLowPriorityLessonsIntoAfternoon() {
		
		for(Teacher teacher : teachers) {
			
			ArrayList<SchoolClass> lowPriorityLessons = teacher.getClassesTeaching(Teacher.LOW_PRIORITY_TYPE);
			
			for(SchoolClass _class : lowPriorityLessons) {
				_class.getSpeciality().setIsInMorning(false);
			}
			
		}
		
		arrangeLessonsEachPriorityType(Teacher.LOW_PRIORITY_TYPE);
		
	}
	
	private void arrangeLessonsEachPriorityType(int priority) {
		
		int index = 0;
		
		for(ScheduleEachDay s : scheduleEachDays) {
			
			removeTeacherSystem.removeTeacherWhoMeetLessonsQuantities(teachers, priority);
			
			for(int i=0; i < teachers.size(); i++) {
				
				String currentDay = schInformations.getDayWorkingList().get(index);
				
				
				boolean isDayOff = teachers.get(i).getDayOff().toString().equals(currentDay);
				
				if(!isDayOff) {
					
					teachers.get(i).setCurrentDayIndex(index);
					
					s.addTeacherLessonIntoScheduleTable(teachers.get(i), priority);
				}
				
			}
			
			index++;
		}
		
	}
	
	public ScheduleEachDay[] getScheduleEachDays() {
		return scheduleEachDays;
	}

	public void addTeacherIntoList(Teacher t) {
		teachers.add(t);
	}
		
	
}
