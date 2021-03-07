package pom.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import util.Commons;

public class LoginPage {

	WebDriver driver;

	@FindBy(tagName = "form")
	WebElement form;
	
	@FindBy(tagName = "h1")
	WebElement tag;
	
	@FindBy(id = "userNameLbl")
	WebElement usernamelab;
	
	@FindBy(name = "loginName")
	WebElement uname;
	
	@FindBy(id = "passwordLbl")
	WebElement passwordlab;
	
	@FindBy(name = "password")
	WebElement pwd;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement logbtn;
	
	@FindBy(id = "logoutLbl")
	WebElement logout;
	
	@FindBy(xpath = "/html/body/font")
	WebElement invalidlogin;

	
	public LoginPage(WebDriver idriver) {
		this.driver = idriver;
	}
	
	public void login(String username, String password) {
		Commons.checkEnabledAndDisplayed(usernamelab, uname, passwordlab, pwd, logbtn);
		
		assertTrue(form.getAttribute("action").endsWith("login"));
		
		// test the form name
		assertTrue(tag.getText().equals("Login Page"));

		// test label for username
		assertTrue(usernamelab.getText().equals("User Name:"));

		// test label for Password
		assertTrue(passwordlab.getText().equals("Password:"));

		// test label for button
		assertTrue(logbtn.getAttribute("value").equals("Login"));

		// test type for username
		assertTrue(uname.getAttribute("type").equals("text"));

		// test type for password
		assertTrue(pwd.getAttribute("type").equals("password"));

		uname.sendKeys(username);
		pwd.sendKeys(password);
		logbtn.click();
	}
	
	public void logout() {
		Commons.checkEnabledAndDisplayed(logout);
		assertTrue(logout.getText().equals("Logout"));
		logout.click();
	}
	
	public void invalidattempt() {
		invalidlogin = driver.findElement(By.xpath("/html/body/font"));
		Commons.checkEnabledAndDisplayed(invalidlogin);
		assertTrue(invalidlogin.getText().equals("Invalid Login."));
	}

	@FindBy(xpath = "/html/body/font")
	WebElement maxattempt;

	public void maxattempt() {
		Commons.checkEnabledAndDisplayed(maxattempt);
		assertTrue(maxattempt.getText().equals("You have exceded Maximum no of attempts.Please contact Admin"));
	}
	
	public void validatePassLength() {
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "password has to be minimum 5 chars and max 10 chars!");
		a.accept();
	}
	public void validateLoginNameAlert() {
		//test for alert message
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide loginName!");
		a.accept();
	}
	public void validatePasswordAlert() {
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide Password!");
		a.accept();
	}
}
