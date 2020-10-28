package testFb;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import util.Commons;

public class TestScroll {
	public static void main(String[] args) {
		// Scroll down the webpage by 4500 pixels
		WebDriver driver = Commons.getDriver();
		driver.get("https://www.youtube.com");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 4500)");
	}
}
