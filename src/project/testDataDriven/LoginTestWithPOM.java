package testDataDriven;


//Approach2

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.BaseTest;
import test15PiDataProvidersEx.ExcelUtils;

public class LoginTestWithPOM extends BaseTest {
	
	@DataProvider(name = "excelData")
	public static Object[][] Authentication() throws Exception {
		return ExcelUtils.getTableArray("C://test1//DataProvider.xlsx", "Sheet2");
	}

	/*
	 if Status = A (login success) then perform Logout
	 if Status = B then Test for Alert (Please provide LoginName!)
	 if Status = C then Test for Alert (Please provide Password!)
	 if Status = D then Test for TextMessage (Invalid Login)
	 
	 */
@Test(dataProvider = "excelData")
public void Registration_data(String name, String pass,String status ) throws Exception {
		//this method is written in LoginPage
		login(name,pass);
		if( status.equals("A"))	{testValidCreds();}
		else if( status.equals("B")) {testAlertLoginName();}
		else if( status.equals("C")) {testAlertPasswordName ();}
		else if( status.equals("D")) {testInvalidLogin();}
		else if( status.equals("E")) {testAlertPassword();}
}
	

	private void login(String un, String pwd) {
		WebElement form = driver.findElement(By.tagName("form"));
		WebElement formTitle = driver.findElement(By.tagName("h1"));
		WebElement usernamelab = driver.findElement(By.id("userNameLbl"));
		WebElement passwordlab = driver.findElement(By.id("passwordLbl"));
		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
		WebElement name = driver.findElement(By.name("loginName"));
		WebElement password = driver.findElement(By.name("password"));

		checkEnabledAndDisplayed(usernamelab, name, passwordlab, password, loginBtn);

		// test the form name
		assertTrue(formTitle.getText().equals("Login Page"));

		// test label for username
		assertTrue(usernamelab.getText().equals("User Name:"));

		// test label for Password
		assertTrue(passwordlab.getText().equals("Password:"));

		// test label for button
		assertTrue(loginBtn.getAttribute("value").equals("Login"));

		// test type for username
		assertTrue(name.getAttribute("type").equals("text"));

		// test type for password
		assertTrue(password.getAttribute("type").equals("password"));

		name.clear();
		password.clear();
		name.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();

		sleep(5);
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
	

	public void testAlertPassword() {
		
		//test for alert message
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "password has to be minimum 5 chars and max 10 chars!");
		a.accept();
		sleep(5);
	}

}



