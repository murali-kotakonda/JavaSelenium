package old.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Securable {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http:\\www.gmail.com");
		Thread.sleep(10000);
		String x = driver.getCurrentUrl();

		if (x.contains(x)) {
			System.out.println("securable site");
		} else {
			System.out.println("Not securable");
		}
		driver.close();
	}

}
