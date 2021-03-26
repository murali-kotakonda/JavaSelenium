package basics;
/*
Req:
open the browser and Hit the URL "https://gmail.com" using the Java and fetch the title 
open the browser and Hit the URL "https://youtube.com" using the Java and fetch the title  
 
*/

import org.openqa.selenium.WebDriver;

import util.Commons;



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

import util.Commons;
public class Ex4 {

	
	public static void main(String[] args) throws Exception {
		//get webdriver 
		 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 
		 driver.get("http://www.gmail.com");
		 Thread.sleep(5000);// wait for 5 seconds
		 driver.navigate().refresh(); // stays on http://www.gmail.com
		 String title = driver.getTitle();
		 System.out.println(title);
		 
		driver.get("http://www.youtube.com");
		Thread.sleep(5000);// wait for 5 seconds
		title = driver.getTitle();
		 System.out.println(title);
		 
		driver.navigate().back(); // redirect to http://www.gmail.com
		title = driver.getTitle();
		 System.out.println(title);
		
		Thread.sleep(5000);// wait for 5 seconds
		driver.navigate().forward();// redirect to http://www.youtube.com
		title = driver.getTitle();
		System.out.println(title);
		 
		Thread.sleep(5000);// wait for 5 seconds
		driver.close();
			 
	}
}





