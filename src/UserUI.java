import java.util.ArrayList;

public class UserUI {
	
	
	public static void main(String[] args) {
		
		ExcelIOManagement.getInstance().insertDataFromExcel();
		
		ScheduleEachWeek s = new ScheduleEachWeek();
		
		s.arrangeLessons();
		
		ExcelIOManagement.getInstance().displayAdjustedDataIntoExcel(s);
	}
}
