
public class SchoolClass {
	
	private final String NAME;
	
	private final int lessonsPerWeek;
	
	private int remainingLessonPerWeek;
	
	private final int lessonPerYear;
	
	private String specialityName;
	
	public static final String Error_Class_Name = "Tên lớp học không tồn tại|";
	
	public static final String Error_Specialty_Name = "Tên môn học không tồn tại|";
	

	public SchoolClass(String name, int lessonsPerWeek, int lessonPerYear, String speciality) throws Exception {
		super();
		this.NAME = name;
		this.lessonsPerWeek = lessonsPerWeek;
		this.lessonPerYear = lessonPerYear;
		this.specialityName = speciality;
		this.remainingLessonPerWeek = lessonsPerWeek;
		
		if(!checkValidInfors().equals("")) {
			throw new Exception(checkValidInfors());
		}
		
	}
	
	private String checkValidInfors() {
		
		String error = "";
		
		boolean isClassExisted = SchoolInformations.getInstance().getClassesNameList().contains(NAME);
		
		boolean isSpecialtyExisted = SchoolInformations.getInstance().getSpecialtyList().get(specialityName) != null;
		
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

	public Speciality getSpeciality() {
		return SchoolInformations.getInstance().getSpecialtyList().get(specialityName);
	}

	public void setSpecialityName(String specialityName) {
		this.specialityName = specialityName;
	}

	public int getRemainingLessonPerWeek() {
		return remainingLessonPerWeek;
	}

	public void setRemainingLessonPerWeek(int remainingLessonPerWeek) {
		this.remainingLessonPerWeek = remainingLessonPerWeek;
	}
	
	@Override
	public String toString() {
		return  "Class Name: " + NAME + "\n" + 
				"Lesson Per Week: " + lessonsPerWeek + "\n" +
				"Lesson Per Year: " + lessonPerYear + "\n" +
				"Specialty Name: " + specialityName + "\n";
	}		   
		


}
