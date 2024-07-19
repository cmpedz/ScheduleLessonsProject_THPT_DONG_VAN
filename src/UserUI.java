import java.util.ArrayList;

public class UserUI {
	
	
	public static void main(String[] args) {
		
		ScheduleEachWeek s = new ScheduleEachWeek();
		
		//////////////////////
		
		ArrayList<SchoolClass> classesTeached1 = new ArrayList<SchoolClass>();
		
		classesTeached1.add(new SchoolClass("11B1", 3, 315, SchoolInformations.getInstance().COURSE_LIST.get(ESpeciality.Văn.getIndex()
				)));
		
		classesTeached1.add(new SchoolClass("11B2", 3, 315, SchoolInformations.getInstance().COURSE_LIST.get(ESpeciality.Văn.getIndex()
				)));
		
		classesTeached1.add(new SchoolClass("11B6", 3, 315, SchoolInformations.getInstance().COURSE_LIST.get(ESpeciality.Văn.getIndex()
				)));
		
		classesTeached1.add(new SchoolClass("12C1", 3, 315, SchoolInformations.getInstance().COURSE_LIST.get(ESpeciality.Văn.getIndex()
				)));
		
		classesTeached1.add(new SchoolClass("12C2", 3, 315,SchoolInformations.getInstance().COURSE_LIST.get(ESpeciality.Văn.getIndex()
				)));
		
		classesTeached1.add(new SchoolClass("12C3", 3, 315, 
				SchoolInformations.getInstance().COURSE_LIST.get(ESpeciality.Văn.getIndex()
						)
				));
		
		//////////////////////
		
		ArrayList<SchoolClass> classesTeached2 = new ArrayList<SchoolClass>();
		
		classesTeached2.add(new SchoolClass("10A1", 3, 100, SchoolInformations.getInstance().COURSE_LIST.get(ESpeciality.Hóa.getIndex())
				));
		
		classesTeached2.add(new SchoolClass("10A3", 3, 100, SchoolInformations.getInstance().COURSE_LIST.get(ESpeciality.Hóa.getIndex())
				));
		
		classesTeached2.add(new SchoolClass("10A2", 3, 100, SchoolInformations.getInstance().COURSE_LIST.get(ESpeciality.Hóa.getIndex())
				));
		
		classesTeached2.add(new SchoolClass("10A4", 3, 100, SchoolInformations.getInstance().COURSE_LIST.get(ESpeciality.Hóa.getIndex())
				));
		
		classesTeached2.add(new SchoolClass("10A2", 3, 100, SchoolInformations.getInstance().COURSE_LIST.get(ESpeciality.Hóa.getIndex())
				));
		
		classesTeached2.add(new SchoolClass("10A3", 3, 100, SchoolInformations.getInstance().COURSE_LIST.get(ESpeciality.Hóa.getIndex())
				));
		
		classesTeached2.add(new SchoolClass("10A1", 3, 100, SchoolInformations.getInstance().COURSE_LIST.get(ESpeciality.Hóa.getIndex())
				));
		
		Teacher[] teachers = { new Teacher("Mã Đức Bảo", Group.TỔ_XÃ_HỘI, DayOff.Thứ_Năm, 
				classesTeached1),
				new Teacher("Nguyễn Văn B", Group.TỔ_TỰ_NHIÊN, DayOff.Thứ_Ba, 
						classesTeached2)
				
		};
		
		
		for(Teacher t : teachers) {
			s.addTeacherIntoList(t);;
		}
		
		s.arrangeLessons();
		
		s.print();
	}
}
