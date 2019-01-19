package com.mythri;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import util.DriverUtils;

public class TestNavigation1 {

	
	static WebDriver driver ;
	@BeforeClass
	public static void setup(){
		 driver = DriverUtils.getDriver();
	}
	
	@Test
	public void test() throws InterruptedException {
		

		driver.get("http:\\www.gmail.com");

		driver.navigate().to("http://www.google.co.in");


		driver.navigate().back();// visites gmail


		driver.navigate().forward(); // google


		driver.navigate().refresh(); // refresh google
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

		Assert.assertEquals("Expected google url",true,currentUrl.contains("www.google.co.in"));

		String title = driver.getTitle();
		Assert.assertEquals("Expected google as title","Google India",title);
		
	}
	
	@AfterClass
	public static void clean(){
		driver.close();
	}

}
