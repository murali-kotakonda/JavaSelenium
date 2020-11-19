package test8.parallel;

import org.testng.annotations.Test;

import utils.BaseTest;

public class Ex2 extends BaseTest{
	  @Test
	  public void verifyHomepageTitle2() {
	      driver.get("https://google.com");
	  }
}
