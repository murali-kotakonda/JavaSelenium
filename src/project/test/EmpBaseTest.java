package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import common.Commons;

public class EmpBaseTest {
	public WebDriver driver;
	
	@AfterTest
	public void quit() {
		Commons.quitBrowser(driver);
	}
}
