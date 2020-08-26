package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.Commons;

public class TestKeysDownGoogle {

	public static void main(String[] args) throws InterruptedException {
		String baseUrl = "http://www.google.com/";
		WebDriver driver = Commons.getDriver();

		driver.get(baseUrl);
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
}
