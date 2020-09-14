package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cars
{
	WebDriver driver;
	public boolean result;
	public Cars(WebDriver driver)
	{
		this.driver = driver;
		//System.out.println("Cars Session ID :" + driver.getWindowHandle());
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	public boolean bookCar()
	{
		System.out.println("RC : Book Car");
		driver.findElement(By.linkText("Car Rentals")).click();
		return true;
	}

}
