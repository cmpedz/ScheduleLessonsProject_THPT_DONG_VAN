import java.util.ArrayList;

public class Teacher {
	
	private final String NAME;
		
	private final String  GROUP;
	
	private String dayOff;
	
	private ArrayList<Integer> lessonsExpectedNotTeaching = new ArrayList<Integer>();
	
	private ArrayList<SchoolClass> classesTeaching = new ArrayList<SchoolClass>();
	


	public Teacher(String name, String group, String dayOff, ArrayList<SchoolClass> classesTeaching) {
		super();
		this.NAME = name;
		this.GROUP = group;
		this.dayOff = dayOff;
		this.classesTeaching = classesTeaching;
	}

	


	public String getDayOff() {
		return dayOff;
	}




	public void setDayOff(String dayOff) {
		this.dayOff = dayOff;
	}




	public ArrayList<Integer> getLessonsExpectedNotTeaching() {
		return lessonsExpectedNotTeaching;
	}




	public void addLessonsExpectedNotTeachingIntoList(int lessonIndex) {
		this.lessonsExpectedNotTeaching.add(lessonIndex);
	}




	public String getNAME() {
		return NAME;
	}




	public String getGROUP() {
		return GROUP;
	}




	public ArrayList<SchoolClass> getClassesTeaching() {
		return classesTeaching;
	}

	public void setClassesTeaching(ArrayList<SchoolClass> classesTeaching) {
		this.classesTeaching = classesTeaching;
	}
	
	@Override
	public String toString() {
		String displayText = "\n" + "Teacher Name: " + NAME + "\n" +
							 "Group: " + GROUP + "\n" +
							 "Dayoff: " + dayOff + "\n" +
							 "Lesson Avoid Teaching: " + lessonsExpectedNotTeaching + "\n" +
							 "====== Current Classes Taught ======" + "\n" + "\n";
		for(SchoolClass _class : classesTeaching) {
			displayText += _class.toString() + "\n";
		}
		
		return displayText;
	}
	
	

}
