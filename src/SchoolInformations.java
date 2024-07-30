import java.util.ArrayList;
import java.util.TreeMap;

public class SchoolInformations implements ISchoolInformations{
	
	private static SchoolInformations instance = null;
	
	
	private final ArrayList<Speciality> COURSE_LIST = new ArrayList<Speciality>();
	
	private final ArrayList<String> GROUPS = new ArrayList<String>();
	
	private final ArrayList<String> CLASSES = new ArrayList<String>();
	
	private final ArrayList<String> DAY_WORKING = new ArrayList<String>();
	
	public static final int MAX_LESSONS_IN_MORNING = 5;
	
	public static final int MAX_LESSONS_IN_AFTERNOON = 3;
	
	private SchoolInformations() {};
	
	public static SchoolInformations getInstance() {
		
		if(instance == null) {
			instance = new SchoolInformations();
		}
		
		return instance;
	}



	@Override
	public ArrayList<Speciality> getCoursesList() {
		// TODO Auto-generated method stub
		
		if(instance != null) {
			return instance.COURSE_LIST;
		}
		
		return null;
	}



	@Override
	public ArrayList<String> getGroupsList() {
		// TODO Auto-generated method stub
		if(instance != null) {
			return instance.GROUPS;
		}
		
		return null;
	}



	@Override
	public ArrayList<String> getClassesNameList() {
		// TODO Auto-generated method stub
		if(instance != null) {
			return instance.CLASSES;
		}
		return null;
	}

	@Override
	public ArrayList<String> getDayWorkingList() {
		// TODO Auto-generated method stub
		if(instance != null) {
			return instance.DAY_WORKING;
		}
		return null;
	}


}
