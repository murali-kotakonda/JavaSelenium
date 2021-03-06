package testpom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import util.Commons;

public class EmpBaseTest {
	public WebDriver driver;
	
	@AfterTest
	public void quit() {
		Commons.quitBrowser(driver);
	}
}
