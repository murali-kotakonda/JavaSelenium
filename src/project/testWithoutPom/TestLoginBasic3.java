package testWithoutPom;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import util.BaseTest;

public class TestLoginBasic3 extends BaseTest{
		
	// login with correct un and correct pwd
	@Test
	public void testLoginSuccess() throws InterruptedException {
		 login("admin","admin");
		Thread.sleep(5000);

		// logout
		WebElement logout = driver.findElement(By.id("logoutLbl"));
		assertTrue(logout.isDisplayed(), "element expeceted to display");
		assertTrue(logout.isEnabled(), "element expected to enable");
		assertTrue(logout.getText().equals("Logout"));
		logout.click();
		Thread.sleep(5000);
	}

	
	// login with correct un and wrong pwd
	@Test
	public void testLoginFailure() throws InterruptedException {
		login("admin", "admin2");
		Thread.sleep(5000);

		// validate the error message
		WebElement invalidlogin = driver.findElement(By.xpath("//font[@color='Red']"));
		assertTrue(invalidlogin.isDisplayed(), "element expeceted to display");
		assertTrue(invalidlogin.isEnabled(), "element expected to enable");
		assertTrue(invalidlogin.getText().equals("Invalid Login."));
	}
	
	//method to perform login
	private void login(String userNameValue,String passwordValue) {

		// get the web element objects
		WebElement usernamelab = driver.findElement(By.id("userNameLbl"));
		WebElement name = driver.findElement(By.name("loginName"));

		WebElement passwordlab = driver.findElement(By.id("passwordLbl"));
		WebElement password = driver.findElement(By.name("password"));

		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
		WebElement formTitle = driver.findElement(By.tagName("h1"));

		checkEnabledAndDisplayed(usernamelab,passwordlab,loginBtn,password,name);

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

		name.sendKeys(userNameValue);
		password.sendKeys(passwordValue);
		loginBtn.click();
	}
}
