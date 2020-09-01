package testNg1.test11pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.Commons;

public class TestChangePassword  {
	WebDriver driver;
	LoginPage login;
	MyProfilePage myProfilePage;
	ChangePasswordPage changePasswordPage;

	public TestChangePassword() {
		driver = Commons.getChromeDriver();
		login = PageFactory.initElements(driver, LoginPage.class);
		myProfilePage = PageFactory.initElements(driver, MyProfilePage.class);
		changePasswordPage = PageFactory.initElements(driver, ChangePasswordPage.class);
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
	public void changePwd() {
		login.performLogin("admin", "admin");
		myProfilePage.clickChangePwd();
		changePasswordPage.changepassword("admin","admin","admin@12345");
	}
}
