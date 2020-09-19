package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//@BeforeTest : methods under this annotation will be executed prior to the first test case in the TestNG file.

//@AfterTest :methods under this annotation will be executed after all test cases in the TestNG file are executed.

//@BeforeMethod :methods under this annotation will be executed prior to each method in each test case.

//@AfterMethod  :methods under this annotation will be executed after each method in each test case.

public class Ex4 {
	public String baseUrl = "http:\\www.newtours.demoaut.com/";
	public WebDriver driver;
	public String expected = null;
	public String actual = null;

	@BeforeClass
	public void testBeforeClass() {
		System.out.println("befor class");
	}
	
	@AfterClass
	public void testafterClass() {
		System.out.println("after class");
	}
		
	@BeforeTest
	public void beforeTest() {
		System.out.println("launching @BeforeTest browser");
		System.setProperty("webdriver.firefox.marionette", "");
		driver = Commons.getDriver();
		driver.get(baseUrl);
	}

	@BeforeMethod
	public void beforeMethod() {
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 0)
	public void T1() {
		driver.findElement(By.linkText("REGISTER")).click();
		expected = "Register: Mercury Tours";
		actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 1)
	public void T2() {
		driver.findElement(By.linkText("SUPPORT")).click();
		expected = "Under Construction: Mercury Tours";
		actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
	}

	@AfterMethod
	public void afterMethod() {
		driver.findElement(By.linkText("Home")).click();
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
