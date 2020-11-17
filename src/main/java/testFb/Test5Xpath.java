package testFb;

import static org.testng.Assert.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.BaseTest;
import util.Commons;

/**

For xpath use:
driver.findElement(By.xpath(""));

For css use:
driver.findElement(By.cssSelector(""));

 */
public class Test5Xpath extends BaseTest{

	@BeforeMethod
	public void setup() {
		super.setup();
		driver.get(Commons.BASE_URL + "xpath1.html");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 Click on both links
	 <a href="https://www.gmail.com">click here</a>  <br/>
	  <a href="https://www.fb.com">click here</a>  <br/>

	 */
	@Test
	public void testXpath1() throws Exception  {
		//get web element for link1 and click
		driver.findElement(By.xpath("//a[@href='https://www.gmail.com']")).click();

		sleep(5);
		driver.navigate().back();
		
		//get web element for link2 and click
		driver.findElement(By.xpath("//a[@href='https://www.fb.com']")).click();
		
		Thread.sleep(5000);
		driver.navigate().back();
	}
	
	/**
	 validate the label text.
	 Enter data to text field.
	  
	<label id='error'>Enter values here</label>  <br/>
	 Enter name : <input id='error' type="text"/><br/><br/>
	 */
	
	@Test
	public void t2() throws Exception {
		WebElement label =driver.findElement(By.xpath("//label[@id='error']"));
		assertEquals( label.getText(),"Enter values here" ,"invalid label value");
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("testuser2");
		sleep(4);
		//driver.findElement(By.xpath("//input[@id='error']")).sendKeys("testuser1");
	}

	/**
	 click on RESET and ADD button
	  <input type="button" value="RESET" onclick="f1()"/><br/><br/>
      <input type="button" value="ADD" onclick="f2()"/><br/>
        <p id="dynamicData"></p>
	 */
	@Test
	public void t3() throws Exception {
		driver.findElement(By.xpath("//input[@value='RESET']")).click();
		sleep(3);
		assertEquals( driver.findElement(By.id("dynamicData")).getText(),"RESET selected" ,"Invalid value");
		
		driver.findElement(By.xpath("//input[@value='ADD']")).click();
		sleep(3);
		assertEquals( driver.findElement(By.id("dynamicData")).getText(),"ADD selected" ,"Invalid value");
	}
	
	/**
	  enter password value
	 <input type="password" name="password"/>
	 */
	@Test
	public void t4() throws Exception {
			WebElement element1 = driver.findElement(By.xpath("<pass xpath here>"));
			List<WebElement> elements1 = driver.findElements(By.xpath("<pass xapth here>"));

			WebElement element2 = driver.findElement(By.cssSelector("<pass css path here>"));
			List<WebElement> elements2 = driver.findElements(By.cssSelector("<pass css path here>"));
			    
			/*
						test
						--------
						enabled
						displayed
						count test
			*/
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("hello");
		sleep(3);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("hello123");
		sleep(3);
		driver.findElement(By.name("password")).sendKeys("hello1234");
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
	public void t5() throws Exception {
		//List<WebElement> elements = driver.findElements(By.xpath("//*[@class='show']"));
		List<WebElement> elements = driver.findElements(By.xpath("//p[@class='show']"));
		assertEquals( elements.size(),4 ,"Invalid value");
		
		for(WebElement  e1: elements) {
			assertTrue(e1.getText().contains("Hello"),"Expected Hello");
		}
		sleep(5);
	}
}
