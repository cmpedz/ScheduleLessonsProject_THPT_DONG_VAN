import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;


public class ScheduleEachWeek {
	
	public static final int MAX_QUANTITIES_DAY_WORKING = 6;
	
	private final ScheduleEachDay[] scheduleEachDays = new ScheduleEachDay[MAX_QUANTITIES_DAY_WORKING];
	
	private LessonsTaughtEachTeacherStorage lessonsTaughtEachTeacherStorage = new LessonsTaughtEachTeacherStorage();
	
	private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	
	private RemoveTeacherWhoHasEnoughLessonsSystem removeTeacherSystem = new RemoveTeacherWhoHasEnoughLessonsSystem();
	
	private SchoolInformations schInformations = SchoolInformations.getInstance();
	
	public static final int MAX_REPEAT = 2;
	
	public ScheduleEachWeek() {
		super();
		
		for( int i = 0; i < scheduleEachDays.length; i++) {
			
			scheduleEachDays[i] = new ScheduleEachDay();
			
		}
		
		
		
	}
	
	
	
	public void arrangeLessons() {
		
		int repeatQuantities = 0;
		
		while(repeatQuantities < MAX_REPEAT && teachers.size() != 0) {
			
			int dayWorkingIndex = 0;
			
			removeTeacherSystem.removeTeacherWhoMeetLessonsQuantities(teachers);
			
			for(ScheduleEachDay schADay : scheduleEachDays) {
				
				resetDataForSomeConditions(schADay);
				
				lessonsTaughtEachTeacherStorage.saveLessonsTaughtEachTeacherIntoStorage(schADay, dayWorkingIndex);
				
				dayWorkingIndex ++;
				
			}
			
			lessonsTaughtEachTeacherStorage.sortDaysRelyOnQuantitiesLessonItHas();
			
			//lessonsTaughtEachTeacherStorage.checkData();
			
			
			for(int i = 0; i < Teacher.MAX_PRIORITY_TYPES; i++) {
				
				arrangeLessonsEachPriorityType(i);
				
			}
			
			arrangeLowPriorityLessonsIntoAfternoon();
			
			repeatQuantities ++;
		}
		
		
		printCurrentLessonsTaughtPerTeacher();
		//printLeftOverLessons();
		
	}
	

	
	private void resetDataForSomeConditions(ScheduleEachDay schADay) {
		
			schADay.getArrangeLessonSystem().getConditionsContainer().resetData();
		
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
		
		
		for(String teacherName : lessonsTaughtEachTeacherStorage.getLessonsTaughtEachDayEachTeacher().keySet()) {
			
			Teacher teacher = FormatDisplayAndExchangeData.getInstance().getTeacherObjectByOwnerName(teacherName);
			
			ArrayList<QuantitiesLessonsTaughtPerDay> workingsSchedule = lessonsTaughtEachTeacherStorage.getLessonsTaughtEachDayEachTeacher().get(teacher.getNAME());
			
			int leftOverWorkingDays = 5;
			
			
			for(QuantitiesLessonsTaughtPerDay aWorkingDay : workingsSchedule) {
				
				teacher.setLeftOverWorkingDays(leftOverWorkingDays);
				
				String currentDay = aWorkingDay.getCurrentDayWorking();
				
				boolean isDayOff = teacher.getDayOff().toString().equals(currentDay);
				
				if(!isDayOff) {
					
					int indexCurrentDay = SchoolInformations.getInstance().getDayWorkingList().indexOf(currentDay);
					
					teacher.setCurrentDayIndex(indexCurrentDay);
					
					scheduleEachDays[indexCurrentDay].addTeacherLessonIntoScheduleTable(teacher, priority);
				}
				
				leftOverWorkingDays--;
				
				
			}
		}
		
		
		
		
	}
	
	public ScheduleEachDay[] getScheduleEachDays() {
		return scheduleEachDays;
	}

	public void addTeacherIntoList(Teacher t) {
		teachers.add(t);
	}
	
	public void printCurrentLessonsTaughtPerTeacher() {
		
		for(String teacherName : lessonsTaughtEachTeacherStorage.getLessonsTaughtEachDayEachTeacher().keySet()) {
			
			System.out.println("=============================");
			
			System.out.println("Teacher Name :" + teacherName);
			
			for(QuantitiesLessonsTaughtPerDay q : lessonsTaughtEachTeacherStorage.getLessonsTaughtEachDayEachTeacher().get(teacherName)) {
				System.out.println(q.getCurrentDayWorking() + " taught :" + q.getQuantitiesLessons() + " lessons");
				
			}
			
			Teacher assessedTeacher = FormatDisplayAndExchangeData.getInstance().getTeacherObjectByOwnerName(teacherName);
			
			System.out.println("leftover :" + assessedTeacher.getSumLessonsTeach());
			
			System.out.println("=============================");
			
		}
	}
	
	public void printLeftOverLessons() {
		
		System.out.println("check available leftover lessons : ");
		
		for(Teacher t : teachers) {
			
			System.out.println("=========================");
			
			System.out.println(t.getNAME());
			
			for(int i = 0; i < 2 ; i++) {
				for(SchoolClass c : t.getClassesTeaching(i)) {
					System.out.println("class name : " + c.getName());
					System.out.println("speciality name : " + c.getSpeciality().getName());
					System.out.println("leftover lessons : " + c.getRemainingLessonPerWeek());
				}
			}
			
			System.out.println("=========================");
			
		}
	}
		
	
}
