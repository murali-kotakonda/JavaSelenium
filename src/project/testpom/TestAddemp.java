package testpom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AddEmp;
import pages.LoginPage;
import pages.LogoutPage;
import util.Commons;

public class TestAddemp extends Headerutility {
	LoginPage login;
	AddEmp emp;
	Headerutility header;
	LogoutPage logout;

	@BeforeTest
	public void start() {
		driver = Commons.startApplication(driver, "Chrome");
		login = PageFactory.initElements(driver, LoginPage.class);
		header = PageFactory.initElements(driver, Headerutility.class);
		emp = PageFactory.initElements(driver, AddEmp.class);
	}
	
	@BeforeMethod
	public void login() {
		login.loginToEmp("admin", "admin");
		header.clickAddNewEmployee();
	}

	@Test 
	public void nodata() throws Exception {
		emp.addEmpolyee("", "", "", "", "", "", "");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide loginName!");
		a.accept();
	}

	@Test(priority = 1)
	public void password() throws Exception {
		emp.addEmpolyee("thirupathi", "vaddempudi", "thirupathi", "vaddempudi", "03/31/1992", "30000", "8899445577");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "password has to be minimum 5 chars and max 10 chars!");
		a.accept();
	}

	@Test(priority = 2)
	public void firstname() throws Exception {
		emp.addEmpolyee("thirupathi", "vaddem", "", "vaddempudi", "03/31/1992", "30000", "8899445577");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide first Name!");
		a.accept();
	}

	@Test(priority = 3)
	public void mobile() throws Exception {
		emp.addEmpolyee("thirupathi", "vaddem", "thirupathi", "vaddempudi", "03/31/1992", "30000", "889944557766");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "mobileNo has to be minimum 10 digits!");
		a.accept();
	}

	@Test(priority = 4)
	public void date() throws Exception {
		emp.addEmpolyee("thirupathi", "vaddem", "thirupathi", "vaddempudi", "", "30000", "8899445577");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Invalid date format!");
		a.accept();
	}

	@Test(priority = 5)
	public void salary() throws Exception {
		emp.addEmpolyee("thirupathi", "vaddem", "thirupathi", "vaddempudi", "04/09/1994", "", "8899445577");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide Salary!");
		a.accept();
	}

	@Test(priority = 6)
	public void emp() throws Exception {
		emp.addEmpolyee("thirupathi", "vaddem", "thirupathi", "vaddempudi", "03/31/1992", "30000", "8899445577");
		Commons.checkEnabledAndDisplayed();
		emp.aftercreateemp(null, null, null, null, null, null, null);
		// TODO check data created

	}

	@Test(priority = 7)
	public void invali() throws Exception {
		emp.addEmpolyee("thirupathi", "vaddem", "thirupathi", "vaddempudi", "03/31/1992", "30000", "8899445577");
		emp.invalid("thirupathi", "", "thirupathi", "vaddempudi", "03/31/1992", "3000", "8899445577");
		// TODO : CHECK DATA
	}

	@AfterMethod
	public void logout() {
		// emp.Deleteprofile();
		emp.logout();
	}
}
