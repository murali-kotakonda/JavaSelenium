package old.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Page {

	final static String reg_Url = "https://customer.oldmutualwealth.co.uk/Registration/1-PersonalInformation";

	final static String driver_Path = "E:\\automation\\chromedriver.exe";

	final static String driver_Type = "webdriver.chrome.driver";

	final static WebDriver driver = new ChromeDriver();

	final static String name = "Navya";

	public void setup() {
		System.setProperty(driver_Type, driver_Path);
	}

	public static void waiting() throws InterruptedException {
		Thread.sleep(5000);
	}

	public static void SendKeys(WebElement ele, String str) {
		ele.sendKeys(str);
	}

	public static WebElement Element(String address, String type) {
		WebElement ele = driver.findElement(By.id(""));
		if (type.equalsIgnoreCase("xpath")) {
			ele = driver.findElement(By.xpath("'+address+'"));
		} else if (type.equalsIgnoreCase("id")) {
			ele = driver.findElement(By.id("'+address+'"));
		} else if (type.equalsIgnoreCase("name"))

			ele = driver.findElement(By.name("'+address+'"));
		return ele;

	}

}
