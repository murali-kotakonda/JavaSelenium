package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
How to make the page to wait for 5 seconds:
------------------------------------------------
Thread.sleep(5000);// wait for 5 seconds


Req:
open the browser and Hit the URL "https://gmail.com" using the Java and fetch the title 
 wait for 5 seconds
open the browser and Hit the URL "https://youtube.com" using the Java and fetch the title  
   wait for 5 seconds
   
  
 */
public class Ex3TitleWait {
	public static void main(String[] args) throws Exception {
		// create driver obj
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// open the url
		driver.get("https://www.gmail.com");
		Thread.sleep(5000);// wait for 5 seconds
		
		// get the title for gmail
		String title = driver.getTitle();
		System.out.println(title);

		// open the url
		driver.get("http://www.youtube.com");
		Thread.sleep(5000);// wait for 5 seconds
		
		// get the title for youtube
		title = driver.getTitle();
		System.out.println(title);

		// close the browser
		driver.quit();
	}
}
