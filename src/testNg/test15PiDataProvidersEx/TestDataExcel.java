package test15PiDataProvidersEx;


import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataExcel {

	@DataProvider(name = "test1")
	public static Object[][] data() throws IOException {
		return ExcelUtils.getTableArray("C://test//data.xlsx", "search");
	}

	@Test(dataProvider = "test1")
	public void testData(String name) {
		System.out.println(name );
	}
	
}
