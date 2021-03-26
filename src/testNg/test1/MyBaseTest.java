package testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import util.Commons;

public class MyBaseTest {

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
}
