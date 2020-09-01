package old;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	public WebDriver driver;

	@Before
	public void setup() {
		driver = DriverUtils.getDriver();
	}

	@After
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
