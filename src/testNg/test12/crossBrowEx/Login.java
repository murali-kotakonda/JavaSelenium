package test12.crossBrowEx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	WebDriver driver;
	By loginName = By.name("loginName");
	By password = By.name("password");
	By loginBtn = By.name("login");
	By title = By.tagName("title");

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	public void setLoginName(String strUserName) {
		driver.findElement(loginName).sendKeys(strUserName);
	}

	public void setPassword(String strPassword) {
		driver.findElement(password).sendKeys(strPassword);
	}

	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}

	public String getLoginTitle() {
		return driver.findElement(title).getText();
	}

	public void performLogin(String strUserName, String strPasword) {
		this.setLoginName(strUserName);
		this.setPassword(strPasword);
		this.clickLogin();
	}

}