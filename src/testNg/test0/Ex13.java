package test0;

import org.testng.annotations.Test;
import util.BaseTest;

/**
  Req:
  Open browser 
  - open  yahoo
  - open google
  - open amazon

 */
public class Ex13 extends BaseTest{ 
	 
	@Test
	public void fb() throws InterruptedException {
		driver.get("http://www.yahoo.com");
		Thread.sleep(3000);// wait for 5 seconds
	}
	
	@Test
	public void yt()throws InterruptedException {
		driver.get("http://www.google.com");
		Thread.sleep(3000);// wait for 5 seconds
	}
	
	@Test
	public void gmail()throws InterruptedException {
		driver.get("http://www.amazon.com");
		Thread.sleep(3000);// wait for 5 seconds
	}
}
