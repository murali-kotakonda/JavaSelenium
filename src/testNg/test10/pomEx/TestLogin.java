package test10.pomEx;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.Commons;

public class TestLogin { 
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
		login.performLogin("admin2","admin1");
	}
	
	@Test
	public void t2() throws InterruptedException {
		Login login = new Login(driver);
		login.performLogin("admin1","admin");
	}
}