package real;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Commons;

public class TestGmailLoginXpath1 {

	public static void main(String[] args) throws InterruptedException {
		
		/*
		 		Xpath=//tagname[@attribute='value']
		 		
		 		Xpath=//input[@type='text']	
		 		Xpath=	//label[@id='message23']
				Xpath=	//input[@value='RESET']
				Xpath=//*[@class='barone']
				Xpath=//a[@href='http://demo.guru99.com/']
				Xpath= //img[@src='//cdn.guru99.com/images/home/java.png']
		
		*/
		
		/*
		 Contains() is a method used in XPath expression. 
		 It is used when the value of any attribute changes dynamically.
		 The contain feature has an ability to find the element with partial text 
		 
		 Xpath=//*[contains(@type,'sub')]  
		 */
		
		WebDriver driver = Commons.getDriver();
		driver.get("http:\\www.facebook.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("testuser");
		
		Thread.sleep(5000);		
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("testPass");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"u_0_a\"]")).click();
	}
}
	
