import java.util.ArrayList;
import java.util.TreeMap;

public class SchoolInformations implements ISchoolInformations{
	
	private static SchoolInformations instance = null;
	
	
	private final ArrayList<Speciality> COURSE_LIST = new ArrayList<Speciality>();
	
	private final ArrayList<Group> GROUPS = new ArrayList<Group>();
	
	private final ArrayList<String> CLASSES = new ArrayList<String>();
	
	public static final int MAX_LESSONS_IN_MORNING = 5;
	
	public static final int MAX_LESSONS_IN_AFTERNOON = 3;
	
	private SchoolInformations() {
		
		//construct data for courses
		COURSE_LIST.add( new Speciality("CD_Hóa", 2, true, false, Group.TỔ_TỰ_NHIÊN));
		ESpeciality.CD_Hóa.setIndex(0);
		
		COURSE_LIST.add(new Speciality("CD_Lý", 2, true, false, Group.TỔ_TỰ_NHIÊN));
		ESpeciality.CD_Lý.setIndex(1);
		
		COURSE_LIST.add(new Speciality("CD_Sinh", 2, true, false, Group.TỔ_TỰ_NHIÊN));
		ESpeciality.CD_Sinh.setIndex(2);
		
		COURSE_LIST.add(new Speciality("CD_Sử", 2, true, false, Group.TỔ_XÃ_HỘI));
		ESpeciality.CD_Sử.setIndex(3);
		
		COURSE_LIST.add(new Speciality("CD_Toán", 2, true, false, Group.TỔ_TỰ_NHIÊN));
		ESpeciality.CD_Toán.setIndex(4);
		
		COURSE_LIST.add(new Speciality("CD_Văn", 2, true, false, Group.TỔ_XÃ_HỘI));
		ESpeciality.CD_Văn.setIndex(5);
		
		COURSE_LIST.add(new Speciality("CD_Địa", 2, true, false, Group.TỔ_XÃ_HỘI));
		ESpeciality.CD_Địa.setIndex(6);
		
		COURSE_LIST.add(new Speciality("CN", 1, true, false, Group.TỔ_TỰ_NHIÊN));
		ESpeciality.CN.setIndex(7);
		
		COURSE_LIST.add(new Speciality("GDKT_PL", 1, false, false, Group.TỔ_XÃ_HỘI));
		ESpeciality.GDKT_PL.setIndex(8);
		
		COURSE_LIST.add(new Speciality("GDĐP", 1, false, false, Group.TỔ_XÃ_HỘI));
		ESpeciality.GDĐP.setIndex(9);
		
		COURSE_LIST.add(new Speciality("Hóa", 1, true, false, Group.TỔ_TỰ_NHIÊN));
		ESpeciality.Hóa.setIndex(10);
		
		COURSE_LIST.add(new Speciality("HĐTN", 1, false, false, Group.TỔ_XÃ_HỘI));
		ESpeciality.HĐTN.setIndex(11);
		
		COURSE_LIST.add(new Speciality("Lý", 1, true, false, Group.TỔ_TỰ_NHIÊN));
		ESpeciality.Lý.setIndex(12);
		
		COURSE_LIST.add(new Speciality("Sinh", 1, true, false, Group.TỔ_TỰ_NHIÊN));
		ESpeciality.Sinh.setIndex(13);
		
		COURSE_LIST.add(new Speciality("Tin", 1, true, false, Group.TỔ_TỰ_NHIÊN));
		ESpeciality.Tin.setIndex(14);
		
		COURSE_LIST.add(new Speciality("Địa", 1, true, false, Group.TỔ_XÃ_HỘI));
		ESpeciality.Địa.setIndex(15);
		
		COURSE_LIST.add(new Speciality("Văn", 2, true, true, Group.TỔ_XÃ_HỘI));
		ESpeciality.Văn.setIndex(16);
		
		COURSE_LIST.add(new Speciality("Anh", 2, true, true, Group.TỔ_XÃ_HỘI));
		ESpeciality.Anh.setIndex(17);
		
		COURSE_LIST.add(new Speciality("Toán", 2, true, true, Group.TỔ_TỰ_NHIÊN));
		ESpeciality.Toán.setIndex(18);
		
		
		
		//construct data for groups
		GROUPS.add(Group.BAN_GIÁM_HIỆU);
		
		GROUPS.add(Group.TỔ_TỰ_NHIÊN);
		
		GROUPS.add(Group.TỔ_XÃ_HỘI);
		
		for(int i = 0; i< GROUPS.size(); i++) {
			GROUPS.get(i).setIndex(i);
		}
		
		//construct data for classes 
		for(int i = 0; i < 3; i++) {
			
		   int classNumber = 10 + i;
		   
		   int classChar = 'A' + i;
		   
		   for(int j = 1; j <= 7; j++) {
			   
			   String className = classNumber + "" + (char)classChar + "" + j ;
			   
			   CLASSES.add(className);
			   
			   if(i == 2 && j == 6) {
				   break;
			   }
		   }
		}
		
		
	 
		
	}
	
	
	
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
	public ArrayList<Group> getGroupsList() {
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


}
