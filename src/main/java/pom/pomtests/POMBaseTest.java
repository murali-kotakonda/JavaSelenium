package pom.pomtests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import util.Commons;

public class POMBaseTest {
	public WebDriver driver;
	
	@AfterTest
	public void quit() {
		Commons.quitBrowser(driver);
	}
	
	@BeforeTest
	public void start() {
		driver = Commons.startApplication(driver, "Chrome");
	}
	
	public  static void checkEnabledAndDisplayed(WebElement... elements) {
		for (WebElement element : elements) {
			assertTrue(element.isDisplayed(), "element expeceted to display");
			assertTrue(element.isEnabled(), "element expected to enable");
		}
	}
	
	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
