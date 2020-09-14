package pages;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\krish\\Desktop\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles");
		driver.findElement(By.xpath("//input[@value = 'Go']")).click();
		List<WebElement> count = driver
				.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		int j = count.size();
		System.out.println(j);
		for (int i = 0; i < count.size(); i++) {
			System.out.println(count.get(i).getText());
		}
		WebElement prdtTitle = driver
				.findElement(By.xpath("//a[contains(@href,'Redmi-comet-Blue-32GB-storage/dp/B07QT569GM')"));
		prdtTitle.click();
		String name = prdtTitle.getText();
		System.out.println(name);
		String prid = driver.getWindowHandle();
		System.out.println(prid);
		Set<String> allwindows = driver.getWindowHandles();
		System.out.println(allwindows);
		for (String x : allwindows) {
			if (!prid.equals(x)) {
				driver.switchTo().window(x);

				driver.findElement(By.id("add-to-cart-button")).click();
				driver.findElement(By.id("nav-cart")).click();
				WebElement addprdt = driver.findElement(
						By.xpath("//span[contains(text(),'Redmi 7 (Comet Blue, 3GB RAM, 32GB Storage)')]"));
				String compareTitle = addprdt.getText();
				System.out.println(compareTitle);
				if (name.equals(compareTitle)) {
					System.out.println("the product is added to the cart");
				}
				driver.switchTo().window(prid);
				WebElement opp = driver.findElement(
						By.xpath("//span[contains(text(),'OPPO K3(Aurora Blue, 6GB RAM, 64GB Storage)')]"));
				WebDriverWait w = new WebDriverWait(driver, 100);
				WebElement y = w.until(ExpectedConditions.elementToBeClickable(opp));
				y.click();
				String ndprdt = driver.getTitle();
				System.out.println(ndprdt);
				driver.switchTo().window(x);
				String title2ndprdt = driver.getTitle();
				System.out.println(title2ndprdt);
				driver.findElement(By.id("add-to-cart-button")).click();
				driver.findElement(By.id("nav-cart")).click();
			}
		}
	}
}
