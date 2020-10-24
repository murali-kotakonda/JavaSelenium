package test15PiDataProvidersEx;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


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