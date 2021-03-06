package test1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.Commons;

/**
Req:
Open browser hit the fb.com
Open browser hit the youtube.com
Open browser hit the gmail.com

*/
public class Ex1 {
	
	WebDriver  driver ;
	
	/**
	 this method is executed before every test method .
	 this method contains the common execution for every test case [executed at first. ]
	 
	 */
	@BeforeMethod
	public void setup() {
		System.out.println("in setup");
		driver = Commons.getChromeDriver();
	}
	
	/**
	 this method is executed after every test method .
	 this method contains the common execution for every test case  [executed at last. ]
	 */
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
