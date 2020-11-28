package testWithoutPom;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.BaseTest;

public class TestAddemp extends BaseTest {

	@BeforeMethod
	public void login() {
		//login
		login("admin", "admin");
		
		sleep(3);
		
		//click on "Add New Employee" link
		WebElement emplabel = driver.findElement(By.id("EmployeeLbl"));;
		WebElement addemp = driver.findElement(By.id("addEmpLbl"));;
		assertTrue(emplabel.getText().equals("Employee"));
		emplabel.click();
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
	public void noLoginName() throws Exception {
		addEmpolyee("", "", "", "", "", "", "");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide loginName!");
		sleep(3);
		a.accept();
		sleep(3);
	}
	
	@Test
	public void noPassword() throws Exception {
		addEmpolyee("kumar", "", "", "", "", "", "");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide Password!");
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
	public void noFirstName() throws Exception {
		addEmpolyee("kumar", "kumar123", "", "", "", "", "");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide first Name!");
		sleep(3);
		a.accept();
		sleep(3);
	}

	
	@Test 
	public void noMobileNo() throws Exception {
		addEmpolyee("thirupathi", "vaddem", "thirupathi", "vaddempudi", "03/31/1992", "30000", "");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide mobile Number!");
		sleep(3);
		a.accept();
		sleep(3);
	}
	
	@Test 
	public void mobileNot10Digits() throws Exception {
		addEmpolyee("thirupathi", "vaddem", "thirupathi", "vaddempudi", "03/31/1992", "30000", "123");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "mobileNo has to be minimum 10 digits!");
		sleep(3);
		a.accept();
		sleep(3);
	}

	@Test
	public void noDate() throws Exception {
		addEmpolyee("thirupathi", "vaddem", "thirupathi", "vaddempudi", "", "30000", "8899445577");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Invalid date format!");
		sleep(3);
		a.accept();
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
	public void noSalary() throws Exception {
		addEmpolyee("thirupathi", "vaddem", "thirupathi", "vaddempudi", "04/09/1994", "", "8899445577");
		Alert a = driver.switchTo().alert();
		Reporter.log(a.getText());
		Assert.assertEquals(a.getText(), "Please provide Salary!");
		sleep(3);
		a.accept();
	}

	@Test
	public void addEmpSuccess() throws Exception {
		addEmpolyee("raju", "raju@1234", "rajvardhan", "kumar", "03/31/1992", "30000", "8899445577");
		WebElement errorMsg = driver.findElement(By.id("errorMsg"));
		Assert.assertEquals(errorMsg.getText(), "Employee Created!");
		sleep(100);
	}
	
	@Test(dependsOnMethods ="addEmpSuccess" )
	public void addEmpDuplicate() throws Exception {
		addEmpolyee("raju", "raju@1234", "rajvardhan", "kumar", "03/31/1992", "30000", "8899445577");
		WebElement errorMsg = driver.findElement(By.id("errorMsg"));
		Assert.assertEquals(errorMsg.getText(), "LoginName already exists.");
		sleep(3);
	}

	//@Test(priority = 7)
	public void invali() throws Exception {
		addEmpolyee("thirupathi", "vaddem", "thirupathi", "vaddempudi", "03/31/1992", "30000", "8899445577");
		//emp.invalid("thirupathi", "", "thirupathi", "vaddempudi", "03/31/1992", "3000", "8899445577");
		// TODO : CHECK DATA
	}

	public void addEmpolyee(String loginName, String password1, String FName, String LName, String birth, String salary,
			String mobileNum) throws Exception {

		WebElement form = driver.findElement(By.id("command"));
		WebElement empdata = driver.findElement(By.tagName("h2"));

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

		assertTrue(form.getAttribute("action").endsWith("empCreate"));
		checkEnabledAndDisplayed(empdata, emploginlabel, logname, emppwdlabel, pass, empfnamelabel, fname,
				emplnanelabel, lname, designationlabel, design, genderlabel, sex, dateofbirthlabel, dob, statuslabel,
				status, departmentlabel, deptid, managerlabel, managerid, employesallabel, sal, mobilenolabel, cellNo,
				maritalstatuslabel, matrialstatus, acceptlabel, accept, submit);
		
		assertTrue(empdata.getText().equals("Add Employee Data"));
		
		assertTrue(emploginlabel.getText().equals("Employee login Name:"));
		assertTrue(logname.getAttribute("type").equals("text"));
		logname.sendKeys(loginName);
		
		assertTrue(emppwdlabel.getText().equals("Employee Password:"));
		assertTrue(pass.getAttribute("type").equals("password"));
		pass.sendKeys(password1);
		
		assertTrue(empfnamelabel.getText().equals("Employee First Name:"));
		assertTrue(fname.getAttribute("type").equals("text"));
		fname.sendKeys(FName);
		
		assertTrue(emplnanelabel.getText().equals("Employee Last Name:"));
		assertTrue(lname.getAttribute("type").equals("text"));
		lname.sendKeys(LName);
		
		assertTrue(designationlabel.getText().equals("Designation:"));
		assertTrue(design.getAttribute("name").equals("designation"));
		design.sendKeys("Analyst");
		
		assertTrue(genderlabel.getText().equals("Gender:"));
		assertTrue(sex.getAttribute("value").equals("male"));
		sex.click();
		
		assertTrue(dateofbirthlabel.getText().equals("Date of Birth:"));
		assertTrue(dob.getAttribute("type").equals("text"));
		dob.sendKeys(birth);
		
		assertTrue(statuslabel.getText().equals("Status:"));
		assertTrue(status.getAttribute("name").equals("login.status"));
		status.sendKeys("Active");
		
		assertTrue(departmentlabel.getText().equals("Department:"));
		assertTrue(deptid.getAttribute("name").equals("department.id"));
		deptid.sendKeys("IT");
		
		assertTrue(managerlabel.getText().equals("Manager :"));
		assertTrue(managerid.getAttribute("name").equals("manager.id"));
		managerid.sendKeys("112");
		
		assertTrue(employesallabel.getText().equals("Employee Salary:"));
		assertTrue(sal.getAttribute("type").equals("text"));
		sal.sendKeys(salary);
		
		assertTrue(mobilenolabel.getText().equals("Mobile No:"));
		assertTrue(cellNo.getAttribute("type").equals("text"));
		cellNo.sendKeys(mobileNum);
		
		assertTrue(maritalstatuslabel.getText().equals("Marital Status:"));
		assertTrue(matrialstatus.getAttribute("name").equals("maritalStatus"));
		matrialstatus.sendKeys("single");
		
		assertTrue(acceptlabel.getText().equals("I accept"));
		assertTrue(accept.getAttribute("value").equals("Accept"));
		accept.click();
		
		assertTrue(submit.getAttribute("value").equals("Submit"));
		submit.click();
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

		name.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();

		sleep(3);
	}
}
