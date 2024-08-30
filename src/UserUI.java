import java.util.ArrayList;

public class UserUI {
	
	
	public static void main(String[] args) {
		
		ExcelIOManagement.getInstance().insertDataFromExcel();
		
		ScheduleEachWeek s = null;
		try {
			s = new ScheduleEachWeek();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		s.arrangeLessons();
		
		ExcelIOManagement.getInstance().displayAdjustedDataIntoExcel(s);
	}
}
