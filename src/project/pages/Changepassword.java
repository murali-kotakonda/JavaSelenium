package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import old.utility.Commons;

public class Changepassword {
	WebDriver driver;
	@FindBy(id="changePwd") WebElement changepassword;
	@FindBy(tagName="h3") WebElement passwordscreen;
	@FindBy(id="currPassLabl") WebElement currentpasswordlabel;
	@FindBy(name="currPass") WebElement currentpasswordname;
	@FindBy(id="newPassLabl1") WebElement newpasswordlabel;
	@FindBy(name="newPass") WebElement newpass;
	@FindBy(id="newPassLabl2") WebElement conform;
	@FindBy(name="confirmPass") WebElement conformpass;
	@FindBy(name="Change Password") WebElement submit;
	
	
public void changepassword(String currentpassword,String newpassword,String conformpassword) {
	assertTrue(changepassword.getText().equals("Change Password"));
	changepassword.click();
	assertTrue(passwordscreen.getText().equals("Change Password Screen"));
	Commons.checkEnabledAndDisplayed(currentpasswordlabel,currentpasswordname,newpasswordlabel
			,newpass,conform,conformpass,submit);
	assertTrue(currentpasswordlabel.getText().equals("Current Password:"));
	assertTrue(currentpasswordname.getAttribute("type").equals("password"));
	currentpasswordname.sendKeys(currentpassword);
	assertTrue(newpasswordlabel.getText().equals("New Password:"));
	assertTrue(newpass.getAttribute("type").equals("password"));
	newpass.sendKeys(newpassword);
	assertTrue(conform.getText().equals("Confirm Password:"));
	assertTrue(conformpass.getAttribute("type").equals("password"));
	conformpass.sendKeys(conformpassword);
	assertTrue(submit.getAttribute("type").equals("submit"));
	submit.click();
	}
@FindBy(id="logoutLbl") WebElement logout;
public void logout() {
	assertTrue(logout.getText().equals("Logout"));
	logout.click();
	
}
}
