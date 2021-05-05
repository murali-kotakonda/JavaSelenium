package  test7.dataProvier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.BaseTest;
 
public class TestDataProvider4Google extends BaseTest{

	@DataProvider(name = "test1")
	public static Object[][] data() {
		return new Object[][] {
			{ "java " }, 
			{ "selenium" }, 
			{ "selenium interview questions" }, 
			{ "how to download selenium driver" },
			{ "selenium data provider example" } };
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
