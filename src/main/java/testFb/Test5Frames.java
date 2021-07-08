package testFb;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.BaseTest;
import util.Commons;

/**
 	<iframe id="fr1" src="frame_1.html">/</iframe>
	<iframe id="fr2" src="frame_2.html">/</iframe>
	<iframe id="fr3" src="frame_3.html">/</iframe>
	<iframe id="fr4" src="frame_4.html">/</iframe>
	
	How to switch to a frame?
	 1.driver.switchTo().frame(<num>);
	   ex:
	   driver.switchTo().frame(1);
	   
	 2.driver.switchTo().frame("<id>");
	   ex:
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
		sleep(5);
	}
	
	/**
	

	 */
	@Test
	public void t1() {
		//switch to frame1 and enter the data
		driver.switchTo().frame("fr1");
		driver.findElement(By.name("data1")).sendKeys("kumar");
		sleep(5);
		driver.switchTo().defaultContent();
		
		//switch to frame2 and enter the data
		driver.switchTo().frame("fr2");
		driver.findElement(By.name("data2")).sendKeys("varma");
		sleep(5);
		driver.switchTo().defaultContent();
		
		//switch to frame3 and enter the data
		driver.switchTo().frame("fr3");
		driver.findElement(By.name("data3")).sendKeys("prasad");
		sleep(5);
		driver.switchTo().defaultContent();
		
		//switch to frame4 and enter the data
		driver.switchTo().frame("fr4");
		driver.findElement(By.name("data4")).sendKeys("hyderabad");
		sleep(5);
		driver.switchTo().defaultContent();
		
		//switch to original and enter the data
		driver.findElement(By.name("id")).sendKeys("E16126");
		sleep(5);
	}
}
