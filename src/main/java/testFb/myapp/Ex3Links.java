package testFb.myapp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.BaseTest;
import util.Commons;

public class Ex3Links {
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void openForm() {
		driver = Commons.getChromeDriver();
		//open the form.html
		driver.get(Commons.BASE_URL + "links.html");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
	}
	
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	//test the page contains only 4 links
	/*
	 How to get the elemnt using the tag name
	 solution)
	 use  driver.findElements(By.tagName("<tag name>"));
	 
	 * */
	@Test
	public void testLinks() {
		 List<WebElement> links = driver.findElements(By.tagName("a"));//multiple web elements
		 
		 //test no of links
		 Assert.assertEquals(links.size() , 4,"expected 4 links.");
	}
	
	
	/*  
	<a href="https://www.google.com">Click Here for Google</a>
	
	How to click on link?
	solution)
	1.get the web element object
	2.call the click method.
	
	We have two approaches to .get the web element object for link?
		a) By.linkText("")
		b) By.partialLinkText("")
		
		WebElement link = driver.findElement(By.linkText("Click Here for Google")); //exact match of link name
		WebElement plink = driver.findElement(By.partialLinkText("Google"));//partial match of link name
		
		link.click();
		plink/click();
	   */
	@Test
	public void testLink1_LinkText() throws InterruptedException {
		WebElement link = driver.findElement(By.linkText("Click Here for Google"));
		checkEnabledAndDisplayed(link);
		link.click();
		Thread.sleep(3000);
	}
	
	@Test
	public void testLink1_PartialText() throws InterruptedException {
		WebElement link = driver.findElement(By.partialLinkText("Google"));
		checkEnabledAndDisplayed(link);
		link.click();
		Thread.sleep(3000);
	}
	
	//  <a href="Ex2.html">Click Here for Ex2</a>
	@Test
	public void testLink2() throws InterruptedException {
		WebElement link = driver.findElement(By.linkText("Click Here for Ex2"));
		checkEnabledAndDisplayed(link);
		link.click();
		Thread.sleep(3000);
	}
	
	//	<a id="gLink1" href=""    onclick="window.open('https://www.fb.com',    'newwindow', 
    //'width=700,height=750'); 
	@Test
	public void testLink4() throws InterruptedException {
		WebElement link = driver.findElement(By.linkText("Open Window"));
		checkEnabledAndDisplayed(link);
		link.click();
		Thread.sleep(3000);
	 }
	
	//<a href="https://www.gmail.com" target="_blank">Click Here for Gmail</a>
	@Test
	public void testLink5() throws InterruptedException {
		WebElement link = driver.findElement(By.linkText("Click Here for Gmail"));
		checkEnabledAndDisplayed(link);
		link.click();
		Thread.sleep(3000);
	}
	
	public void checkEnabledAndDisplayed(WebElement ... elements ) {
		for(WebElement element : elements) {
			// How to check if the text field is enabled
			Assert.assertTrue(element.isEnabled(), "Field should be enabled");

			// How to check if the text field is displayed
			Assert.assertTrue(element.isDisplayed(), "Field should be Displayed");
		}
	}
}
