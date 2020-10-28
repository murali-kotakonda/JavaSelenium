package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.Commons;

public class DragDrop  {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver;
		driver = Commons.getChromeDriver();
	
		driver.get("http://jqueryui.com/droppable/");

		driver.switchTo().frame(0);
		Thread.sleep(5000);
		WebElement e = driver.findElement(By.id("draggable"));

		WebElement e1 = driver.findElement(By.id("droppable"));
		Actions a = new Actions(driver);
		a.dragAndDrop(e, e1).build().perform();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
	}

	 }
