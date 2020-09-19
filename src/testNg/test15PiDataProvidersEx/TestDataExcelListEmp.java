package test15PiDataProvidersEx;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Commons;


public class TestDataExcelListEmp {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		driver = Commons.getChromeDriver();
	}

	@DataProvider(name = "excelData")
	public static Object[][] Authentication() throws Exception {
		Object[][] testObjArray = ExcelUtils.getLoginObjs("C://data.xlsx", "input");
		return (testObjArray);
	}

	@Test(dataProvider = "excelData")
	public void Registration_data(Login login) throws Exception {
		System.out.println(login.getName());
		System.out.println(login.getPass());
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}