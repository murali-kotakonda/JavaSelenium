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
 --------
 -mouse operations
- keyboard opeartions

 -Action Class in Selenium is a built-in feature provided by the selenium for
 handling keyboard and mouse events.
 - It includes various operations 
 such as multiple events clicking by control key, drag and drop events
 
 
 ex:
 ->KeyPress,key up, key down, enter, tab, pageup, page down and context menu interactions.
-> hover over and drag and drop.
->double click , right click'
  
  
 KEY:
-------------
sendKeys(keysToSend): Sends a series of keystrokes onto the element.
keyDown(theKey): Sends a key press without release it.
keyUp(theKey): Performs a key release.



Mouse:
-------------- 
click(): Clicks on the element.
doubleClick (): Double clicks on the element.
contextClick() : Performs a context-click (right-click) on the element.
clickAndHold(): Clicks at the present mouse location without releasing.  
moveToElement(toElement):  
  
  

  

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
	/**
	Open Google.com
	 Type selenium
	 press down
	 press down
	 press down
	 press Enter

   */
	@Test // WORKING
	public void test1() throws InterruptedException {
		WebElement element = driver.findElement(By.name("q"));
		
		//create actions object
		Actions actions = new Actions(driver);
		
		// How to enter data
		element.sendKeys("selenium");
		Thread.sleep(3000);
				
		// How to do the mouse over and click
		actions.moveToElement(element).click().build().perform();
		Thread.sleep(3000);

		// press arrow down
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(3000);

		// press arrow down
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(3000);

		// press arrow down
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(3000);

		// press enter
		actions.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);

	}

	@Test //WORKING
	public void test2Builder() throws InterruptedException {
		WebElement element = driver.findElement(By.name("q"));
		
		//create actions object
		Actions actions = new Actions(driver);
		
		//How to enter data
		element.sendKeys("selenium");
		Thread.sleep(3000);
		
		//How to do the mouse over and click
		actions.moveToElement(element).click()
		.sendKeys(Keys.ARROW_DOWN)
		.sendKeys(Keys.ARROW_DOWN)
		.sendKeys(Keys.ARROW_DOWN)
		.sendKeys(Keys.ENTER)
		.build().perform();
		
		Thread.sleep(3000);
		
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
 
     How to send the text using the actions.
	 solution:
	 a.sendKeys(<elementObj>, "<some text>").build().perform();
		
	 
	 */
	 
	
	/**
	 How to press the shify key?
	 solution:
	  The keyUp and keyDown methods are used for imitating the keyboard
	  actions of pressing and releasing the keys.
	
	  These methods serve multiple methods like converting the texts into uppercase or lowercase, copy text from source and paste in destination location, 
	 scrolling up and down the web page, multiple value selection
	 */
	

	/**
	Open Google.com
	 
	 Type 'selenium' [in capital using shift key]
	 Type 'interview questions' [without shift]
	 
	 press down
	 press down
	 press down
	 press Enter
	 
	 How to send the text using the actions.
	 solution:
	  sendKeys(<elementObj>, "<some text>").build().perform();
	 * @throws InterruptedException 
	 

	 	//Type selenium in caps using SHIFT
		//action.keyDown(element, Keys.SHIFT).sendKeys(element, "selenium").keyUp(element, Keys.SHIFT).build().perform();
		

   */

	@Test // working
	public void testShift() throws InterruptedException {
		WebElement element = driver.findElement(By.name("q"));
		
		Actions action = new Actions(driver);
		
		//press shift
		action.keyDown(element, Keys.SHIFT);
		//enter selenium
		action.sendKeys(element, "selenium");
		//release shift
		action.keyUp(element, Keys.SHIFT);
		
		//enter 'interview questions'
		action.sendKeys(element, "interview questions");
		
		action.build().perform();
		Thread.sleep(3000);
		
		// press arrow down
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(3000);

		// press arrow down
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(3000);

		// press arrow down
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(3000);

		// press enter
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		
	}


	 @Test //doubt
	public void testShiftBuilder() throws InterruptedException {
		WebElement element = driver.findElement(By.name("q"));
		
		Actions action = new Actions(driver);
		
		//press shift
		action.keyDown(element, Keys.SHIFT) 
		      .sendKeys(element, "selenium") 
		      .keyUp(element, Keys.SHIFT)
		      .sendKeys(element, "interview questions")
		      .sendKeys(Keys.ARROW_DOWN) 
		      .sendKeys(Keys.ARROW_DOWN)
		      .sendKeys(Keys.ARROW_DOWN)
		      .sendKeys(Keys.ENTER)
		      .build().perform();
		Thread.sleep(3000);
	}
	
	/**
		Press
		1.control + Home
		2.control + End
		3.control + f5
	 */
		//WORKING
	@Test 
	public void t3_HomeAndEnd() {
		t1();
		Actions action = new Actions(driver);
		Actions action = new Actions(driver);
		
		// Press END using Actions class
		action.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
		Thread.sleep(3000);
		
		// Press Home using Actions class
		action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
		Thread.sleep(3000);
		
		// Press f5 using Actions class
		action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).build().perform();
		Thread.sleep(3000);
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
