
public class SchoolClass {
	
	private final String NAME;
	
	private final int lessonsPerWeek;
	
	private int leftOverLessonPerWeek;
	
	private final int lessonPerYear;
	
	private String courseName;
	
	public static final String Error_Class_Name = "Tên lớp học không tồn tại|";
	
	public static final String Error_Specialty_Name = "Tên môn học không tồn tại|";
	

	public SchoolClass(String name, int lessonsPerWeek, int lessonPerYear, String speciality) throws Exception {
		super();
		this.NAME = name;
		this.lessonsPerWeek = lessonsPerWeek;
		this.lessonPerYear = lessonPerYear;
		this.courseName = speciality;
		this.leftOverLessonPerWeek = lessonsPerWeek;
		
		if(!checkValidInfors().equals("")) {
			throw new Exception(checkValidInfors());
		}
		
	}
	
	private String checkValidInfors() {
		
		String error = "";
		
		boolean isClassExisted = SchoolInformations.getInstance().getClassesNameList().contains(NAME);
		
		boolean isSpecialtyExisted = SchoolInformations.getInstance().getSpecialtyList().get(courseName) != null;
		
		if(!isClassExisted) {
			error += Error_Class_Name;
		}
		
		if(!isSpecialtyExisted) {
			error += Error_Specialty_Name;
		}
		
		return error;
		
	}

	public String getName() {
		return NAME;
	}

	public int getLessonsPerWeek() {
		return lessonsPerWeek;
	}


	public int getLessonPerYear() {
		return lessonPerYear;
	}

	public Course getCourse() {
		return SchoolInformations.getInstance().getSpecialtyList().get(courseName);
	}

	public void setCourseName(String CourseName) {
		this.courseName = CourseName;
	}

	public int getLeftOverLessonPerWeek() {
		return leftOverLessonPerWeek;
	}

	public void setLeftOverLessonPerWeek(int leftOverLessonPerWeek) {
		this.leftOverLessonPerWeek = leftOverLessonPerWeek;
	}
	
	@Override
	public String toString() {
		return  "Class Name: " + NAME + "\n" + 
				"Lesson Per Week: " + lessonsPerWeek + "\n" +
				"Lesson Per Year: " + lessonPerYear + "\n" +
				"Specialty Name: " + courseName + "\n";
	}		   
		


}
