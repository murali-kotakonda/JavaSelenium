package actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.Commons;

public class TestDoubleClick {
	@Test
	public void doubleClick() throws InterruptedException {
		WebDriver driver = Commons.getDriver();
		driver.get("");
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement target = driver.findElement(By.id(""));
		target.sendKeys("hello");
		//double click
		Thread.sleep(5000);
		action.doubleClick(target).build().perform();
		//right click
		Thread.sleep(5000);
		action.contextClick(target).build().perform();
	}
}
