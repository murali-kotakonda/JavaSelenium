package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.UpdateProfile;
import utility.BrowserFactory;
import utility.Headerutility;

public class UpdateTest {
	WebDriver driver;
	LoginPage login;
	Headerutility header;
	UpdateProfile update;
	public UpdateTest() {
		driver=BrowserFactory.startApplication(driver, "Chrome");
		login=PageFactory.initElements(driver, LoginPage.class);
		header=PageFactory.initElements(driver, Headerutility.class);
		update=PageFactory.initElements(driver, UpdateProfile.class);
		
	}
	@BeforeMethod
	public void login() {
		login.loginToEmp("venkat", "vaddem");
	}
	@Test
	public void update() {
		update.uppdate("venkatarao","vaddempudi","9988774455");
		
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
