package project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TestDragAndDrop {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();

		String URL = "";

		driver.get(URL);

		WebElement From = driver.findElement(By.id(""));

		WebElement To = driver.findElement(By.id(""));

		Actions action = new Actions(driver);

		Action dragAndDrop = action.clickAndHold(From)
				.moveToElement(To)
				.release(To)
				.build();

		dragAndDrop.perform();
	}
}
