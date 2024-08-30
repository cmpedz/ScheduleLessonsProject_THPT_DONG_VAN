import java.util.ArrayList;
import java.util.Map;

public interface ISchoolInformations {

	public Map<String, Course> getSpecialtyList();
	
	public ArrayList<String> getGroupsList();
	
	public ArrayList<String> getClassesNameList();
	
	public ArrayList<String> getDayWorkingList();
	
	public ArrayList<Teacher> getCurrentTeacherList();
}
