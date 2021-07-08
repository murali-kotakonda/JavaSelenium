package testFb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Commons;
public class TestXpathNotes {
	  /**
		 xpath:
		-----------
		attribute search
		
		//tagName     --> all elements with that tag name
		// tagName[@attributename ='attributevalue']     --> all elements with that tag name and attrbute name 
		
		 
		Ex1:
		<a href="https://www.gmail.com">click here</a>
		<a href="https://www.fb.com">click here</a>

		solution)
		 -> get element that has 'a' as tag name and href as 'https://www.gmail.com'
		    syntax:
   				//a[@href = 'https://www.gmail.com' ]

		 	WebElement element1 = driver.findElement(By.xpath("//a[@href='https://www.gmail.com']"));
		    WebElement element2 = driver.findElement(By.cssSelector("a[href='https://www.gmail.com']"));

		 -> get element that has 'a' as tag name and href as 'https://www.fb.com'
		   syntax:
   				//a[@href = 'https://www.fb.com' ]
		    WebElement element3 = driver.findElement(By.xpath("//a[@href='https://www.fb.com']"));
		    WebElement element4 = driver.findElement(By.xpath("a[href='https://www.fb.com']"));


		  
		2.
		<label id='error'>Enter values here</label>
		<input id='error' type='text'/> 
		<label id='error2'>Enter data</label>
		
	 -> get element that has 'label' as tag name and id as 'error'
		syntax:
		 //label[@id='error']


		 WebElement element2 = driver.findElement(By.xpath(" //label[@id='error']"));

		
		3. <input type="text"/>
		-> get element that has 'input' as tag name and type as 'text'
		syntax:
		 //input[@type='text']
		 
		WebElement element2 = driver.findElement(By.xpath("//input[@type='text']"));
		
		4.<input type="submit" value="RESET"/>
		  <input type="submit" value="ADD"/>
		
		WebElement element1 =driver.findElement(By.xpath("//input[@value='RESET']"));
		WebElement element2 =driver.findElement(By.xpath("//input[@value='ADD']"));
		
		
		
5.<input type="text" name="username"  id ="myName"/>
WebElement  we1 = driver.findElement(By.name("username"))
 WebElement we2 = driver.findElement(By.id("myName")
WebElement we3 = driver.findElement(By.xpath("//input[@name='username']"))
 WebElement we4 = driver.findElement(By.xpath("//input[@id='myName']"))
  WebElement element2 = driver.findElement(By.cssSelector("//input[@name='username']"))
  WebElement element2 = driver.findElement(By.cssSelector("//input[@id='myName']"))
 WebElement we5 = WebElement element2 = driver.findElement(By.tagName("input"))

		
		6. <input type="text" name="age"/>
		WebElement element3=driver.findElement(By.xpath("//input[@name='age']"));
		
		
		7.<img src="mypic.jpeg/>
		 WebElement element3=driver.findElement(By.xpath("//img[@src='mypic.jpeg']"));
		
		8.
		<p class="show"> test1 </p>
		<p class="show"> test2 </p>
		<p class="show"> test3 </p>
		<p class="show"> test4 </p>
		
		 Xpath=//p[@class='show']
		 List<WebElement> elements=driver.findElements(By.xpath("//p[@class='show']"));
		 */
	
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Commons.getDriver();
		
