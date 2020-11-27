package test8.parallel;

import org.testng.annotations.Test;

import common.BaseTest;

public class Ex1 extends BaseTest{
	  
	  @Test
	  public void verifyHomepageTitle2() {
	      driver.get("https://www.facebook.com");
	  }
}
