package test8.parallelEx;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.Commons;

public class Ex2 {
	  
	public WebDriver driver;

	@BeforeTest
	public void setup() {
		System.out.println("in setup");
		driver = Commons.getChromeDriver();
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
	
	  @Test
	  public void google() {
	      driver.get("https://www.google.com");
	  }
}
