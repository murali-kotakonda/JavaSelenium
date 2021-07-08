package testFb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ex3Links extends MyAppBaseTest{
	
	@BeforeMethod
	public void openForm() {
		//open the form.html
		driver.get(URL + "links.html");
		sleep(2);
	}
	
	
	//test the page contains only 4 links
	/*
	 How to get the element using the tag name
	 solution)
	 use  driver.findElements(By.tagName("<tag name>"));
	 
	 * */
	@Test
	public void testLinks() {
		 List<WebElement> links = driver.findElements(By.tagName("a"));//multiple web elements
		 
		 //test no of links
		 Assert.assertEquals(links.size() , 8 ,"expected 8 links.");
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
	
	By.linkText("<pass entire text>"):
	-------------------------------------
		WebElement link = driver.findElement(By.linkText("Click Here for Google")); //exact match of link name
		link.click();
		
	 By.partialLinkText("<pass the partial value>"):
	 --------------------------------------------	
		WebElement link = driver.findElement(By.partialLinkText("Google"));//partial match of link name
		link.click();	
	*/

	//<a href="https://www.youtube.com" id="ytUrl">Click here for Youtube</a>
	@Test
	public void testYt() {
		WebElement link = driver.findElement(By.id("ytUrl"));
			Assert.assertTrue(link.isEnabled());
		Assert.assertTrue(link.isDisplayed());
		checkEnabledAndDisplayed(link);
		link.click();
		sleep(3);
	}
	
	
	@Test
	public void Google1() throws InterruptedException {
		WebElement link = driver.findElement(By.linkText("Click here for Google"));
			Assert.assertTrue(link.isEnabled());
		Assert.assertTrue(link.isDisplayed());
		checkEnabledAndDisplayed(link);
		link.click();
		Thread.sleep(3000);
	}
	
	@Test
	public void Google2() throws InterruptedException {
		WebElement link = driver.findElement(By.partialLinkText("Google"));
			Assert.assertTrue(link.isEnabled());
		Assert.assertTrue(link.isDisplayed());
		checkEnabledAndDisplayed(link);
		link.click();
		Thread.sleep(3000);
	}
	
	@Test
	public void testGoogle3() {
		getLinkText("Click here for Google").click();
		sleep(3);
	}
	
	@Test
	public void testGoogle4() {
		getPartialText("Google").click();
		sleep(3);
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
	
}
