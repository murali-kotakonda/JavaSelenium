package testFb;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.BaseTest;
import common.Commons;

public class Test1 extends BaseTest{

	@BeforeMethod
	public void setup() {
		super.setup();
		//driver.get("http://localhost:8081/myapp/form.html");
		driver.get(Commons.BASE_URL+"form.html"); 
		 assertEquals(driver.getTitle(), "my form page","Invalid title");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 using webelement obj :
	   -> actions
	   -> assertions
	 * @throws InterruptedException 
	 */

	   
	
	@Test
	public void testLName() throws InterruptedException {
		//<input type="text" name="LName" size="30" width="30">
		 WebElement element = driver.findElement(By.name("LName"));
		 
		//How to check if the text field is enabled
		 assertTrue(element.isEnabled(),"text field should enabled");
		 
		 //How to check if the text field is displayed
		 assertTrue(element.isDisplayed(),"text field should be displayed");
		 
		 //How to check if the field is text field
		 assertEquals(element.getAttribute("type"),"text", "Invalid field type.Expected text");
		 
		//How to check if the field is text field has size as 30
		 assertEquals(element.getAttribute("size"),"30", "Invalid field size.");
		 
		//How to check if the field is text field has WIDTH as 30
		 //assertEquals(element.getAttribute("width"),"30", "Invalid width.");
			 
		 //how to send data to the text field
		 element.sendKeys("Raju");
		 
		 //how to clear data from the text field
		 // element.clear();
		  Thread.sleep(5000);
	}
	
	
	/**
	//How to get web element usin tag name
	use method driver.findElements(By.tagName("a"))
	
	
	//How to get web element for link
	<a href="https://www.gmail.com">click here for next link</a>
	
	Two approaches
	approach 1:  WebElement l2 = driver.findElement(By.LinkText("click here for next link")) ; // Pass the entire link text
	approach 2:  WebElement l2 = driver.findElement(By.partialLinkText("click here")) ; pass only the partial link
	 
	 */
	@Test
	public void testLinks() throws InterruptedException {
		// <a href="ex1.html">open for Next page</a><br/>
		// <a href="https://www.gmail.com">click here for next link</a>

		// verify the no of links on page
		List<WebElement> links = driver.findElements(By.tagName("a")); // 'a' is the tag name for the link ; this method
																		// fetches all links
		assertEquals(links.size(), 2, "invalid no of links:");

		// verify link text
		List<String> linkTexts = Arrays.asList("open for Next page", "click here for Next link");
		for (WebElement element : links) {
			String text = element.getText();
			Assert.assertTrue("misisng link " + text, linkTexts.contains(text));
			testLinkWorking(element);
		}

		// get specific link element
		WebElement l1 = driver.findElement(By.linkText("open for Next page")); //get link obj using the link text
		assertTrue(l1.getAttribute("href").endsWith("ex1.html"), "invalid url:");
		
		//how to click on link
		l1.click();
		// Commons.checkEnabledanddisplayed("open for Next page", l1);
		// Common.checkEnabledanddisplayed("click here for next link", l2);
	
		assertEquals(driver.getTitle(), "Google", "invalid title:");
		Thread.sleep(5000);
		driver.navigate().back();

		WebElement l2 = driver.findElement(By.partialLinkText("click here"));
		assertTrue(l2.getAttribute("href").endsWith("gmail.com/"), "invalid url:");
		l2.click();
		
		assertEquals(driver.getTitle(), "page for 3.html", "invalid title:");
	}
}