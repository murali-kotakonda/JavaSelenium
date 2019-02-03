package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.Commons;

public class TestMouseHoverAndClick {
	public static void main(String[] args) {

		WebDriver driver = Commons.getDriver();

		driver.get("http://localhost");

		WebElement element = driver.findElement(By.linkText("Add New Employee"));

		Actions action = new Actions(driver);

        action.moveToElement(element);

        action.click();

        action.perform();

	}
}
