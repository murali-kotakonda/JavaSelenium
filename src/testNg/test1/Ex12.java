package test1;

import org.testng.annotations.Test;

/**
  Req:
  Open browser hit the fb.com
  Open browser hit the youtube.com
  Open browser hit the gmail.com
  
 */
public class Ex12 extends MyBaseTest{
	
	@Test
	public void testFb() throws InterruptedException {
		// Open the URL
		driver.get("https://www.fb.com");

		// wait for 5 sleep
		Thread.sleep(3000);
	}
	
	@Test
	public void testYt() throws InterruptedException {
		// Open the URL
		driver.get("https://www.youtube.com");

		// wait for 5 sleep
		Thread.sleep(3000);
	}
	
	@Test
	public void testGmail() throws InterruptedException {
		// Open the URL
		driver.get("https://www.gmail.com");

		// wait for 5 sleep
		Thread.sleep(3000);
	}
	
}