package actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import old.BaseTest;

public class TestCache2Chrome extends BaseTest{
	
	@Test
	public void test() throws InterruptedException {
		WebElement e = driver.findElement(By.name("q"));
		
		Actions a=new Actions(driver);
		
		a.sendKeys(e,"selenium").build().perform();
		a.sendKeys(Keys.DOWN).build().perform();
		a.sendKeys(Keys.ENTER).build().perform();
	
	}
	
}
