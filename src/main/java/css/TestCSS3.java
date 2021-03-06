package css;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Commons;

public class TestCSS3 {

	@Test
	public void main() throws InterruptedException {
		String baseUrl = "https://www.facebook.com/login/identify?ctx=recover";
		WebDriver driver = Commons.getDriver();

		driver.get(baseUrl);
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("a[title=\"Go to Facebook home\"]"))
		.click();

		Thread.sleep(5000);
		driver.close();
	}
}
