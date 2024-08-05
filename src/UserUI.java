import java.util.ArrayList;

public class UserUI {
	
	
	public static void main(String[] args) {
		
		ExcelIOManagement.getInstance().insertDataFromExcel();
		
		ScheduleEachWeek s = new ScheduleEachWeek();
		
		ISchoolInformations iSchoolInformations = SchoolInformations.getInstance();
		
		for(Teacher teacher : iSchoolInformations.getCurrentTeacherList()) {
			s.addTeacherIntoList(teacher);
			
			System.out.println();
			
			System.out.println(teacher.getNAME());
			
			System.out.println("check sum lessons teach :" 
			+ "High :" + teacher.getSumLessonsTeachPerPriorityType()
			+ "Low :" + teacher.getSumLessonsTeachPerPriorityType());
			
			System.out.println("check average lessons teach :" 
					+ "High :" + teacher.getAverageLessonsTeachEachDay()
					+ "Low :" + teacher.getAverageLessonsTeachEachDay());
			
			System.out.println();
			
			
		}
		
		s.arrangeLessons();
		
		ExcelIOManagement.getInstance().displayAdjustedDataIntoExcel(s);
	}
}
