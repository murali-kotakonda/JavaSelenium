package testFb;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import util.Commons;


/**
 For scroll use the JavascriptExecutor
 
 How to get the JavascriptExecutor
 JavascriptExecutor js = (JavascriptExecutor) driver;
 
 
 How to perform scroll?
 js.executeScript("scrollBy(0, 4500)");
 
 */

public class TestScroll {
	public static void main(String[] args) throws InterruptedException {
		// Scroll down the webpage by 4500 pixels
		WebDriver driver = Commons.getDriver();
		driver.get("https://www.youtube.com");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 4500)");

		 js.executeScript("scrollBy(0, 4500)");
		 Thread.sleep(3);
		 
		 js.executeScript("scrollBy(0, 4500)");
		 Thread.sleep(3);
	}
}
