package testFb.myapp;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.BaseTest;
import util.Commons;

public class Ex1 extends BaseTest{
	
	@BeforeMethod
	public void openForm() {
		//open the form.html
		driver.get(Commons.BASE_URL + "form.html");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
	}
	
	/**
	 using webelement obj :
	   -> actions
	   -> assertions
	 * @throws InterruptedException 
	 */
	@Test
	public void t1() throws InterruptedException {
		//<input type="text" id="myname" name="uName">
		 WebElement element = driver.findElement(By.name("uName"));
		 
		 //How to check if the text field is enabled
		 Assert.assertTrue(element.isEnabled() ,"fn should be enabled");
		 
		 //How to check if the text field is displayed
		 Assert.assertTrue(element.isDisplayed(),"fn should be enabled");
		 
		 //How to check if the field is text field
		 Assert.assertEquals(element.getAttribute("type") , "text");
		 
 		 //how to send data to the text field
		 element.sendKeys("Raj Kumar");
		 
		 Thread.sleep(5000);
		 
		 //how to clear data from the text field
		 // element.clear();
		 
	}
	
	
	@Test
	public void testSurName() {
		//<input type="text" name="uName2" disabled="disabled">
		
		WebElement element = driver.findElement(By.name("uName2"));
		
		//How to check if the field is text field
		Assert.assertEquals(element.getAttribute("type"),"text", "Invalid field type.Expected text");
		 
		//How to check if the text field is enabled
		Assert.assertFalse(element.isEnabled(),"uName2 should be disabled");
		
		//How to check if the text field is displayed
		Assert.assertTrue(element.isDisplayed(),"uName2 should be displayed");
	}
	
	//<input type="text" name="LName" size="30" width="30">
	@Test
	public void testLastName() throws InterruptedException {
		//get web element obj
		WebElement element = driver.findElement(By.name("LName"));
		
		//How to check if the text field is enabled
		 Assert.assertTrue(element.isEnabled() ,"LName should be enabled");
		 
		 //How to check if the text field is displayed
		 Assert.assertTrue(element.isDisplayed(),"LName should be Displayed");
		 
		 //How to check if the field is text field
		 Assert.assertEquals(element.getAttribute("type") , "text");

		 	//How to check width
		 Assert.assertEquals(element.getAttribute("width") , "30");
		 
		 //How to check size
		 Assert.assertEquals(element.getAttribute("size") , "30");

		 
		//How to check if the field is text field has WIDTH as 30
		 //assertEquals(element.getAttribute("width"),"30", "Invalid width.");
		
		 //how to send data to the text field
		 element.sendKeys("my last name");
		 
		 //how to clear data from the text field
		 // element.clear();
		 
		 Thread.sleep(5000);
	}
	
