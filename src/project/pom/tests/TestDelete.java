package pom.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom.pages.Deleteprofile;
import pom.pages.LoginPage;
import util.Commons;

public class TestDelete extends Headerutility {
	LoginPage login;
	Headerutility header;
	Deleteprofile delete;
	
	@BeforeTest
	public void start() {
		driver = Commons.startApplication(driver, "Chrome");
		login=PageFactory.initElements(driver, LoginPage.class);
		header=PageFactory.initElements(driver, Headerutility.class);
		delete=PageFactory.initElements(driver, Deleteprofile.class);
	}
	
	@BeforeMethod
	public void login() {
		login.login("admin", "admin");
		header.employe();
		
	}
	@Test
	public void delete() {
		delete.delete();
	}
}
