import java.util.ArrayList;
import java.util.TreeMap;

public class Teacher {
	
	private final String NAME;
		
	private final String  GROUP;
	
	private String dayOff;

	private int currentDayIndex = 0;
	
	private  TreeMap<String, ArrayList<Integer>>  lessonsExpectedNotTeaching = new TreeMap<String, ArrayList<Integer>>();
	
	public static final int MAX_PRIORITY_TYPES = 2;
	
	public static final int HIGH_PRIORITY_TYPE = 0;
	
	public static final int LOW_PRIORITY_TYPE = 1;
	
	private ArrayList<ArrayList<SchoolClass>> classesTeaching = new ArrayList<ArrayList<SchoolClass>>();
	


	public Teacher(String name, String group, String dayOff) {
		
		super();
		this.NAME = name;
		this.GROUP = group;
		this.dayOff = dayOff;
		
		for(int i = 0; i< MAX_PRIORITY_TYPES; i++) {
			classesTeaching.add(new ArrayList<SchoolClass>());
		}
		
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




	public ArrayList<SchoolClass> getClassesTeaching(int priority) {
		
		return classesTeaching.get(priority);
	}

	public void addClassTeaching(SchoolClass _class) {
		
		int priorityClass = _class.getSpeciality().getPriority() - 1;

		this.classesTeaching.get(priorityClass).add(_class);
	}
	
	@Override
	public String toString() {
		String displayText = "\n" + "Teacher Name: " + NAME + "\n" +
							 "Group: " + GROUP + "\n" +
							 "Dayoff: " + dayOff + "\n" +
							 "Lesson Avoid Teaching: " + lessonsExpectedNotTeaching + "\n" +
							 "====== Current Classes Taught ======" + "\n" + "\n";
		
		return displayText;
	}
	
	

}
