package testpom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import util.Commons;

public class TestLogin extends EmpBaseTest  {
	LoginPage login;
	
	@BeforeTest
	public void start() {
		driver = Commons.startApplication(driver, "Chrome");
		login = PageFactory.initElements(driver, LoginPage.class);
	}
	
	@Test 
	public void withoutusernamepassword() {
		login.loginToEmp("", "");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide loginName!");
		a.accept();
	}

	@Test 
	public void withusernamewithoutpassword() {
		login.loginToEmp("admin", "");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide Password!");
		a.accept();
	}

	@Test
	public void invalidusernamevalidpassword() {
		login.loginToEmp("admin1", "admin");
		login.invalidattempt();
	}

	@Test(priority = 3)
	public void validpasswordinvalidusername() {
		login.loginToEmp("admin", "admin1");
		login.invalidattempt();
	}

	@Test(priority = 4)
	public void invalidusernameandpassword() {
		login.loginToEmp("admin1", "admin1");
		login.invalidattempt();
	}

	@Test(priority = 6)
	public void invalidusernameandpassword5times() {
		for (int i = 1; i <= 5; i++) {
			login.loginToEmp("thirupathiswamy", "vaddemp");
			login.invalidattempt();
		}
	}

	@Test(priority = 7)
	public void driver() {
		login.loginToEmp("thirupathiswamy", "vaddem");
		login.maxattempt();
	}

	@Test
	public void log() {
		login.loginToEmp("admin", "admin");
		login.logout();
	}

	
	@BeforeTest
	public void emp() throws Exception {
		//login.loginToEmp("admin", "admin");
		//emp = PageFactory.initElements(driver, AddEmp.class);
		//emp.clickAddNewEmployee();
		//emp.addEmpolyee("thirupathiswamy", "vaddem", "thirupathiswamy", "vaddempudi", "03/31/1992", "30000",
			//	"8899445577");
		//login.logout();
	}
}
