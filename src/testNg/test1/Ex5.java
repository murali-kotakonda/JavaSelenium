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

public class Ex5 {
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
	String driverPath = "C:\\geckodriver.exe";
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
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}

	@Test(priority = 0)
	public void T1() {
		System.out.println("T1");
	}

	@Test(priority = 1)
	public void T2() {
		System.out.println("T2");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest");
	}
}
