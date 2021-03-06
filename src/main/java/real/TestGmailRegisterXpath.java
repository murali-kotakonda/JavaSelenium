package real;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.Commons;

public class TestGmailRegisterXpath {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Commons.getDriver();

		driver.get("http:\\www.gmail.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Create account']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='firstName'][@id='firstName']")).sendKeys("naveeen");

		driver.findElement(By.xpath("//input[@name='lastName'][@id='lastName']")).sendKeys("shyam");

		driver.findElement(By.xpath("//input[@name='Username'][@id='username']")).sendKeys("navven");

		driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys("singham");

		driver.findElement(By.xpath("//input[@aria-label='Confirm']")).sendKeys("singham");

		driver.findElement(By.xpath("//span[text()='Next']")).click();

		Thread.sleep(5000);
		WebElement e = driver.findElement(By.xpath("//select[@aria-labelledby='month-label']"));

		Actions a = new Actions(driver);

		a.click(e).build().perform();

		a.sendKeys("jun").build().perform();

		Thread.sleep(5000);

		a.sendKeys(Keys.ENTER).build().perform();

		driver.findElement(By.xpath("//input[@aria-label='Day']")).sendKeys("20");

		driver.findElement(By.xpath("//input[@aria-label='Year']")).sendKeys("1995");

		e = driver.findElement(By.id("gender"));

		a.click(e).build().perform();

		Thread.sleep(5000);

		a.sendKeys("f").build().perform();

		a.sendKeys(Keys.ENTER).build().perform();

		driver.findElement(By.xpath("//span[text()='Next']")).click();

		Thread.sleep(5000);

		driver.close();
	}
}
