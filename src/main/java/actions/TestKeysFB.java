package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import util.Commons;

public class TestKeysFB {

	public static void main(String[] args) throws InterruptedException {
		String baseUrl = "http://www.facebook.com/";
		WebDriver driver = Commons.getDriver();

		driver.get(baseUrl);
		Thread.sleep(5000);
		WebElement txtUsername = driver.findElement(By.id("email"));
		txtUsername.sendKeys("hello");
		
		// or
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.moveToElement(txtUsername)
				.click()
				.sendKeys(txtUsername, "shyam").build().perform();
		
		//or
		Thread.sleep(5000);
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(txtUsername)
				.click()
				.keyDown(txtUsername, Keys.SHIFT)
				.sendKeys(txtUsername, "shyam")
				.keyDown(txtUsername, Keys.SHIFT)
				.sendKeys(txtUsername, "Kumar")
				.build().perform();
		
		//or
		Thread.sleep(5000);
	    Actions builder = new Actions(driver);
		Action action = builder.moveToElement(txtUsername)
				.click()
				.keyDown(txtUsername, Keys.SHIFT)
				.sendKeys(txtUsername, "shyam")
				.keyUp(txtUsername, Keys.SHIFT)
				.sendKeys(txtUsername, "kumar")
				.doubleClick(txtUsername).contextClick().build();

		action.perform();
	}
}
