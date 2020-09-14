package testNg1.test12.crossBrow;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import util.Commons;

public class TestLogin { 
	WebDriver driver = null;
	
	@Parameters("browser")
	@BeforeMethod
	public void before(String browser) {
		driver = Commons.getDriver(browser);
	}
	
	@Test
	public void t1() throws InterruptedException {
		driver.get("https://gmail.com");
		Thread.sleep(5000);
		driver.close();
	}
}