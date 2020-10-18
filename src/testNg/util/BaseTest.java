package util;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.out.println("in setup");
		driver = Commons.getChromeDriver();
	}

	@AfterMethod
	public void close() {
		driver.close();
		System.out.println("driver closed");
	}

}
