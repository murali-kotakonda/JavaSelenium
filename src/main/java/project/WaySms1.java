package project;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import common.BaseTest;


public class WaySms1  extends  BaseTest{

	@Before
	public void beforeEveryTime(){
		driver = new ChromeDriver();
		driver.get("http://site24.way2sms.com/content/index.html");	
	}
	
	@Test
	public void login() throws InterruptedException  {
		
		driver.findElement(By.name("mobileNo")).sendKeys("7893605549");
		driver.findElement(By.id("password")).sendKeys("navya620");
		
		driver.findElement(By.xpath("(//button[contains(text(),'Login')])[1]")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys("7893605549");
		
		
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Message']")).sendKeys("hi sir");
		
		driver.findElement(By.xpath("//button[text()='Send Sms']")).click();
		
		Thread.sleep(5000);
		
		
}
	@Test
	public void logout() throws InterruptedException  {
		driver.findElement(By.name("mobileNo")).sendKeys("7893605549");
		driver.findElement(By.id("password")).sendKeys("navya620");
		
		driver.findElement(By.xpath("(//button[contains(text(),'Login')])[1]")).click();
		
		Thread.sleep(5000);
		
	driver.findElement(By.xpath("//i[@class='fa icon-logout hidden-xs']")).click();
	Thread.sleep(5000);
	}
}
