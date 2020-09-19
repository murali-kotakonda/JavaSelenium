package test11pomEx;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.Commons;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver idriver) {
		this.driver = idriver;
	}

	@FindBy(name = "loginName")
	WebElement uname;
	@FindBy(name = "password")
	WebElement pwd;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement logbtn;
	@FindBy(xpath = "/html/body/font")
	WebElement invalidlogin;

	public void performLogin(String username, String password) {
		enterUserName(username);
		enterPassword(password);
		clickLogin();
	}

	public void clickLogin() {
		Commons.checkEnabledAndDisplayed(logbtn);
		assertTrue(logbtn.getAttribute("value").equals("Login"));
		logbtn.click();
	}

	public void enterPassword(String password) {
		Commons.checkEnabledAndDisplayed(pwd);
		assertTrue(pwd.getAttribute("type").equals("password"));
		pwd.clear();
		pwd.sendKeys(password);
	}

	public void enterUserName(String username) {
		Commons.checkEnabledAndDisplayed(uname);
		assertTrue(uname.getAttribute("type").equals("text"));
		uname.clear();
		uname.sendKeys(username);
	}
	
	public void invalidattempt() {
		Commons.checkEnabledAndDisplayed(invalidlogin);
		assertTrue(invalidlogin.getText().equals("Invalid Login."));
	}
}
