package testFb;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import old.BaseTest;
import util.Commons;

public class Test1 extends BaseTest{

	@BeforeMethod
	public void setup() {
		super.setup();
		//driver.get("http://localhost:8081/myapp/form.html");
		driver.get(Commons.BASE_URL+"form.html"); 
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTextBox1() throws InterruptedException {
	 assertEquals(driver.getTitle(), "my form page","Invalid title");
	 
	 //<input type="text" id="myname" name="uName">
	 WebElement element = driver.findElement(By.name("uName"));
	 //or
	 //WebElement element1 = driver.findElement(By.id("myname"));
	 
	 //How to check if the field is text field
	 assertEquals(element.getAttribute("type"),"text", "Invalid field type.Expected text");
		 
	 //how to send data to the text field
	 element.sendKeys("learning selenium");
	 Thread.sleep(5000);
	 
	 //how to clear data from the text field
	  element.clear();
	  Thread.sleep(5000);
		 
	 
	 //How to check if the text field is enabled
	 assertTrue(element.isEnabled(),"text field should enabled");
	 
	 //How to check if the text field is displayed
	 assertTrue(element.isDisplayed(),"text field should be displayed");
  }
	
	/*
	Select City
	<select name="city">
	  <option value="hyd">Hyderabad</option>
	  <option value="bang" selected="selected">Bangalore</option>
	  <option value="chen">Chennai</option>
	  <option value="mum">Mumbai</option>
	</select> 
	
  	  
	  There are 3 ways for selecting the optio in dropdown
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
			assertEquals(expectedCities.get(count), visible,"invalid city:");
			assertEquals(expectedCitiesValues.get(count), value,"invalid city:");
			count++;
		}
	}
	
}