import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelDataInputManangement {
	
	private Map<String, InsertDataFromEachTable> dataInsertController = new TreeMap<String, InsertDataFromEachTable>(); 
	
	public static final String TEACHER_TABLE = "Giáo Viên";
	
	public static final String CLASS_TABLE = "Lớp";
	
	public static final String SPECIALITY_TABLE = "Môn Học";
	
	public static final String GROUP_TABLE = "Tổ";
	
	public static final String DAY_WORKING_TABLE = "Ngày Làm Việc";
	
	private static ExcelDataInputManangement instance; 
	
	private ExcelDataInputManangement() {
		dataInsertController.put(TEACHER_TABLE, new InsertDataFromTeacherTableManager());
	}
	
	
	public static ExcelDataInputManangement getInstance() {
		if(instance == null) {
			instance = new ExcelDataInputManangement();
		}
		
		return instance;
	}
	
	private boolean checkIsNotEmptyCell(Cell cell) {
		return 	cell != null && cell.getCellType() != CellType.BLANK;
	}
	
	
	public void insertDataFromExcel(Sheet sheet) {
		
		indicateStartAndEndRowForEachTable(sheet);
		
		for(String keyName : dataInsertController.keySet()) {
			
			dataInsertController.get(keyName).insertData(sheet);
			
		}
		
	}
	

	
	private void indicateStartAndEndRowForEachTable(Sheet sheet) {
		
		for(int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
			
			Row currentRow = sheet.getRow(i);
			
			if(currentRow == null) continue;
			
			Cell headerCell = currentRow.getCell(0);
			
			if(checkIsNotEmptyCell(headerCell)) {
				
				String tableName = headerCell.getStringCellValue();
				
				InsertDataFromEachTable data = dataInsertController.get(tableName);
				
				if(data != null) {
					
					data.setFirstRowTable(i);
					
					do {
						i++;
					} while(checkIsNotEmptyCell(sheet.getRow(i).getCell(0)));
					
					data.setEndRowTable(i - 1);
					
				}
				
			}
			
		}
	}
	
	public void print() {
		
		for(Teacher teacher : SchoolInformations.getInstance().getCurrentTeacherList()) {
			System.out.println("teacher infos : ");
			System.out.println("Name : " + teacher.getNAME());
			System.out.println("Group : " + teacher.getGROUP());
			System.out.println("Day Off : " + teacher.getDayOff());
			System.out.println("lesson avoid teaching : " + teacher.getLessonAvoidTeaching());
			
			System.out.println("class taught currently :");
			
			for(SchoolClass currentClass : teacher.getClassesTeaching()) {
				System.out.println();
				
				System.out.println(currentClass.getName());
				
				System.out.println(currentClass.getLessonsPerWeek());
				
				System.out.println(currentClass.getLessonPerYear());
			
				
//				System.out.println("Specialty Infors :");
//				System.out.println(currentClass.getSpeciality().getName());
//				System.out.println(currentClass.getSpeciality().getPriority());
//				System.out.println(currentClass.getSpeciality().getMaxContinuesLessonCanTeach());
//				System.out.println(currentClass.getSpeciality().getGROUP());
//				
//				System.out.println();
			}
		}
	}
	

	
}
