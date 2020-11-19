package utils;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
-  How to delete the page cookies?
   driver.manage().deleteAllCookies();
  
  
 - How to get the page cookies?
   Set<Cookie> cookies = driver.manage().getCookies();
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getPath() + " - " + cookie.getValue());
		}
  
 - How to maximize the window?
  driver.manage().window().maximize();
  
-  How to get driver obj for firefox?
    System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
		
 */

public class Commons {
	public static final String BASE_URL ="http://localhost:8081/myapp/";
	public static final String URL ="http://localhost:8011/EmpDemo1/";
	public static final String LOGIN = "login";
	public static final String PASSWORD = "password";
	public static final String LOGIN_NAME = "loginName";
	
	public static WebDriver getDriver(){
		String browser ="chrome";
		if ("chrome".equals(browser)){
			return getChromeDriver();
		}else {
			return getChromeDriver();
		}
	}
	
	public static WebDriver getDriver(String browser) {
		if("chrome".equals(browser)) {
			return getChromeDriver();
		}
		
		if("firefox".equals(browser)) {
			return getFireFoxDriver();
		}
		
		return null;
	}

	public static WebDriver getChromeDriver(){
		
		String exePath 
		= "C:\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
	
		WebDriver driver = new ChromeDriver();
		Options manage = driver.manage();
		manage.deleteAllCookies();
		manage.window().maximize();
		manage.timeouts().pageLoadTimeout(60, 
				TimeUnit.SECONDS); //Identify performance issues
		// the time that the script allots for a web page to be displayed. 
		//If the page loads within the time then the script continues. 
		//If the page does not load within the timeout the script will be stopped by a TimeoutException.
		manage.timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//manage.window().maximize();
		return driver;
	}
	
	
	public static WebDriver getFireFoxDriver(){
        System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		Options manage = driver.manage();
		manage.deleteAllCookies();
		manage.timeouts().pageLoadTimeout(60, 
				TimeUnit.SECONDS); //Identify performance issues
		return driver;
	}
	
	public  static void checkEnabledAndDisplayed(WebElement... elements) {
		for (WebElement element : elements) {
		assertTrue(element.isDisplayed(), "element expeceted to display");
			assertTrue(element.isEnabled(), "element expected to enable");
		}
	}
}
