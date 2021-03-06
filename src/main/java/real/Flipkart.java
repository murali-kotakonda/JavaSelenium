package real;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Flipkart extends MyBaseTest{
	@Test
	public void search() throws InterruptedException{
		
		driver.findElement(By.name("field-keywords")).sendKeys("sprays for men");
		
		
		Thread.sleep(5000);
		
	}
	@Test
	public void moveelement() throws InterruptedException{
		
		WebElement e =		driver.findElement(By.linkText("Amazon Pay"));

		Actions a = new Actions(driver);
		
		a.moveToElement(e).build().perform();
		
		Thread.sleep(5000);
			
	}	
	@Test
	public void shop() throws InterruptedException{
	WebElement e =	(driver.findElement(By.xpath("//span[contains(text(),'Category')]")));
	Actions a = new Actions(driver);
	a.click(e).build().perform();
	Thread.sleep(5000);
	}
	@Test
	public void doublec() throws InterruptedException{	
		WebElement e =		driver.findElement(By.linkText("Today's Deals"));
		
		Actions a = new Actions(driver);
		a.doubleClick(e).build().perform();
		Thread.sleep(5000);

	
	}


}
