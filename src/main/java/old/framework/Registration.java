package old.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration extends Page {
	
	public  void registration() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get(reg_Url);
		Thread.sleep(5000);
		
		/*  Object Declaration - Start -- */
		WebElement txtForeName = Element("//div[./label[text()='Forename:']]//input","xpath");
		WebElement txtSurName = Element("Surname","id");
		
	WebElement txtForeName1 = driver.findElement(By.xpath("//div[./label[text()='Forename:']]//input"));
	WebElement txtSurName1 = driver.findElement(By.id("Surname"));
	WebElement txtPhoneHome = driver.findElement(By.id("PhoneHome"));
	WebElement txtMobile = driver.findElement(By.id("PhoneMobile"));
	WebElement btnContinue = driver.findElement(By.xpath("//input[@value='Continue']"));
	
    /*  Object Declaration - End -- */
	
		SendKeys(txtForeName,name);
		
		txtForeName.sendKeys(name);
		txtSurName.sendKeys("Singamreddy");
		txtMobile.sendKeys("13466897");
		btnContinue.click();
	}

}
