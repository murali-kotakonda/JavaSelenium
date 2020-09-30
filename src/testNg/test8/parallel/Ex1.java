package test8.parallel;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import util.Commons;

public class Ex1 {
	  
	  @Test
	  public void verifyHomepageTitle2() {
		  WebDriver driver  = Commons.getChromeDriver();
	      driver.get("https://www.facebook.com");
	      driver.close();
	  }
}
