package testNg1.test1;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex1 {
	public String baseUrl = "https://www.fb.xom";
	public WebDriver driver;

	@Test
	public void verifyHomepageTitle() {
		driver = Commons.getDriver();
		driver.get(baseUrl);
		String expectedTitle = "";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.close();
	}
}
