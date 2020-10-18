package basics2;

import org.openqa.selenium.WebDriver;

import util.Commons;

/**
 Req:
	Open 2.html and 3.html using the selenium


 */
public class Ex1 {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Commons.getDriver();
		//open the url
		driver.get(Commons.URL+"/2.html");
		Thread.sleep(5000);
		//	close the browser
		driver.quit();
}
}
