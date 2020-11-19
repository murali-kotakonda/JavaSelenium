package testFb;

import static org.testng.Assert.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.Commons;

public class Test4Alert extends BaseTest{

	@BeforeMethod
	public void setup() {
		super.setup();
		driver.get(Commons.BASE_URL + "alert.html");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 How to switch to alert?
	  Alert alert = driver.switchTo().alert();	
	  
	 How to get alert message?
       String alertMessage= alert.getText();
       
      How to click ok on alert message?
       alert.accept();	
	 
	 */
	@Test
	public void testAlert1() throws Exception  {									
        driver.findElement(By.name("submit")).click();			
        		
        // Switching to Alert        
        Alert alert = driver.switchTo().alert();		
        		
        // Capturing and validate alert message.    
        String alertMessage= alert.getText();		
        assertEquals(alertMessage , "Hello", "Invalid popup message");
        
        Thread.sleep(5000);
        // Accepting alert		
        alert.accept();	
        
        Thread.sleep(4000);
    }
	
	/**
	 How to click on Ok/accept?
	  alert.accept();	
	  
	 How to click on cancel/dismiss?
	  alert.dismiss(); 
	 */
	 // <input type="button" name="alert1" onclick="check2()" value="alert2">
	@Test
	public void testAlert21() throws Exception  {									
        Alert alert = clickOnAlert1();
        // click ok		
        alert.accept();	
        Thread.sleep(5000);
    }
	
	@Test
	public void testAlert22() throws Exception  {									
        Alert alert = clickOnAlert1();
        // click cancel		
        alert.dismiss();
        Thread.sleep(5000);
    }

	private Alert clickOnAlert1() throws InterruptedException {
		driver.findElement(By.name("alert1")).click();			
        // Switching to Alert        
        Alert alert = driver.switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= alert.getText();		
        assertEquals(alertMessage , "do you want to continue?", "Invalid popup message");		
        
        Thread.sleep(5000);
		return alert;
	}
	
	/**
	How to send data to the popup?
	  alert.sendKeys("<some text>");
	 */
	 
	//<input type="button" name="alert2" onclick="check3()" value="alert3">
	@Test
	public void testAlert3() throws Exception {
		driver.findElement(By.name("alert2")).click();

		// Switching to Alert
		Alert alert = driver.switchTo().alert();

		// Capturing alert message.
		String alertMessage = alert.getText();
		assertEquals(alertMessage , "enter page", "Invalid popup message");
		
		Thread.sleep(5000);
		alert.sendKeys("ex1.html");
		
		// click ok
		alert.accept();
		Thread.sleep(5000);
	}
}
