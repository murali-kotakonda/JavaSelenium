package testNg1.test15PiDataProviders;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Commons;


public class TestDataExcel {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		driver = Commons.getChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@DataProvider(name = "excelData")
	public static Object[][] Authentication() throws Exception {
		Object[][] testObjArray = ExcelUtils.getTableArray("C://data.xlsx", "input");
		return (testObjArray);
	}

	@Test(dataProvider = "excelData")
	public void Registration_data(String name, String pass,String status ) throws Exception {
		System.out.println(name);
		System.out.println(pass);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}