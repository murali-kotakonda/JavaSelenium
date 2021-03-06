package real;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GmailLoginTest extends MyBaseTest {

	@Test
	public void loginSuccess() throws InterruptedException {
		driver.findElement(By.xpath("//input[@aria-label='Email or phone']")).sendKeys("navyareddye0@gmail.com");

		driver.findElement(By.xpath("//span[text()='Next']")).click();
		//Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@aria-label='Enter your password']")).sendKeys("sudnav206");

		driver.findElement(By.xpath("//span[text()='Next']")).click();

		Thread.sleep(5000);
	}
	

	@Test
	public void loginFail() throws InterruptedException {
		driver.findElement(By.xpath("//input[@aria-label='Email or phone']")).sendKeys("navyareddye0@gmail.com");

		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@aria-label='Enter your password']")).sendKeys("xyz");

		driver.findElement(By.xpath("//span[text()='Next']")).click();

		//driver.getCurrentUrl()
		driver.findElement(By.xpath("//input[@aria-label='Enter your password']"));
	}

	public void logout() throws InterruptedException {

		driver.findElement(By.xpath("//input[@aria-label='Email or phone']")).sendKeys("navyareddye0@gmail.com");

		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@aria-label='Enter your password']")).sendKeys("sudnav206");

		driver.findElement(By.xpath("//span[text()='Next']")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[@class='gb_cb gbii']")).click();

		driver.findElement(By.linkText("Sign out")).click();

		Thread.sleep(5000);
	}
}
