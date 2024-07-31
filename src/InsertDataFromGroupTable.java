import org.apache.poi.ss.usermodel.Row;

public class InsertDataFromGroupTable extends InsertDataFromEachTable {

	@Override
	public void getDataEachRow(Row row) {
		
		String groupHas = row.getCell(0).getStringCellValue();
		
		schoolInformations.getGroupsList().add(groupHas);
		
	}

}
