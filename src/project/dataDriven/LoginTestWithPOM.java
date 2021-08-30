package dataDriven;
//Approach2
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import emppages.LoginPage;
import excelDataDriven.ExcelUtils;
import testNg.BaseTest;

/**
 Data provider for login page

excel:
------------------
<username> , <password> , <asserType>

admin	a	


/*
	 if asserType = A (login success) then perform Logout
	 if asserType = B then Test for Alert (Please provide LoginName!)
	 if asserType = C then Test for Alert (Please provide Password!)
	 if asserType = D then Test for TextMessage (Invalid Login)
	 if asserType = E then Test for password Length (Invalid Login)
 */
 
public class LoginTestWithPOM extends BaseTest {
	
	LoginPage loginPageObj;
	
	@BeforeClass
	public void mysetup() {
		//loginPageObj = new LoginPage(driver);
		loginPageObj = PageFactory.initElements(driver, LoginPage.class);
	}
	
	@BeforeMethod
	public void openForm() {
		//open the form.html
		driver.get(EMPDEMO_URL);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
	}
	
	@DataProvider(name = "test1")
	public static Object[][] data() throws IOException {
		return ExcelUtils.getTableArray("DataProvider.xlsx", "input");
	}

	@Test(dataProvider = "test1")
	public void testData(String name,String pass, String assertType) {
		if(name==null) {
			name ="";
		}
		if(pass==null) {
			pass ="";
		}
		
		loginPageObj.login(name,pass);
		sleep(4);
		
		if(assertType.equals("A")) {
			loginPageObj.logout();
		}else if(assertType.equals("B")) {
			loginPageObj.validateLoginNameAlert();
		}else if(assertType.equals("C")) {
			loginPageObj.validatePasswordAlert();
		}else if(assertType.equals("D")) {
			loginPageObj.validateLoginFailure();
		}else if(assertType.equals("E")) {
			loginPageObj.validatePasswordLength();
		}
	}
	
}


