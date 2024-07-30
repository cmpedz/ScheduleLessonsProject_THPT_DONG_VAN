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
		
		System.out.println("==================================");
		
		System.out.println(teacherName);
		
		for(String className : classesTaught) {
			System.out.print(className + " ");
		}
		
		System.out.println();
		
		System.out.println(specialty);
		
		System.out.println(lessonsPerWeek);
		
		System.out.println(lessonsPerYear);
		
		System.out.println(dayOff);
		
		System.out.println("==================================");
	}

}