		/*
		 Contains usage
		 
		 Contains() is a method used in XPath expression. 
		 It is used when the value of any attribute changes dynamically.
		 The contain feature has an ability to find the element with partial text 
		 
		 syntax: tag[contains(@attribute, ‘value‘)]
		  
		9:
		  <img src='ProfilePic123445.jpg'/>
   		  Xpath= //img[contains(@src,’Profile’)] - similar match
		  Xpath = //img[@src='ProfilePic123445.jpg']  - exact match

		10:
		<a href="https://www.gmail.com"> click here for gmail page </a>
		WebElement element1 =driver.find_element_by_xpath("//a[@href='https://www.gmail.com']")
		WebElement element2 =driver.find_element_by_xpath("//a[contains(@href,'gmail')]")
		WebElement element3 =driver.find_element_by_xpath("//a[contains(text(),'gmail page')]")  -- partial serach by text


		  
  		11:
		A)<input type= 'subContractor' />
		B) <input type= 'subRegister' />
		C) <p type= 'subAgent' />
		D)  <input type= 'password' />
	      
			1.-- Get only input tag elements if the attribute type has partial value 'sub'
			 Xpath=//input[contains(@type,'sub')] 
			fetches A & B 

			2. -- Get only p tag elements if the attribute type has partial value 'sub'
			 Xpath=//p[contains(@type,'sub')]

			fetches C

			3. -- Get all elements if the attribute type has partial value 'sub'
			 Xpath=//*[contains(@type,'sub')]    -> tag name can be anything , but type should contain 'sub'
			Fetches A , B & C
	 
	  Ex3: 
		 <input name= 'btnUser1' />
		 <input name= 'btnUser2' />
		 <p name= 'btnUser3' />
		 Xpath=//*[contains(@name,'btn')]  -- all elements if the attribute type has partial value 'btn'
		 Xpath=//input[contains(@name,'btn')]  -- input elements if the attribute type has partial value 'btn'
		 
		syntax: *[contains(@attribute, ‘value‘)]  -> serach for any tagname + attribute similar match
		syntax: tag[contains(@attribute, ‘value‘)]  -> serach by tagname + attribute similar match
		
		EX4: 
		    <a href="https://www.gmail.com"> click here </a> 
		    driver.findElement(By.linkText("click here")).click();
			driver.findElement(By.partialLinkText("click")).click();
			driver.findElement(By.xpath("//a[@href='https://www.gmail.com']	")).click();
			driver.findElement(By.xpath("//a[contains(@href,'gmail')]	")).click();
			driver.findElement(By.xpath("//a[contains(text(),'click here')]")).click();
					 
		 */
 

		 /*
	     <td class="abc">hello</td>		
		here td => tag 
		class ='abc ' ==> attribute
		hello  => text
	      
	      text()
		  Syntax: //tag[text()=’text value‘]
		           //*[text()='Search Google or type a URL']
		
		//<input type="text" placeholder="Organization/Company Name" name="organization_name" value="" class="form-control sign-up-input-2 ">
		 driver.findElement(By.xpath("//a[contains(text(), 'TESTING')]")).click();
		
		12.
			<td>UserID</td>
			<td>name</td>
			<td>age</td>
			
		WebElement element1=driver.findElement(By.xpath("//td[text()='UserID']"));  
		WebElement element2=driver.findElement(By.xpath("//td[text()='name']")); 
		WebElement element3=driver.findElement(By.xpath("//td[text()='age']")); 
     	

 	    13:
		  <label id="abc">Enter Id<label> 
		  <label id="abc">Enter Name<label> 
		   
		  WebElement we1 =driver.findElement(By.xpath("//input[text()='Enter Id']"));
		  WebElement we2 =driver.findElement(By.xpath("//input[text()='Enter Name']"));
		   

		14:
		 <label>Enter message<label>
		
		 here label is tag
		 'Enter message' is the text
		 
		

	
		  here label is tag
		  id is the attribute , 'xyz' is attribute value
		 'Enter message' is the text
		  
		 Xpath = //label[text()='Enter message']   -> exact match
		 Xpath = //label[contains(text() ,'message')]-> similar match
		 
		
		WebElement we1 =driver.findElement(By.xpath("//label[text()='Enter message']")); -> exact match
		WebElement we2 =driver.findElement(By.xpath("//label[contains(text() ,'message')]"));-> similar match


		 Ex2:
		   <td>UserID</td>
		   Xpath=//td[text()='UserID']
		  
		 Ex3:
		   <a href="https://www.gmail.com"> click here </a> 
		    driver.findElement(By.xpath("//a[text()='click here')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'click')]")).click();
			
		 Ex4:	
			<button type="submit">Signup for Free</button>
				Xpath= //button[text()='Signup for Free']
				Xpath=//button[contains(text(),'Signup')]
				Xpath= //button[@type='submit']
  		 */
	      
