import java.util.ArrayList;

public class Teacher {
	
	private String name;
		
	private Group group;
	
	private DayOff dayOff;
	
	private ArrayList<SchoolClass> classesTeaching = new ArrayList<SchoolClass>();
	


	public Teacher(String name, Group group, DayOff dayOff, ArrayList<SchoolClass> classesTeaching) {
		super();
		this.name = name;
		this.group = group;
		this.dayOff = dayOff;
		this.classesTeaching = classesTeaching;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public DayOff getDayOff() {
		return dayOff;
	}

	public void setDayOff(DayOff dayOff) {
		this.dayOff = dayOff;
	}

	public ArrayList<SchoolClass> getClassesTeaching() {
		return classesTeaching;
	}

	public void setClassesTeaching(ArrayList<SchoolClass> classesTeaching) {
		this.classesTeaching = classesTeaching;
	}
	
	
	
	
	

}
