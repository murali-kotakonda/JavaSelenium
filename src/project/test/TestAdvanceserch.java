package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.Commons;
import pages.AddEmp;
import pages.Advanceserch;
import pages.LoginPage;

public class TestAdvanceserch extends Headerutility{
	LoginPage login;
	Headerutility header;
	Advanceserch serch;

	public void start() {
		driver = Commons.startApplication(driver, "Chrome");
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
}
