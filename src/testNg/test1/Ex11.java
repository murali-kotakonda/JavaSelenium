package testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.Commons;

/**
  Req:
  Open browser hit the fb.com
  Open browser hit the youtube.com
  Open browser hit the gmail.com
  
 */
public class Ex11 {
	
	// get driver
	WebDriver driver; 
			
	@BeforeClass
	public void openDriver() {
		// get driver
		driver = Commons.getChromeDriver();
	}
	
	@AfterClass
	public void closeDriver() {
		// close the browser
		driver.quit();
	}
	
	@Test
	public void testFb() throws InterruptedException {
		// Open the URL
		driver.get("https://www.fb.com");

		// wait for 5 sleep
		Thread.sleep(3000);
	}
	
	@Test
	public void testYt() throws InterruptedException {
		// Open the URL
		driver.get("https://www.youtube.com");

		// wait for 5 sleep
		Thread.sleep(3000);
	}
	
	@Test
	public void testGmail() throws InterruptedException {
		// Open the URL
		driver.get("https://www.gmail.com");

		// wait for 5 sleep
		Thread.sleep(3000);
	}
	
}