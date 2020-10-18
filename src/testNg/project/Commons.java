package project;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;

public class Commons {
	public static final String URL ="http://localhost:8011/EmpDemo1/";
	public static final String LOGIN = "login";
	public static final String PASSWORD = "password";
	public static final String LOGIN_NAME = "loginName";
	public static final String BASE_URL = null;
	
	
	public static WebDriver getDriver(){
		String browser ="chrome";
		if ("chrome".equals(browser)){
			return getChromeDriver();
		}else {
			return getChromeDriver();
		}
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
	
	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(fileWithPath);

		if(!DestFile.exists())
			DestFile.createNewFile();
		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);
	}
	
}
