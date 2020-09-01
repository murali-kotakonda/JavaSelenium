package testNg1.test8.parallel;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import util.Commons;

public class Ex2 {
	  @Test
	  public void verifyHomepageTitle2() {
		  WebDriver driver  = Commons.getChromeDriver();
	      driver.get("https://google.com");
	      driver.close();
	  }
}
