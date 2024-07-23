
public class FormatDisplayAndExchangeData {

	public static String getLessonDisplayFormat(String teacherName, String specialityName) {
		return teacherName + "-" + specialityName;
	}
	
	public static String separateTeacherNameInALessonDisplayFormat(String formatString) {
		
		String teacherName = formatString.split("-")[0];
		
		return teacherName.trim();
	}
	
	public static String exchangeNumberIntoDay(int i) {
		switch(i) {
			case 0 :
				return DaysWorking.Thứ_Hai.name();
				
			case 1 :
				return DaysWorking.Thứ_Ba.name();
				
			case 2 :
				return DaysWorking.Thứ_Tư.name();
				
			case 3 :
				return DaysWorking.Thứ_Năm.name();
				
			case 4 :
				return DaysWorking.Thứ_Sáu.name();
				
			case 5 :
				return DaysWorking.Thứ_Bảy.name();
				
			default :
				return "error";
				
		}
		
	}
	
	
}
