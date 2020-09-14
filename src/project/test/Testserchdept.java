package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import old.pages.LoginPage;
import old.pages.Serchdepartment;
import old.utility.BrowserFactory;
import old.utility.Headerutility;

public class Testserchdept extends Headerutility {
	WebDriver driver;
	LoginPage login;
	Serchdepartment dept;
	Headerutility header;
	public Testserchdept() {
		driver=BrowserFactory.startApplication(driver,"Chrome");
		login=PageFactory.initElements(driver,LoginPage.class);
		dept=PageFactory.initElements(driver,Serchdepartment.class);
		header=PageFactory.initElements(driver,Headerutility.class);
	}
	@BeforeMethod
	public void login() {
		login.loginToEmp("admin", "admin");
	}
	@Test
	public void invalid() {
		header.serchdept();
		dept.serchdept("");
		dept.invalid();
		header.logout();
	}
	@Test
	public void serch() {
		header.serchdept();
		dept.serchdept("HR");
		dept.afterserch();
		header.logout();
	}
	@AfterClass
	public void quit() {
		BrowserFactory.quitBrowser(driver);
	}

}
