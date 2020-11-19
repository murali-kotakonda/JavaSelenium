package utils;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.Commons;

public class Headerutility {
	WebDriver driver;

	@FindBy(id = "myProfileLbl")
	WebElement mylabel;
	@FindBy(id = "mySubLbl")
	WebElement mysublab;

	public void validatelables() throws Exception {
		Commons.checkEnabledAndDisplayed(mylabel, emplabel, mysublab, deptlab, logoutlab);
		assertTrue(mylabel.getText().equals("My Profile"));
		assertTrue(mysublab.getText().equals("My Subordinates"));
	}

	@FindBy(id = "EmployeeLbl")
	WebElement emplabel;
	@FindBy(xpath = "//*[@id=\"addEmpLbl\"]")
	WebElement addemp;

	public void clickAddNewEmployee() {
		assertTrue(emplabel.getText().equals("Employee"));
		emplabel.click();
		assertTrue(addemp.getText().equals("Add New Employee"));
		addemp.click();
	}

	@FindBy(id = "EmployeeLbl")
	WebElement emplabel1;
	@FindBy(id = "searchEmpLbl")
	WebElement serchemp;

	public void serchemp() {
		assertTrue(emplabel1.getText().equals("Employee"));
		emplabel1.click();
		assertTrue(serchemp.getText().equals("Search Employee"));
		// emplabel1.click();
		serchemp.click();
	}

	@FindBy(id = "DepartmentLbl")
	WebElement deptlab;
	@FindBy(id = "addDeptLbl")
	WebElement dept;

	public void adddept() {
		assertTrue(deptlab.getText().equals("Department"));
		deptlab.click();
		assertTrue(dept.getText().equals("Add New Department"));
		dept.click();
	}

	@FindBy(id = "DepartmentLbl")
	WebElement deptlab1;
	@FindBy(id = "searchDeptLbl")
	WebElement serchdept;

	public void serchdept() {
		assertTrue(deptlab.getText().equals("Department"));
		// assertTrue(serchdept.getText().equals("Search Department"));
		deptlab1.click();
		serchdept.click();
	}

	@FindBy(id = "logoutLbl")
	WebElement logoutlab;

	public void logout() {
		assertTrue(logoutlab.getText().equals("Logout"));
		logoutlab.click();
	}

	@FindBy(id = "EmployeeLbl")
	WebElement emplabel2;
	@FindBy(id = "advSearchEmpLbl")
	WebElement adserch;

	public void advance() {
		assertTrue(emplabel.getText().equals("Employee"));
		emplabel.click();
		assertTrue(adserch.getText().equals("Advance Search"));
		adserch.click();

	}

	@FindBy(id = "EmployeeLbl")
	WebElement employe;
	@FindBy(id = "showEmpsLbl")
	WebElement showall;

	public void employe() {
		assertTrue(employe.getText().equals("Employee"));
		employe.click();
		assertTrue(showall.getText().equals("Show All Employees"));
		showall.click();
	}

}
