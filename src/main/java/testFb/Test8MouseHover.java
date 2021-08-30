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

 */
public class Test8MouseHover extends BaseTest {
	
	@BeforeMethod
	public void setup() {
		super.setup();
		driver.get(Commons.BASE_URL + "hover.html");
		sleep(5);
	}


	@Test
	public void testTextF() throws InterruptedException {
		WebElement element = driver.findElement(By.name("uName"));
		element.sendKeys("user1");
		
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.moveToElement(element)
		       .sendKeys(element, " user2")
		       .build()
		       .perform();
		
	   Thread.sleep(3000);
	}


	@Test
	public void test1() {
		//create action object
		Actions actions = new Actions(driver);
		
		//get web element
		WebElement link = getByLinkText("Click here");
		
		//move to element
		Actions move = actions.moveToElement(link);
		
		move.build().perform();
		sleep(3);
	}
	

	/**
		Notes:
		For mouse hover
		use moveToElement() on actions

			steps:
	1.get the web element obj
	2.get actions obj
	3.call movetoElement() method
	4.call build and perform method
	
		WebElement element = driver.findElement(By.linkText("Click here"));
		Actions  action= actions.moveToElement(element);
     	action.build().perform(); 
     	
	 */
	@Test
	public void t2() throws InterruptedException {
		Actions actions = new Actions(driver);
		
		//mouse over on link1
		actions.moveToElement(getLinkObj("Click for fb")).build().perform();
		Thread.sleep(3000);
	
		//mouse over on link2
		actions.moveToElement(getLinkObj("Click for Gmail")).build().perform();
		Thread.sleep(3000);
		
		//mouse over on link3
		actions.moveToElement(getLinkObj("Click for Google")).build().perform();
		Thread.sleep(3000);
		
		//mouse over on link4
		actions.moveToElement(getLinkObj("form page")).build().perform();
		Thread.sleep(3000);
		
		//mouse over on link5
		actions.moveToElement(getLinkObj("alert page")).build().perform();
		Thread.sleep(3000);
		
	}

	public WebElement getLinkObj(String linkText) {
		return driver.findElement(By.linkText(linkText));
	}

	
	/**
		Notes:
		For mouse hover and click
		use moveToElement()  and click() on actions
	 */
	@Test
	public void t3() throws InterruptedException {
		Actions actions = new Actions(driver);
		
		//mouse over on link1
		actions.moveToElement(getLinkObj("Click for fb")).click().build().perform();
		Thread.sleep(3000);
		driver.navigate().back();
	
		//mouse over on link2
		actions.moveToElement(getLinkObj("Click for Gmail")).click().build().perform();
		Thread.sleep(3000);
		driver.navigate().back();
		
		//mouse over on link3
		actions.moveToElement(getLinkObj("Click for Google")).click().build().perform();
		Thread.sleep(3000);
		driver.navigate().back();
		
		//mouse over on link4
		actions.moveToElement(getLinkObj("form page")).click().build().perform();
		Thread.sleep(3000);
		driver.navigate().back();
		
		//mouse over on link5
		actions.moveToElement(getLinkObj("alert page")).click().build().perform();
		Thread.sleep(3000);
		driver.navigate().back();
		
	}

	/**
	validate mouse hover.
    get color of link before mouse hover and after mouse hover.
   use link_Home.getCssValue("color") to get the color.
	*/
	@Test
	public  void t4() throws InterruptedException {
		
		//get web element
		WebElement link_Home = getByLinkText("Click here");
		
		 //get the color  before mouse hover 
		String bgColor = link_Home.getCssValue("color");
		System.out.println("Before hover: " + bgColor);
		sleep(3);
		
		//mouse hover
		Actions builder = new Actions(driver);
	    builder.moveToElement(link_Home).build().perform();

	    //get the color after mouse hover 
		bgColor = link_Home.getCssValue("color");
		sleep(3);
		System.out.println("After hover: " + bgColor);
	}

	//Enter FirstName : <input type="text" id="myname" name="uName" /> <br>
	@Test
	public void testText_1() {
		Actions action = new Actions(driver);
		
		//move to text field and click
		WebElement element = getTextFieldByName("uName");
		
		action.moveToElement(element).click().build().perform();
		sleep(3);
		
		action.sendKeys(element, "selenium").build().perform();
		sleep(3);
	}

//use shift key
	@Test
	public void testText_2() {
		Actions action = new Actions(driver);
		
		//move to text field and click
		WebElement element = getTextFieldByName("uName");
		
		action.moveToElement(element).click().build().perform();
		sleep(3);
		
		action
		.keyDown(Keys.SHIFT)
		.sendKeys(element, "selenium")
		.keyUp(Keys.SHIFT)
		.build().perform();
		
		sleep(3);
	}
	

	//double click + right click
	@Test
	public void testText_3() throws InterruptedException {
		WebElement element = driver.findElement(By.name("uName"));
		
		Actions action = new Actions(driver);
		
		//enter selenium
		action
		.sendKeys(element, "selenium")
		.build().perform();
		Thread.sleep(3000);
		
		// Double click
		action.doubleClick(element).build().perform();
		Thread.sleep(3000);
		
		// Right click
		action.contextClick(element).build().perform();
		Thread.sleep(3000);
		
	}

 

	@Test
	public void testText_4() {
		Actions action = new Actions(driver);
		
		//move to text field and click
		WebElement element = getTextFieldByName("uName");
		
		action.moveToElement(element).click() 
		.sendKeys(element, "selenium")
		.doubleClick(element)
		.contextClick(element)
		.build().perform();
		
		sleep(3);
	}

	/**
	  Type Hello in caps using SHIFT
	  Double click
	  Right click
      Enter FirstName : <input type="text" id="myname" name="uName" /> <br>
	 */
	@Test
	public void keysTest1() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement txtUsername = driver.findElement(By.id("myname"));
		
		//move to element
		action.moveToElement(txtUsername).click().build().perform();
		sleep(3);
		
		//Type Hello in caps using SHIFT
		action.keyDown(txtUsername, Keys.SHIFT)
		.sendKeys(txtUsername, "selenium")
		.keyUp(txtUsername, Keys.SHIFT)
		.build().perform();
		sleep(3);

	}
	
	/**
	  Type Hello in caps using SHIFT
	  Double click
	  Right click
      Enter FirstName : <input type="text" id="myname" name="uName" /> <br>
	 */
	@Test
	public void keysTest2() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement txtUsername = driver.findElement(By.id("myname"));
		
		//move to element
		action.moveToElement(txtUsername).click().build().perform();
		sleep(3);
		
		//Type Hello in caps using SHIFT
		action.keyDown(txtUsername, Keys.SHIFT)
		.sendKeys(txtUsername, "hello")
		.keyUp(txtUsername, Keys.SHIFT)
		.build().perform();
		sleep(3);
		
		// Double click
		action.doubleClick(txtUsername).build().perform();
		sleep(3);
		
		// Right click
		action.contextClick(txtUsername).build().perform();
		sleep(3);
		
		action
				.moveToElement(txtUsername)
				.click()
				.keyDown(txtUsername, Keys.SHIFT)
				.sendKeys(txtUsername, "hello")
				.keyUp(txtUsername, Keys.SHIFT)
				.doubleClick(txtUsername)
				.contextClick()
				.build().perform();
		sleep(5);
	}
	
}
