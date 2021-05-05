package pom.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.pages.LoginPage;

/**
  1.login with correct un and correct pwd [admin , admin 
  2.login with correct  un and wrong pwd [ admin , admin1]
  3.login with wrong un and wrong pwd [  admin2, admin3] 
  4.user name empty and pwd empty 
  5.username empty and pwd not  empty 
  6.username not empty and pwd is empty 
  7.pass < 4 
  8. pass> 10
 */
public class TestLogin2  extends POMBaseTest {

	LoginPage loginPageObj;
	
	@BeforeClass
	public void init() {
		loginPageObj = PageFactory.initElements(driver, LoginPage.class);
	}
	
	@Test
	public void testValidCreds() {
		loginPageObj.login("admin","admin");
		loginPageObj.logout();
		sleep(5);
	}
	
	@Test
	public void testValidUnAndInvalidPwd() {
		loginPageObj.login("admin","admin123");
		loginPageObj.invalidattempt();
	}
	
	@Test
	public void testInValidUnAndInvalidPwd() {
		loginPageObj.login("admin123","admin123");
		loginPageObj.invalidattempt();
	}

	@Test
	public void testUserNameEmptyAndPasswordEmpty() {
		loginPageObj.login("","");
		loginPageObj.validateLoginNameAlert();
	}

	@Test
	public void testUserNameEmptyAndPasswordNotEmpty() {
		loginPageObj.login("","admin123");
		loginPageObj.validateLoginNameAlert();
		sleep(5);
	}
	
	@Test
	public void testUserNameNotEmptyAndPasswordEmpty() {
		loginPageObj.login("admin123",""); 
		//test for alert message
		loginPageObj.validatePasswordAlert();
	}

	@Test
	public void testUserNameNotEmptyAndPasswordLengthLessThan4Chars() {
		loginPageObj.login("admin123","ab"); 
		//test for alert message
		loginPageObj.validatePassLength();
	}

	@Test
	public void testUserNameNotEmptyAndPasswordGreaterThan10Chars() {
		loginPageObj.login("admin123","1212121212122222222"); 
		loginPageObj.validatePassLength();
	}

	@Test(priority = 7)
	public void driver() {
		loginPageObj.login("thirupathiswamy", "vaddem");
		loginPageObj.maxattempt();
	}

	@Test(priority = 6)
	public void invalidusernameandpassword5times() {
		for (int i = 1; i <= 5; i++) {
			loginPageObj.login("thirupathiswamy", "vaddemp");
			loginPageObj.invalidattempt();
		}
	}
}
