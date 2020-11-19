package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Deleteprofile;
import pages.LoginPage;
import utils.BrowserFactory;
import utils.Headerutility;

public class TestDelete {
	WebDriver driver;
	LoginPage login;
	Headerutility header;
	Deleteprofile delete;
	
	public TestDelete() {
		driver=BrowserFactory.startApplication(driver, "Chrome");
		login=PageFactory.initElements(driver, LoginPage.class);
		header=PageFactory.initElements(driver, Headerutility.class);
		delete=PageFactory.initElements(driver, Deleteprofile.class);
		
	}
	@BeforeMethod
	public void login() {
		login.loginToEmp("admin", "admin");
		header.employe();
		
	}
	@Test
	public void delete() {
		delete.delete();
	}

}
