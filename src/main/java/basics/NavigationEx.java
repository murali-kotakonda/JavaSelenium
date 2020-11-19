package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.Commons;

/**
 
How to perform refresh on page?
------------------------------------
driver.navigate().refresh();


How to perform back on page?
------------------------------------
driver.navigate().back();

 
How to perform forward on page?
------------------------------------
driver.navigate().forward();


Req:
1.Open gmail.com
2.wait for 5 seconds
3.perfrom refresh
4.Open youtube.com
5.wait for 5 seconds
6.Perform back operation  ====> it will go to gmail.com
7.wait for 5 seconds
8.Perform forward operation====> it will go to youtube.com
9.wait for 5 seconds
10.close the browser
 */

public class NavigationEx {
	public static void main(String[] args) throws InterruptedException {
		// create driver obj
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// open browser
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);// wait for 5 seconds

		//refresh
		driver.navigate().refresh();
		Thread.sleep(5000);// wait for 5 seconds
		
		// open youtube
		driver.get("http://www.youtube.com");
		Thread.sleep(5000);// wait for 5 seconds

		//back
		driver.navigate().back();
		Thread.sleep(5000);// wait for 5 seconds

		//forward
		driver.navigate().forward();
		Thread.sleep(5000);// wait for 5 seconds

		driver.close();
	}
}
