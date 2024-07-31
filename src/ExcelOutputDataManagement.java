import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelOutputDataManagement {
	
	private static ExcelOutputDataManagement instance;
	
	public static final int MAX_DISTANCE_BETWEEN_TABLE = 12;
	
	public static final int MAX_DISTANCE_BETWEEN_CONTENT_AND_TITLE = 2;
	
	public static final int COLUMN_START_INDEX = 2;
	
	private ExcelOutputDataManagement() {}
	
	public static ExcelOutputDataManagement getInstance() {
		
		if(instance == null) {
			instance = new ExcelOutputDataManagement();
		}
		
		return instance;
	}
	
	public void displayScheduleTableDataIntoExcel(ScheduleEachWeek schedule, Sheet sheet,
			File file) {
		
		for(int i = 0; i< ScheduleEachWeek.MAX_QUANTITIES_DAY_WORKING; i++) {
			
			ScheduleEachDay scheduleADay = schedule.getScheduleEachDays()[i];
			
			int indexCurrentRow = sheet.getFirstRowNum() + MAX_DISTANCE_BETWEEN_TABLE * i + 
					MAX_DISTANCE_BETWEEN_CONTENT_AND_TITLE;
			
			for(int j = 0; j < SchoolInformations.MAX_LESSONS_IN_MORNING + SchoolInformations.MAX_LESSONS_IN_AFTERNOON; j++) {
				
				int _index = indexCurrentRow + j;
				
				addTeacherDataIntoEachClassForCurrentLesson(_index, sheet, scheduleADay, j);
			}
			
			
		}
		
		openExcelInUserDesktop(file);
		
	}
	
	private void addTeacherDataIntoEachClassForCurrentLesson(int indexCurrentRow, Sheet sheet, 
			ScheduleEachDay scheduleADay, int lessonPosition) {
		
		Row evaluatedRow = sheet.getRow(indexCurrentRow);
		
		if(evaluatedRow == null) return;
		
		int indexCell = COLUMN_START_INDEX;
		
		for( String className : SchoolInformations.getInstance().getClassesNameList()) {
			
			Cell evaluatedCell = evaluatedRow.getCell(indexCell);
			
			String value = scheduleADay.getScheduleTable().get(className)[lessonPosition];
			
			if(value != null) {
				
				System.out.println(value);
				
				evaluatedCell.setCellValue(value);
			}
			
			indexCell ++;
		}
		
	}
	
	private void openExcelInUserDesktop(File file) {
		
		if(file == null) {
			return;
		}
		
		if(Desktop.isDesktopSupported()) {
			
			Desktop desktop = Desktop.getDesktop();
			
			if(file.exists()) {
				
				try {
					desktop.open(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
			
		}
	}

}
