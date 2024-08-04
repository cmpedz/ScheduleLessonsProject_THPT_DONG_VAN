import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class InsertDataFromTeacherTableManager extends InsertDataFromEachTable{

	@Override
	public void getDataEachRow(Row row) {
		
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
		
		for(String className : classesTaught) {
			
			classes.add(new SchoolClass(className, lessonsPerWeek, lessonsPerYear, specialty));
		}
		
		
		//define teacher infos
		Teacher teacher = new Teacher(teacherName, group, dayOff, classes);
		
		int firstDayWorkingIndex = 0;
		
		int lastDayWorkingIndex = firstDayWorkingIndex + SchoolInformations.getInstance().getDayWorkingList().size();
		
		for(int i = firstDayWorkingIndex; i < lastDayWorkingIndex; i++) {
			
			addUnexpectedLessonsIntoSpecifiedDay(i, row, teacher);
		}
		
		schoolInformations.getCurrentTeacherList().add(teacher);
	}
	
	private void addUnexpectedLessonsIntoSpecifiedDay(int indexDay, Row row, Teacher teacher) {
		
		int exchangeDayIndexIntoDayCellUnit = 5;
		
		int dayDataCell = indexDay + exchangeDayIndexIntoDayCellUnit;
		
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
