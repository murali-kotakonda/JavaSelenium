package pom.pomtests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.pages.LoginPage;

public class TestLogin extends POMBaseTest {

	LoginPage loginPageObj;
	
	@BeforeClass
	public void init() {
		loginPageObj = PageFactory.initElements(driver, LoginPage.class);
	}
	
	

	@Test
	public void testValidCreds() {
		loginPageObj.login("admin", "admin");
	}

	@Test
	public void testValidUnAndInvalidPwd() {
		loginPageObj.login("admin", "admin123");
		sleep(3);
		loginPageObj.logout();
	}

	@Test
	public void testInValidUnAndInvalidPwd() {
		loginPageObj.login("admin123", "admin123");
		sleep(3);
		loginPageObj.validateLoginFailure();
	}

	@Test
	public void testUserNameEmptyAndPasswordEmpty() {
		loginPageObj.login("", "");
		sleep(3);
		loginPageObj.validateLoginNameAlert();
	}

	@Test
	public void testUserNameEmptyAndPasswordNotEmpty() {
		loginPageObj.login("", "admin123");
		sleep(3);
		loginPageObj.validateLoginNameAlert();
	}

	@Test
	public void testUserNameNotEmptyAndPasswordEmpty() {
		loginPageObj.login("admin123", "");
		sleep(5);
		loginPageObj.validatePasswordAlert();
	}

	@Test
	public void testUserNameNotEmptyAndPasswordLengthLessThan4Chars() {
		loginPageObj.login("admin123", "ab");
		sleep(3);
		loginPageObj.validatePasswordLength();
		sleep(3);
	}

	@Test
	public void testUserNameNotEmptyAndPasswordGreaterThan10Chars() {
		loginPageObj.login("admin123", "1212121212122222222");
		sleep(5);
		loginPageObj.validatePasswordLength();
	}
}