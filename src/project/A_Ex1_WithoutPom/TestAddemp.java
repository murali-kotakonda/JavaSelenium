package A_Ex1_WithoutPom;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.BaseTest;

/**
-> empty data
-> valid data
-> invalid data
-> already existing data

 testcases for add new employee:
--------------------------------
1.empty loginName
2.empty password
3.empty firstName
4.empty dob
5.empty emp salary
6.empty mobilNo
7.password < 5
8.password > 10
9.mobile < 10
10.mobile > 10
11.success emp creation
12.testCase for loginName already exists
13.invalid date for dob

common:
--------------
->login
->click on 'add new employee' link
-> verify the content of add employee page
-> get the webelement objects + assertions on fileds
->logout


 */
public class TestAddemp extends BaseTest {

	@BeforeMethod
	public void login() {
		 //write code for login + click "add new employee"
		
		//login
		login("admin", "admin");
		
		sleep(3);
		
		//click on "Add New Employee" link
		WebElement emplabel = driver.findElement(By.id("EmployeeLbl"));
		assertTrue(emplabel.getText().equals("Employee"));
		emplabel.click();
		
		
		WebElement addemp = driver.findElement(By.id("addEmpLbl"));;
		assertTrue(addemp.getText().equals("Add New Employee"));
		addemp.click();
	}

	
	@AfterMethod
	public void logout() {
		// emp.Deleteprofile();
		WebElement logout = driver.findElement(By.id("logoutLbl"));
		assertTrue(logout.getText().equals("Logout"));
		logout.click();
		sleep(2);
	}
	
	@Test
	public void emptyLoginName() throws Exception {
		addEmpolyee("", "", "", "", "", "", "");
		
		//validate the alert
		Alert a = driver.switchTo().alert();
		Assert.assertEquals(a.getText(), "Please provide loginName!");
		sleep(3);
		a.accept();
		sleep(3);
	}
	
	@Test
	public void emptyPassword() throws Exception {
		addEmpolyee("kumar", "", "", "", "", "", "");
		
		//validate the alert
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide Password!");
		sleep(3);
		a.accept();
		sleep(3);
	}
	
	@Test 
	public void emptyFirstName() throws Exception {
		addEmpolyee("kumar", "kumar123", "", "", "", "", "");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide first Name!");
		sleep(3);
		a.accept();
		sleep(3);
	}
	
	@Test
	public void emptyDate() throws Exception {
		addEmpolyee("thirupathi", "vaddem", "thirupathi", "vaddempudi", "", "30000", "8899445577");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Invalid date format!");
		sleep(3);
		a.accept();
	}
	
	@Test 
	public void emptySalary() throws Exception {
		addEmpolyee("thirupathi", "vaddem", "thirupathi", "vaddempudi", "04/09/1994", "", "8899445577");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide Salary!");
		sleep(3);
		a.accept();
	}
	
	@Test 
	public void emptyMobileNo() throws Exception {
		addEmpolyee("thirupathi", "vaddem", "thirupathi", "vaddempudi", "03/31/1992", "30000", "");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide mobile Number!");
		sleep(3);
		a.accept();
		sleep(3);
	}
	
