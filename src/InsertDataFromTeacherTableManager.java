import java.util.ArrayList;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class InsertDataFromTeacherTableManager extends InsertDataFromEachTable{
	
	private final TreeMap<String, Teacher> teachers = new TreeMap<String, Teacher>();
	
	public TreeMap<String, Teacher> getTeachers() {
		return teachers;
	}

	@Override
	public void getDataEachRow(Row row) throws Exception{
		
		int teacherDataCell = 0;
		String teacherName = row.getCell(teacherDataCell).getStringCellValue();
		
		int classDataCell = 1;
		String[] classesTaught = row.getCell(classDataCell).getStringCellValue().split(",");
		
		int specialtyDataCell = 2;
		String specialty = row.getCell(specialtyDataCell).getStringCellValue();
		
		int lessonsPerWeekDataCell = 3;
		int lessonsPerWeek = (int)row.getCell(lessonsPerWeekDataCell).getNumericCellValue();
		
		int lessonsPerYearDataCell = 4;
		int lessonsPerYear = (int)row.getCell(lessonsPerYearDataCell).getNumericCellValue();
		
		int dayOffDataCell = 11;
		String dayOff = row.getCell(dayOffDataCell).getStringCellValue();
		
		int groupDataCell = 12;
		String group = row.getCell(groupDataCell).getStringCellValue();
		
		// define classes taught by this teacher 
		ArrayList<SchoolClass> classes = new ArrayList<SchoolClass>();
		
		boolean isInMorning = SchoolInformations.getInstance().getSpecialtyList().get(specialty).isInMorning();
		
		for(String className : classesTaught) {
			
			classes.add(new SchoolClass(className, lessonsPerWeek, lessonsPerYear, specialty));
			
			QuantitiesLessonsPerClassStorage.getInstance().addQuantitiesLessonsIntoStorage(className, lessonsPerWeek, isInMorning);
			
		}
		
		
		//define teacher infos
		Teacher teacher = new Teacher(teacherName, group, dayOff);
		
		
		
		addLessonsForTeacher(teacher, classes);
		
		
		int firstDayWorkingIndex = 0;
		
		int lastDayWorkingIndex = firstDayWorkingIndex + SchoolInformations.getInstance().getDayWorkingList().size();
		
		for(int i = firstDayWorkingIndex; i < lastDayWorkingIndex; i++) {
			
			addUnexpectedLessonsIntoSpecifiedDay(i, row, teacherName);
		}
		
	}
	
	
	private void addLessonsForTeacher(Teacher teacher, ArrayList<SchoolClass> classes) {
		
		String teacherName = teacher.getNAME();
		
		if(this.teachers.get(teacherName) == null) {
			
			this.teachers.put(teacherName, teacher);
			
		}
		
		for(SchoolClass _class : classes) {
			
			this.teachers.get(teacherName).addClassTeaching(_class);;
		}
		
	}
	
	private void addUnexpectedLessonsIntoSpecifiedDay(int indexDay, Row row, String teacherName) {
		
		int exchangeDayIndexIntoDayCellUnit = 5;
		
		int dayDataCell = indexDay + exchangeDayIndexIntoDayCellUnit;
		
		Teacher teacher = teachers.get(teacherName);
		
		if(teacher == null) return;
		
		Cell unexpectedLessonsDataCell = row.getCell(dayDataCell); 
		
		if(unexpectedLessonsDataCell != null && 
				unexpectedLessonsDataCell.getCellType() != CellType.BLANK) {
			
			String[] unexpectedlessons = unexpectedLessonsDataCell.getStringCellValue().split(",");
			
			
			String specifiedDay = schoolInformations.getDayWorkingList().get(indexDay);
			
			for(String sLesson : unexpectedlessons) {
				
				int iLesson = Integer.parseInt(sLesson);
				
				teacher.addLessonsExpectedNotTeachingIntoList(iLesson - 1, specifiedDay);
				
			}
			
			
			
		}
	}
		

}
