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


 
Meeting ID: 881 7508 2546
Passcode: 456790
One tap mobile
+12532158782,,88175082546#,,,,*456790# US (Tacoma)
+13017158592,,88175082546#,,,,*456790# US (Washington DC)

Dial by your location
        +1 253 215 8782 US (Tacoma)
        +1 301 715 8592 US (Washington DC)
        +1 312 626 6799 US (Chicago)
        +1 346 248 7799 US (Houston)
        +1 669 900 6833 US (San Jose)
        +1 929 205 6099 US (New York)
Meeting ID: 881 7508 2546
Passcode: 456790
Find your local number: https://us02web.zoom.us/u/kcznRLj5I
