package testFb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.BaseTest;

/**
 	WebElement From = driver.findElement(By.id(""));

		WebElement To = driver.findElement(By.id(""));

		Actions action = new Actions(driver);

		Action dragAndDrop = action.clickAndHold(From)
				.moveToElement(To)
				.release(To)
				.build();

		dragAndDrop.perform();
		
		//Alternately u can also use Performing the drag and drop action  
		action.dragAndDrop(From,To).build().perform();  
 */
public class Test9DragAndDrop extends BaseTest {
	
	@BeforeMethod
	public void setup() {
		super.setup();
		driver.get("http://jqueryui.com/droppable/");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void t1() throws InterruptedException {
		driver.switchTo().frame(0);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		Thread.sleep(5000);
		
		new Actions(driver).dragAndDrop(source, target).build().perform();
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(5000);
	}
}
