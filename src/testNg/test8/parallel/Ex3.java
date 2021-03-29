package parallel;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.Commons;

public class Ex3 {

	@Test
	public void youtube() {
		WebDriver driver = Commons.getChromeDriver();
		driver.get("https://www.youtube.com");
		driver.close();
	}

	@Test
	public void twitter() {
		WebDriver driver = Commons.getChromeDriver();
		driver.get("https://www.twitter.com");
		driver.close();
	}
}
