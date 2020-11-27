package basics;


import org.openqa.selenium.WebDriver;

import common.Commons;

/**

Req:
open the browser and Hit the URL "https://gmail.com" using the Java 

Steps:
-------

1.Provide the driver software location ""C:\\chromedriver.exe" to the System.
     Create the web driver Object using the driver software.
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    
2.Open the URL
  driver.get("https://www.gmail.com");
  
3.close the browser
  driver.quit()
  
*/
public class Ex4Comm {
	

	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Commons.getDriver();
		
		//open the url
		driver.get("http://www.google.com");
		Thread.sleep(5000);
		//	close the browser
		driver.quit();
	}
	
	
	
public static void main1(String[] args) {
	WebDriver driver = Commons.getDriver();
	driver.get("http://www.google.com");
	driver.close();
}
}
