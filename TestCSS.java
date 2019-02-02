package project;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import util.DriverUtils;

public class TestCSS {

	@Test
	public void main() throws InterruptedException {
		String baseUrl = "https://www.facebook.com/login/identify?ctx=recover";
		WebDriver driver = DriverUtils.getDriver();

		driver.get(baseUrl);
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("a[title=\"Go to Facebook home\"]"))
		.click();

		Thread.sleep(5000);
		Assert.assertEquals("same title", "Facebook - log in or sign up" ,driver.getTitle());
		driver.close();

	}
}
