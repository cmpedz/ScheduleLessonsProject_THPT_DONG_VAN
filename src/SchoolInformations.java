import java.util.ArrayList;
import java.util.TreeMap;

public class SchoolInformations {
	
	private static SchoolInformations instance = null;
	
	private SchoolInformations() {
		
		COURSE_LIST.add(Speciality.CD_Hóa);
		
		COURSE_LIST.add(Speciality.CD_Lý);
		
		COURSE_LIST.add(Speciality.CD_Sinh);
		
		COURSE_LIST.add(Speciality.CD_Sử);
		
		COURSE_LIST.add(Speciality.CD_Toán);
		
		COURSE_LIST.add(Speciality.CD_Văn);
		
		COURSE_LIST.add(Speciality.CD_Địa);
		
		COURSE_LIST.add(Speciality.CN);
		
		COURSE_LIST.add(Speciality.GDKT_PL);
		
		COURSE_LIST.add(Speciality.GDĐP);
		
		COURSE_LIST.add(Speciality.Hóa);
		
		COURSE_LIST.add(Speciality.HĐTN);
		
		COURSE_LIST.add(Speciality.Lý);
		
		COURSE_LIST.add(Speciality.Sinh);
		
		COURSE_LIST.add(Speciality.Tin);
		
		COURSE_LIST.add(Speciality.Địa);
		
		for(int i = 0; i < COURSE_LIST.size(); i++) {
			COURSE_LIST.get(i).setIndex(i);
		}
		
		GROUPS.add(Group.BAN_GIÁM_HIỆU);
		GROUPS.add(Group.TỔ_TỰ_NHIÊN);
		GROUPS.add(Group.TỔ_XÃ_HỘI);
		
		for(int i = 0; i< GROUPS.size(); i++) {
			GROUPS.get(i).setIndex(i);
		}
		
		for(int i = 0; i < 2; i++) {
			
		   int classNumber = 10 + i;
		   
		   for(int j = 1; j <= 7; j++) {
			   String className = classNumber + "A" + j;
			   CLASSES.add(className);
		   }
		}
		
		for(int i = 1; i < 7; i++) {
			String className = "12B" + i;
			CLASSES.add(className);
		}
		
	}
	
	
	
	public static SchoolInformations getInstance() {
		
		if(instance == null) {
			instance = new SchoolInformations();
		}
		
		return instance;
	}
	
	public final ArrayList<Speciality> COURSE_LIST = new ArrayList<Speciality>();
	
	public final ArrayList<Group> GROUPS = new ArrayList<Group>();
	
	public final ArrayList<String> CLASSES = new ArrayList<String>();
	
	public static final int MAX_LESSONS_IN_MORNING = 5;
	
	public static final int MAX_LESSONS_IN_AFTERNOON = 3;

}
