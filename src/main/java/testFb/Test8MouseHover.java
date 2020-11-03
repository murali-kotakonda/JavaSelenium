package testFb;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.BaseTest;
import util.Commons;

/**
 KEY:
-------------
sendKeys(keysToSend): Sends a series of keystrokes onto the element.
keyDown(theKey): Sends a key press without release it. Subsequent actions may assume it as pressed.
Example: Keys.ALT, Keys.SHIFT, or Keys.CONTROL);
keyUp(theKey): Performs a key release.



Mouse:
--------------
click(): Clicks on the element.
doubleClick (): Double clicks on the element.
contextClick() : Performs a context-click (right-click) on the element.
clickAndHold(): Clicks at the present mouse location without releasing.
dragAndDrop(source, target): Clicks at the source location and moves to the location of the target element before releasing the mouse. source (element to grab, target – element to release).
dragAndDropBy(source, xOffset, yOffset): Performs click-and-hold at the source location, shifts by a given offset value, then frees the mouse. (X offset – to shift horizontally, Y Offset – to shift vertically).
moveByOffset(x-offset, y-offset): Shifts the mouse from its current position (or 0,0) by the given offset. x-offset – Sets the horizontal offset (negative value – shifting the mouse to the left), y-offset – Sets the vertical offset (negative value – shifting the mouse to the up).
moveToElement(toElement): It shifts the mouse to the center of the element.
release(): Releases the pressed left mouse button at the existing mouse location.

 */
public class Test8MouseHover extends BaseTest {
	
	@BeforeMethod
	public void setup() {
		super.setup();
		driver.get(Commons.BASE_URL + "hover.html");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
		Notes:
		For mouse hover
		use moveToElement() on actions
	 */
	@Test
	public void t1() throws InterruptedException {
		Actions actions = new Actions(driver);
		
		/* WebElement element = driver.findElement(By.linkText("Click here"));
		Actions  action= actions.moveToElement(element);
     	action.build().perform(); */
		Thread.sleep(3000);
			
	    actions.moveToElement(getByLinkText("Click here")).build().perform();
		Thread.sleep(3000);
		
		actions.moveToElement(getByLinkText("Click for Date")).build().perform();
		Thread.sleep(3000);
		
		actions.moveToElement(getByLinkText("Send Data")).build().perform();
		Thread.sleep(3000);
		
		actions.moveToElement(getByLinkText("Ex1")).build().perform();
		Thread.sleep(3000);
		
		actions.moveToElement(getByLinkText("Ex2")).build().perform();
		Thread.sleep(3000);
	}
	
	/**
		Notes:
		For mouse hover and click
		use moveToElement()  and click() on actions
	 */
	@Test
	public void t2() throws InterruptedException {
		Actions actions = new Actions(driver);
		
	    actions.moveToElement(getByLinkText("Click here")).click().build().perform();
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		actions.moveToElement(getByLinkText("Click for Date")).click().build().perform();
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		actions.moveToElement(getByLinkText("Send Data")).click().build().perform();
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		actions.moveToElement(getByLinkText("Ex1")).click().build().perform();
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		actions.moveToElement(getByLinkText("Ex2")).click().build().perform();
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		Thread.sleep(3000);
	}

	/**
	validate mouse hover
	 */
	@Test
	public  void t3() throws InterruptedException {
		WebElement link_Home = getByLinkText("Click here");

		Actions builder = new Actions(driver);
		String bgColor = link_Home.getCssValue("color");
		System.out.println("Before hover: " + bgColor);
		Thread.sleep(3000);
		
	    builder.moveToElement(link_Home).build().perform();

		bgColor = link_Home.getCssValue("color");
		Thread.sleep(3000);
		System.out.println("After hover: " + bgColor);
	}
	
	/**
	  Type Hello in caps using SHIFT
	  Double click
	  Right click
	  
  Enter FirstName : <input type="text" id="myname" name="uName" /> <br>
  
	 */
	@Test
	public void keyActions() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement txtUsername = driver.findElement(By.id("myname"));
		
		//move to element
		action.moveToElement(txtUsername).click().build().perform();
		Thread.sleep(3000);
		
		//Type Hello in caps using SHIFT
		action.keyDown(txtUsername, Keys.SHIFT)
		.sendKeys(txtUsername, "hello")
		.keyUp(txtUsername, Keys.SHIFT)
		.build().perform();
		Thread.sleep(3000);
		
		// Double click
		action.doubleClick(txtUsername).build().perform();
		Thread.sleep(3000);
		
		// Right click
		action.contextClick(txtUsername).build().perform();
		Thread.sleep(3000);
		
		action
				.moveToElement(txtUsername)
				.click()
				.keyDown(txtUsername, Keys.SHIFT)
				.sendKeys(txtUsername, "hello")
				.keyUp(txtUsername, Keys.SHIFT)
				.doubleClick(txtUsername)
				.contextClick()
				.build().perform();
		Thread.sleep(5000);
	}
	
	@Test
	public void t4() throws InterruptedException {
		WebElement txtUsername = driver.findElement(By.id("myname"));
		txtUsername.sendKeys("kumar");
		
		// or
		Thread.sleep(5000);
		new Actions(driver).moveToElement(txtUsername)
				.click()
				.sendKeys(txtUsername, "shyam")
				.build().perform();

	}
}
