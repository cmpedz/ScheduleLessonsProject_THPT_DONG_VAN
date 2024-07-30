import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;

public class ExcelIOManagement {
	
	private static final String INPUT_SHEET_NAME = "input";
	
	private static final String OUTPUT_SHEET_NAME = "output";
	
	private static final String EXCEL_DATA_PATH = "src/excel_resources/excel_data.xlsx";
	
	private FileInputStream input_file = null;
	
	private Workbook work_book;
	
	private static ExcelIOManagement instance;
	
	private ExcelIOManagement() {
		
		/* - bên trong try dường như các thuộc tính của đổi tượng từ lớp đó, hay cả của lớp đó 
		 * đều không được nhận dạng, => cần phải khởi tạo thuộc tính mới
		 * - có thể check nhiều try cùng lúc bằng việc phân tách bới ";" giữa các điều kiện cần check
		 * */
		
		/* - FileOutputStream outputFile = new FileOutputStream(path);
		 * - với cách khởi tạo trên thì nếu chưa tồn tại, thì java sẽ khởi tạo file đó theo địa chỉ đường dẫn
		 * - Nếu đã có rồi thì toàn bộ dữ liệu muốn in ra file đó sẽ được java ghi đè hẳn file mới lên file cũ
		 * - Nếu chỉ muốn thay thế dữ liệu mà không cần ghi đè file thì thêm điều kiện true sau path (điều kiện cho phép append hay không)
		 * 
		 * 
		 * */
		try(FileInputStream inputFile = new FileInputStream(EXCEL_DATA_PATH)){
			
			
			if(inputFile != null) {
				
				this.input_file = inputFile;
				
				this.work_book = new XSSFWorkbook(inputFile);
			}
			
			
			
			System.out.println("intitiate file and work_book successful !");
			
		} catch(IOException e) {
			
			e.printStackTrace();
		}
			
		
	}
	
	public static void main(String[] args) {
		ExcelIOManagement.getInstance().print();
	}
	
	public void print() {
		Sheet sheet = this.work_book.getSheet(INPUT_SHEET_NAME);
		
		ExcelDataInputManangement.getInstance().insertDataFromExcel(sheet);
		
		ExcelDataInputManangement.getInstance().print();
	}
	
	
	
	public static ExcelIOManagement getInstance() {
		if(instance == null) {
			instance = new ExcelIOManagement();
		}
		
		return instance;
	}
	
	
}
