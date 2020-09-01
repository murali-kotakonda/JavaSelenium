package testNg1.test1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Commons {
	public static final String BASE_URL = null;
	public static final String LOGIN = "login";
	public static final String PASSWORD = "password";
	public static final String LOGIN_NAME = "loginName";
	public static WebDriver getDriver(){
		
		String exePath 
		= "C:\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
	
		WebDriver driver = new ChromeDriver();
		
		Options manage = driver.manage();
		manage.deleteAllCookies();
		//manage.window().maximize();
		manage.timeouts().pageLoadTimeout(60, 
				TimeUnit.SECONDS); //Identify performance issues
		// the time that the script allots for a web page to be displayed. 
		//If the page loads within the time then the script continues. 
		//If the page does not load within the timeout the script will be stopped by a TimeoutException.
		
		manage.timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
	}

	public static void checkenabledAndDisplayed(WebElement username, WebElement pwd, WebElement loginButton) {
		
	}
}
