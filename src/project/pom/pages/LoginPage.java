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
	WebElement pwd;
	//WebElement password = driver.findElement(By.name("password"));
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement logbtn;
	//WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
	
	@FindBy(id = "logoutLbl")
	WebElement logout;
	
	public LoginPage(WebDriver idriver) {
		this.driver = idriver;
	}
	
	public void login(String username, String password) {
		Commons.checkEnabledAndDisplayed(usernamelab, name, passwordlab, pwd, logbtn);
		
		assertTrue(form.getAttribute("action").endsWith("login"));
		
		// test the form name
		assertTrue(formTitle.getText().equals("Login Page"));

		// test label for username
		assertTrue(usernamelab.getText().equals("User Name:"));

		// test label for Password
		assertTrue(passwordlab.getText().equals("Password:"));

		// test label for button
		assertTrue(logbtn.getAttribute("value").equals("Login"));

		// test type for username
		assertTrue(name.getAttribute("type").equals("text"));

		// test type for password
		assertTrue(pwd.getAttribute("type").equals("password"));

		name.clear();
		pwd.clear();
		
		name.sendKeys(username);
		pwd.sendKeys(password);
		logbtn.click();
	}
	
	public void logout() {
		WebElement logout = driver.findElement(By.id("logoutLbl"));;
		Commons.checkEnabledAndDisplayed(logout);
		assertTrue(logout.getText().equals("Logout"));
		logout.click();
	}
	
	public void invalidattempt() {
		WebElement invalidlogin = driver.findElement(By.xpath("/html/body/font"));
		Commons.checkEnabledAndDisplayed(invalidlogin);
		assertTrue(invalidlogin.getText().equals("Invalid Login."));
	}
	public void validateLoginFailure() {
		//TEST for invalid error message
		WebElement invalidlogin = driver.findElement(By.xpath("/html/body/font"));
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
	public void validatePasswordLength() {
		//test for alert message
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "password has to be minimum 5 chars and max 10 chars!");
		a.accept();
	}
}
