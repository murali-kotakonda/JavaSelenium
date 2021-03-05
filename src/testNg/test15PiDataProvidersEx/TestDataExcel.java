package test15PiDataProvidersEx;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/*
admin	admin123	pass
admin1	admin1_123	fail
admin2	admin1_124	pass
admin3	admin1_125	fail
admin4	admin1_126	pass
*/
public class TestDataExcel {

	@DataProvider(name = "excelData")
	public static Object[][] Authentication() throws Exception {
		return ExcelUtils.getTableArray("C://test//data.xlsx", "output");
	}

	@Test(dataProvider = "excelData")
	public void Registration_data(String name, String pass,String status ) throws Exception {
		System.out.println(name);
		System.out.println(pass);
		System.out.println(status);
	}
}