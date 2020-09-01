package testNg1.test9.listen;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import util.Commons;

public class Ex2 {
	   public String baseUrl = "https://google.com";
	     
	  @Test
	  public void t1() {
		  WebDriver driver  = Commons.getChromeDriver();
	      driver.get(baseUrl);
	      driver.close();
	  }
	  
	  @Test
	  public void t2() {
		  WebDriver driver  = Commons.getChromeDriver();
	      driver.get("https://www.facebook.com");
	      driver.close();
	  }
}
