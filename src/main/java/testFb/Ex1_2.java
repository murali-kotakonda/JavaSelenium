package testFb;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.BaseTest;
import util.Commons;

public class Ex1_2 extends BaseTest{
	
	@BeforeClass
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
		 WebElement element = getTextFieldByName ("uName");
		 
 		 //how to send data to the text field
		 element.sendKeys("Raj Kumar");
		 
		 Thread.sleep(5000);
		 
	}
	
	//<input type="text" name="LName" size="30" width="30">
	@Test
	public void testLastName() throws InterruptedException {
		//get web element obj
		 WebElement element = getTextFieldByName ("LName");
		 
		 //how to send data to the text field
		 element.sendKeys("my last name");
		 
		 Thread.sleep(5000);
	}
	
	//<input type="text" name="uName1" readonly="readonly" value="kumar">
	@Test
	public void testMiddleName() throws InterruptedException {
		WebElement element = getTextFieldByName ("uName1");
		
		// How to assert the value
		Assert.assertEquals(element.getAttribute("value"), "kumar");
		
		// How to assert the readonly
		Assert.assertEquals(element.getAttribute("readonly"), "true");
	}
	
	//<input type="text" name="uName2" disabled="disabled">
	@Test
	public void testSurName() throws InterruptedException {
		
		WebElement element = driver.findElement(By.name("uName2"));
		
		//How to check if the text field is enabled
		 Assert.assertFalse(element.isEnabled() ,"surname should not be enabled");
		 
		 //How to check if the text field is displayed
		 Assert.assertTrue(element.isDisplayed(),"surname should be Displayed");
		 
		 //How to check if the field is text field
		 Assert.assertEquals(element.getAttribute("type") , "text");
	}
	
	//<input type="password" name="password">
	@Test
	public void testpassword() throws InterruptedException {
		//get web element obj
		 WebElement element = getPasswordByName("password");
		 
		 //how to send data to the text field
		 element.sendKeys("helllo@123");
		 
		 Thread.sleep(5000);
	}
	
	/* 
	 <input type="radio" name="gender" id="mRadio" value="male" checked="">
	 <input type="radio" name="gender" id="fRadio" value="female">
	 <input type="radio" name="gender" id="oRadio" value="other">
	 */
	@Test
	public void testRadio() throws InterruptedException {
		//test the gender contains only 3 radio buttons
	
		//size test
		List<WebElement> radios = driver.findElements(By.name("gender"));
		int size = radios.size();
		Assert.assertEquals(size, 3);
		 
		// content test for value 
		List<String> expectedValues = Arrays.asList("male","female","other");
		for(WebElement radio : radios) {
			String actualValue = radio.getAttribute("value");
			checkEnabledAndDisplayed(radio); //enable and displayed testing
			Assert.assertEquals(radio.getAttribute("type"), "radio"); //type testing
			Assert.assertTrue(expectedValues.contains(actualValue) ,actualValue+" is not expected ."); //content test for value
		}
		
		//get specific
		WebElement mRadio = driver.findElement(By.id("mRadio"));
		WebElement fRadio = driver.findElement(By.id("fRadio"));
		WebElement oRadio = driver.findElement(By.id("oRadio")); 
		
		//test by default male is selected
		Assert.assertTrue(mRadio.isSelected());
		Assert.assertFalse(fRadio.isSelected());
		Assert.assertFalse(oRadio.isSelected());
		
		// how to select radio button
		fRadio.click();
		Thread.sleep(2000);
		
		// how to select radio button
		oRadio.click();
		Thread.sleep(2000);

		// how to select radio button
		mRadio.click();
		Thread.sleep(2000);
	}
	
	/*  
	 	<input type="checkbox" name="proof1" value="passport">passport &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<input 	type="checkbox" name="proof2" value="voter">voter &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<input type="checkbox" name="proof3" value="pan" checked> pan
		
		How to get the web element based on attribute?
		------------------------------------------------
		List<WebElement> checks = driver.findElements(By.xpath("//input[@type='checkbox']"));  // fetch the weblement that has 'checkbox' as attribute for the input tag
		
	  */
	@Test
	public void testCheckBox() throws InterruptedException {
		// fetch web elements based on attribute
		//validate no of check boxes
		List<WebElement> checks = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int size = checks.size();
		Assert.assertEquals(size, 3, "invalid no of check boxes");
		
		
		// content test for value
		List<String> expectedValues = Arrays.asList("passport", "voter", "pan");
		for (WebElement check : checks) {
			String actualValue = check.getAttribute("value");
			checkEnabledAndDisplayed(check); // enable and displayed testing
			Assert.assertTrue(expectedValues.contains(actualValue), actualValue + " is not expected ."); // content test
		}

		//specific 
		WebElement passport = driver.findElement(By.name("proof1"));
		WebElement voter = driver.findElement(By.name("proof2"));
		WebElement pan = driver.findElement(By.name("proof3"));
		
		//test by default male is selected
		Assert.assertFalse(passport.isSelected());
		Assert.assertFalse(voter.isSelected());
		Assert.assertTrue(pan.isSelected());
		
		// how to select check button
		passport.click();
		Thread.sleep(2000);
		
		// how to select check button
		voter.click();
		Thread.sleep(2000);

		// how to unselect check button
		pan.click();
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
	
	   1.How to get web element?
	    WebElement cities = driver.findElement(By.name("city"));
	   
	   2.Get the all the options in the dropdown.
	   //create select obj
	    Select select = new Select(cities);
	    
       //get all the options
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
	public void testCityDropDown() throws InterruptedException {
		WebElement cities = driver.findElement(By.name("city"));

		//get options
		Select select = new Select(cities);

		List<WebElement> options = select.getOptions();

		//size testing
		int size = options.size();
		Assert.assertEquals(size, 5, "invalid no of cities");
		
		//validate the default value in dropdown
		WebElement selectedCity = select.getFirstSelectedOption();
		Assert.assertEquals(selectedCity.getText(), "Bangalore");
		
		
		// content test for value
		List<String> expectedCities =Arrays.asList("Hyderabad","Bangalore","Chennai","Mumbai","Pune");
		List<String> expectedCitiesValues =Arrays.asList("hyd","bang","chen","mum","pune");
		
		for (WebElement check : options) {
			String value = check.getAttribute("value");
			String visible = check.getText();
			
			Assert.assertTrue(expectedCities.contains(visible), value + " is not expected ."); // content test
			Assert.assertTrue(expectedCitiesValues.contains(value), value + " is not expected ."); // content test
		}
		
		//select dropdown values
		select.selectByVisibleText("Chennai");
		Thread.sleep(2000);
		
		select.selectByIndex(1);
		Thread.sleep(2000);

		select.selectByValue("mum");
		Thread.sleep(2000);
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

		//get options
		Select select = new Select(citizen);

		List<WebElement> options = select.getOptions();

		//size testing
		int size = options.size();
		Assert.assertEquals(size, 4, "invalid no of citizenship");
		
		// content test for value
		List<String> expectedCitizen =Arrays.asList("India","Pakistan","America","Australia");
		List<String> expectedCitizenValues =Arrays.asList("IN","PAK","US","AUS");
		for (WebElement check : options) {
			String value = check.getAttribute("value");
			String visible = check.getText();
			System.out.println(  visible +" _ "+ value);
			Assert.assertTrue(expectedCitizen.contains(visible), visible + " is not expected ."); // content test
			Assert.assertTrue(expectedCitizenValues.contains(value), value + " is not expected ."); // content test
		}
		
		//select the values in dropdown
		select.selectByVisibleText("India");
		Thread.sleep(2000);
		
		select.selectByIndex(1);
		Thread.sleep(2000);
		
		select.selectByValue("US");
		Thread.sleep(2000);

		//deselect the values in dropdown
		select.deselectByVisibleText("India");
		Thread.sleep(2000);

		select.deselectByIndex(1);
		Thread.sleep(2000);

		select.deselectByValue("US");
		Thread.sleep(2000);
		
	}
	
	
	
}
