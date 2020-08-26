package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AddEmp;
import pages.LoginPage;
import utility.BrowserFactory;
import utility.Headerutility;

public class LoginTestEmp extends Headerutility {
	WebDriver driver;
	LoginPage login;
	AddEmp emp;
	public  LoginTestEmp()
	{
		driver = BrowserFactory.startApplication(driver, "Chrome", "http://localhost:9080/EmpDemo/login");
		login = PageFactory.initElements(driver, LoginPage.class);
		
	  }
//	@BeforeMethod
	@BeforeClass
	public void emp() throws Exception {
		login.loginToEmp("admin","admin");
		emp = PageFactory.initElements(driver, AddEmp.class);
		emp.addEmpolyee("thirupathiswamy","vaddem","thirupathiswamy","vaddempudi","03/31/1992","30000","8899445577");
		login.logout();
	}
   	@Test(priority=0)
	public void withoutusernamepassword() {
		login.loginToEmp("", "");
		Alert a=driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide loginName!");
		a.accept();
	}
	@Test(priority=1)
	public void withusernamewithoutpassword() {
		login.loginToEmp("admin","");
		Alert a=driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide Password!");
		a.accept();
	}
	
	@Test(priority=2)
	public void invalidusernamevalidpassword() {
		login.loginToEmp("admin1","admin");
		login.invalidattempt();
	}
	@Test(priority=3)
	public void validpasswordinvalidusername() {
		login.loginToEmp("admin","admin1");
		login.invalidattempt();
	}
	@Test(priority=4)
	public void invalidusernameandpassword() {
		login.loginToEmp("admin1","admin1");
		login.invalidattempt();
	}
//	@Test(priority=5)
//	public void emp() throws Exception {
//		emp.addEmpolyee("thirupathi","vaddem","thirupathi","vaddempudi","03/31/1992","30000","8899445577");
//	}
	@Test(priority=6)
	public void invalidusernameandpassword5times() {
		for(int i=1;i<=5;i++) {
			login.loginToEmp("thirupathiswamy","vaddemp");
			login.invalidattempt();
		}
			}
	 @Test(priority=7)
		public void driver() {
		 login.loginToEmp("thirupathiswamy","vaddem");
		 login.maxattempt();
		}
		@Test(priority=8)
		public void log()
		{
			login.loginToEmp("admin", "admin");
			login.logout();
		}

	
	@AfterClass
		public void quit() {
			BrowserFactory.quitBrowser(driver);
			driver.quit();
		}
		}

	

