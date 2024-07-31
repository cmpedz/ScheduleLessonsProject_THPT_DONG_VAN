import org.apache.poi.ss.usermodel.Row;

public class InsertDataFromWorkingDaysTable extends InsertDataFromEachTable{

	@Override
	public void getDataEachRow(Row row) {
		// TODO Auto-generated method stub
		String dayWorking = row.getCell(0).getStringCellValue();
		
		schoolInformations.getDayWorkingList().add(dayWorking);
		
	}

}
