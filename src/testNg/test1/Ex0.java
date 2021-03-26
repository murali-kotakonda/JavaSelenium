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
public class Ex0 {

	@Test
	public void verifyFb() throws InterruptedException {
		WebDriver  driver = Commons.getChromeDriver();
		driver.get("https://www.fb.com");
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test
	public void verifyYT() throws InterruptedException {
		WebDriver driver = Commons.getChromeDriver();
		driver.get("https://www.youtube.com");
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test
	public void verifyGmail() throws InterruptedException {
		WebDriver driver = Commons.getChromeDriver();
		driver.get("https://www.gmail.com");
		Thread.sleep(3000);
		driver.close();
	}
	
}