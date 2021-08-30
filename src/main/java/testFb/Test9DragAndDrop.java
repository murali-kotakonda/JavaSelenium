package testFb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.BaseTest;

/**
 	How to perfrom drag and drop?

 	Approach#1:
 	--------------------
 	WebElement From = driver.findElement(By.id(""));
	WebElement To = driver.findElement(By.id(""));
	Actions action = new Actions(driver);
	Action dragAndDrop = action.clickAndHold(From)
				.moveToElement(To)
				.release(To)
				.build();

	dragAndDrop.perform();
		
	
 	Approach#2:
 	--------------------
 	WebElement From = driver.findElement(By.id(""));
	WebElement To = driver.findElement(By.id(""));
	Actions action = new Actions(driver);
	
	action.dragAndDrop(From,To).build().perform();  
 */

public class Test9DragAndDrop extends BaseTest {
	
	@BeforeMethod
	public void setup() {
		super.setup();
		driver.get("http://jqueryui.com/droppable/");
		sleep(5);
	}
	
	@Test
	public void t1()  {
		driver.switchTo().frame(0);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		sleep(3);
		
		Actions action = new Actions(driver);
		
		action.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();
		sleep(3);
	}
}
