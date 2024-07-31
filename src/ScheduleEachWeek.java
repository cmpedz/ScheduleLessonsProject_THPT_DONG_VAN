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
	
	public void print() {
		int index = 0;
		
		for(ScheduleEachDay s : scheduleEachDays) {
			System.out.println();
			String dayWoking = schInformations.getDayWorkingList().get(index);
			System.out.println("===================================" + dayWoking + "======================================");
			System.out.println();
			s.print();
			System.out.println();
			index++;
		}
		
		
	}
	
	public void arrangeLessons() {
		
		int index = 0;
		
		for(ScheduleEachDay s : scheduleEachDays) {
			
			removeTeacherSystem.removeTeacherWhoMeetLessonsQuantities(teachers);
			
			for(int i=0; i < teachers.size(); i++) {
				
				String currentDay = schInformations.getDayWorkingList().get(index);
				
				
				boolean isDayOff = teachers.get(i).getDayOff().toString().equals(currentDay);
				
				if(!isDayOff) {
					s.addTeacherLessonIntoScheduleTable(teachers.get(i));
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
