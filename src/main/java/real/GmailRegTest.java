package real;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GmailRegTest extends MyBaseTest {
	@Test
	public void regestration() throws InterruptedException {
		
		WebElement createAcc = driver.findElement(By.xpath("//span[text()='Create account']"));
		Assert.assertNotNull("create account is expected.",createAcc);
		createAcc.click();
		
		Thread.sleep(5000);
		WebElement fName = driver.findElement(By.xpath("//input[@name='firstName'][@id='firstName']"));
		Assert.assertEquals("Invalid size for firstName.",172,fName.getSize().getWidth());
		fName.sendKeys("navya");

		
		WebElement lName = driver.findElement(By.xpath("//input[@name='lastName'][@id='lastName']"));
		String text = lName.getText();
		Assert.assertEquals("Invalid value for lastName","",text);
		Assert.assertEquals("Invalid size for lastName.",174,lName.getSize().getWidth());
		lName.sendKeys("singamreddy");

		WebElement uName = driver.findElement(By.xpath("//input[@name='Username'][@id='username']"));
		uName.sendKeys("navyareddyyyy");
		
		WebElement pwd  = driver.findElement(By.xpath("//input[@name='Passwd']"));
		
		pwd.sendKeys("navya620@%");

		driver.findElement(By.xpath("//input[@aria-label='Confirm']")).sendKeys("navya620@%");

		driver.findElement(By.xpath("//span[text()='Next']")).click();

		Thread.sleep(5000);
	}

	@Test
	public void login() throws InterruptedException {
		driver.findElement(By.xpath("//input[@aria-label='Email or phone']")).sendKeys("navyareddye0@gmail.com");

		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@aria-label='Enter your password']")).sendKeys("sudnav206");

		driver.findElement(By.xpath("//span[text()='Next']")).click();

		Thread.sleep(5000);

	}

	@Test
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
