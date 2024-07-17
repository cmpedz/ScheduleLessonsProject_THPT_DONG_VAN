
public class SchoolClass {
	
	private String name;
	
	private final int lessonsPerWeek;
	
	private int remainingLessonPerWeek;
	
	private final int lessonPerYear;
	
	private Speciality speciality;
	
	

	public SchoolClass(String name, int lessonsPerWeek, int lessonPerYear, Speciality speciality) {
		super();
		this.name = name;
		this.lessonsPerWeek = lessonsPerWeek;
		this.lessonPerYear = lessonPerYear;
		this.speciality = speciality;
		this.remainingLessonPerWeek = lessonsPerWeek;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLessonsPerWeek() {
		return lessonsPerWeek;
	}


	public int getLessonPerYear() {
		return lessonPerYear;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public int getRemainingLessonPerWeek() {
		return remainingLessonPerWeek;
	}

	public void setRemainingLessonPerWeek(int remainingLessonPerWeek) {
		this.remainingLessonPerWeek = remainingLessonPerWeek;
	}
	
	

}
