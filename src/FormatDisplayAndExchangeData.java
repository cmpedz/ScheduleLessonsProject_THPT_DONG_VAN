import java.util.TreeMap;

public class FormatDisplayAndExchangeData {
	
	private static FormatDisplayAndExchangeData instance;
	
	private final TreeMap<String, Teacher> nameTeacherToTeacherObject = new TreeMap<String, Teacher>();

	public static String getLessonDisplayFormat(String teacherName, String specialityName) {
		return teacherName + "-" + specialityName;
	}
	
	public static String separateTeacherNameFromALessonDisplayFormat(String formatString) {
		
		String teacherName = formatString.split("-")[0];
		
		return teacherName.trim();
	}
	
	public static String separateSpecialtyFromALessonDisplayFormat(String formatString) {
		
		String specialty = formatString.split("-")[1];
		
		return specialty.trim();
	}
	
	private FormatDisplayAndExchangeData() {
		
		for(Teacher teacher : SchoolInformations.getInstance().getCurrentTeacherList()) {
			nameTeacherToTeacherObject.put(teacher.getNAME(), teacher);
		}
	}
	
	
	
	public Teacher getTeacherObjectByOwnerName(String teacherName) {
		
		return nameTeacherToTeacherObject.get(teacherName);
		
	}

	public static FormatDisplayAndExchangeData getInstance() {
		
		if(instance == null) {
			instance = new FormatDisplayAndExchangeData();
		}
		
		return instance;
	}
	

		
}
