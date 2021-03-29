package testFb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import util.Commons;

public class MyAppBaseTest {

	public WebDriver driver;
	public static final String URL ="http://localhost:8087/myapp/";

	@BeforeTest
	public void setup() {
		System.out.println("in setup");
		driver = Commons.getChromeDriver();
	}

	@AfterTest
	public void quit() {
		driver.quit();
	}
	
	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void checkEnabledAndDisplayed(WebElement... elements) {
		for (WebElement element : elements) {
			Assert.assertTrue(element.isDisplayed(), "element expeceted to display");
			Assert.assertTrue(element.isEnabled(), "element expected to enable");
		}
	}
	
	public WebElement getTextField(By by) {
		WebElement element = driver.findElement(by);
		//
		checkEnabledAndDisplayed(element);
		
		// verify type
		String actual = element.getAttribute("type");
		Assert.assertEquals(actual, "text");
		
		return element;
	}
	
	
	public WebElement getPasswordField(By by) {
		WebElement element = driver.findElement(by);
		//
		checkEnabledAndDisplayed(element);
		
		// verify type
		String actual = element.getAttribute("type");
		Assert.assertEquals(actual, "password");
		
		return element;
	}
	
	public  WebElement getRadio(By by,boolean isSelected) {
		WebElement radio = driver.findElement(by);
		
		checkEnabledAndDisplayed(radio);
		
		Assert.assertEquals(radio.getAttribute("type"), "radio");
		
		Assert.assertEquals(radio.isSelected(), isSelected, "radio is selected.");
		
		return radio;
	}
	
	
	public  WebElement getCheckBox(By by,boolean isSelected) {
		WebElement check = driver.findElement(by);
		
		checkEnabledAndDisplayed(check);
		
		Assert.assertEquals(check.getAttribute("type"), "checkbox");
		
		Assert.assertEquals(check.isSelected(), isSelected, "radio is selected.");
		
		return check;
	}
	
	public WebElement getDropDown(By by, int actual,String defaultCity) {
		WebElement cities = driver.findElement(by);
		// create select obj
		Select select = new Select(cities);	
		Assert.assertFalse(select.isMultiple(), "should be  multi dropdown");
		return validateDropDown(actual, defaultCity, cities, select);
	}
	
	public WebElement getMultiDropDown(By by, int actual,String defaultCity) {
		WebElement cities = driver.findElement(by);
		// create select obj
		Select select = new Select(cities);	
		Assert.assertTrue(select.isMultiple(), "should be  multi dropdown");
		return validateDropDown(actual, defaultCity, cities, select);
	}

	private WebElement validateDropDown(int actual, String defaultValue, WebElement dropdownObj, Select select) {
		checkEnabledAndDisplayed(dropdownObj);
		
		// How to get all the options
		List<WebElement> options = select.getOptions();	
		//validate the number of cities
		int size = options.size();
		Assert.assertEquals(size, actual,"invalid no of options");
		
		if(defaultValue!=null && !defaultValue.equals("")) {
		// validate the default value in dropdown
		WebElement selectedCity = select.getFirstSelectedOption();	
		Assert.assertEquals(selectedCity.getText(), defaultValue,"invalid default value");
		}
		
		return dropdownObj;
	}
	
	public WebElement getLinkText(String text) {
		WebElement link = driver.findElement(By.linkText(text));
		checkEnabledAndDisplayed(link);
		return link;
	}
	
	public WebElement getPartialText(String text) {
		WebElement link = driver.findElement(By.partialLinkText(text));
		checkEnabledAndDisplayed(link);
		return link;
	}
}
