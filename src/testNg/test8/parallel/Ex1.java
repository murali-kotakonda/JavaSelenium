package parallel;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.Commons;

public class Ex1 {

	public WebDriver driver;

	@BeforeTest
	public void setup() {
		System.out.println("in setup");
		driver = Commons.getChromeDriver();
	}
	
	@Test
	public void verifyHomepageTitle2() {
		driver.get("https://www.facebook.com");
	}

	@AfterTest
	public void close() {
		driver.quit();
	}
}
