package testFb;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.BaseTest;
import util.Commons;

/**
 	How to switch to a frame?
 	   driver.switchTo().frame(<num>);
       driver.switchTo().frame(1);
       
       driver.switchTo().frame("<id>");
	   driver.switchTo().frame("fr1");
	 
  How to switch to a parent frame?	
     driver.switchTo().defaultContent();   
	   driver.switchTo().parentFrame();
	  
	
 */
public class Test10Frames extends BaseTest {
	
	@BeforeMethod
	public void setup() {
		super.setup();
		driver.get(Commons.BASE_URL + "frames.html");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void t1() throws InterruptedException {
		//switch to frame1 and enter the data
		driver.switchTo().frame("fr1");
		driver.findElement(By.name("data1")).sendKeys("kumar");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		//switch to frame1 and enter the data
		driver.switchTo().frame("fr2");
		driver.findElement(By.name("data2")).sendKeys("varma");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		//switch to frame1 and enter the data
		driver.switchTo().frame("fr3");
		driver.findElement(By.name("data3")).sendKeys("prasad");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		//switch to frame1 and enter the data
		driver.switchTo().frame("fr4");
		driver.findElement(By.name("data4")).sendKeys("hyderabad");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		//switch to original and enter the data
		driver.findElement(By.name("id")).sendKeys("E16126");
		Thread.sleep(3000);
	}
}
