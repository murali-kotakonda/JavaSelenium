package test2.screenshotEx;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import util.BaseTest;
import util.Commons;

/**
  Req:Take screenshot for facebook.
  solution:
  call Commons.takeSnapShot(driver, "C://test//test.png");
 */
public class TestScreenShot extends BaseTest{

	@Test
	public void takeScreenShot() throws Exception {

		WebDriver driver = Commons.getDriver();
		
		// goto url
		driver.get("http://facebook.com");

		// Call take screenshot function
		takeSnapShot("C://test//test.jpeg");
		Thread.sleep(5000);
		
		driver.quit();
	}
}