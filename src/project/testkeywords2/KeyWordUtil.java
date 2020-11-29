package testkeywords2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import common.Commons;
import testkeywords.Action;

public class KeyWordUtil {
	
	private String properties_path = "C:\\test\\empDemo.properties";
	WebDriver driver;
	Properties properties;
	
	public KeyWordUtil(WebDriver driver) {
		super();
		this.driver = driver;
		try {
			properties = new Properties();
			properties.load(new FileInputStream(properties_path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void enter_URL(WebDriver driver, String data) throws IOException {
		if(data.equals("BASE_URL")) {
			data = Commons.BASE_URL;
		}
		driver.get(data);
	}

	public void type(WebDriver driver, String expression, String locatorType, String testdata) throws IOException {
		WebElement field = driver.findElement(this.getObject(expression, locatorType));
		field.clear();
		field.sendKeys(testdata);
		// driver.findElement(By.xpath("//")).sendKeys(testdata);
	}

	public void wait(WebDriver driver, String expression, String locatorType) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(this.getObject(expression, locatorType))));
	}

	public void click(WebDriver driver, String expression, String locatorType) throws IOException {
		driver.findElement(this.getObject(expression, locatorType)).click();
	}

	public String get_currentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	
	
	public void perform(Action action) throws IOException, InterruptedException {
		String keyword = action.getKeyword();
		String objectName = action.getObjectName();
		String  locatorType = action.getLocatorType();
		String data = action.getTestdata();
		String assertionType = action.getAssertionType();
		String expectedValue = action.getExpectedValue();
		
		switch (keyword) {
		case "URL":
			//Perform click
			 enter_URL(driver, data);
			break;

		case "get_currentURL":
			//Set text on control
			get_currentURL(driver);
			break;

		case "TYPE":
			 type(driver, objectName, locatorType, data);
			 break;

		case "CLICK":
			 click(driver, objectName, locatorType);
			 break;
			/*
			 * case "wait": keyword.wait(driver, objectName, locatorType);
			 */
		case "implicitWait":
			Thread.sleep(8000);
			break;

		default:
			break;
		}

		switch (assertionType) {
		case "contains":
			// Assert.assertTrue(get_currentURL(driver).contains("login"));
			break;
		case "equals":
			// Assert.assertEquals(get_currentURL(driver),"http://localhost:8012/EmpDemo/login");
			break;
		case "homeTitle":
			Assert.assertTrue(get_currentURL(driver).contains("login"));
			Assert.assertEquals(driver.getTitle(), expectedValue);
			break;
		case "invaldiLogin" :
			WebElement invalidlogin = driver.findElement(this.getObject(objectName, locatorType));
			Assert.assertEquals(invalidlogin.getText(), expectedValue);
			break;
		case "loginTitle":
			Assert.assertEquals(driver.getTitle(), expectedValue);
			break;
		case "alert":
			Alert a = driver.switchTo().alert();
			Reporter.log(a.getText());
			Assert.assertEquals(a.getText(), expectedValue);
			a.accept();
			break;
		}

		if (keyword.contains("AssertElement")) {
			// assertion.AssertElement(driver, assertionType, objectName, locatorType);
		}
	}

	public void close() {
		driver.quit();
	}
	
	By getObject(String propName, String locatorType) throws IOException {
		String expression = properties.getProperty(propName);
		
		// find by xpath
		if (locatorType.equalsIgnoreCase("XPATH")) {
			return By.xpath(expression);
		}
		// find by class
		else if (locatorType.equalsIgnoreCase("CLASSNAME")) {
			return By.className(expression);
		}
		else if (locatorType.equalsIgnoreCase("ID")) {
			return By.id(expression);
		}
		// find by name
		else if (locatorType.equalsIgnoreCase("NAME")) {
			return By.name(expression);
		}
		// Find by css
		else if (locatorType.equalsIgnoreCase("CSS")) {
			return By.cssSelector(expression);
		}
		// find by link
		else if (locatorType.equalsIgnoreCase("LINK")) {
			return By.linkText(expression);
		}
		// find by partial link
		else if (locatorType.equalsIgnoreCase("PARTIALLINK")) {
			return By.partialLinkText(expression);
		}
		return null;
	}
}
