package testFb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.BaseTest;

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
		sleep(5);
	}
	
	@Test
	public void t1()  {
		driver.switchTo().frame(0);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		sleep(3);
		
		new Actions(driver).dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();
		sleep(3);
	}
}
