package real;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestNewTours {

	public static void main(String[] args) throws InterruptedException {
						System.setProperty("webdriver.chrome.driver", "E:\\automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http:\\www.newtours.demoaut.com/");
		Thread.sleep(5000);
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys("navya");
		driver.findElement(By.name("lastName")).sendKeys("singamreddy");
		driver.findElement(By.name("phone")).sendKeys("7893605549");
		driver.findElement(By.name("userName")).sendKeys("navyareddye0@gmail.com");
		
		driver.findElement(By.name("address1")).sendKeys("sreeramnagar");
		
		
		driver.findElement(By.name("address2")).sendKeys("dorasanipalliroad");
		driver.findElement(By.name("city")).sendKeys("proddatur");
		
		driver.findElement(By.name("state")).sendKeys("andhrapradesh");
		
		driver.findElement(By.name("postalCode")).sendKeys("516360");
		Select s = new Select(driver.findElement(By.name("country")));
		s.selectByVisibleText("INDIA");
		driver.findElement(By.name("email")).sendKeys("navyareddye0@gmail.com");
		
		driver.findElement(By.name("password")).sendKeys("navya620");
		
		driver.findElement(By.name("confirmPassword")).sendKeys("navya620");
		
		driver.findElement(By.name("register")).click();
		
		Thread.sleep(5000);	
		
		driver.close();
	}

}
