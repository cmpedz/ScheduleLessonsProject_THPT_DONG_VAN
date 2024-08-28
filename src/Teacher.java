import java.util.ArrayList;
import java.util.TreeMap;

public class Teacher {
	
	private final String NAME;
		
	private final String  GROUP;
	
	private String dayOff;

	private int currentDayIndex = 0;
	
	private  TreeMap<String, ArrayList<Integer>>  lessonsExpectedNotTeaching = new TreeMap<String, ArrayList<Integer>>();
	
	
	private ArrayList<SchoolClass> classesTeaching = new ArrayList<SchoolClass>();
	
	private int sumLessonsTeach = 0;
	
	private int leftOverWorkingDays = 0; 
	
	public static final String Error_Group = "Tổ của giáo viên không hợp lệ|";
	
	public static final String Error_DayOff = "Ngày nghỉ của giáo viên không hợp lệ|";

	public Teacher(String name, String group, String dayOff) throws Exception {
		
		super();
		
		this.NAME = name;
		this.GROUP = group;
		this.dayOff = dayOff;
		
		if(!checkValidInfos().equals("")) {
			throw new Exception(checkValidInfos());
		}
		
		for(String day : SchoolInformations.getInstance().getDayWorkingList()) {
			
			lessonsExpectedNotTeaching.put(day, new ArrayList<Integer>());
		}
		
		
		
	}
	
	private String checkValidInfos() {
		
		boolean isGroupExisted = SchoolInformations.getInstance().getGroupsList().contains(GROUP);
		
		boolean isDayOffExisted = SchoolInformations.getInstance().getDayWorkingList().contains(dayOff);
		
		String error = "";
		
		if(!isDayOffExisted) {
			error +=  Error_DayOff;
		}
		
		if(!isGroupExisted) {
			error +=  Error_Group;
		}
		
		return error;
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

	public void addClassTeaching(SchoolClass _class) {
		
		
		sumLessonsTeach += _class.getLessonsPerWeek();

		this.classesTeaching.add(_class);
	}
	
	public void removeClassFromTaughtClasses(SchoolClass mClass) {
		
		this.classesTeaching.remove(mClass);
	}
	
	
	
	public int getSumLessonsTeach() {
		return sumLessonsTeach;
	}
	
	public void decreaseSumLessonsTeach(int quantities) {
		
		this.sumLessonsTeach -= quantities;
	}

	public int getAverageLessonsTeachEachDay() {
		
		if(leftOverWorkingDays <= 0) {
			leftOverWorkingDays = 1;
		}

		int averageLessonsTaughtEachDay = sumLessonsTeach/ leftOverWorkingDays;
		
		if(averageLessonsTaughtEachDay == 0) {
			
			averageLessonsTaughtEachDay = sumLessonsTeach;
			
		}
	
		
		return averageLessonsTaughtEachDay;
	}

	public int getLeftOverWorkingDays() {
		return leftOverWorkingDays;
	}




	public void setLeftOverWorkingDays(int leftOverWorkingDays) {
		this.leftOverWorkingDays = leftOverWorkingDays;
	}

	
	

}
