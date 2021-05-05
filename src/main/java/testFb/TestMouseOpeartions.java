package testFb;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.BaseTest;
import util.Commons;

public class TestMouseOpeartions extends BaseTest{
	
	@BeforeMethod
	public void openForm() {
		//open the form.html
		driver.get(Commons.BASE_URL + "hover.html");
		sleep(3);
	}
	
	/**
	Notes:
	For mouse hover
	use moveToElement() on actions
  */
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
	
	@Test
	public void test2() {
		//create action object
		Actions actions = new Actions(driver);
		
		//move to element
		actions.moveToElement(getByLinkText("Click here")).build().perform();
		sleep(3);
		
		actions.moveToElement(getByLinkText("Click for Date")).build().perform();
		sleep(3);

		actions.moveToElement(getByLinkText("Send Data")).build().perform();
		sleep(3);

		actions.moveToElement(getByLinkText("Ex1")).build().perform();
		sleep(3);

		actions.moveToElement(getByLinkText("Ex2")).build().perform();
		sleep(3);
	}
	
	//move to element and click
	@Test
	public void test3() {
		//create action object
		Actions actions = new Actions(driver);
		
		//move to element
		actions.moveToElement(getByLinkText("Click here")).click().build().perform();
		sleep(3);
		
		driver.navigate().back();
		
		actions.moveToElement(getByLinkText("Click for Date")).click().build().perform();
		sleep(3);

		driver.navigate().back();
		
		actions.moveToElement(getByLinkText("Send Data")).click().build().perform();
		sleep(3);

		driver.navigate().back();
		
		actions.moveToElement(getByLinkText("Ex1")).click().build().perform();
		sleep(3);
		driver.navigate().back();
		
		actions.moveToElement(getByLinkText("Ex2")).click().build().perform();
		sleep(3);
		driver.navigate().back();
	}
	
	//Enter FirstName : <input type="text" id="myname" name="uName" /> <br>
	@Test
	public void testText() {
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
	public void testText2() {
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
	public void testText2_dc_rc() {
		Actions action = new Actions(driver);
		
		
		WebElement element = getTextFieldByName("uName");
		//move to text field and click
		action.moveToElement(element).click().build().perform();
		sleep(3);
		
		//enter selenium
		action
		.sendKeys(element, "selenium")
		.build().perform();

		// Double click
		action.doubleClick(element).build().perform();
		sleep(3);
		
		// Right click
		action.contextClick(element).build().perform();
		sleep(3);
		
	}
	
	@Test
	public void testText2_dc_rc2() {
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
}
