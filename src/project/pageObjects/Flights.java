package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import applicationUtilities.ApplicationUtilities;

public class Flights extends ApplicationUtilities
{
	List<WebElement> elements;
	WebDriver driver;
	public boolean result;
	public Flights(WebDriver driver)
	{
		this.driver = driver;
		//System.out.println("Flights Session ID :" + driver.getWindowHandle());
	}
	
	public boolean bookFlight()
	{
		System.out.println("RC : bookFlight ");
		elements = driver.findElements(By.name("tripType"));
		selectAnElementFromCollection(elements,"value","oneway");
		elements = driver.findElements(By.name("servClass"));
		selectAnElementFromCollection(elements,"value","First");
		selectAnElementFromDropDown(driver.findElement(By.name("passCount")),2);
		selectAnElementFromDropDown(driver.findElement(By.name("fromPort")),2);
		selectAnElementFromDropDown(driver.findElement(By.name("fromMonth")),10);
		selectAnElementFromDropDown(driver.findElement(By.name("fromDay")),29);
		selectAnElementFromDropDown(driver.findElement(By.name("toPort")),"Paris");
		selectAnElementFromDropDown(driver.findElement(By.name("toMonth")),"December");
		selectAnElementFromDropDown(driver.findElement(By.name("toDay")),5);
		selectAnElementFromDropDown(driver.findElement(By.name("airline")),2);
		return true;
	}
}
