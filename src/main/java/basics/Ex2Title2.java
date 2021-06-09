package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Req:
open the browser and Hit the URL "https://gmail.com" using the Java and fetch the title 
open the browser and Hit the URL "https://youtube.com" using the Java and fetch the title  

How to get the page title?
solution)
use "driver.getTitle()"

*/

public class Ex2Title2 {
public static void main(String[] args) throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	//open  gmail
	driver.get("https://www.gmail.com");
	String title = driver.getTitle();
	System.out.println(title);
	Thread.sleep(5000);
	
	//open  youtube
	driver.get("https://www.youtube.com");
	title = driver.getTitle();
	System.out.println(title);
	Thread.sleep(5000);
	
	driver.close();
}
}







