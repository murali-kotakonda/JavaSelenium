import org.openqa.selenium.WebDriver;

import util.Commons;

public class Test1 {
public static void main(String[] args) throws InterruptedException {
	WebDriver  driver  = Commons.getDriver();
	driver.get("https://fb.com");
	String title = driver.getTitle();
	if(!"Facebook – log in or sign up".equals(title)){
		System.out.println("invalid title..");
		System.out.println("expected:: facebbok");
		System.out.println("actual:: "+title);
	}
	Thread.sleep(10000);
	driver.close();
	//driver.quit();
}


/*
*/
}
