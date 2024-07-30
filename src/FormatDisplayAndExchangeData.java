
public class FormatDisplayAndExchangeData {

	public static String getLessonDisplayFormat(String teacherName, String specialityName) {
		return teacherName + "-" + specialityName;
	}
	
	public static String separateTeacherNameInALessonDisplayFormat(String formatString) {
		
		String teacherName = formatString.split("-")[0];
		
		return teacherName.trim();
	}
		
}
