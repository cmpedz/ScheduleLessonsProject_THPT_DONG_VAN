import java.util.ArrayList;
import java.util.TreeMap;

public class LessonsTaughtEachTeacherStorage {
	
	private final TreeMap<String, ArrayList<QuantitiesLessonsTaughtPerDay>> lessonsTaughtEachDayEachTeacher  
	
	= new TreeMap<String, ArrayList<QuantitiesLessonsTaughtPerDay>>();
	
	
	public LessonsTaughtEachTeacherStorage() {
		
		for(int dayWokingIndex = 0; dayWokingIndex < SchoolInformations.getInstance().getDayWorkingList().size(); dayWokingIndex++) {
			
			for(Teacher teacher : SchoolInformations.getInstance().getCurrentTeacherList()) {
				
				String teacherName = teacher.getNAME();
				
				if(lessonsTaughtEachDayEachTeacher.get(teacherName) == null) {
					
					lessonsTaughtEachDayEachTeacher.put(teacherName, new ArrayList<QuantitiesLessonsTaughtPerDay>());
				
				}
				
				String nameDay = SchoolInformations.getInstance().getDayWorkingList().get(dayWokingIndex);
				
				QuantitiesLessonsTaughtPerDay quantitiesLessonsTaughtPerDay = new QuantitiesLessonsTaughtPerDay(nameDay, 0);
				
				lessonsTaughtEachDayEachTeacher.get(teacherName).add(quantitiesLessonsTaughtPerDay);
				
			}
			
		}
		
	}
	
	public void saveLessonsTaughtEachTeacherIntoStorage(ScheduleEachDay schADay, int dayWorkingIndex) {
		
		
		for(String className : schADay.getScheduleTable().keySet()) {
			
			String[] lessons = schADay.getScheduleTable().get(className);
			
			for(String aLesson : lessons) {
				
				String teacherName = FormatDisplayAndExchangeData.separateTeacherNameFromALessonDisplayFormat(aLesson);
				
				if(this.lessonsTaughtEachDayEachTeacher.get(teacherName) == null) continue; 
				
				QuantitiesLessonsTaughtPerDay quantitiesLessonsTaughtSpecifiedDay = this.lessonsTaughtEachDayEachTeacher.get(teacherName).get(dayWorkingIndex);
				
				quantitiesLessonsTaughtSpecifiedDay
				.setQuantitiesLessons(quantitiesLessonsTaughtSpecifiedDay.getQuantitiesLessons() + 1);
				
			}
			
		}
		
		System.out.println("Save Data");
		
		
		
	}
	
	public void checkData() {
		
		System.out.println("====================================================================");
		for(String teacherName : lessonsTaughtEachDayEachTeacher.keySet()) {
			System.out.println(teacherName + " :");
			for(QuantitiesLessonsTaughtPerDay quantitiesLessonsTaughtPerDay : lessonsTaughtEachDayEachTeacher.get(teacherName)) {
				System.out.println();
				System.out.println("Day Working :" + quantitiesLessonsTaughtPerDay.getCurrentDayWorking());
				System.out.println("Lessons Taught :" + quantitiesLessonsTaughtPerDay.getQuantitiesLessons());
				System.out.println();
			}
		}
		System.out.println("====================================================================");
		
	}

}
