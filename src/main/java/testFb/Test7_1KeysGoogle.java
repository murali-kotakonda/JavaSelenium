package testFb;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.BaseTest;

/**
Actions:
----------
 Action Class in Selenium is a built-in feature provided by the selenium for
 handling keyboard and mouse events. 
 It includes various operations 
 such as multiple events clicking by control key, drag and drop events
 
 
ActionChains are a way to automate low-level interactions such as mouse movements,
mouse button actions.
->KeyPress,key up, key down, enter, tab, pageup, page down and context menu interactions.
-> hover over and drag and drop.
->double click , right click'
 
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
public class Test7_1KeysGoogle extends BaseTest{

	@BeforeMethod
	public void setup() {
		super.setup();
		driver.get("https://www.google.com/");
		sleep(3);
	}
	

	@Test // WORKING
	public void test1() {
		//create action object
		Actions actions = new Actions(driver);
		WebElement textField = getByName("q");
		textField.sendKeys("selenium");
		sleep(3);
		
		actions.moveToElement(textField).click().build().perform();
		sleep(3);
		
		actions.sendKeys(Keys.DOWN).build().perform();
		sleep(3);
		
		actions.sendKeys(Keys.DOWN).build().perform();
		sleep(3);
		
		actions.sendKeys( Keys.DOWN).build().perform();
		sleep(3);
		
		actions.sendKeys( Keys.ENTER).build().perform();
		sleep(3);
	}

	/**
	Open Google.com
	 search selenium
	 press down
	 press down
	 press down
	 press Enter

	 //a.sendKeys(e, "selenium").build().perform();
	 */


   //working
	@Test
	public void t1() {
		WebElement e = driver.findElement(By.name("q"));
		
		e.sendKeys("selenium");
		sleep(2);
		
		Actions a = new Actions(driver);
		
		a.sendKeys(Keys.DOWN).build().perform();
		sleep(2);
		
		a.sendKeys(Keys.DOWN).build().perform();
		sleep(2);
		
		a.sendKeys(Keys.DOWN).build().perform();
		sleep(2);
		
		a.sendKeys(Keys.ENTER).build().perform();
		sleep(2);
		
	}
 
	
	/**
	
	/**
	Open Google.com
	 search selenium
	 press down
	 press down
	 press down
	 press Enter

	How to send the text using the actions.
	 solution:
	 a.sendKeys(<elementObj>, "<some text>").build().perform();
		
	 
	 */
	@Test
	public void t2FailedSendKeys()   {
		WebElement e = driver.findElement(By.name("q"));
		Actions a = new Actions(driver);

		a.sendKeys(Keys.DOWN).build().perform();
		sleep(3);
		a.sendKeys(Keys.DOWN).build().perform();
		sleep(3);
		a.sendKeys(Keys.DOWN).build().perform();
		sleep(3);
		a.sendKeys(Keys.ENTER).build().perform();
	}
	
	/**
	 How to press the shify key?
	 solution:
	  The keyUp and keyDown methods are used for imitating the keyboard
	  actions of pressing and releasing the keys.
	
	  These methods serve multiple methods like converting the texts into uppercase or lowercase, copy text from source and paste in destination location, 
	 scrolling up and down the web page, multiple value selection
	 */
	
	@Test // working
	public void t3SendKeysShiftKey()   {
		WebElement element = driver.findElement(By.name("q"));
		
		Actions action = new Actions(driver);
		
		//Type selenium in caps using SHIFT
		//action.keyDown(element, Keys.SHIFT).sendKeys(element, "selenium").keyUp(element, Keys.SHIFT).build().perform();
		
		//Type selenium  in caps using SHIFT and  then type java tutorial 
		action.keyDown(element, Keys.SHIFT);
		action.sendKeys(element, "selenium");
		action.keyUp(element, Keys.SHIFT);
		action.build().perform();
		sleep(3);
				
		action.sendKeys(Keys.DOWN).build().perform();
		sleep(2);
		action.sendKeys(Keys.DOWN).build().perform();
		sleep(2);
		action.sendKeys(Keys.DOWN).build().perform();
		sleep(2);
		action.sendKeys(Keys.ENTER).build().perform();
		sleep(2);
	}
	
	@Test  //WORKING
	public void t4SendKeysShiftKey()   {
		WebElement element = driver.findElement(By.name("q"));
		
		Actions action = new Actions(driver);
		
		//Type selenium  in caps using SHIFT and  then type java tutorial 
		action.keyDown(element, Keys.SHIFT);
		action.sendKeys(element, "selenium");
		action.keyUp(element, Keys.SHIFT);
		action.sendKeys(element, " java tutorial");
		action.build().perform();
		sleep(3);
				
		action.sendKeys(Keys.DOWN).build().perform();
		sleep(2);
		action.sendKeys(Keys.DOWN).build().perform();
		sleep(2);
		action.sendKeys(Keys.DOWN).build().perform();
		sleep(2);
		action.sendKeys(Keys.ENTER).build().perform();
		sleep(2);
	}
	
	/**
		Press
		1.control + Home
		2.control + End
		3.control + f5
	 */
	@Test //WORKING
	public void t3_HomeAndEnd() {
		t1();
		Actions action = new Actions(driver);
		// Press END using Actions class
		action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		sleep(3);
		// Press HOME using  Actions class
		action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		sleep(3);
		//Refresh
		action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).build().perform();
		sleep(3);
	}
	
	@Test
	public void t2Failed() throws InterruptedException {
		WebElement e = driver.findElement(By.name("q"));
		
		 Actions action = new Actions(driver)
		.sendKeys(e, "selenium")
		.sendKeys(Keys.DOWN)
		.sendKeys(Keys.DOWN)
		.sendKeys(Keys.DOWN)
		.sendKeys(Keys.ENTER);

		 action.build().perform();
		 Thread.sleep(5000);
	}
	
	 
}
