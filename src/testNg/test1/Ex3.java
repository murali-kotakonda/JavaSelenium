package testNg1.test1;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ex3 {
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
	public WebDriver driver;

	//@BeforeTest : methods under this annotation will be executed prior to the first test case in the TestNG file.

	// @AfterTest :methods under this annotation will be executed after all test cases in the TestNG file are executed.
	
	 @BeforeTest
     public void launchBrowser() {
         driver = Commons.getDriver();
         driver.get(baseUrl);
     }
     
     @AfterTest
     public void terminateBrowser(){
         driver.close();
     }
     
	@Test(priority = 1)
	public void T1() {
		System.out.println("2");
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 0)
	public void T2() {
		System.out.println("1");
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 5)
	public void T3() {
		Assert.fail();
	}
}
