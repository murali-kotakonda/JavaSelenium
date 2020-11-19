package testFb;

import static org.testng.Assert.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.Commons;

public class Test6CSS extends BaseTest{

	@BeforeMethod
	public void setup() {
		super.setup();
		driver.get(Commons.BASE_URL + "xpath.html");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCSS1() throws Exception  {
		//get web element for link1
		WebElement link1=driver.findElement(By.cssSelector("a#href='https://www.gmail.com'"));
		link1.click();

		Thread.sleep(5000);
		driver.navigate().back();
		
		//get web element for link2
		WebElement link2=driver.findElement(By.xpath("//a[@href='https://www.fb.com']"));
		link2.click();
		
		Thread.sleep(5000);
		driver.navigate().back();
	}
	
	@Test
	public void t2() throws Exception {
		WebElement label =driver.findElement(By.xpath("//label[@id='error']"));
		assertEquals( label.getText(),"Enter values here" ,"invalid label value");
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("testuser1");
		Thread.sleep(5000);
	}

	@Test
	public void t3() throws Exception {
		driver.findElement(By.xpath("//input[@value='RESET']")).click();
		Thread.sleep(5000);
		assertEquals( driver.findElement(By.id("dynamicData")).getText(),"RESET selected" ,"Invalid value");
		
		driver.findElement(By.xpath("//input[@value='ADD']")).click();
		Thread.sleep(5000);
		assertEquals( driver.findElement(By.id("dynamicData")).getText(),"ADD selected" ,"Invalid value");
	}
	
	@Test
	public void t4() throws Exception {
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("hello");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("hello123");
		Thread.sleep(5000);
	}
	
	@Test
	public void t5() throws Exception {
		List<WebElement> elements = driver.findElements(By.xpath("//*[@class='show']"));
		assertEquals( elements.size(),4 ,"Invalid value");
		
		for(WebElement  e1: elements) {
			assertTrue(e1.getText().contains("Hello"),"Expected test");
		}
		Thread.sleep(5000);
	}
}
