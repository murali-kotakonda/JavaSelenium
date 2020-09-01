package testNg1.test9.listen;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import util.Commons;

@Listeners(MyListener.class)	
public class MyTest {
	  @Test
	  public void verifyHomepageTitle1() {
		  WebDriver driver  = Commons.getChromeDriver();
	      driver.get("https://google.com");
	      driver.close();
	  }
	  
	  @Test
	  public void verifyHomepageTitle2() {
		  WebDriver driver  = Commons.getChromeDriver();
	      driver.get("https://www.facebook.com");
	      driver.close();
	  }
}
