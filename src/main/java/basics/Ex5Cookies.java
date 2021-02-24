package basics;

/*

-  How to delete the page cookies?
   driver.manage().deleteAllCookies();

-  How to delete the page cookie by name?
   driver.manage().deleteCookieNamed("language");
   
-  How to GET the page cookie by name?   
   driver.manage().getCookieNamed("SID")
   
 - How to get the page cookies?
   Set<Cookie> cookies = driver.manage().getCookies();
    
*/


import java.util.Set;

import org.openqa.selenium.Cookie;

import org.openqa.selenium.WebDriver;

import util.Commons;
public class Ex5Cookies {

	public static void main(String[] args) throws Exception {
		WebDriver driver = Commons.getChromeDriver();

		driver.get("https://www.youtube.com");
		Set<Cookie> cookies = driver.manage().getCookies();
		
		
		for(Cookie cookie : cookies) {
			System.out.println(cookie.getName());
			System.out.println(cookie.getValue());
			System.out.println("****************************");
		}
		
		driver.close();
	}
}





