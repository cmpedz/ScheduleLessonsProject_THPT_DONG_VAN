import org.apache.poi.ss.usermodel.Row;

public class InsertDataFromSpecialtyTable extends InsertDataFromEachTable {
	
	public final String MORNING = "Sáng";

	@Override
	public void getDataEachRow(Row row) {
		// TODO Auto-generated method stub
		String specialtyName = row.getCell(0).getStringCellValue();
		
		int priority = (int)row.getCell(1).getNumericCellValue();
		
		boolean isInMorning = row.getCell(2).getStringCellValue().equals(MORNING);
		
		int maxLessonContinues = (int)row.getCell(3).getNumericCellValue();
		
		boolean isMainCourse = row.getCell(4).getBooleanCellValue();
		
		String group = row.getCell(5).getStringCellValue();
		
		Speciality speciality = new Speciality(specialtyName, maxLessonContinues, isInMorning, isMainCourse, group, priority);
		
		schoolInformations.getSpecialtyList().put(specialtyName, speciality);
	}

}
