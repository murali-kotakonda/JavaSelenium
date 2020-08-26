package browserCommands;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import util.Commons;

public class AcessUrl {
	
	
	public static void main1(String[] args) {
		String exePath = "C:\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.close();
	}	
	
	
	
	
public static void main(String[] args) {
	WebDriver driver = Commons.getDriver();
	driver.get("http://www.google.com");
	driver.close();
}
}
