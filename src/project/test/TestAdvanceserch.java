package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Advanceserch;
import pages.LoginPage;
import utility.BrowserFactory;
import utility.Headerutility;

public class TestAdvanceserch {
	WebDriver driver;
	LoginPage login;
	Headerutility header;
	Advanceserch serch;

	public TestAdvanceserch() {
		driver = BrowserFactory.startApplication(driver, "Chrome");
		login = PageFactory.initElements(driver, LoginPage.class);
		header = PageFactory.initElements(driver, Headerutility.class);
		serch = PageFactory.initElements(driver, Advanceserch.class);
	}

	@BeforeMethod
	public void login() {
		login.loginToEmp("admin", "admin");
		header.advance();
	}

	@Test(priority = 0)
	public void serch() {
		serch.serch("");
	}

	@Test(priority = 1)
	public void invalid() {
		serch.serch("anand");
	}

	@AfterMethod
	public void logout() {
		header.logout();
	}

	@AfterClass
	public void quit() {
		BrowserFactory.quitBrowser(driver);
	}
}
