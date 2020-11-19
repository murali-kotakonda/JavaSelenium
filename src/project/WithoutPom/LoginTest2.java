package WithoutPom;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import utils.BaseTest;

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
public class LoginTest2 extends BaseTest {

	@Test
	public void testValidCreds() {
		login("admin","admin");
		WebElement logout = driver.findElement(By.id("logoutLbl"));;
		checkEnabledAndDisplayed(logout);
		assertTrue(logout.getText().equals("Logout"));
		logout.click();
		sleep(5);
	}
	
	@Test
	public void testValidUnAndInvalidPwd() {
		login("admin","admin123");
		
		//TEST for invalid error message
		WebElement invalidlogin = driver.findElement(By.xpath("/html/body/font"));
		checkEnabledAndDisplayed(invalidlogin);
		assertTrue(invalidlogin.getText().equals("Invalid Login."));
	}
	
	@Test
	public void testInValidUnAndInvalidPwd() {
		login("admin123","admin123");

		//TEST for invalid error message
		WebElement invalidlogin = driver.findElement(By.xpath("/html/body/font"));
		checkEnabledAndDisplayed(invalidlogin);
		assertTrue(invalidlogin.getText().equals("Invalid Login."));
	}

	@Test
	public void testUserNameEmptyAndPasswordEmpty() {
		login("","");
		
		//test for alert message
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide loginName!");
		a.accept();
	}
	
	@Test
	public void testUserNameEmptyAndPasswordNotEmpty() {
		login("","admin123");

		//test for alert message
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide loginName!");
		a.accept();
		sleep(5);
		
	}
	
	@Test
	public void testUserNameNotEmptyAndPasswordEmpty() {
		login("admin123",""); 
		
		//test for alert message
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide Password!");
		a.accept();
		sleep(5);
	}
	
	@Test
	public void testUserNameNotEmptyAndPasswordLengthLessThan4Chars() {
		login("admin123","ab"); 
		
		//test for alert message
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "password has to be minimum 5 chars and max 10 chars!");
		a.accept();
		sleep(5);
	}

	
	@Test
	public void testUserNameNotEmptyAndPasswordGreaterThan10Chars() {
		login("admin123","1212121212122222222"); 

		//test for alert message
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "password has to be minimum 5 chars and max 10 chars!");
		a.accept();
		sleep(5);
	}
	
	private void login(String un, String pwd) {
		WebElement form = driver.findElement(By.tagName("form"));
		WebElement formTitle = driver.findElement(By.tagName("h1"));
		WebElement usernamelab = driver.findElement(By.id("userNameLbl"));
		WebElement passwordlab = driver.findElement(By.id("passwordLbl"));
		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
		WebElement name = driver.findElement(By.name("loginName"));
		WebElement password = driver.findElement(By.name("password"));

		checkEnabledAndDisplayed(usernamelab, name, passwordlab, password, loginBtn);

		// test the form name
		assertTrue(formTitle.getText().equals("Login Page"));

		// test label for username
		assertTrue(usernamelab.getText().equals("User Name:"));

		// test label for Password
		assertTrue(passwordlab.getText().equals("Password:"));

		// test label for button
		assertTrue(loginBtn.getAttribute("value").equals("Login"));

		// test type for username
		assertTrue(name.getAttribute("type").equals("text"));

		// test type for password
		assertTrue(password.getAttribute("type").equals("password"));

		name.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();

		sleep(5);
	}
}
