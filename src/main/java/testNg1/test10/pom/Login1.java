package testNg1.test10.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login1 {
	WebDriver driver;
	By loginName = By.name("loginName");
	By password = By.name("password");
	By loginBtn = By.name("login");
	By title = By.tagName("title");

	public Login1(WebDriver driver) {
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