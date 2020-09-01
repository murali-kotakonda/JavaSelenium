package testNg1.test11.parallelTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import util.Commons;

public class TestLogin2 { 
	
	@Test
	public void t1() throws InterruptedException {
		System.out.println("t1");
		WebDriver driver = Commons.getChromeDriver();
		driver.get("http://google.com");
		Thread.sleep(5000);
		driver.close();
	}
}