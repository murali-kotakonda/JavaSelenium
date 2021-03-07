package pom.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom.pages.LoginPage;
import pom.pages.UpdateProfile;
import util.Commons;

public class UpdateTest extends Headerutility{
	LoginPage login;
	Headerutility header;
	UpdateProfile update;
	
	@BeforeTest
	public void start() {
		driver = Commons.startApplication(driver, "Chrome");
		login=PageFactory.initElements(driver, LoginPage.class);
		header=PageFactory.initElements(driver, Headerutility.class);
		update=PageFactory.initElements(driver, UpdateProfile.class);
	}

	@BeforeMethod
	public void login() {
		login.login("venkat", "vaddem");
	}
	@Test
	public void update() {
		update.uppdate("venkatarao","vaddempudi","9988774455");
		
	}
	@AfterMethod
	public void logout() {
		header.logout();
	}
}
