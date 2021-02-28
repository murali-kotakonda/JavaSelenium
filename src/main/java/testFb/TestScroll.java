package testFb;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import common.Commons;


/**
 For scroll use the JavascriptExecutor
 
 How to get the JavascriptExecutor
 JavascriptExecutor js = (JavascriptExecutor) driver;
 
 
 How to perform scroll?
 js.executeScript("scrollBy(0, 4500)");
 
 */

public class TestScroll {
	public static void main(String[] args) {
		// Scroll down the webpage by 4500 pixels
		WebDriver driver = Commons.getDriver();
		driver.get("https://www.youtube.com");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 4500)");

		 js.executeScript("scrollBy(0, 4500)");
		 sleep(3);
		 
		 js.executeScript("scrollBy(0, 4500)");
		 sleep(3);

		 
	}
}
