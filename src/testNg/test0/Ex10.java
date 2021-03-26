package test0;

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
public class Ex10 { 
	WebDriver driver;
	
	@BeforeMethod
	public void before() {
		 driver = Commons.getChromeDriver();
	}
	
	@AfterMethod
	public void afer() {
		driver.close();
	}
	
	@Test
	public void fb() throws InterruptedException {
		driver.get("http://www.fb.com");
		Thread.sleep(5000);// wait for 5 seconds
	}
	
	@Test
	public void yt()throws InterruptedException {
		driver.get("http://www.youtube.com");
		Thread.sleep(5000);// wait for 5 seconds
	}
	
	@Test
	public void gmail()throws InterruptedException {
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);// wait for 5 seconds
	}
}
