package basics;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import util.Commons;

/**

Req:
open the browser and Hit the URL "https://gmail.com" using the Java 

Steps:
-------

1.Create the web driver Object using the driver software.
Provide the driver software location ""C:\\chromedriver.exe" to the System.
System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
    
2.Open the URL usting get() method
  driver.get("https://www.gmail.com");
  
3.close the browser
  driver.quit()
  
WebDriver driver = new ChromeDriver();
Here WebDriver is a interface
ChromeDriver is a child class.

Based on the browser we need the child class.

  
  
*/
public class Ex1 {
	
	public static void main(String[] args) throws InterruptedException {
		//create driver obj
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//open the url
		driver.get("http://www.google.com");
	
    //wait for 5 seconds
		Thread.sleep(5000);
		//	close the browser
		driver.quit();
	}
	
	
	
public static void main1(String[] args) {
	WebDriver driver = Commons.getChromeDriver();
	driver.get("http://www.google.com");
	driver.close();
}
}
