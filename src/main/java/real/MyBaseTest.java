package real;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import old.DriverUtils;

public class MyBaseTest {
	
	WebDriver driver;

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
