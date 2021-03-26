package testFb.myapp;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 
For xpath use:
WebElement element = driver.findElement(By.xpath(""));

For css use:
WebElement element = driver.findElement(By.cssSelector(""));

	Ex1:
	<a href="https://www.gmail.com">click here</a>
	<a href="https://www.fb.com">click here</a>

solution)
 -> get element that has 'a' as tag name and href as 'https://www.gmail.com'
 	WebElement element1 = driver.findElement(By.xpath("//a[@href='https://www.gmail.com']"));
    WebElement element2 = driver.findElement(By.cssSelector("a[href='https://www.gmail.com']"));
 
 -> get element that has 'a' as tag name and href as 'https://www.fb.com'
    WebElement element3 = driver.findElement(By.xpath("//a[@href='https://www.fb.com']"));
    WebElement element4 = driver.findElement(By.xpath("a[href='https://www.fb.com']"));

 Ex2:
   <input type="text" name="username"  id ="myName"/>
   get web element:
   solution:
   WebElement  we1 = driver.findElement(By.name("username"));
   WebElement we2 = driver.findElement(By.id("myName");
   WebElement we3 =driver.findElement(By.xpath("//input[@name='username']"));
   WebElement we4 =driver.findElement(By.xpath("//input[@id='myName']"));
   WebElement we5 =driver.findElement(By.cssSelector("input[name='username']"));
   WebElement we6 =driver.findElement(By.cssSelector("input[id='myName']"));
   
  Ex3:
  <label id="abc">Enter Id<label> 
  <label id="abc">Enter Name<label> 
   
    WebElement we1 =driver.findElement(By.xpath("//input[text()='Enter Id']"));
    WebElement we2 =driver.findElement(By.xpath("//input[text()='Enter Name']"));
  
  EX4:
  <td>UserID</td>
  WebElement we1 =driver.findElement(By.xpath("//td[text()='UserID']"));
  
  When to use XPath ID's:
------------------------------------
- Cases where you only want to support one selector type
- Your browser does not fully support CSS or all the CSS selectors you need

CSS:
--------

<p class="show"> Hello1 </p>
<p class="show"> Hello2 </p>
<p class="show"> Hello3  </p>
<p class="show"> Hello4  </p>


 List<WebElement>  we1 =driver.findElements(By.xpath("//p[@class='show']"));
 List<WebElement> we2 =driver.findElements(By.cssSelector("p.show));

#get all elements that has 'show' as class attribute
 List<WebElement> we2 =driver.findElements(By.cssSelector(".show));

Some CSS selectors will not work all browsers
CSS selectors are better to use when dealing with classes, IDs and tag names.

 */

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.BaseTest;
import util.Commons;

public class XpathEx  extends BaseTest{
	
	@BeforeMethod
	public void openForm() {
		//open the form.html
		driver.get(Commons.BASE_URL + "xpath2.html");
		sleep(3);
	}

	//<a href="https://www.gmail.com">click here</a>  <br/>
	// <a href="https://www.fb.com">click here</a>  <br/>
	@Test
	public void t1() {
		
		driver.findElement(By.xpath("//a[@href='https://www.gmail.com']")).click();
		sleep(3);
		driver.navigate().back();
		
		sleep(3);
		driver.findElement(By.xpath("//a[@href='https://www.fb.com']")).click();
		sleep(3);
	}
	
	/*  
			<label id='error'>Enter values here</label>  <br/>
 			Enter name : <input id='error' type="text"/><br/><br/>
	 */
	@Test
	public void t2() {
		//<label id='error'>Enter values here</label>  <br/>
		WebElement labelObj = driver.findElement(By.xpath("//label[@id='error']"));
		Assert.assertEquals(labelObj.getText(), "Enter values here");
		
		driver.findElement(By.xpath("//input[@id='error']")).sendKeys("selenium");
		sleep(4);
	}
	
	/*
	 <input type="button" value="RESET" onclick="f1()"/><br/><br/>
	 <input type="button" value="ADD" onclick="f2()"/><br/>
	 <p id="dynamicData"></p>
	 
	*/
	@Test
	public void t3() {
		driver.findElement(By.xpath("//input[@value='RESET']")).click();
		sleep(3);
		
		WebElement dynamicData = driver.findElement(By.id("dynamicData"));
		Assert.assertEquals(dynamicData.getText(), "RESET selected");
		
		driver.findElement(By.xpath("//input[@value='ADD']")).click();
		Assert.assertEquals(dynamicData.getText(), "ADD selected");
		sleep(3);
	}
	
	/**
    validate the below p tag values:
    <p class="show"> Hello1 </p>
	<p class="show"> Hello2 </p>
	<p class="show"> Hello3  </p>
	<p class="show"> Hello4  </p>
   */
	@Test
	public void t4() {
		List<WebElement> list = driver.findElements(By.xpath("//p[@class='show']"));
		Assert.assertEquals(list.size(), 4);
		
		//get each web element obj
		for(WebElement  element : list) {
			Assert.assertTrue(element.getText().contains("Hello"));
		}
		
		sleep(3);
	}
	
	
}
