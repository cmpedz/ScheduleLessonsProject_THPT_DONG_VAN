import java.util.ArrayList;

public class UserUI {
	
	
	public static void main(String[] args) {
		
		ScheduleEachWeek s = new ScheduleEachWeek();
		
		ArrayList<SchoolClass> classesTeached1 = new ArrayList<SchoolClass>();
		
		classesTeached1.add(new SchoolClass("10A1", 2, 100, Speciality.Địa));
		
		classesTeached1.add(new SchoolClass("12B1", 3, 100, Speciality.CD_Địa));
		
		ArrayList<SchoolClass> classesTeached2 = new ArrayList<SchoolClass>();
		
		classesTeached2.add(new SchoolClass("10A1", 3, 100, Speciality.CD_Hóa));
		
		classesTeached2.add(new SchoolClass("10A3", 3, 100, Speciality.CD_Hóa));
		
		classesTeached2.add(new SchoolClass("10A2", 3, 100, Speciality.CD_Hóa));
		
		classesTeached2.add(new SchoolClass("10A4", 3, 100, Speciality.CD_Hóa));
		
		classesTeached2.add(new SchoolClass("10A2", 3, 100, Speciality.Hóa));
		
		classesTeached2.add(new SchoolClass("10A3", 3, 100, Speciality.Hóa));
		
		classesTeached2.add(new SchoolClass("10A1", 3, 100, Speciality.Hóa));
		
		Teacher[] teachers = { new Teacher("Nguyễn Văn A", Group.TỔ_XÃ_HỘI, DayOff.Thứ_Sáu, 
				classesTeached1),
				new Teacher("Nguyễn Văn B", Group.TỔ_TỰ_NHIÊN, DayOff.Thứ_Năm, 
						classesTeached2)
				
		};
		
		
		for(Teacher t : teachers) {
			s.addTeacherIntoList(t);;
		}
		
		s.arrangeLessons();
		
		s.print();
	}
}