	      //<div class="col-sm-12 google-sign-form"><input type="text" placeholder="Organization/Company Name" name="organization_name" value="" class="form-control sign-up-input-2 "> <input type="text" placeholder="Full Name*" name="name" value="" class="form-control sign-up-input-2 "> <input type="email" placeholder="Work Email*" name="email" value="" class="form-control sign-up-input-2 ">
	      driver.findElement(By.xpath("//a[text()='Complete Guide On TestNG Annotations For Selenium WebDriver']")).click();
	      
		 /*  
		 
		 Or,and usage
		 Syntax: //tag[XPath Statement-1 or XPath Statement-2]
		 Syntax: //tag[XPath Statement-1 and XPath Statement-2]
		
		15.
		<input type="button" name="CLEAR">
		<input type="submit" name="submit">
		<input type="button" name="btnReset">
		 
		 Req: click on submit button or Reset buton
		solution:
		xpath:  //input[@name='submit' or @name='btnReset']
		List<WebElement> wes =driver.findElements(By.xpath("//input[@name='submit' or @name='btnReset']"));
		  


		16.
		<input type="submit" name="btnLogin">
		<input type="button" name="btnLogin">
		<input type="submit" name="btnReset">
		 
		 click on submit button and with name as btnLogin
		//input[@type='submit' and @name='btnLogin']
		  
		 17.
		 <input type="user-message1" class="form-control1">
		 <input type="user-message2" class="form-control1">
		 <input type="user-message1" class="form-control3">
		 
		 //*[@id=’user-message1’ or @class=’form-control’]
		 
		 */
		 //< input type="email" placeholder="Work Email" name="email" value="" class="form-control sign-up-input-2 " >
		  driver.findElement(By.xpath("//input[@name='email' or @placeholder='Work Email']")).sendKeys("TATA@YMAIL.COM");
	        
	        //Finding the full name field via xpath using AND
	      driver.findElement(By.xpath("//input[@name='name' and @placeholder='Full Name*']")).sendKeys("Lambdatest");
	        
	        //Finding the work email field via xpath using OR, where only one of the attribute defined is correct whereas the other incorrect and does not match, still this should work as one of them meets the condition.
	      driver.findElement(By.xpath("//input[@name='email' or @id='not present']")).sendKeys("Lambdatest");
	        
	        //Finding the password field via xpath using AND, where only one of the attribute defined is correct whereas the other incorrect and does not match,this should NOT work as one of them does not meets the condition.
	      driver.findElement(By.xpath("//input[@name='password' and @id='not present']")).sendKeys("Lambdatest");
	      
	    
	      
	      /*
	      Start-with function finds the element whose attribute value

		  Syntax: //tag[starts-with(@attribute, ‘value‘)]
		  
   		  Ex1:
    	    <label id="message1234" > Hello</label>
    	     <label id="error" > Hello</label>

    	     //get the label that has id starting with message

		    Xpath=//label[starts-with(@id,'message')]   
      
			Ex2:
			 <a href="gmail.com">START here</a>
			 <a href="fb.com">Click here</a>
		       
		 click on gmail:
		 
		 xpath = //a[starts-with(text(), 'START')]  
		 xpath = //a[starts-with(@href, 'gmail')]
		 
     	 driver.findElement(By.xpath("//a[starts-with(text(), 'START')]")).click();
		 driver.findElement(By.xpath("//a[starts-with(href, 'gmail')]")).click();
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

/* 
 


similar match:
-----------------------------------------------

syntax: tag[contains(@attribute, ‘value‘)]  -> serach by tagname + attribute similar match

<a href="https://www.gmail.com"> click here for gmail page </a>

we1 =  driver.find_element_by_tag("a")
we3 =  driver.find_element_by_link_text(" click here for gmail page ") # exact match
we4 =  driver.find_element_by_partial_link_text("gmail page") #similar match
we2 =  driver.find_element_by_xpath("//a[@href='https://www.gmail.com']") #exact attribute match
we5 =  driver.find_element_by_xpath("//a[contains(@href,'gmail')]") #similar attribute match


'and; 'or' usage:
---------------------------------------------------
<input type="submit" name="submit">
<input type="button" name="CLEAR">
<input type="button" name="btnReset">



webelements =driver.find_element_by_xpath("//input[@type='submit' or @name='btnReset']") # using or fetches two buttons
webelements =driver.find_element_by_xpath("//input[@type='button' and @name='CLEAR']") # using and

 */
	
