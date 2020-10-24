package test15PiDataProvidersEx;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestDataExcelListEmp {

	@DataProvider(name = "excelData")
	public static Object[][] Authentication() throws Exception {
		return ExcelUtils.getLoginObjs("C://test//data.xlsx", "input");
	}

	@Test(dataProvider = "excelData")
	public void Registration_data(Login login) throws Exception {
		System.out.println(login.getName());
		System.out.println(login.getPass());
	}
}