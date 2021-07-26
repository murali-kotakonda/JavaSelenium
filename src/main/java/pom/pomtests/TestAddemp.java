package pom.pomtests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.pompages.AddEmp;
import pom.pompages.LoginPage;

public class TestAddemp extends POMBaseTest {

	LoginPage loginPageObj;
	AddEmp empPageObj;

	@BeforeClass
	public void init() {
		loginPageObj = PageFactory.initElements(driver, LoginPage.class);
	}

	@BeforeMethod
	public void login() {
		loginPageObj.login("admin", "admin");
		sleep(5);
		loginPageObj.clickAddNewEmp();
		empPageObj = PageFactory.initElements(driver, AddEmp.class);
	}

	@AfterMethod
	public void logout() {
		loginPageObj.logout();
	}

	@Test
	public void emptyLoginName() throws Exception {
		empPageObj.addEmpolyee("", "", "", "", "", "", "");
		empPageObj.validateLoginName();
		sleep(3);
	}
	
	@Test
	public void emptyPass() throws Exception {
		empPageObj.addEmpolyee("rajkumar", "", "", "", "", "", "");
		empPageObj.validatePass();
		sleep(3);
	}
	
	@Test 
	public void emptyFirstName() throws Exception {
		empPageObj.addEmpolyee("kumar", "kumar123", "", "", "", "", "");
		empPageObj.validateFN();
		sleep(3);
	}
	
	
	@Test
	public void emptyDate() throws Exception {
		empPageObj.addEmpolyee("thirupathi", "vaddem", "thirupathi", "vaddempudi", "", "30000", "8899445577");
		empPageObj.validateEmptyDate();
		sleep(3);
	}
	
	@Test 
	public void emptySalary() throws Exception {
		empPageObj.addEmpolyee("thirupathi", "vaddem", "thirupathi", "vaddempudi", "04/09/1994", "", "8899445577");
		empPageObj.validateSalary();
		sleep(3);
	}
	
	
	@Test 
	public void emptyMobileNo() throws Exception {
		empPageObj.addEmpolyee("thirupathi", "vaddem", "thirupathi", "vaddempudi", "03/31/1992", "30000", "");
		empPageObj.validateMno();
		sleep(3);		
	}
	
	
	@Test 
	public void passLessThan5() throws Exception {
		empPageObj.addEmpolyee("kumar", "abc", "", "", "", "", "");
		empPageObj.validatePassLength();
		sleep(3);
	}
	
	
	@Test 
	public void passGreaterThan10() throws Exception {
		empPageObj.addEmpolyee("kumar", "ahahahahahahahahaaj", "", "", "", "", "");
		empPageObj.validatePassLength();
		sleep(3);
	}
	
	
	@Test 
	public void mobilelessThan10Digits() throws Exception {
		empPageObj.addEmpolyee("thirupathi", "vaddem", "thirupathi", "vaddempudi", "03/31/1992", "30000", "123");
		empPageObj.validateMnoLength();
		sleep(3);
	}
	
	
	@Test
	public void inValidDate() throws Exception {
		empPageObj.addEmpolyee("thirupathi", "vaddem", "thirupathi", "vaddempudi", "20/20/1994", "30000", "8899445577");
		empPageObj.validateEmptyDate();
	}
	
}