package basics;

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

How to maximize the window?
------------------------------------
driver.manage().window().maximize();

Req:
1.Open gmail.com
2.wait for 5 seconds
3.perform refresh
4.Open youtube.com
5.wait for 5 seconds
6.Perform back operation  
7.wait for 5 seconds
8.Perform forward operation 
9.wait for 5 seconds
10.close the browser
 */



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Ex4 {
	public static void main(String[] args) throws InterruptedException {
		// create driver obj
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(3000);// wait for 5 seconds
		
		driver.manage().window().maximize();

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
