package test15PiDataProvidersEx;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.BaseTest;
 
public class Ex5readExcelGoogle_working extends BaseTest{

	@DataProvider(name = "test1")
	public static Object[][] data() throws IOException {
		 return ExcelUtils.getTableArray("C:\\test\\data.xlsx", "search");
	}
	
	@Test(dataProvider = "test1")
	public void testData(String searchKey) throws InterruptedException {
		driver.get("https://www.google.com");
		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys(searchKey);
        searchText.submit();
        Thread.sleep(5000);
	}
}