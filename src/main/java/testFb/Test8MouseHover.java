package testFb;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.Commons;

/**

 */
public class Test8MouseHover extends BaseTest {
	
	@BeforeMethod
	public void setup() {
		super.setup();
		driver.get(Commons.BASE_URL + "hover.html");
		sleep(5);
	}
	
	/**
		Notes:
		For mouse hover
		use moveToElement() on actions
	 */
	@Test
	public void t1() throws InterruptedException {
		Actions actions = new Actions(driver);
		
		/* 
		WebElement element = driver.findElement(By.linkText("Click here"));
		Actions  action= actions.moveToElement(element);
     	action.build().perform(); 
        */
		sleep(3);
		
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
	
	/**
		Notes:
		For mouse hover and click
		use moveToElement()  and click() on actions
	 */
	@Test
	public void t2() throws InterruptedException {
		Actions actions = new Actions(driver);
		
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
		
		sleep(3);
	}

	/**
	validate mouse hover.
    get color of link before mouse hover and after mouse hover.
   use link_Home.getCssValue("color") to get the color.
	*/
	@Test
	public  void t3() throws InterruptedException {
		
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
