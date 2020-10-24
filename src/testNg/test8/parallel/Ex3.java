package test8.parallel;

import org.testng.annotations.Test;

import util.BaseTest;

public class Ex3 extends BaseTest{
	  @Test
	  public void fb() {
	      driver.get("https://fb.com");
	  }
	  
	  @Test
	  public void amazon() {
	      driver.get("https://www.amazon.com");
	  }
}
