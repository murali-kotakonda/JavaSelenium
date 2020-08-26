package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	public static WebDriver startApplication(WebDriver driver,String browserName,String appURL)
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\\\Selenium_Student_SW\\\\Drivers\\\\chromedriver_win32\\\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","E:\\Selenium_Student_SW\\Drivers\\geckodriver-v0.20.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}


}
