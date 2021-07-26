package dataProviderPom;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom.pages.LoginPage;
import pom.pomtests.POMBaseTest;
import test15PiDataProvidersEx.ExcelUtils;

//data provider + POM

public class TestLogin extends POMBaseTest {

	@DataProvider(name = "excelData")
	public static Object[][] Authentication() throws Exception {
		return ExcelUtils.getTableArray("C://test1//DataProvider.xlsx", "input");
	}
	
	LoginPage loginPageObj;
	
	@BeforeClass
	public void init() {
		loginPageObj = PageFactory.initElements(driver, LoginPage.class);
	}
	
	/*
	 if Status = A (login success) then perform Logout
	 if Status = B then Test for Alert (Please provide LoginName!)
	 if Status = C then Test for Alert (Please provide Password!)
	 if Status = D then Test for TextMessage (Invalid Login)
	 
	 */
	@Test(dataProvider =  "excelData")
	public void testLogin(String name, String pass, String status) {
		if(name==null) {
			name = "";
		}
		if(pass == null) {
			pass= "";
		}
		loginPageObj.login(name, pass);
		
		if(status.equals("A")) {
			loginPageObj.logout();
		}else if(status.equals("B")) {
			loginPageObj.validateLoginNameAlert();
		}else if(status.equals("C")) {
			loginPageObj.validatePasswordAlert();
		}else if(status.equals("D")) {
			loginPageObj.invalidattempt();
		}
		
		sleep(10);
	}
}