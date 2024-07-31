import java.util.ArrayList;

public class UserUI {
	
	
	public static void main(String[] args) {
		
		ExcelIOManagement.getInstance().insertDataFromExcel();
		
		ScheduleEachWeek s = new ScheduleEachWeek();
		
		ISchoolInformations iSchoolInformations = SchoolInformations.getInstance();
		
		for(Teacher teacher : iSchoolInformations.getCurrentTeacherList()) {
			s.addTeacherIntoList(teacher);
		}
		
		s.arrangeLessons();
		
		s.print();
	}
}
