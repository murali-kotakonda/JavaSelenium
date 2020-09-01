package old;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.Commons;

public class TestDropdown4 {
	 public static void main(String[] args) { 
		    String baseURL = "http://demo.guru99.com/test/newtours/register.php";
		    WebDriver driver = Commons.getDriver();
			driver.get(baseURL);
			
			List<String> countries =Arrays.asList("INDIA","ALBANIA","US");
			Select drpCountry = new Select(driver.findElement(By.name("country")));
			List<WebElement> options  = drpCountry.getOptions();
			for(WebElement element :options){
				String country = element.getText();
				System.out.println(country);
				Assert.assertTrue("missing country", countries.contains(country));
			}

			
			
			
			
			
			
			
			
			drpCountry.selectByVisibleText("ANTARCTICA");

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