	@Test 
	public void passLessThan5() throws Exception {
		addEmpolyee("kumar", "abc", "", "", "", "", "");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "password has to be minimum 5 chars and max 10 chars!");
		sleep(3);
		a.accept();
		sleep(3);
	}
	
	@Test 
	public void passGreaterThan10() throws Exception {
		addEmpolyee("kumar", "ahahahahahahahahaaj", "", "", "", "", "");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "password has to be minimum 5 chars and max 10 chars!");
		sleep(3);
		a.accept();
		sleep(3);
	}
	
	@Test 
	public void mobilelessThan10Digits() throws Exception {
		addEmpolyee("thirupathi", "vaddem", "thirupathi", "vaddempudi", "03/31/1992", "30000", "123");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "mobileNo has to be minimum 10 digits!");
		sleep(3);
		a.accept();
		sleep(3);
	}
	
	@Test 
	public void mobileGreaterThan10Digits() throws Exception {
		addEmpolyee("thirupathi", "vaddem", "thirupathi", "vaddempudi", "03/31/1992", "30000", "12312121231313");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "mobileNo has to be minimum 10 digits!");
		sleep(3);
		a.accept();
		sleep(3);
	}
	
	@Test
	public void inValidDate() throws Exception {
		addEmpolyee("thirupathi", "vaddem", "thirupathi", "vaddempudi", "20/20/1994", "30000", "8899445577");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Invalid date format!");
		sleep(3);
		a.accept();
	}

	@Test
	public void addEmpSuccess() throws Exception {
		addEmpolyee("raju", "raju@1234", "rajvardhan", "kumar", "03/31/1992", "30000", "8899445577");
		WebElement errorMsg = driver.findElement(By.id("errorMsg"));
		Assert.assertEquals(errorMsg.getText(), "Employee Created!");
		sleep(4);
	}
	
	@Test(dependsOnMethods ="addEmpSuccess" )
	public void addEmpDuplicate() throws Exception {
		addEmpolyee("raju", "raju@1234", "rajvardhan", "kumar", "03/31/1992", "30000", "8899445577");
		WebElement errorMsg = driver.findElement(By.id("errorMsg"));
		Assert.assertEquals(errorMsg.getText(), "LoginName already exists.");
		sleep(3);
	}

	//@Test(priority = 7)
	public void invalid() throws Exception {
		addEmpolyee("thirupathi", "vaddem", "thirupathi", "vaddempudi", "03/31/1992", "30000", "8899445577");
		//emp.invalid("thirupathi", "", "thirupathi", "vaddempudi", "03/31/1992", "3000", "8899445577");
		// TODO : CHECK DATA
	}

	public void addEmpolyee(String loginName, String password1, String FName, String LName, String birth, String salary,
			String mobileNum) throws Exception {

		//WebElement form = driver.findElement(By.id("command"));
		//WebElement empdata = driver.findElement(By.tagName("h2"));

		WebElement emploginlabel = driver.findElement(By.id("empLoginLbl"));
		WebElement logname = driver.findElement(By.id("loginName"));

		WebElement emppwdlabel = driver.findElement(By.id("empPwdLbl"));
		WebElement pass = driver.findElement(By.id("password"));

		WebElement empfnamelabel = driver.findElement(By.id("empFnameLbl"));
		WebElement fname = driver.findElement(By.id("fName"));

		WebElement emplnanelabel = driver.findElement(By.id("empLnameLbl"));
		WebElement lname = driver.findElement(By.id("lName"));

		WebElement designationlabel = driver.findElement(By.id("desigLbl"));
		WebElement design = driver.findElement(By.id("designation"));

		WebElement genderlabel = driver.findElement(By.id("genderLbl"));
		WebElement sex = driver.findElement(By.id("mRadio"));

		WebElement dateofbirthlabel = driver.findElement(By.id("dobLbl"));
		WebElement dob = driver.findElement(By.id("dateOfBirth"));

		WebElement statuslabel = driver.findElement(By.id("statusLbl"));
		WebElement status = driver.findElement(By.id("login.status"));

		WebElement departmentlabel = driver.findElement(By.id("deptLbl"));
		WebElement deptid = driver.findElement(By.id("department.id"));

		WebElement managerlabel = driver.findElement(By.id("managerLbl"));
		WebElement managerid = driver.findElement(By.id("manager.id"));

		WebElement employesallabel = driver.findElement(By.id("empSalLbl"));
		WebElement sal = driver.findElement(By.id("salary"));

		WebElement mobilenolabel = driver.findElement(By.id("mnoLbl"));
		WebElement cellNo = driver.findElement(By.id("mobileNo"));

		WebElement maritalstatuslabel = driver.findElement(By.id("maritalStatusLbl"));
		WebElement matrialstatus = driver.findElement(By.id("maritalStatus"));

		WebElement acceptlabel = driver.findElement(By.id("acceptLabl"));
		WebElement accept = driver.findElement(By.id("accept"));

		WebElement submit = driver.findElement(By.id("submit"));

		//assertTrue(form.getAttribute("action").endsWith("empCreate"));
		//assertTrue(empdata.getText().equals("Add Employee Data"));
		
		checkEnabledAndDisplayed( emploginlabel, logname, emppwdlabel, pass, empfnamelabel, fname,
				emplnanelabel, lname, designationlabel, design, genderlabel, sex, dateofbirthlabel, dob, statuslabel,
				status, departmentlabel, deptid, managerlabel, managerid, employesallabel, sal, mobilenolabel, cellNo,
				maritalstatuslabel, matrialstatus, acceptlabel, accept, submit);
		
		
		assertTrue(emploginlabel.getText().equals("Employee login Name:"));
		assertTrue(logname.getAttribute("type").equals("text"));
		
		assertTrue(emppwdlabel.getText().equals("Employee Password:"));
		assertTrue(pass.getAttribute("type").equals("password"));
		
		assertTrue(empfnamelabel.getText().equals("Employee First Name:"));
		assertTrue(fname.getAttribute("type").equals("text"));
		
		assertTrue(emplnanelabel.getText().equals("Employee Last Name:"));
		assertTrue(lname.getAttribute("type").equals("text"));
		
		assertTrue(designationlabel.getText().equals("Designation:"));
		assertTrue(design.getAttribute("name").equals("designation"));
		
		assertTrue(genderlabel.getText().equals("Gender:"));
		assertTrue(sex.getAttribute("value").equals("male"));
		
		assertTrue(dateofbirthlabel.getText().equals("Date of Birth:"));
		assertTrue(dob.getAttribute("type").equals("text"));
		
		assertTrue(statuslabel.getText().equals("Status:"));
		assertTrue(status.getAttribute("name").equals("login.status"));
		
		assertTrue(departmentlabel.getText().equals("Department:"));
		assertTrue(deptid.getAttribute("name").equals("department.id"));
		
		assertTrue(managerlabel.getText().equals("Manager :"));
		assertTrue(managerid.getAttribute("name").equals("manager.id"));
		
		assertTrue(employesallabel.getText().equals("Employee Salary:"));
		assertTrue(sal.getAttribute("type").equals("text"));
		
		assertTrue(mobilenolabel.getText().equals("Mobile No:"));
		assertTrue(cellNo.getAttribute("type").equals("text"));
		
		assertTrue(maritalstatuslabel.getText().equals("Marital Status:"));
		assertTrue(matrialstatus.getAttribute("name").equals("maritalStatus"));
		
		assertTrue(acceptlabel.getText().equals("I accept"));
		assertTrue(accept.getAttribute("value").equals("Accept"));

		assertTrue(submit.getAttribute("value").equals("Submit"));
		
		logname.sendKeys(loginName);
		pass.sendKeys(password1);
		fname.sendKeys(FName);
		lname.sendKeys(LName);
		design.sendKeys("Analyst");
		sex.click();
		dob.sendKeys(birth);
		status.sendKeys("Active");
		deptid.sendKeys("IT");
		managerid.sendKeys("112");
		sal.sendKeys(salary);
		cellNo.sendKeys(mobileNum);
		matrialstatus.sendKeys("single");
		accept.click();
		submit.click();
	}
}
