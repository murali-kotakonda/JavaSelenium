package test1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import util.Commons;

/**
  Req:
  Open browser hit the fb.com
  Open browser hit the youtube.com
  Open browser hit the gmail.com

 */
public class Ex00 { 
	
	@Test
	public void fb() throws InterruptedException {
		WebDriver driver = Commons.getChromeDriver();
		driver.get("http://www.fb.com");
		Thread.sleep(5000);// wait for 5 seconds
		driver.close();
	}
	
	@Test
	public void yt()throws InterruptedException {
		WebDriver driver = Commons.getChromeDriver();
		driver.get("http://www.youtube.com");
		Thread.sleep(5000);// wait for 5 seconds
		driver.close();
	}
	
	@Test
	public void gmail()throws InterruptedException {
		WebDriver driver = Commons.getChromeDriver();
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);// wait for 5 seconds
		driver.close();
	}
}
