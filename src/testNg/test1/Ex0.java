package test1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import project.Commons;

/**
  Req:
  Open browser hit the fb.com
  Open browser hit the youtube.com
  Open browser hit the gmail.com
  
 */
public class Ex0 {

	@Test
	public void verifyFb() {
		WebDriver  driver = Commons.getChromeDriver();
		driver.get("https://www.fb.com");
		driver.close();
	}
	
	@Test
	public void verifyYT() {
		WebDriver driver = Commons.getChromeDriver();
		driver.get("https://www.youtube.com");
		driver.close();
	}
	
	@Test
	public void verifyGmail() {
		WebDriver driver = Commons.getChromeDriver();
		driver.get("https://www.gmail.com");
		driver.close();
	}
	
}