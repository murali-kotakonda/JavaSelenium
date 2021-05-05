package test15PiDataProvidersEx;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testFb.MyAppBaseTest;

public class TestDataExcel3 extends MyAppBaseTest{

	@BeforeClass
	public void t1() {
		driver.get("https://www.google.com");
	}
	
	@DataProvider(name = "test1")
	public static Object[][] data() throws IOException {
		return ExcelUtils.getTableArray("C://test//data.xlsx", "search");
	}

	@Test(dataProvider = "test1")
	public void testData(String searchKey) throws InterruptedException {
		WebElement searchText = driver.findElement(By.name("q"));
		searchText.clear();
		searchText.sendKeys(searchKey);
	    searchText.submit();
	    Thread.sleep(4000);
	}
	
}
