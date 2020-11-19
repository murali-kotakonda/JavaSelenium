package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.Commons;

public class BrowserFactory {
	public static WebDriver startApplication(WebDriver driver, String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = Commons.getChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = Commons.getFireFoxDriver();
		}
		driver.get("http://localhost:9080/EmpDemoApp/");
		driver.manage().window().maximize();
		// driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

	public static WebDriver crossBrowsing(WebDriver driver, String browsername, String url) {
		return null;
	}
}
