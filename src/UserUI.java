import java.util.ArrayList;

public class UserUI {
	
	
	public static void main(String[] args) {
		
		ScheduleEachWeek s = new ScheduleEachWeek();
		
		ISchoolInformations iSchoolInformations = SchoolInformations.getInstance();
		
		//////////////////////
		
		ArrayList<SchoolClass> classesTeached1 = new ArrayList<SchoolClass>();
		
		classesTeached1.add(new SchoolClass("10A1", 3, 315, iSchoolInformations.getCoursesList().get(ESpeciality.Toán.getIndex()
				)));
		
		classesTeached1.add(new SchoolClass("10A1", 3, 315, iSchoolInformations.getCoursesList().get(ESpeciality.Lý.getIndex()
				)));
		
		classesTeached1.add(new SchoolClass("10A1", 3, 315, iSchoolInformations.getCoursesList().get(ESpeciality.Hóa.getIndex()
				)));
		
		classesTeached1.add(new SchoolClass("11B1", 3, 315, iSchoolInformations.getCoursesList().get(ESpeciality.Văn.getIndex()
				)));
		
		classesTeached1.add(new SchoolClass("11B2", 3, 315, iSchoolInformations.getCoursesList().get(ESpeciality.Văn.getIndex()
				)));
		
		classesTeached1.add(new SchoolClass("11B6", 3, 315, iSchoolInformations.getCoursesList().get(ESpeciality.Văn.getIndex()
				)));
		
		classesTeached1.add(new SchoolClass("12C1", 3, 315, iSchoolInformations.getCoursesList().get(ESpeciality.Văn.getIndex()
				)));
		
		classesTeached1.add(new SchoolClass("12C2", 3, 315,iSchoolInformations.getCoursesList().get(ESpeciality.Văn.getIndex()
				)));
		
		classesTeached1.add(new SchoolClass("12C3", 3, 315, 
				iSchoolInformations.getCoursesList().get(ESpeciality.Văn.getIndex()
						)
				));
		
		//////////////////////
		
		ArrayList<SchoolClass> classesTeached2 = new ArrayList<SchoolClass>();
		
		classesTeached2.add(new SchoolClass("10A1", 3, 315, iSchoolInformations.getCoursesList().get(ESpeciality.Địa.getIndex()
				)));
		
		classesTeached2.add(new SchoolClass("10A1", 3, 315, iSchoolInformations.getCoursesList().get(ESpeciality.GDCD.getIndex()
				)));
		
		classesTeached2.add(new SchoolClass("10A1", 3, 315, iSchoolInformations.getCoursesList().get(ESpeciality.Sử.getIndex()
				)));
		
		classesTeached2.add(new SchoolClass("11B2", 3, 485, iSchoolInformations.getCoursesList().get(ESpeciality.Anh.getIndex())
				));
		
		classesTeached2.add(new SchoolClass("11B1", 3, 485, iSchoolInformations.getCoursesList().get(ESpeciality.Anh.getIndex())
				));
		
		classesTeached2.add(new SchoolClass("10A4", 3, 485, iSchoolInformations.getCoursesList().get(ESpeciality.Anh.getIndex())
				));
		
		classesTeached2.add(new SchoolClass("10A5", 3, 485, iSchoolInformations.getCoursesList().get(ESpeciality.Anh.getIndex())
				));
		
		classesTeached2.add(new SchoolClass("10A6", 3, 485, iSchoolInformations.getCoursesList().get(ESpeciality.Anh.getIndex())
				));
		
//////////////////////
		
ArrayList<SchoolClass> classesTeached3 = new ArrayList<SchoolClass>();

classesTeached2.add(new SchoolClass("11B2", 3, 485, iSchoolInformations.getCoursesList().get(ESpeciality.Anh.getIndex())
	));

classesTeached2.add(new SchoolClass("11B1", 3, 485, iSchoolInformations.getCoursesList().get(ESpeciality.Anh.getIndex())
	));

classesTeached2.add(new SchoolClass("10A4", 3, 485, iSchoolInformations.getCoursesList().get(ESpeciality.Anh.getIndex())
	));

classesTeached2.add(new SchoolClass("10A5", 3, 485, iSchoolInformations.getCoursesList().get(ESpeciality.Anh.getIndex())
	));

classesTeached2.add(new SchoolClass("10A6", 3, 485, iSchoolInformations.getCoursesList().get(ESpeciality.Anh.getIndex())
	));
		
		
		
		Teacher[] teachers = { new Teacher("Mã Đức Bảo", Group.TỔ_XÃ_HỘI, DayOff.Thứ_Năm, 
				classesTeached1),
				new Teacher("Củng Thị Trường", Group.TỔ_XÃ_HỘI, DayOff.Thứ_Năm, 
						classesTeached2)
				
		};
		
		
		for(Teacher t : teachers) {
			s.addTeacherIntoList(t);;
		}
		
		s.arrangeLessons();
		
		s.print();
	}
}