	//<input type="text" name="uName1" readonly="readonly" value="kumar">
	@Test
	public void testMiddleName() throws InterruptedException {

		WebElement element = driver.findElement(By.name("uName1"));

		// How to check if the text field is enabled
		Assert.assertTrue(element.isEnabled(), "Middle name should be enabled");

		// How to check if the text field is displayed
		Assert.assertTrue(element.isDisplayed(), "Middle name should be Displayed");

		// How to check if the field is text field
		Assert.assertEquals(element.getAttribute("type"), "text");
		
		// How to assert the value
		Assert.assertEquals(element.getAttribute("value"), "kumar");
		
		// How to assert the readonly
		Assert.assertEquals(element.getAttribute("readonly"), "true");
		
	}
	
	
	//<input type="password" name="password">
	@Test
	public void testPassword() throws InterruptedException {
		
		 WebElement element = driver.findElement(By.name("password"));
		 
		//How to check if the password is enabled
		 Assert.assertTrue(element.isEnabled(),"password should be enabled");
		 
		 //How to check if the password is displayed
		 Assert.assertTrue(element.isDisplayed(),"password should be displayed");
		 
		 //How to check if the field is password
		 Assert.assertEquals(element.getAttribute("type"),"password", "Invalid field type.Expected password");
		 
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
		Assert.assertTrue(element.isEnabled(), "uType should not be enabled");

		// How to check if the uType is displayed
		Assert.assertTrue(!element.isDisplayed(), "uType should not be displayed");

		// How to check if the field is uType
		Assert.assertEquals(element.getAttribute("type"), "hidden", "Invalid field type.Expected hidden");
		
		// How to check if the field is uType
		Assert.assertEquals(element.getAttribute("value"), "agent", "Expected agent as value");
	}
	
	
	/**
	  Proofs:
		<input type="checkbox" name="proof1" value="passport">passport &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="checkbox" name="proof2" value="voter">voter &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="checkbox" name="proof3" value="pan" checked> pan<br>
		<br><br>
		
		How to get the web element based on attribute?
		------------------------------------------------
		List<WebElement> checks = driver.findElements(By.xpath("//input[@type='checkbox']"));  // fetch the weblement that has 'checkbox' as attribute for the input tag
		
		
		How to check/uncheck the checkbox?
		use click() method
	 */
	@Test
	public void testCheckBox1() throws InterruptedException {
		// fetch web elements based on attribute
		//validate no of check boxes
		List<WebElement> checks = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int size = checks.size();
		assertEquals(size, 3, "invalid no of check boxes");

		// content test
		List<String> expectedChecks = Arrays.asList("voter", "pan", "passport");
		for (WebElement element : checks) {
			String checkValue = element.getAttribute("value");
			assertTrue(expectedChecks.contains(checkValue));
		}

		WebElement passport = driver.findElement(By.name("proof1"));
		WebElement voter = driver.findElement(By.name("proof2"));
		WebElement pan = driver.findElement(By.name("proof3"));

		Assert.assertEquals(passport.getAttribute("type"), "checkbox");
		Assert.assertEquals(voter.getAttribute("type"), "checkbox");
		Assert.assertEquals(pan.getAttribute("type"), "checkbox");

		// checkEnabledAndDisplayed
		Assert.assertTrue(passport.isEnabled(), "passport should  enabled");
		Assert.assertTrue(voter.isEnabled(), "voter should  enabled");
		Assert.assertTrue(pan.isEnabled(), "pan should be enabled");

		Assert.assertFalse(passport.isSelected(), "passport is not selected.");
		Assert.assertFalse(voter.isSelected(), "voter is not selected.");
		Assert.assertTrue(pan.isSelected(), "pan is  selected.");

		// unchek pan
		pan.click();

		Thread.sleep(2000);
		
		// select voter
		voter.click();
		
		Thread.sleep(2000);
		// select passport
		passport.click();
		
		Thread.sleep(2000);
	}

