package actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import old.BaseTest;

public class TestCache extends BaseTest{
	
	@Test
	public void test() throws InterruptedException {
		WebElement e = driver.findElement(By.name("q"));
		
		Actions a=new Actions(driver);
		
		a.sendKeys(e,"abdul bari").build().perform();
		a.sendKeys(Keys.DOWN).build().perform();
		a.sendKeys(Keys.DOWN).build().perform();
		a.sendKeys(Keys.ENTER).build().perform();
	
	}

	
	public void test(int x) throws InterruptedException {
		WebElement e = driver.findElement(By.name("q"));
		
		Actions a=new Actions(driver);
		
		a.sendKeys(e,"abdul bari").build().perform();
		a.sendKeys(Keys.DOWN).build().perform();
		a.sendKeys(Keys.DOWN).build().perform();
		a.sendKeys(Keys.ENTER).build().perform();
	
	}
	

	
	@Test
	public void testNumber() throws InterruptedException {
		////input[@aria-label='Google Search'][@value='Google Search']
//
		WebElement e = driver.findElement(By.name("q"));
		
		Actions a=new Actions(driver);
		
		a.sendKeys(e,"java").build().perform();
		a.sendKeys(Keys.DOWN).build().perform();
		a.sendKeys(Keys.ENTER).build().perform();
	
		
	}
	
}
