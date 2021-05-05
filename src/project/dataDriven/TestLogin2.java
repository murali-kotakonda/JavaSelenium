package dataDriven;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom.pages.LoginPage;
import pom.tests.POMBaseTest;
import test15PiDataProvidersEx.ExcelUtils;

/**
Data provider with page object model for login page

excel:
------------------
<username> , <password> , <asserType>

/*
	 if asserType = A (login success) then perform Logout
	 if asserType = B then Test for Alert (Please provide LoginName!)
	 if asserType = C then Test for Alert (Please provide Password!)
	 if asserType = D then Test for TextMessage (Invalid Login)
	 if asserType = E then Test for Password length (Password length)
	 
	 
excel name: DataProvider.xlsx
sheet name : input 

data in excel:
---------------
admin	  admin	  A
	      abcd	  B
abcd		      C
admin1	  admin1  D
*/

public class TestLogin2 extends POMBaseTest {

	LoginPage loginPageObj;
	
	@BeforeClass
	public void init() {
		loginPageObj = PageFactory.initElements(driver, LoginPage.class);
	}

	@DataProvider(name = "excelData")
	public static Object[][] getData() throws Exception {
		return ExcelUtils.getTableArray("C://test1//DataProvider.xlsx", "input");
	}
	
	@Test(dataProvider = "excelData")
	public void testLogin(String name, String pass, String assertType)  {
		name = name==null? "": name;
		pass = pass==null? "": pass;
		
		loginPageObj.login(name,pass);
		if(assertType.equals("A")) {
			loginPageObj.logout();
		}else if (assertType.equals("B")) {
			loginPageObj.validateLoginNameAlert();
		} else if (assertType.equals("C")) {
			loginPageObj.validatePasswordAlert();
		} else if (assertType.equals("D")) {
			loginPageObj.invalidattempt();
		} else if (assertType.equals("E")) {
			loginPageObj.validatePassLength();
		}
	}
}