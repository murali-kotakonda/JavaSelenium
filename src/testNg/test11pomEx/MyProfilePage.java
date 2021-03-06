package test11pomEx;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.Commons;

public class MyProfilePage {

	WebDriver driver;

	public MyProfilePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@FindBy(id = "changePwd")
	WebElement changepassword;
	
	public void clickChangePwd() {
		Commons.checkEnabledAndDisplayed(changepassword);
		assertTrue(changepassword.getText().equals("Change Password"));
		changepassword.click();
	}
}
