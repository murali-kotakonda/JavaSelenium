package test11pomEx;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Commons;

public class ChangePasswordPage {
	WebDriver driver;

	public ChangePasswordPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@FindBy(name = "currPass")
	WebElement currentpasswordname;

	@FindBy(name = "newPass")
	WebElement newpass;
	
	@FindBy(name = "confirmPass")
	WebElement conformpass;
	
	@FindBy(name = "Change Password")
	WebElement submit;

	public void changepassword(String currentpassword, String newpassword, String conformpassword) {
		Commons.checkEnabledAndDisplayed(currentpasswordname, newpass, conformpass, submit);
		
		//enter old pass
		assertTrue(currentpasswordname.getAttribute("type").equals("password"));
		currentpasswordname.sendKeys(currentpassword);
		
		//enter new pass
		assertTrue(newpass.getAttribute("type").equals("password"));
		newpass.sendKeys(newpassword);
		
		//enter confir  pass
		assertTrue(conformpass.getAttribute("type").equals("password"));
		conformpass.sendKeys(conformpassword);
		
		//click button
		assertTrue(submit.getAttribute("type").equals("submit"));
		submit.click();
	}
	
}
