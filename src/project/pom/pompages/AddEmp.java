package pom.pompages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import util.Commons;

public class AddEmp  extends BasePage{
	
	public AddEmp(WebDriver idriver) {
		super(idriver);
	}
	
	@FindBy(id="command") 
	WebElement form;
	
	@FindBy(tagName="h2") WebElement empdata;
	@FindBy(id="empLoginLbl") WebElement emploginlabel;
	@FindBy(id="loginName") WebElement logname;
	@FindBy(id="empPwdLbl") WebElement emppwdlabel;
	@FindBy(id = "password") WebElement pass;
	@FindBy(id="empFnameLbl") WebElement empfnamelabel;
	@FindBy(id = "fName") WebElement fname;
	@FindBy(id="empLnameLbl") WebElement emplnanelabel;
	@FindBy(id = "lName") WebElement lname;
	@FindBy(id="desigLbl") WebElement designationlabel;
	@FindBy(id = "designation") WebElement design;
	@FindBy(id="genderLbl") WebElement genderlabel;
	@FindBy(id = "mRadio") WebElement sex;
	@FindBy(id="dobLbl") WebElement dateofbirthlabel;
	@FindBy(id = "dateOfBirth") WebElement dob;
	@FindBy(id="statusLbl") WebElement statuslabel;
	@FindBy(id = "login.status") WebElement status;
	@FindBy(id="deptLbl") WebElement departmentlabel;
	@FindBy(id = "department.id") WebElement deptid;
	@FindBy(id="managerLbl") WebElement managerlabel;
	@FindBy(id="manager.id") WebElement managerid;
	@FindBy(id="empSalLbl") WebElement employesallabel;
	@FindBy(id ="salary") WebElement sal;
	@FindBy(id="mnoLbl") WebElement mobilenolabel;
	@FindBy(id = "mobileNo") WebElement cellNo;
	@FindBy(id="maritalStatusLbl") WebElement maritalstatuslabel;
	@FindBy(id = "maritalStatus") WebElement matrialstatus;
	@FindBy(id="acceptLabl") WebElement acceptlabel;
	@FindBy(id="accept") WebElement accept;
	@FindBy(id="submit") WebElement submit;
	
	 
	public void addEmpolyee(String loginName, String password1, String FName, String LName, String birth, String salary,
			String mobileNum) throws Exception {
		assertTrue(form.getAttribute("action").endsWith("empCreate"));
		Commons.checkEnabledAndDisplayed(empdata, emploginlabel, logname, emppwdlabel, pass, empfnamelabel, fname,
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
	
	public void validateLoginName() {
		// validate the alert
		Alert a = driver.switchTo().alert();
		assertEquals(a.getText(), "Please provide loginName!");
		a.accept();
	}
	
	public void validatePass() {
		//validate the alert
		Alert a = driver.switchTo().alert();
		assertEquals(a.getText(), "Please provide Password!");
		a.accept();
	}
	
	public void validateFN() {
		Alert a = driver.switchTo().alert();
		Assert.assertEquals(a.getText(), "Please provide first Name!");
		a.accept();
	}
	
	
	public void validateEmptyDate() {
		Alert a = driver.switchTo().alert();
		Assert.assertEquals(a.getText(), "Invalid date format!");
		
		a.accept();
	}
	

	public void validateSalary() {
		Alert a = driver.switchTo().alert();
		Assert.assertEquals(a.getText(), "Please provide Salary!");
		
		a.accept();
	}
	
	
	public void validateMno() {
		Alert a = driver.switchTo().alert();
		Assert.assertEquals(a.getText(), "Please provide mobile Number!");
		
		a.accept();
	}
	
	
	public void validatePassLength() {
		Alert a = driver.switchTo().alert();
		Assert.assertEquals(a.getText(), "password has to be minimum 5 chars and max 10 chars!");
		
		a.accept();
	}
	
	
	public void validateMnoLength() {
		Alert a = driver.switchTo().alert();
		Assert.assertEquals(a.getText(), "mobileNo has to be minimum 10 digits!");
		
		a.accept();
	}
	
	public void validateAddEmpSuccess() {
		WebElement errorMsg = driver.findElement(By.id("errorMsg"));
		Assert.assertEquals(errorMsg.getText(), "Employee Created!");
	}
	
	public void validateAddEmpDupliateLoginName() {
		WebElement errorMsg = driver.findElement(By.id("errorMsg"));
		Assert.assertEquals(errorMsg.getText(), "LoginName already exists.");
	}
}