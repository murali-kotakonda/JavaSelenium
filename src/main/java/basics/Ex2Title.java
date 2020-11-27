package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import common.Commons;

/**
 How to get the page title:
-----------------------------
1. create the driver object
2.call  driver.getTitle() method to get the title


Req:
open the browser and Hit the URL "https://gmail.com" using the Java and fetch the title 
open the browser and Hit the URL "https://youtube.com" using the Java and fetch the title  
  
  
 */
public class Ex2Title {
	public static void main(String[] args) {
		// create driver obj
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// open the url
		driver.get("https://www.gmail.com");

		// get the title for gmail
		String title = driver.getTitle();
		System.out.println(title);

		// open the url
		driver.get("http://www.youtube.com");

		// get the title for youtube
		title = driver.getTitle();
		System.out.println(title);

		// close the browser
		driver.quit();
	}
}
