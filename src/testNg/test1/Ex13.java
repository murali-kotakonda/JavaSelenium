package testng;

import org.testng.annotations.Test;

/**
  Req:
  Open browser hit the amazon.com
  Open browser hit the flipkart.com
  Open browser hit the ajio.com
  
 */
public class Ex13 extends MyBaseTest{
	
	@Test
	public void testFb() throws InterruptedException {
		// Open the URL
		driver.get("https://www.amazon.com");

		// wait for 5 sleep
		Thread.sleep(3000);
	}
	
	@Test
	public void testYt() throws InterruptedException {
		// Open the URL
		driver.get("https://www.flipkart.com");

		// wait for 5 sleep
		Thread.sleep(3000);
	}
	
	@Test
	public void testGmail() throws InterruptedException {
		// Open the URL
		driver.get("https://www.ajio.com");

		// wait for 5 sleep
		Thread.sleep(3000);
	}
	
}