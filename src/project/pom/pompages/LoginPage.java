package pom.pompages;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import util.Commons;

public class LoginPage extends BasePage {
	
	@FindBy(tagName = "form")
	WebElement form;
	//WebElement form = driver.findElement(By.tagName("form"));
	
	@FindBy(tagName = "h1")
	WebElement formTitle;
	//WebElement formTitle = driver.findElement(By.tagName("h1"));
	
	@FindBy(id = "userNameLbl")
	WebElement usernamelab;
	//WebElement usernamelab = driver.findElement(By.id("userNameLbl"));
	
	@FindBy(name = "loginName")
	WebElement name;
	//WebElement name = driver.findElement(By.name("loginName"));
	
	@FindBy(id = "passwordLbl")
	WebElement passwordlab;
	//WebElement passwordlab = driver.findElement(By.id("passwordLbl"));
	
	@FindBy(name = "password")
	WebElement password;
	//WebElement password = driver.findElement(By.name("password"));
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;
	
	public LoginPage(WebDriver idriver) {
		this.driver = idriver;
	}
	
	
	// method to perform login
		public void login(String userNameValue, String passwordValue) {

			Commons.checkEnabledAndDisplayed(usernamelab, passwordlab, loginBtn, password, name);

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

			name.clear();
			password.clear();
			
			name.sendKeys(userNameValue);
			password.sendKeys(passwordValue);
			loginBtn.click();
		}
	
		public void logout() {
			//logout
			WebElement logout = driver.findElement(By.id("logoutLbl"));;
			Commons.checkEnabledAndDisplayed(logout);
			assertTrue(logout.getText().equals("Logout"));
			logout.click();
		}
		
		public void validateLoginFailure() {
			//TEST for invalid error message
			WebElement invalidlogin = driver.findElement(By.xpath("/html/body/font"));
			Commons.checkEnabledAndDisplayed(invalidlogin);
			assertTrue(invalidlogin.getText().equals("Invalid Login."));
		}
		
		public void validateLoginNameAlert() {
			//test for alert message
			Alert a = driver.switchTo().alert();
			Reporter.log(a.getText());
			Assert.assertEquals(a.getText(), "Please provide loginName!");
			a.accept();
		}
		
		public void validatePasswordAlert() {
			//test for alert message
			Alert a = driver.switchTo().alert();
			Reporter.log(a.getText());
			Assert.assertEquals(a.getText(), "Please provide Password!");
			a.accept();
		}
		
		public void validatePasswordLength() {
			//test for alert message
			Alert a = driver.switchTo().alert();
			Reporter.log(a.getText());
			Assert.assertEquals(a.getText(), "password has to be minimum 5 chars and max 10 chars!");
			a.accept();
		}
}


