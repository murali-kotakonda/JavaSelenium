package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Commons;
import pages.LoginPage;
import pages.Serchdepartment;

public class Testserchdept extends Headerutility {
	WebDriver driver;
	LoginPage login;
	Serchdepartment dept;
	Headerutility header;
	
	@BeforeTest
	public void start() {
		driver = Commons.startApplication(driver, "Chrome");
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
}
