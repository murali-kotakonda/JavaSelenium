package old;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = DriverUtils.getDriver();
	}

	@AfterMethod
	public  void clean() {
		driver.close();
	}
	
	@BeforeClass
	public static void oneTime(){
		String exePath 
		= "C:\\Murali\\Mythri Progs\\selenium\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
	}

}
