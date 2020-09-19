package test15PiDataProvidersEx;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestDPExcel {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		driver = util.Commons.getChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@DataProvider(name = "excelData")
	public static Object[][] Authentication() throws Exception {
		Object[][] testObjArray = ExcelUtils.getTableArray("C://data.xlsx", "output");
		return (testObjArray);
	}

	@Test(dataProvider = "excelData")
	public void Registration_data(String id, String name, String age) throws Exception {
		System.out.println(id);
		System.out.println(name);
		System.out.println(age);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}