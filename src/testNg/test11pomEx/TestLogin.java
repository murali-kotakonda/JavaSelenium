package test11pomEx;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.Commons;
import utility.BrowserFactory;

public class TestLogin  {
	WebDriver driver;
	LoginPage login;

	public TestLogin() {
		driver = Commons.getChromeDriver();
		login = PageFactory.initElements(driver, LoginPage.class);
	}

	@BeforeClass
	public void open() {
		driver.get("");	
	}
	
	@AfterClass
	public void closing() {
		driver.close();
	}
	
	@Test
	public void withoutUN_Pwd() {
		//login.loginToEmp("", "");
		login.enterUserName("");
		login.enterPassword("");
		login.clickLogin();
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide loginName!");
		a.accept();
	}

	@Test
	public void withUN_withoutpassword() {
		//login.loginToEmp("admin", "");
		login.enterUserName("admin");
		login.enterPassword("");
		login.clickLogin();
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide Password!");
		a.accept();
	}
	
	@Test
	public void withoutUN_withpassword() {
		login.performLogin("", "ada");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide Login!");
		a.accept();
	}


	@Test(priority = 2)
	public void invalidUNAndPass() {
		login.performLogin("admin1", "admin");
		login.invalidattempt();
	}

	@Test(priority = 3)
	public void validpasswordinvalidusername() {
		login.performLogin("admin", "admin1");
		login.invalidattempt();
	}

	@Test(priority = 4)
	public void invalidusernameandpassword() {
		login.performLogin("admin1", "admin1");
		login.invalidattempt();
	}

	@Test(priority = 6)
	public void invalidusernameandpassword5times() {
		for (int i = 1; i <= 5; i++) {
			login.performLogin("thirupathiswamy", "vaddemp");
			login.invalidattempt();
		}
	}

	@Test(priority = 7)
	public void driver() {
		login.performLogin("thirupathiswamy", "vaddem");
		login.maxattempt();
	}

	@Test
	// public void Registration_data(String name, String pass) throws Exception {
	public void log() {
		login.performLogin("admin", "admin");
		login.logout();
	}

	@AfterClass
	public void quit() {
		BrowserFactory.quitBrowser(driver);
		driver.quit();
	}
}
