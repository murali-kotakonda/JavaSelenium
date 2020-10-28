package testFb;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import util.Commons;

public class Test4Alert {

	public static void main(String[] args) throws NoAlertPresentException,InterruptedException  {									
		WebDriver driver = Commons.getDriver();
        // Alert Message handling
        driver.get(Commons.ALERT_URL);			
     	
        driver.findElement(By.name("submit")).click();			
        		
        // Switching to Alert        
        Alert alert = driver.switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= alert.getText();		
        		
        // Displaying alert message		
        System.out.println(alertMessage);	
        Thread.sleep(5000);
     
       // Accepting alert		
        alert.accept();	
    }	
}
