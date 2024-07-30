import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class SchoolInformations implements ISchoolInformations{
	
	private static SchoolInformations instance = null;
	
	private final Map<String, Speciality> SPECIALTY_LIST = new TreeMap<String, Speciality>();
	
	private final ArrayList<String> GROUPS = new ArrayList<String>();
	
	private final ArrayList<String> CLASSES = new ArrayList<String>();
	
	private final ArrayList<String> DAY_WORKING = new ArrayList<String>();
	
	private final ArrayList<Teacher> TEACHERS = new ArrayList<Teacher>();
	
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
	public ArrayList<String> getGroupsList() {
		// TODO Auto-generated method stub
		
			return instance.GROUPS;
		
	}



	@Override
	public ArrayList<String> getClassesNameList() {
		// TODO Auto-generated method stub
		
			return instance.CLASSES;
		
	}

	@Override
	public ArrayList<String> getDayWorkingList() {
		// TODO Auto-generated method stub
		
			return instance.DAY_WORKING;
		
	}

	@Override
	public ArrayList<Teacher> getCurrentTeacherList() {
		// TODO Auto-generated method stub
	
			return instance.TEACHERS;
		
	}

	@Override
	public Map<String, Speciality> getSpecialtyList() {
		// TODO Auto-generated method stub
		
		return instance.SPECIALTY_LIST;
	}


}
