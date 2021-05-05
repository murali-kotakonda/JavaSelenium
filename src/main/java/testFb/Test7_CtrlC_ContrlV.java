package testFb;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.BaseTest;
import util.Commons;


public class Test7_CtrlC_ContrlV extends BaseTest {
	
	@BeforeMethod
	public void setup() {
		super.setup();
		driver.get(Commons.BASE_URL + "form.html");
		sleep(5);
	}
	
	/*
	Enter FirstName1 : <input type="text" id="myname" name="uName" /> <br>
	Enter LastName : <input type="text" name="LName" size="30" width="30" /><br>
	steps:
	1.Enter firstname
	2.ctrl + a
	3.ctrl + c
	4.PRESS TAB 3 TIMES
	5.on last name perform ctrl +v
	*/
	@Test
	public void keyActions() throws InterruptedException {
        // Enter the Name
        WebElement fullName = driver.findElement(By.name("uName"));
        fullName.sendKeys("Ramesh");
        
        sleep(3);
        
		//Create object of the Actions class
        Actions actions = new Actions(driver);
       
        // Select the first name using CTRL + A
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        
        sleep(3);
       
        // Copy the first name using CTRL + C
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("c");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        
        
        //Press the TAB Key  
        actions.sendKeys(Keys.TAB);
        actions.build().perform();
        sleep(3);
        
        //Press the TAB Key  
        actions.sendKeys(Keys.TAB);
        actions.build().perform();
        sleep(3);
        
        //Paste the   CTRL + V
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("v");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        sleep(3);
        
        //  actions.keyDown( Keys.CONTROL ).sendKeys( "a" ).keyUp( Keys.CONTROL ).build().perform();
        //actions.keyDown( Keys.CONTROL ).sendKeys( "c" ).keyUp( Keys.CONTROL ).build().perform();
       // actions.keyDown( Keys.CONTROL ).sendKeys( "v" ).keyUp( Keys.CONTROL ).build().perform();
 }
	
}