	/**
	     How to know if the radio button is selected or not?
  		use element.isSelected() -> returns true/false
  
  	How to know if the web element is radio button?
   		element.getAttribute("type") should return "radio"
   
   	How to select a radio button
   		element.click()
	 * @throws InterruptedException 
   
	 */
	@Test
	public void testRadio() throws InterruptedException {
		// <input type="radio" name="gender" id="mRadio" value="male" checked> Male<br>
	   //  <input type="radio" name="gender" id="fRadio" value="female"> Female<br>
		// <input type="radio" name="gender" id="oRadio" value="other"> Other
		List<WebElement> radios = driver.findElements(By.name("gender"));
		int size = radios.size();
		Assert.assertEquals(size, 3, "Invalid no of radios for gender");

		// content test
		List<String> expectedGenerValues = Arrays.asList("male", "female", "other");
		for (WebElement element : radios) {
			String genderValue = element.getAttribute("value");
			Assert.assertTrue(expectedGenerValues.contains(genderValue));
		}
		
		//get specific
		WebElement mRadio = driver.findElement(By.id("mRadio"));
		WebElement fRadio = driver.findElement(By.id("fRadio"));
		WebElement oRadio = driver.findElement(By.id("oRadio"));
		
		Assert.assertEquals(mRadio.getAttribute("type"), "radio");
		Assert.assertEquals(fRadio.getAttribute("type"), "radio");
		Assert.assertEquals(oRadio.getAttribute("type"), "radio");

		// checkEnabledAndDisplayed
		Assert.assertTrue(mRadio.isEnabled() && mRadio.isDisplayed(), "mRadio should be enabled and displayed");
		Assert.assertTrue(fRadio.isEnabled() && fRadio.isDisplayed(), "fRadio should be enabled and displayed");
		Assert.assertTrue(oRadio.isEnabled() && oRadio.isDisplayed(), "oRadio should be enabled and displayed");
		

		Assert.assertTrue(mRadio.isSelected(), "mRadio is selected.");
		Assert.assertFalse(fRadio.isSelected(), "fRadio is not selected.");
		Assert.assertFalse(oRadio.isSelected(), "oRadio is not selected.");
		
		// how to select radio button
		oRadio.click();
		Thread.sleep(2000);
		
		// how to select radio button
		fRadio.click();
		Thread.sleep(2000);
		
		// how to select radio button
		mRadio.click();
		Thread.sleep(2000);
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
		
  2.Get the all the options in the dropdown.
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


	  How to check if the dropdown is single/multiple?
	  select.isMultiple()

    
	*/
	
	@Test
	public void testDropdown() throws InterruptedException {
		WebElement cities = driver.findElement(By.name("city"));


		// How to check if the password is enabled
		Assert.assertTrue(cities.isEnabled(), "cities should be enabled");

		// How to check if the password is displayed
		Assert.assertTrue(cities.isDisplayed(), "cities should be displayed");
		


		//create select obj
		Select select = new Select(cities);
		
		Assert.assertFalse(select.isMultiple(),"city is not multi dropdown");
		
		//How to get all the options
		List<WebElement> options  = select.getOptions();
		
		//validate the number of cities
		int size = options.size();
		Assert.assertEquals(size, 4,"invalid no of cities");
		
		//validate the default value in dropdown
		WebElement selectedCity = select.getFirstSelectedOption();
		
		Assert.assertEquals(selectedCity.getText(), "Bangalore","invalid default value");
		
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
			Assert.assertEquals(visible ,expectedCities.get(count) ,"invalid city:");
			Assert.assertEquals(value ,expectedCitiesValues.get(count) ,"invalid city:");
			count++;
		}
	}
	
	/*
	  Citizenship: 
	
	<select name="citizen" multiple>
			<option value="IN">India</option>
			<option value="PAK">Pakistan</option>
			<option value="US">America</option>
			<option value="AUS">Australia</option>
  </select> 
  
   1.How to test if the dropdown is multiple?
   select.isMultiple()-> returns true/false
   
   2.How to deselect option under multi dropdown?
        There are 3 ways for deselecting the option in dropdown
        
          1.deselect by index . ex: 0 , 1, 2, 3,
    		select.deselectByIndex(1);
          
          2.deselect by visible Text . ex: Hyderabad Bangalore or Chennai or Mumbai
          	select.deselectByVisibleText("Chennai");
          	
          3.deselect by value . ex: hyd , bang, chen , mum
          	select.deselectByValue("mum");
	 */
          	
	@Test
	public void testMultiDropdown() throws InterruptedException {
		WebElement citizen = driver.findElement(By.name("citizen"));
		// How to check if the citizen is enabled
		Assert.assertTrue(citizen.isEnabled(), "citizen should be enabled");

		// How to check if the citizen is displayed
		Assert.assertTrue(citizen.isDisplayed(), "citizen should be displayed");
		
		//create select obj
		Select select = new Select(citizen);
		
		Assert.assertEquals(citizen.getAttribute("multiple"),"true","citizen is multi dropdown");
		Assert.assertTrue(select.isMultiple(),"citizen is multi dropdown");
		
			// How to get all the options
		List<WebElement> options = select.getOptions();
		// validate the number of cities
		int size = options.size();
		Assert.assertEquals(size, 4, "invalid no of options");
							
		
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


			//validate the number of citizen
		int size = options.size();
		assertEquals(size, 4,"invalid no of citizen");
		
		List<String> expectedCitizen =Arrays.asList("India","Pakistan","America","Australia");
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
	}

}
