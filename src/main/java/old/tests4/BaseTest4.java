package old.tests4;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest4 {
static WebDriver driver;
	
	@BeforeClass
	public static void oneTime(){
		System.setProperty("webdriver.chrome.driver", "E:\\automation\\chromedriver.exe");
	}
	
	@Before
	public void beforeEveryTime(){
		driver = new ChromeDriver();
		driver.get("http://www.amazon.in/");
	}
	
	
	@After
	public void afterEveryTime(){
		driver.close();
	}
}
