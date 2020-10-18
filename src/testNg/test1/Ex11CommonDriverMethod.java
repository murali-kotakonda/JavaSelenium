package test1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.Commons;

 
/**
  understand @BeforeMethod , @AfterMethod , @Test.
 */
public class Ex11CommonDriverMethod { 
	
	WebDriver  driver ;
	
	@BeforeMethod
	public void setup() {
		System.out.println("in setup");
		driver = Commons.getDriver();
	}
	
	@AfterMethod
	public void close() {
		driver.close();
		System.out.println("driver closed");
	}
	
	@Test
	public void verifyFb() {
		driver.get("https://www.fb.com");
	}
	
	@Test
	public void verifyYT() {
		driver.get("https://www.youtube.com");
	}
	
	@Test
	public void verifyGmail() {
		driver.get("https://www.gmail.com");
	}
}
