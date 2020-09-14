package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Hotels
{
	WebDriver driver;
	public boolean result;
	public Hotels(WebDriver driver)
	{
		this.driver = driver;
		//System.out.println("Hotels Session ID :" + driver.getWindowHandle());
	}
	
	public boolean bookHotel()
	{
		System.out.println("RC : Book Hotel");
		driver.findElement(By.linkText("Hotels")).click();
		return false;
	}

}
