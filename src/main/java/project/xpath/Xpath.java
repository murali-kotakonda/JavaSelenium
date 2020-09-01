package project.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Commons;

public class Xpath {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Commons.getDriver();
		
		/* attribute search

		<a href="gmail.com">click here</a>
		<a href="google.com">click here</a>
	WebElement element = driver.findElement(By.xpath("//a[@href='gmail.com']"));
	element.click();	
		 
		  
		  
		<input type="text"/>
     WebElement element = driver.findElement(By.xpath("//input[@type='text']"));
		element.sendKeys("hello");
		
     <label id='error'>Enter values here</label> 
     Xpath=	//label[@id='error']
     
    <input type="text" value="RESET"/>
		WebElement element = driver.findElement(By.xpath("//input[@value='RESET']"));
		element.sendKeys("hello");
		
		 
		 Xpath=//*[@class='show']
		 Xpath=//a[@href='1.html']
		 Xpath= //img[@src='//cdn.guru99.com/images/home/java.png']
		 driver.findElement(By.xpath("//input[@name='name']")).sendKeys("kumar");
		
		 Refer Xpath2.java
		*/
		
		WebElement element = driver.findElement(By.xpath("//a[@href='gmail.com']"));
		element.click();
		    
		 WebElement element1 = driver.findElement(By.xpath("//a[@href='google.com']"));
		 element1.click();
		/*Contains usage
 		 
		 
		 Contains() is a method used in XPath expression. 
		 It is used when the value of any attribute changes dynamically.
		 The contain feature has an ability to find the element with partial text 
		 
		 syntax: tag[contains(@attribute, ‘value‘)]
		 Xpath= //img[contains(@src,’Profile’)]
		 Xpath=//*[contains(@type,'sub')]  -- if the attribute type has partial value 'sub'
		 Xpath=//*[contains(@name,'btn')]  -- if the attribute type has partial value 'btn'
		 
		
		syntax: *[contains(@attribute, ‘value‘)]  -> serach for any tagname + attribute similar match
		syntax: tag[contains(@attribute, ‘value‘)]  -> serach by tagname + attribute similar match
		
		EX: 
		 <a href="gmail.com"> click here </a> 
driver.findElement(By.xpath("//a[contains(@href,'gmail')]	")).click();
driver.findElement(By.xpath("//a[contains(text(),'here')]")).click();
		 
		 */
		 
		//<input type="text" placeholder="Organization/Company Name" name="organization_name" value="" class="form-control sign-up-input-2 ">
		 driver.findElement(By.xpath("//a[contains(text(), 'TESTING')]")).click();
		
		 
		 /*  Or,and usage
		 Syntax: //tag[XPath Statement-1 or XPath Statement-2]
				 
		Ex:1
		<input type="submit" name="submit">
		<input type="button" name="btnReset">
		
		//input[@type='submit' or @name='btnReset']
		
		
		Ex:2
		<input type="submit" name="btnLogin">
		<input type="button" name="btnLogin">
		<input type="submit" name="btnReset">
		 
		//input[@type='submit' and @name='btnLogin']
		  
		  
		 2.//*[@id=’user-message’ or @class=’form-control’]
		 3.//input[@type='submit' and @name='btnLogin']
		 
		 Syntax: //tag[XPath Statement-1 and XPath Statement-2]
		 1.//*[@id=’user-message’ and @class=’form-control’]
		 
		 */
		 //< input type="email" placeholder="Work Email" name="email" value="" class="form-control sign-up-input-2 " >
		  driver.findElement(By.xpath("//input[@name='email' or @placeholder='Work Email']")).sendKeys("TATA@YMAIL.COM");
	        
	        //Finding the full name field via xpath using AND
	      driver.findElement(By.xpath("//input[@name='name' and @placeholder='Full Name*']")).sendKeys("Lambdatest");
	        
	        //Finding the work email field via xpath using OR, where only one of the attribute defined is correct whereas the other incorrect and does not match, still this should work as one of them meets the condition.
	      driver.findElement(By.xpath("//input[@name='email' or @id='not present']")).sendKeys("Lambdatest");
	        
	        //Finding the password field via xpath using AND, where only one of the attribute defined is correct whereas the other incorrect and does not match,this should NOT work as one of them does not meets the condition.
	      driver.findElement(By.xpath("//input[@name='password' and @id='not present']")).sendKeys("Lambdatest");
	 
		
		
		
	      
	      
	      /* Start-with function finds the element whose attribute value

		  Syntax: //tag[starts-with(@attribute, ‘value‘)]
		  <label id="message" > Hello</label>
		  Xpath=//label[starts-with(@id,'message')]
		  
		  
		  <a href="gmail.com">START here</a>
		 
		 */
	      driver.findElement(By.xpath("//a[starts-with(text(), 'START')]")).click();
		
		
	      
	      /*text()
		 
		  Syntax: //tag[text()=’text value‘]
		  Example: .//label[text()=’Enter message’]
		 
		 1.<td>UserID</td>
		  Xpath=//td[text()='UserID']
		  
		 2.//*[text()='Search Google or type a URL']
		 
		 */
	      
	      //<div class="col-sm-12 google-sign-form"><input type="text" placeholder="Organization/Company Name" name="organization_name" value="" class="form-control sign-up-input-2 "> <input type="text" placeholder="Full Name*" name="name" value="" class="form-control sign-up-input-2 "> <input type="email" placeholder="Work Email*" name="email" value="" class="form-control sign-up-input-2 ">
	      driver.findElement(By.xpath("//a[text()='Complete Guide On TestNG Annotations For Selenium WebDriver']")).click();
		
		  /* 

<button type="submit">Signup for Free</button>
				Xpath= //button[text()=’ Signup for Free’]
				Xpath=//button[contains(text(),’ Signup’ )]
				Xpath= //button[@type='submit']

				
				
		  */
	      
	      
	      
		
		/* chain search
		  //<outer>//<inner>  
		  //div[@class=’form-group’]//input[@id=’user-message’]
		 
		 */
		
	      
	      /*Index
	       
	       <div class="col-sm-12 google-sign-form"><input type="text" placeholder="Organization/Company Name" name="organization_name" value="" class="form-control sign-up-input-2 "> <input type="text" placeholder="Full Name*" name="name" value="" class="form-control sign-up-input-2 "> <input type="email" placeholder="Work Email*" name="email" value="" class="form-control sign-up-input-2 ">
	       Xpath= //div[@class= ’ col-sm-12 google-sign-form’]/input[2]
	        driver.findElement(By.xpath("//div[@class='col-sm-12 google-sign-form']/input[2]")).sendKeys("sadhvi singh");
	       */

	}
}
	
