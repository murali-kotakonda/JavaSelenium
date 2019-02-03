package project;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import util.Commons;

public class TestDoubleClick {
	@Test
	public void doubleClick() throws InterruptedException {
		WebDriver driver = Commons.getDriver();
		driver.get("");
		Actions action = new Actions(driver);
		WebElement target = driver.findElement(By.id(""));
		action.doubleClick(target).build().perform();
	}
}
