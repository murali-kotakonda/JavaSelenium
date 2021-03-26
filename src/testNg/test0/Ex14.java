package test0;

import org.testng.annotations.Test;
import util.BaseTest;

/**
  Req:
  Open browser 
  - open google
  - take screenshot
  
 */
public class Ex14 extends BaseTest{ 
	 
	@Test
	public void google()throws Exception {
		driver.get("https://www.google.com");
		takeSnapShot("C://test//test.jpeg");
		Thread.sleep(3000);// wait for 5 seconds
	}
}
