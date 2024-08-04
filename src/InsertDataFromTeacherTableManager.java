import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class InsertDataFromTeacherTableManager extends InsertDataFromEachTable{

	@Override
	public void getDataEachRow(Row row) {
		
		String teacherName = row.getCell(0).getStringCellValue();
		
		String[] classesTaught = row.getCell(1).getStringCellValue().split(",");
		
		String specialty = row.getCell(2).getStringCellValue();
		
		int lessonsPerWeek = (int)row.getCell(3).getNumericCellValue();
		
		int lessonsPerYear = (int)row.getCell(4).getNumericCellValue();
		
		String dayOff = row.getCell(6).getStringCellValue();
		
		String group = row.getCell(7).getStringCellValue();
		
		// define classes taught by this teacher 
		ArrayList<SchoolClass> classes = new ArrayList<SchoolClass>();
		
		for(String className : classesTaught) {
			
			classes.add(new SchoolClass(className, lessonsPerWeek, lessonsPerYear, specialty));
		}
		
		
		//define teacher infos
		Teacher teacher = new Teacher(teacherName, group, dayOff, classes);
		
		Cell lessonAvoidInforsCell = row.getCell(5); 
		
		if(lessonAvoidInforsCell != null && 
				lessonAvoidInforsCell.getCellType() != CellType.BLANK) {
			
			String[] lessonsAvoidTeaching = row.getCell(5).getStringCellValue().split(",");
			
			for(String lI : lessonsAvoidTeaching) {
				
				int lessonIndex = Integer.valueOf(lI);
				System.out.println("Lesson index :" + lessonIndex);
				
				teacher.addLessonsExpectedNotTeachingIntoList(lessonIndex - 1);
			}
			
		}
		

		
		
		schoolInformations.getCurrentTeacherList().add(teacher);
	}
		

}
