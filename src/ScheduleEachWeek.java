import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class ScheduleEachWeek {
	
	public static final int MAX_QUANTITIES_DAY_WORKING = 6;
	
	private final ScheduleEachDay[] scheduleEachDays = new ScheduleEachDay[MAX_QUANTITIES_DAY_WORKING];
	
	private LessonsTaughtEachTeacherStorage lessonsTaughtEachTeacherStorage = new LessonsTaughtEachTeacherStorage();
	
	private ArrayList<Teacher> teachersWhoNotTeachMainCourse = new ArrayList<Teacher>();
	
	private ArrayList<Teacher> teachersWhoTeachMainCourse = new ArrayList<Teacher>();
	
	
	private RemoveTeacherWhoHasEnoughLessonsSystem removeTeacherSystem = new RemoveTeacherWhoHasEnoughLessonsSystem();
	
	
	public static final int MAX_REPEAT = 10;
	
	public ScheduleEachWeek() throws Exception {
		super();
		
		for( int i = 0; i < scheduleEachDays.length; i++) {
			
			scheduleEachDays[i] = new ScheduleEachDay();
			
		}
		
		seperateTeacherWhoTeachesMainCourseAndWhoDoesnt();
		
	}
	
	private void seperateTeacherWhoTeachesMainCourseAndWhoDoesnt() throws Exception {
		
			for(Teacher t : SchoolInformations.getInstance().getCurrentTeacherList()) {
			
			Teacher teacherTeachesMainCourse = new Teacher(t.getNAME(), t.getGROUP(), t.getDayOff());
			
			Teacher teacherNotTeachesMainCourse = new Teacher(t.getNAME(), t.getGROUP(), t.getDayOff());
			
			for(SchoolClass _class : t.getClassesTeaching()) {
				if(_class.getCourse().isIS_MAIN_COURSE()) {
					teacherTeachesMainCourse.addClassTeaching(_class);
				} else {
					teacherNotTeachesMainCourse.addClassTeaching(_class);
				}
			}
			
			if(teacherTeachesMainCourse.getClassesTeaching().size() > 0) {teachersWhoTeachMainCourse.add(teacherTeachesMainCourse);}
			
			if(teacherNotTeachesMainCourse.getClassesTeaching().size() > 0) {teachersWhoNotTeachMainCourse.add(teacherNotTeachesMainCourse);}
			
		}
	}
	
	public void arrangeLessons() {
		
		int repeatQuantities = 0;
		
		while(repeatQuantities < MAX_REPEAT && teachersWhoNotTeachMainCourse.size() != 0
				&& teachersWhoTeachMainCourse.size() != 0) {
			
			int dayWorkingIndex = 0;
			
			removeTeacherSystem.removeTeacherWhoMeetLessonsQuantities(teachersWhoNotTeachMainCourse);
			
			removeTeacherSystem.removeTeacherWhoMeetLessonsQuantities(teachersWhoTeachMainCourse);
			
			lessonsTaughtEachTeacherStorage.resetData();
			
			for(ScheduleEachDay schADay : scheduleEachDays) {
				
				resetDataForSomeConditions(schADay);
				
				schADay.resetData();
				
				lessonsTaughtEachTeacherStorage.saveLessonsTaughtEachTeacherIntoStorage(schADay, dayWorkingIndex);
				
				dayWorkingIndex ++;
				
			}
			
			lessonsTaughtEachTeacherStorage.insertionSortDaysRelyOnQuantitiesLessonItHas();
			
			//lessonsTaughtEachTeacherStorage.checkData();
			
			arrangeLessonsEachPriorityType(teachersWhoTeachMainCourse);
			
			arrangeLessonsEachPriorityType(teachersWhoNotTeachMainCourse);
			
			
			
			repeatQuantities ++;
			
			System.out.println("-----------------" + repeatQuantities + "-------------------------");
			try {
				printCurrentLessonsTaughtPerTeacher();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("------------------------------------------------------------------");
		}
		
		
		
		//printLeftOverLessons();
		
		QuantitiesLessonsPerClassStorage.getInstance().checkData();
		
	}
	

	
	private void resetDataForSomeConditions(ScheduleEachDay schADay) {
		
			schADay.getArrangeLessonSystem().getConditionsContainer().resetData();
		
	}


	
	private void arrangeLessonsEachPriorityType(ArrayList<Teacher> teachers) {
		
		
		for(Teacher teacher : teachers) {
			
			ArrayList<QuantitiesLessonsTaughtPerDay> workingsSchedule = lessonsTaughtEachTeacherStorage.getLessonsTaughtEachDayEachTeacher().get(teacher.getNAME());
			
			int leftOverWorkingDays = 5;
			
			for(QuantitiesLessonsTaughtPerDay aWorkingDay : workingsSchedule) {
				
				teacher.setLeftOverWorkingDays(leftOverWorkingDays);
				
				String currentDay = aWorkingDay.getCurrentDayWorking();
				
				boolean isDayOff = teacher.getDayOff().toString().equals(currentDay);
				
				if(true) {
					
					int indexCurrentDay = SchoolInformations.getInstance().getDayWorkingList().indexOf(currentDay);
					
					teacher.setCurrentDayIndex(indexCurrentDay);
					
					scheduleEachDays[indexCurrentDay].addTeacherLessonIntoScheduleTable(teacher);
				}
				
				leftOverWorkingDays--;
				
				
			}
		}
		
		
		
		
	}
	
	public ScheduleEachDay[] getScheduleEachDays() {
		return scheduleEachDays;
	}


	public void printCurrentLessonsTaughtPerTeacher() throws Exception {
		
		
		TreeMap<String, Teacher> teachers = new TreeMap<String, Teacher>();
		
		for(Teacher t : teachersWhoNotTeachMainCourse) {
			String teacherName = t.getNAME();
			if(teachers.get(teacherName) == null) {
				teachers.put(teacherName, new Teacher(teacherName, t.getGROUP(), t.getDayOff()));
			}
			
			for(SchoolClass _Class : t.getClassesTeaching()) {
				
				teachers.get(teacherName).addClassTeaching(_Class);
			}
			
		}
		
		for(Teacher t : teachersWhoTeachMainCourse) {
			
			String teacherName = t.getNAME();
			
			if(teachers.get(teacherName) == null) {
				
				teachers.put(teacherName, new Teacher(teacherName, t.getGROUP(), t.getDayOff()));
			}
			
			for(SchoolClass _Class : t.getClassesTeaching()) {
				teachers.get(teacherName).addClassTeaching(_Class);
			}
			
		}
		
		for(String teacherName : lessonsTaughtEachTeacherStorage.getLessonsTaughtEachDayEachTeacher().keySet()) {
			
			System.out.println("=============================");
			
			System.out.println("Teacher Name :" + teacherName);
			
			for(QuantitiesLessonsTaughtPerDay q : lessonsTaughtEachTeacherStorage.getLessonsTaughtEachDayEachTeacher().get(teacherName)) {
				System.out.println(q.getCurrentDayWorking() + " taught :" + q.getQuantitiesLessons() + " lessons");
				
			}
			
			Teacher assessedTeacher = teachers.get(teacherName);
			
			if(assessedTeacher == null) continue;
			
			int leftOverLessons = assessedTeacher.getSumLessonsTeach();
			
			System.out.println("leftover :" + leftOverLessons);
			
			if(leftOverLessons > 0) {
				
					for(SchoolClass s : assessedTeacher.getClassesTeaching()) {
						
							System.out.println(s.getName() + " , " + s.getCourse().getName());
		
					}
				
				
			}
			
			System.out.println("=============================");
			
		}
	}
	
	public void printLeftOverLessons(ArrayList<Teacher> teachers) {
		
		System.out.println("check available leftover lessons : ");
		
		for(Teacher t : teachers) {
			
			System.out.println("=========================");
			
			System.out.println(t.getNAME());
			
			
				for(SchoolClass c : t.getClassesTeaching()) {
					System.out.println("class name : " + c.getName());
					System.out.println("speciality name : " + c.getCourse().getName());
					System.out.println("leftover lessons : " + c.getLeftOverLessonPerWeek());
				}
			
			
			System.out.println("=========================");
			
		}
	}
		
	
}
