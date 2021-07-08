package testFb;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.BaseTest;
import util.Commons;

public class Test4Alert1 extends BaseTest{
	
	@BeforeMethod
	public void openForm() {
		//open the form.html
		driver.get(Commons.BASE_URL + "alerts.html");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
	}
	
	/* 
	 How to switch to alert and get alert obj?
	  Alert alert = driver.switchTo().alert();	

 	 How to get alert message?
       String alertMessage= alert.getText();
       
      How to click ok on alert message?
       alert.accept();	
      
      How to click on cancel/dismiss?
	  alert.dismiss(); 
	  
	  How to send data to the popup?
	  alert.sendKeys("<some text>");
	  
	 */

	//<input type="button" name="alert1" onclick="check1()" value="alert1"><br><br>
	@Test
	public void testAlert1() throws InterruptedException {
		driver.findElement(By.name("alert1")).click();
		Thread.sleep(2000);

		// Switching to Alert
		Alert alert = driver.switchTo().alert();

		// Capturing alert message.
		String alertMessage = alert.getText();
		Assert.assertEquals(alertMessage, "Hello","invalid alert message");

		
		 // Accepting alert	
		 alert.accept();	
		 Thread.sleep(2000);
	}
	
	
	//<input type="button" name="alert2" onclick="check2()" value="alert2"><br><br>
	@Test
	public void testAlert2Ok() throws InterruptedException {
		driver.findElement(By.name("alert2")).click();
		
		// Switching to Alert
		Alert alert = driver.switchTo().alert();

		// Capturing alert message.
		String alertMessage = alert.getText();
		Thread.sleep(5000);
		Assert.assertEquals(alertMessage, "do you want to continue?");
		
		//click on OK
		alert.accept();
		Thread.sleep(5000);
		
	}
	
	//<input type="button" name="alert2" onclick="check2()" value="alert2"><br><br>
	@Test
	public void testAlert2Cancel() throws InterruptedException {
		driver.findElement(By.name("alert2")).click();
		
		// Switching to Alert
		Alert alert = driver.switchTo().alert();

		// Capturing alert message.
		String alertMessage = alert.getText();
		Thread.sleep(5000);
		Assert.assertEquals(alertMessage, "do you want to continue?");
		
		//click on cancel
		alert.dismiss();
		Thread.sleep(5000);
	}
	
	//<input type="button" name="alert3" onclick="check3()" value="alert3"><br><br>
	@Test
	public void testAlert4() throws InterruptedException {
		driver.findElement(By.name("alert3")).click();
		
		// Switching to Alert
		Alert alert = driver.switchTo().alert();

		// Capturing alert message.
		String alertMessage = alert.getText();
		Assert.assertEquals(alertMessage, "enter page");
		
		Thread.sleep(3000);
		//enter data
		alert.sendKeys("Ex1.html");
		
		// click ok
		alert.accept();
		Thread.sleep(3000);
	}
	
}
