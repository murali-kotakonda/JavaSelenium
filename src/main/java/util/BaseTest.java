package util;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	public WebDriver driver;
	
	public static final String URL = "http://localhost:8012/EmpDemo";

	@BeforeTest
	public void setup() {
		System.out.println("in setup");
		driver = Commons.getChromeDriver();
		driver.get(URL);
	}

	@AfterTest
	public void quit() {
		driver.quit();
	}
	
	public WebElement getElement(String address, String type) {
		WebElement ele = driver.findElement(By.id(""));
		if (type.equalsIgnoreCase("xpath")) {
			ele = driver.findElement(By.xpath("'+address+'"));
		} else if (type.equalsIgnoreCase("id")) {
			ele = driver.findElement(By.id("'+address+'"));
		} else if (type.equalsIgnoreCase("name"))
			ele = driver.findElement(By.name("'+address+'"));
		return ele;
	}
	
	public  static void checkEnabledAndDisplayed(WebElement... elements) {
		for (WebElement element : elements) {
			assertTrue(element.isDisplayed(), "element expeceted to display");
			assertTrue(element.isEnabled(), "element expected to enable");
		}
	}
	
	public void takeSnapShot(  String fileWithPath) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);

		if(!DestFile.exists())
			DestFile.createNewFile();
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		
	}
	 
	public void testLinkWorking(WebElement it) {
		String url = it.getAttribute("href");
		HttpURLConnection huc = null;
		int respCode = 200;
		System.out.println(url);
		//Assert.assertTrue("Link url is missing..", url != null && !url.isEmpty());
		//Assert.assertTrue("Link domain is wrong is missing..", url.startsWith("https://"));
		try {
			huc = (HttpURLConnection) (new URL(url).openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();
			respCode = huc.getResponseCode();
			//Assert.assertTrue("Link not working..", respCode == 200);
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
	}
	
	public WebElement getByLinkText(String text) {
		WebElement element = driver.findElement(By.linkText(text));
		return element;
	}
	
	public WebElement getByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		checkEnabledAndDisplayed(element);
		return element;
	}

	public WebElement getTextFieldByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		checkEnabledAndDisplayed(element);
		
		assertEquals("text", element.getAttribute("type"), "element expeceted to display");
		return element;
	}
	
	public WebElement getPasswordByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		checkEnabledAndDisplayed(element);
		
		assertEquals("password", element.getAttribute("type"), "element expeceted to display");
		return element;
	}
	
	
	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void setDriver() {
		//Download the web driver executable
	  //ChromeDriverManager.getInstance().setup();
	  driver = new ChromeDriver();
	  //FirefoxDriverManager.getInstance().setup();
	  driver = new FirefoxDriver();
	}
	
	public void login(String un, String pwd) {
		WebElement form = driver.findElement(By.tagName("form"));
		WebElement formTitle = driver.findElement(By.tagName("h1"));
		WebElement usernamelab = driver.findElement(By.id("userNameLbl"));
		WebElement passwordlab = driver.findElement(By.id("passwordLbl"));
		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
		WebElement name = driver.findElement(By.name("loginName"));
		WebElement password = driver.findElement(By.name("password"));

		checkEnabledAndDisplayed(usernamelab, name, passwordlab, password, loginBtn);

		// test the form name
		assertTrue(formTitle.getText().equals("Login Page"));

		// test label for username
		assertTrue(usernamelab.getText().equals("User Name:"));

		// test label for Password
		assertTrue(passwordlab.getText().equals("Password:"));

		// test label for button
		assertTrue(loginBtn.getAttribute("value").equals("Login"));

		// test type for username
		assertTrue(name.getAttribute("type").equals("text"));

		// test type for password
		assertTrue(password.getAttribute("type").equals("password"));

		name.clear();
		password.clear();
		name.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();

		sleep(3);
	}
}
