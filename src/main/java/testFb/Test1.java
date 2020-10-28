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

import util.BaseTest;
import util.Commons;

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
	
	@Test
	public void testFN() throws InterruptedException {
	 //<input type="text" id="myname" name="uName">
	 WebElement element = driver.findElement(By.name("uName"));
	 //or
	 //WebElement element1 = driver.findElement(By.id("myname"));
	 
	 //How to check if the text field is enabled
	 assertTrue(element.isEnabled(),"text field should enabled");
	 
	 //How to check if the text field is displayed
	 assertTrue(element.isDisplayed(),"text field should be displayed");
	 
	 //How to check if the field is text field
	 assertEquals(element.getAttribute("type"),"text", "Invalid field type.Expected text");
		 
	 //how to send data to the text field
	 element.sendKeys("learning selenium");
	 Thread.sleep(5000);
	 
	 //how to clear data from the text field
	  element.clear();
	  Thread.sleep(5000);
		 
  }
	
	@Test
	public void testLn1() {
		//<input type="text" name="uName1" readonly="readonly" value="kumar">
		WebElement element = driver.findElement(By.name("uName1"));
		
		 //How to check if the field is text field
		 assertEquals(element.getAttribute("type"),"text", "Invalid field type.Expected text");
		 
		//How to check if the text field is enabled
		 assertTrue(element.isEnabled(),"uName1 should be enabled");
		 
		 //How to check if the text field is displayed
		 assertTrue(element.isDisplayed(),"uName1 should be displayed");
		 
		 //how to validate the existing text box value
		 assertEquals(element.getAttribute("value"),"kumar", "Invalid text value");
		 
		 //how to validate the existing text box is readonly
		 assertEquals(element.getAttribute("readonly"),"true", "expected readonly");
	}
	
	@Test
	public void testSn() {
		//<input type="text" name="uName2" disabled="disabled">
		
		WebElement element = driver.findElement(By.name("uName2"));
		
		//How to check if the field is text field
		assertEquals(element.getAttribute("type"),"text", "Invalid field type.Expected text");
		 
		//How to check if the text field is enabled
		assertFalse(element.isEnabled(),"uName2 should be disabled");
		
		//How to check if the text field is displayed
		assertTrue(element.isDisplayed(),"uName2 should be displayed");
	}
	
	@Test
	public void testLn2() throws InterruptedException {
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
	
	@Test
	public void testPassword() throws InterruptedException {
		//<input type="password" name="password">
		 WebElement element = driver.findElement(By.name("password"));
		 
		//How to check if the password is enabled
		 assertTrue(element.isEnabled(),"password should be enabled");
		 
		 //How to check if the password is displayed
		 assertTrue(element.isDisplayed(),"password should be displayed");
		 
		 //How to check if the field is password
		 assertEquals(element.getAttribute("type"),"password", "Invalid field type.Expected password");
		 
		 //how to send data to the password
		 element.sendKeys("Raju1234345");
		 
		 //how to clear data from the password
		 // element.clear();
		  Thread.sleep(5000);
	}
	
	@Test
	public void testHidden() {
		//<input type="hidden" name="uType" value="agent"/><br><br>      
		WebElement element = driver.findElement(By.name("uType"));

		// How to check if the uType is enabled
		assertTrue(element.isEnabled(), "uType should not be enabled");

		// How to check if the uType is displayed
		assertTrue(!element.isDisplayed(), "uType should not be displayed");

		// How to check if the field is uType
		assertEquals(element.getAttribute("type"), "hidden", "Invalid field type.Expected hidden");
		
		// How to check if the field is uType
		assertEquals(element.getAttribute("value"), "agent", "Expected agent as value");
	}
	
	/*
	Select City
	<select name="city">
	  <option value="hyd">Hyderabad</option>
	  <option value="bang" selected="selected">Bangalore</option>
	  <option value="chen">Chennai</option>
	  <option value="mum">Mumbai</option>
	</select> 
  
  1.How to get webelement?
  WebElement cities = driver.findElement(By.name("city"));
		
  2.Get the wwebelements for all the options in the dropdown.
    //create select obj
		Select select = new Select(cities);
		
		//How to get all the options
		List<WebElement> options  = select.getOptions();
    
  3.How to get the no of options
    int size = options.size();
    
  4.How to get the default selected value
    WebElement selectedCity = select.getFirstSelectedOption();
    selectedCity.getText();// fetches Bangalore
    
  5.How to select option under dropdown?
      There are 3 ways for selecting the option in dropdown
      
     1.select by index . ex: 0 , 1, 2, 3,
	  select.selectByIndex(1);
	  
	  2.select by visible Text . ex: Hyderabad Bangalore or Chennai or Mumbai
	  select.selectByVisibleText("Chennai");
	  
	  3.select by value . ex: hyd , bang, chen , mum
	  select.selectByValue("mum");
    
	*/
	
	@Test
	public void testDropdown() throws InterruptedException {
		WebElement cities = driver.findElement(By.name("city"));
		//create select obj
		Select select = new Select(cities);
		
		assertFalse(select.isMultiple(),"city is not multi dropdown");
		
		//How to get all the options
		List<WebElement> options  = select.getOptions();
		
		//validate the number of cities
		int size = options.size();
		assertEquals(size, 4,"invalid no of cities");
		
		//validate the default value in dropdown
		WebElement selectedCity = select.getFirstSelectedOption();
		
		assertEquals(selectedCity.getText(), "Bangalore","invalid default value");
		
		select.selectByVisibleText("Chennai");
		Thread.sleep(2000);
		
		select.selectByIndex(1);
		Thread.sleep(2000);
		
		select.selectByValue("mum");
		Thread.sleep(2000);
		
		List<String> expectedCities =Arrays.asList("Hyderabad","Bangalore","Chennai","Mumbai");
		List<String> expectedCitiesValues =Arrays.asList("hyd","bang","chen","mum");
		
		int count= 0;
		for(WebElement element :options){
			String visible = element.getText();
			String value= element.getAttribute("value");
			//System.out.println(visible +" - "+value);
			assertEquals(visible ,expectedCities.get(count) ,"invalid city:");
			assertEquals(value ,expectedCitiesValues.get(count) ,"invalid city:");
			count++;
		}
	}
	
	/**
		<select name="citizen" multiple>
		  <option value="IN">India</option>
		  <option value="PAK">Pakistan</option>
		  <option value="US">AMERICA</option>
		  <option value="AUS">AUSTRLIA</option>
		</select>
	 */
	@Test
	public void testMultiDropdown() throws InterruptedException {
		WebElement citizen = driver.findElement(By.name("citizen"));
		
		//create select obj
		Select select = new Select(citizen);
		
		assertEquals(citizen.getAttribute("multiple"),"true","citizen is multi dropdown");
		assertTrue(select.isMultiple(),"citizen is multi dropdown");
		
		//How to get all the options
		List<WebElement> options  = select.getOptions();
		
		//validate the number of citizen
		int size = options.size();
		assertEquals(size, 4,"invalid no of citizen");
		
		List<String> expectedCitizen =Arrays.asList("India","Pakistan","AMERICA","AUSTRLIA");
		List<String> expectedCitizenValues =Arrays.asList("IN","PAK","US","AUS");
		
		//content testing
		int count= 0;
		for(WebElement element :options){
			String visible = element.getText();
			String value= element.getAttribute("value");
			//System.out.println(visible +" - "+value);
			assertEquals(visible ,expectedCitizen.get(count) ,"invalid citizen text:");
			assertEquals(value ,expectedCitizenValues.get(count) ,"invalid citizen value:");
			count++;
		}
		
		//select the values in dropdown
		select.selectByVisibleText("India");
		Thread.sleep(2000);
		
		select.selectByIndex(1);
		Thread.sleep(2000);
		
		select.selectByValue("US");
		Thread.sleep(2000);
		
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		
		//get the selected values
		for(WebElement element :allSelectedOptions){
			String visible = element.getText();
			String value= element.getAttribute("value");
			System.out.println(visible +" - "+value);
		}
		//deselect the values in dropdown
		select.deselectByVisibleText("India");
		Thread.sleep(2000);
		
		select.deselectByIndex(1);
		Thread.sleep(2000);
		
		select.deselectByValue("US");
		Thread.sleep(2000);
		
		//to deselect all
		// select the values in dropdown
		select.selectByVisibleText("India");
		Thread.sleep(2000);

		select.selectByIndex(1);
		Thread.sleep(2000);
				
		select.deselectAll();
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