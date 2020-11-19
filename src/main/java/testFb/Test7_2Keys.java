package testFb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.Commons;

/**

 */
public class Test7_2Keys extends BaseTest {
	
	@BeforeMethod
	public void setup() {
		super.setup();
		driver.get(Commons.BASE_URL + "hover.html");
		sleep(5);
	}
	
	@Test
	public void t4() throws InterruptedException {
		WebElement txtUsername = driver.findElement(By.id("myname"));
		txtUsername.sendKeys("kumar");
		
		// or
		sleep(5);
		new Actions(driver).moveToElement(txtUsername)
				.click()
				.sendKeys(txtUsername, "shyam")
				.build().perform();

	}
}
