package old.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaySms {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://site24.way2sms.com/content/index.html");
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.id("mobileNo")).sendKeys("7893605549");
		driver.findElement(By.id("password")).sendKeys("navya620");
		driver.findElement(By.xpath("(//button[contains(text(),'Login')])[1]")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys("7893605549");
		
		
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Message']")).sendKeys("hi sir");
		
		driver.findElement(By.xpath("//button[text()='Send Sms']")).click();
		
		Thread.sleep(5000);
		
		
		
		
}

	
	
}	
