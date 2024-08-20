import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public abstract class InsertDataFromEachTable {
	
	protected int firstRowTable;
	
	protected int endRowTable;
	
	private final int DISTANCE_BETWEEN_CONTENT_TITLE = 2;
	
	protected SchoolInformations schoolInformations = SchoolInformations.getInstance();

	
	public void insertData(Sheet sheet) {
		
		for(int i = firstRowTable + DISTANCE_BETWEEN_CONTENT_TITLE; i <= endRowTable; i++) {
			
			Row currentRow = sheet.getRow(i); 
			
			try {
				getDataEachRow(currentRow);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("row error : " + currentRow.getRowNum());
			}
			
		}
		
	}
	
	public abstract void getDataEachRow(Row row) throws Exception;

	public int getFirstRowTable() {
		return firstRowTable;
	}

	public void setFirstRowTable(int firstRowTable) {
		this.firstRowTable = firstRowTable;
	}

	public int getEndRowTable() {
		return endRowTable;
	}

	public void setEndRowTable(int endRowTable) {
		this.endRowTable = endRowTable;
	}
	
	

}
