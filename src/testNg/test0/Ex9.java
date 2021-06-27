package test0;

import org.testng.annotations.Test;

public class Ex9 {

	 
	@Test
	public void fb() throws InterruptedException {
		 WebDriver driver = Commons.getChromeDriver();
		driver.get("http://www.fb.com");
		Thread.sleep(5000);// wait for 3 seconds
		driver.close();
	}
	
	@Test
	public void yt()throws InterruptedException {
		 WebDriver driver = Commons.getChromeDriver();
		driver.get("http://www.youtube.com");
		Thread.sleep(5000);// wait for 3 seconds
		driver.close();
	}
	
	@Test
	public void gmail()throws InterruptedException {
		 WebDriver driver = Commons.getChromeDriver();
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);// wait for 3 seconds
		driver.close();
	}
}
