package old.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import old.utility.Commonsutility;



public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver idriver)
	{
		this.driver=idriver;
//url browser should come in testng.xml file
		//config info should not be hardcoded should come in xml or propertiesfile
		// for everypage there is a onepageclass testclass
	}
	@FindBy(tagName="form") WebElement form;
	@FindBy(tagName="h1") WebElement tag;
	@FindBy(id="userNameLbl")
	 WebElement usernamelab;
	@FindBy(name="loginName") WebElement uname;
	@FindBy(id="passwordLbl") WebElement passwordlab;
	@FindBy(name="password") WebElement pwd;
	@FindBy(xpath="//input[@value='Login']") WebElement logbtn;
	public void loginToEmp(String username,String password)
	{
		Commonsutility.checkEnabledAndDisplayed(usernamelab,uname,passwordlab,pwd,logbtn);
        //Assert.assertEquals("null",form.getAttribute("href"),"invalid");
		System.out.println(form.getAttribute("action"));
        assertTrue(form.getAttribute("action").endsWith("login"));
		assertTrue(tag.getText().equals("Login Page"));
		assertTrue(usernamelab.getText().equals("User Name:"));
		uname.sendKeys(username);
		assertTrue(passwordlab.getText().equals("Password:"));
		pwd.sendKeys(password);
		logbtn.click();
//		assertTrue(logout.getText().equals("Logout"));
//		logout.click();
	}
	@FindBy(id="logoutLbl")  WebElement logout;
	public  void logout() {
		//Commonsutility.checkEnabledAndDisplayed(usernamelab,uname,passwordlab,pwd,logbtn);
	 assertTrue(logout.getText().equals("Logout"));
	}
	@FindBy(xpath="/html/body/font") WebElement invalidlogin;
	public  void invalidattempt() {
		Commonsutility.checkEnabledAndDisplayed(usernamelab,uname,passwordlab,pwd,logbtn);
		assertTrue(invalidlogin.getText().equals("Invalid Login."));
	}
	@FindBy(xpath="/html/body/font")   WebElement maxattempt;
	public  void maxattempt() {
		Commonsutility.checkEnabledAndDisplayed(usernamelab,uname,passwordlab,pwd,logbtn);
		assertTrue(maxattempt.getText().equals("You have exceded Maximum no of attempts.Please contact Admin"));
	}
	
	
}
