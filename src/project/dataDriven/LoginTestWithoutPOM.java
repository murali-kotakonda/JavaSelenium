package dataDriven;


//Approach2

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import test15PiDataProvidersEx.ExcelUtils;
import util.BaseTest;

/**
 Data provider for login page

excel:
------------------
<username> , <password> , <asserType>

/*
	 if asserType = A (login success) then perform Logout
	 if asserType = B then Test for Alert (Please provide LoginName!)
	 if asserType = C then Test for Alert (Please provide Password!)
	 if asserType = D then Test for TextMessage (Invalid Login)
 */
 
public class LoginTestWithoutPOM extends BaseTest {
	
	@DataProvider(name = "excelData")
	public static Object[][] getData() throws Exception {
		return ExcelUtils.getTableArray("C://test1//DataProvider.xlsx", "Sheet2");
	}

	/*
	 if asserType = A (login success) then perform Logout
	 if asserType = B then Test for Alert (Please provide LoginName!)
	 if asserType = C then Test for Alert (Please provide Password!)
	 if asserType = D then Test for TextMessage (Invalid Login)
  	if asserType = E then Test for PASSWORD LENGTH (password has to be minimum 5 chars and max 10 chars!)
	 */

	@Test(dataProvider = "excelData")
	public void testLogin(String name, String pass, String assertType) throws Exception {
		// this method is written in LoginPage
		login(name, pass);
		if (assertType.equals("A")) {
			testValidCreds();
		} else if (assertType.equals("B")) {
			testAlertLoginName();
		} else if (assertType.equals("C")) {
			testAlertPasswordName();
		} else if (assertType.equals("D")) {
			testInvalidLogin();
		} else if (assertType.equals("E")) {
			testAlertPasswordlength();
		}
	}
	public void testValidCreds() {
		WebElement logout = driver.findElement(By.id("logoutLbl"));;
		checkEnabledAndDisplayed(logout);
		assertTrue(logout.getText().equals("Logout"));
		logout.click();
		sleep(5);
	}

	public void testInvalidLogin() {
		//TEST for invalid error message
		WebElement invalidlogin = driver.findElement(By.xpath("/html/body/font"));
		checkEnabledAndDisplayed(invalidlogin);
		assertTrue(invalidlogin.getText().equals("Invalid Login."));
	}


	public void testAlertLoginName() {
		//test for alert message
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide loginName!");
		a.accept();
	}
	



	public void testAlertPasswordName() {

		
		//test for alert message
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide Password!");
		a.accept();
		sleep(5);
	}
	

	public void testAlertPasswordlength() {
		
		//test for alert message
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "password has to be minimum 5 chars and max 10 chars!");
		a.accept();
		sleep(5);
	}
}

