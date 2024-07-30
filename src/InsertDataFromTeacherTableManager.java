import java.util.ArrayList;

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
		Teacher teacher = new Teacher(teacherName, group, dayOff, classes, 0);
		
		schoolInformations.getCurrentTeacherList().add(teacher);
	}
		

}
