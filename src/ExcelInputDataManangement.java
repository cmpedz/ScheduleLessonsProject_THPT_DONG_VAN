import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelInputDataManangement {
	
	private Map<String, InsertDataFromEachTable> dataInsertController = new TreeMap<String, InsertDataFromEachTable>(); 
	
	public static final String TEACHER_TABLE = "Giáo Viên";
	
	public static final String CLASS_TABLE = "Lớp";
	
	public static final String SPECIALITY_TABLE = "Môn Học";
	
	public static final String GROUP_TABLE = "Tổ";
	
	public static final String DAY_WORKING_TABLE = "Ngày Làm Việc";
	
	private static ExcelInputDataManangement instance; 
	
	private ExcelInputDataManangement() {
		
		dataInsertController.put(CLASS_TABLE, new InsertDataFromClassTable());
		
		dataInsertController.put(GROUP_TABLE, new InsertDataFromGroupTable());
		
		dataInsertController.put(DAY_WORKING_TABLE, new InsertDataFromWorkingDaysTable());
		
		dataInsertController.put(SPECIALITY_TABLE, new InsertDataFromSpecialtyTable());
		
		dataInsertController.put(TEACHER_TABLE, new InsertDataFromTeacherTableManager());
		
		
	}
	
	
	public static ExcelInputDataManangement getInstance() {
		if(instance == null) {
			instance = new ExcelInputDataManangement();
		}
		
		return instance;
	}
	
	private boolean checkIsNotEmptyCell(Cell cell) {
		return 	cell != null && cell.getCellType() != CellType.BLANK;
	}
	
	
	public void insertDataFromExcel(Sheet sheet) {
		
		indicateStartAndEndRowForEachTable(sheet);
		
		dataInsertController.get(CLASS_TABLE).insertData(sheet);
		
		dataInsertController.get(DAY_WORKING_TABLE).insertData(sheet);
		
		dataInsertController.get(GROUP_TABLE).insertData(sheet);
		
		dataInsertController.get(SPECIALITY_TABLE).insertData(sheet);
		
		dataInsertController.get(TEACHER_TABLE).insertData(sheet);
		
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
						
						if(sheet.getRow(i) == null) break;
						
					} while(checkIsNotEmptyCell(sheet.getRow(i).getCell(0)));
					
					data.setEndRowTable(i - 1);
					
				}
				
			}
			
		}
	}
		
	
}
