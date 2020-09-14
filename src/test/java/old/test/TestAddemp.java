package old.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import old.pages.AddEmp;
import old.pages.LoginPage;
import old.pages.LogoutPage;
import old.utility.BrowserFactory;
import old.utility.Commonsutility;

public class TestAddemp {
	WebDriver driver;
	LoginPage login;
	AddEmp emp;
	LogoutPage logout;
	public TestAddemp() {
		driver=BrowserFactory.startApplication(driver,"Chrome","http://localhost:9080/EmpDemo/");
		login=PageFactory.initElements(driver,LoginPage.class);
		emp=PageFactory.initElements(driver,AddEmp.class);
		logout = PageFactory.initElements(driver,LogoutPage.class);
	}
	@BeforeMethod
	public void login() {
		login.loginToEmp("admin", "admin");
		
	}
	@Test(priority=0)
	public void emp() throws Exception {
		emp.addEmpolyee("thirupathi","vaddem","thirupathi","vaddempudi","03/31/1992","30000","8899445577");
		Commonsutility.checkEnabledAndDisplayed();
		emp.aftercreateemp();
		//emp.logout();
	}
	@Test(priority=1)
	public void invali() throws Exception {
		emp.addEmpolyee("thirupathi","vaddem","thirupathi","vaddempudi","03/31/1992","30000","8899445577");
		emp.invalid();
		//emp.logout();
	}
	@AfterMethod
	public void logout() {
		logout.click();
	}
	@AfterClass
	public void quit() {
		BrowserFactory.quitBrowser(driver);
		
	}

}
