package test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Changepassword;
import pages.LoginPage;
import utils.BrowserFactory;

public class Testchangepassword {
	WebDriver driver;
	LoginPage login;
	Changepassword change;

	public Testchangepassword() {
		driver = BrowserFactory.startApplication(driver, "Chrome");
		login = PageFactory.initElements(driver, LoginPage.class);
		change = PageFactory.initElements(driver, Changepassword.class);
	}

	@BeforeMethod
	public void login() {
		login.loginToEmp("thirupathi", "venkatv");

	}

	@Test(priority = 0)
	public void withoutdata() {
		change.changepassword("", "", "");
		Alert a = driver.switchTo().alert();
		a.getText();
		assertTrue(a.getText().equals("Please provide current Password!"));
		a.accept();
		change.logout();
	}

	@Test(priority = 1)
	public void invalid() {
		change.changepassword("venkatv", "", "");
		Alert a = driver.switchTo().alert();
		a.getText();
		assertTrue(a.getText().equals("Please provide new Password!"));
		a.accept();
		change.logout();
	}

	@Test(priority = 2)
	public void notconform() {
		change.changepassword("venkatv", "venkatv", "");
		Alert a = driver.switchTo().alert();
		a.getText();
		assertTrue(a.getText().equals("Please provide confirm new Password!"));
		a.accept();
		change.logout();
	}

	@Test(priority = 3)
	public void change() {
		change.changepassword("venkatv", "venkatv", "venkatv");
		change.logout();
	}

	@AfterMethod
	public void loginchangepassword() {
		login.loginToEmp("thirupathi", "venkatv");
		change.logout();
	}

	@AfterClass
	public void quit() {
		BrowserFactory.quitBrowser(driver);
		driver.quit();

	}
}
