import java.util.ArrayList;
import java.util.TreeMap;

public class Teacher {
	
	private final String NAME;
		
	private final String  GROUP;
	
	private String dayOff;

	private int currentDayIndex = 0;
	
	private  TreeMap<String, ArrayList<Integer>>  lessonsExpectedNotTeaching = new TreeMap<String, ArrayList<Integer>>();
	
	private ArrayList<SchoolClass> classesTeaching = new ArrayList<SchoolClass>();
	


	public Teacher(String name, String group, String dayOff, ArrayList<SchoolClass> classesTeaching) {
		
		super();
		this.NAME = name;
		this.GROUP = group;
		this.dayOff = dayOff;
		this.classesTeaching = classesTeaching;
		
		for(String day : SchoolInformations.getInstance().getDayWorkingList()) {
			
			lessonsExpectedNotTeaching.put(day, new ArrayList<Integer>());
		}
		
	}

	


	public String getDayOff() {
		return dayOff;
	}




	public void setDayOff(String dayOff) {
		this.dayOff = dayOff;
	}

	


	public int getCurrentDayIndex() {
		return currentDayIndex;
	}




	public void setCurrentDayIndex(int currentDayIndex) {
		this.currentDayIndex = currentDayIndex;
	}




	public ArrayList<Integer> getLessonsExpectedNotTeaching() {
		
		String day = SchoolInformations.getInstance().getDayWorkingList().get(currentDayIndex);
		
		return lessonsExpectedNotTeaching.get(day);
	}




	public void addLessonsExpectedNotTeachingIntoList(int lessonIndex, String day) {
		
	
		this.lessonsExpectedNotTeaching.get(day).add(lessonIndex);
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
