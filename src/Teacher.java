import java.util.ArrayList;

public class Teacher {
	
	private final String NAME;
		
	private final String  GROUP;
	
	private String dayOff;
	
	private int lessonAvoidTeaching;
	
	private ArrayList<SchoolClass> classesTeaching = new ArrayList<SchoolClass>();
	


	public Teacher(String name, String group, String dayOff, ArrayList<SchoolClass> classesTeaching,
			int lessonAvoidTeaching) {
		super();
		this.NAME = name;
		this.GROUP = group;
		this.lessonAvoidTeaching = lessonAvoidTeaching;
		this.dayOff = dayOff;
		this.classesTeaching = classesTeaching;
	}

	


	public String getDayOff() {
		return dayOff;
	}




	public void setDayOff(String dayOff) {
		this.dayOff = dayOff;
	}




	public int getLessonAvoidTeaching() {
		return lessonAvoidTeaching;
	}




	public void setLessonAvoidTeaching(int lessonAvoidTeaching) {
		this.lessonAvoidTeaching = lessonAvoidTeaching;
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
							 "Lesson Avoid Teaching: " + lessonAvoidTeaching + "\n" +
							 "====== Current Classes Taught ======" + "\n" + "\n";
		for(SchoolClass _class : classesTeaching) {
			displayText += _class.toString() + "\n";
		}
		
		return displayText;
	}
	
	

}
