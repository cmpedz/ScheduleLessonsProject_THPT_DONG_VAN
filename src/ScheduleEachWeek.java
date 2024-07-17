import java.util.ArrayList;

public class ScheduleEachWeek {
	
	public static final int MAX_QUANTITIES_DAY_WORKING = 6;
	
	private final ScheduleEachDay[] scheduleEachDays = new ScheduleEachDay[MAX_QUANTITIES_DAY_WORKING];
	
	private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	
	private RemoveTeacherWhoHasEnoughLessonsSystem removeTeacherSystem = new RemoveTeacherWhoHasEnoughLessonsSystem();
	
	public ScheduleEachWeek() {
		super();
		
		for( int i = 0; i < scheduleEachDays.length; i++) {
			scheduleEachDays[i] = new ScheduleEachDay();
		}
		
	}
	
	public void print() {
		int order = 2;
		
		for(ScheduleEachDay s : scheduleEachDays) {
			System.out.println();
			System.out.println("===================================" + order + "======================================");
			System.out.println();
			s.print();
			System.out.println();
			order++;
		}
	}
	
	public void arrangeLessons() {
		
		for(ScheduleEachDay s : scheduleEachDays) {
			
			removeTeacherSystem.removeTeacherWhoMeetLessonsQuantities(teachers);
			
			for(int i=0; i < teachers.size(); i++) {
				s.addTeacherLessonIntoScheduleTable(teachers.get(i));
			}
		}
	}
	
	
	
	public void addTeacherIntoList(Teacher t) {
		teachers.add(t);
	}
		
	
}
