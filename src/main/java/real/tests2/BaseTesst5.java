package real.tests2;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTesst5 {
static WebDriver driver;
	
	@BeforeClass
	public static void oneTime(){
		System.setProperty("webdriver.chrome.driver", "E:\\automation\\chromedriver.exe");
	}
	
	@Before
	public void beforeEveryTime(){
		driver = new ChromeDriver();
		driver.get("http://jqueryui.com/slider");
	}
	
	
	@After
	public void afterEveryTime(){
		driver.close();
	}
}
