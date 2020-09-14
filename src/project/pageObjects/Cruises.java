package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cruises
{
	WebDriver driver;
	public boolean result;
	public Cruises(WebDriver driver)
	{
		this.driver = driver;
		//System.out.println("Cruise Session ID :" + driver.getWindowHandle());
	}
	
	public boolean bookCruise()
	{
		System.out.println("RC : Book Cruise");
		driver.findElement(By.linkText("Cruises")).click();
		return true;
	}

}
