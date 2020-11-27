package test10.pomEx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.Commons;

public class TestLogin2 { 
	static WebDriver driver;
	
	@BeforeClass
	public static void before() {
		driver = Commons.getChromeDriver();
	}
	
	@BeforeMethod
	public void beforem() {
		driver.get("http://localhost:8017/EmpDemo/");
	}

	@Test
	public void t1() throws InterruptedException {
		Login login = new Login(driver);
		driver.findElement(By.name("loginName")).sendKeys("11");
		driver.findElement(By.name("password")).sendKeys("3113");
		driver.findElement(By.name("login")).submit();
	}
	
}