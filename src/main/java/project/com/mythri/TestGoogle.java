package project.com.mythri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestGoogle extends BaseTest{
	
	@Test
	public void testGoogle() throws InterruptedException{
		driver.get("http:\\www.google.com");	
	
		WebElement name= driver.findElement(By.name("q"));
		name.sendKeys("selenium") ;
		Thread.sleep(3000);

		
		//press key down
		Actions action = new Actions(driver);
		//action.sendKeys("selenium").build().perform();
		action.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(3000);
		action.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(3000);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
	}

	 
}
