package browserCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;

import util.Commons;

public class NavigationEx {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Commons.getDriver();

		// open browser
		driver.get("http://www.google.com");
		Thread.sleep(5000);// wait for 5 seconds

		// for perform navigations, get navigate object
		Navigation navigate = driver.navigate();

		navigate.to("http://www.fb.com");
		Thread.sleep(5000);// wait for 5 seconds

		navigate.back();
		Thread.sleep(5000);// wait for 5 seconds

		navigate.forward();
		Thread.sleep(5000);// wait for 5 seconds

		navigate.refresh();
		Thread.sleep(5000);// wait for 5 seconds

		driver.close();
	}
}
