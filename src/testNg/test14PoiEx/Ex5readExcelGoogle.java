package test14PoiEx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import test15PiDataProvidersEx.ExcelUtils;
import util.BaseTest;


public class Ex5readExcelGoogle extends BaseTest{

	@DataProvider(name = "excelData")
	public static Object[][] Authentication() throws Exception {
		return ExcelUtils.getTableArray("C://test//data.xlsx", "output");
	}

	@Test(dataProvider = "excelData")
	public void Registration_data(String name, @Optional("")String pass,@Optional("")String status ) throws Exception {
		driver.get("https://www.google.com");
		WebElement searchText = driver.findElement(By.name("q"));
        searchText.sendKeys(name);
        searchText.submit();
        Thread.sleep(5000);
	}
}