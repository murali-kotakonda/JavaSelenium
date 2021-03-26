package test0;

import org.testng.annotations.Test;

import util.BaseTest;

/**
  Req:
  Open browser hit the fb.com
  Open browser hit the youtube.com
  Open browser hit the gmail.com

 */
public class Ex12 extends BaseTest{ 
	 
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
