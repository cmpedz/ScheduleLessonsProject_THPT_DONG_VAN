import org.apache.poi.ss.usermodel.Row;

public class InsertDataFromClassTable extends InsertDataFromEachTable{

	@Override
	public void getDataEachRow(Row row) {
		// TODO Auto-generated method stub
		String classHas = row.getCell(0).getStringCellValue();
		
		schoolInformations.getClassesNameList().add(classHas);
	}

}
