package css;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import util.Commons;

public class TestCSS4 {

	@Test
	public void main() throws InterruptedException {
		String baseUrl = "welcome.jsp";
		WebDriver driver = Commons.getDriver();

		driver.get(baseUrl);
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("a[href=\"1.html\"]"))
		.click();

		driver.findElement(By.cssSelector("a[href=\"2.html\"]"))
		.click();
	}
}
