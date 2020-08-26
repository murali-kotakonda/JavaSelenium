package browserCommands;

import org.openqa.selenium.WebDriver;

import util.Commons;

public class AcessUrlGetTitle {
	public static void main(String[] args) {
		WebDriver driver = Commons.getDriver();
		driver.get("http://www.google.com");

		driver.navigate().to("");
		// get title
		String title = driver.getTitle();
		System.out.println(title);

		// get current url
		String CurrentUrl = driver.getCurrentUrl();
		System.out.println(CurrentUrl);
		driver.close();// closes last window
		driver.quit();// closes all windows
	}
}
