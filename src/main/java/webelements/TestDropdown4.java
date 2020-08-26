package webelements;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.Commons;

public class TestDropdown4 {
	
	/*Select City
	<select name="city">
	  <option value="hyd">Hyderabad</option>
	  <option value="bang" selected="selected">Bangalore</option>
	  <option value="chen">Chennai</option>
	  <option value="mum">Mumbai</option>
	</select> */
	
	 public static void main(String[] args) throws InterruptedException { 
		 	WebDriver driver = Commons.getDriver();
			driver.get(Commons.URL);
	
			WebElement cities = driver.findElement(By.name("city"));
			Select select = new Select(cities);
			List<WebElement> options  = select.getOptions();
			int size = options.size();
			if(size!=4) {
				System.out.println("invalid no of cities");
			}
			
			WebElement selectedCity = select.getFirstSelectedOption();
			if(!selectedCity.getText().equals("Bangalore")) {
				System.out.println("invalid default value");
			}
			
			List<String> expectedCities =Arrays.asList("Hyderabad","Bangalore","Chennai","Mumbai");
			List<String> expectedCitiesValues =Arrays.asList("hyd","bang","chen","mum");
			
			int count= 0;
			for(WebElement element :options){
				String visible = element.getText();
				String value= element.getAttribute("value");
				System.out.println(visible + " - " + value);
				if(!expectedCities.get(count).equals(visible)) {
					System.out.println("invalid city:" + visible);
				}
				
				if(!expectedCitiesValues.get(count).equals(value)) {
					System.out.println("invalid city value:" + value);
				}
				count++;
			}

			
			
			select.selectByVisibleText("Chennai");
			Thread.sleep(2000);
			select.selectByIndex(1);
			Thread.sleep(2000);
			select.selectByValue("mum");
			Thread.sleep(2000);
			//Selecting Items in a Multiple SELECT elements
			driver.get("http://jsbin.com/osebed/2");
			Select fruits = new Select(driver.findElement(By.id("fruits")));
			fruits.selectByVisibleText("Banana");
			fruits.selectByIndex(1);
	 }
	 /*
		selectByVisibleText()/ deselectByVisibleText()	selects/deselects an option by its displayed text
		selectByValue()/ deselectByValue()	selects/deselects an option by the value of its "value" attribute
		selectByIndex()/ deselectByIndex()	selects/deselects an option by its index
		isMultiple()	returns TRUE if the drop-down element allows multiple selection at a time; FALSE if otherwise
		deselectAll()	deselects all previously selected options
*/}
