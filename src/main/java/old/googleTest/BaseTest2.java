package old.googleTest;

import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import old.BaseTest;

public class BaseTest2 extends BaseTest{
	
	@Before
	public void beforeEveryTime(){
		driver = new ChromeDriver();
		driver.get("http:\\www.google.co.in");
		
	}

}
