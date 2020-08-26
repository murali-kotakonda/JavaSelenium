package project.com.mythri;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import util.Commons;

public class BaseTest {
	
	WebDriver driver;

	@Before
	public void setup() {
		driver = Commons.getDriver();
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
