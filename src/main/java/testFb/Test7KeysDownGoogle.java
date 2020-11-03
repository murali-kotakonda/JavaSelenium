package testFb;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.BaseTest;

public class Test7KeysDownGoogle extends BaseTest{

	@BeforeMethod
	public void setup() {
		super.setup();
		driver.get("https://www.google.com/");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void t1() throws InterruptedException {
		WebElement e = driver.findElement(By.name("q"));
		
		Actions a = new Actions(driver);
		a.sendKeys(e, "selenium").build().perform();
		Thread.sleep(3000);
		a.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(3000);
		a.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(3000);
		a.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(3000);
		a.sendKeys(Keys.ENTER).build().perform();
	}
	
	@Test
	public void t2() throws InterruptedException {
		WebElement e = driver.findElement(By.name("q"));
		
		 Actions action = new Actions(driver)
		.sendKeys(e, "selenium")
		.sendKeys(e,Keys.DOWN)
		.sendKeys(e,Keys.DOWN)
		.sendKeys(e,Keys.DOWN)
		.sendKeys(e,Keys.ENTER);

		 action.build().perform();
		 Thread.sleep(5000);
	}
}
