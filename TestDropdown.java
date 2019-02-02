package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import util.DriverUtils;

public class TestDropdown {

	 public static void main(String[] args) { 
		    String baseURL = "http://demo.guru99.com/test/newtours/register.php";
		    WebDriver driver = DriverUtils.getDriver();
			driver.get(baseURL);

			Select drpCountry = new Select(driver.findElement(By.name("country")));
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
