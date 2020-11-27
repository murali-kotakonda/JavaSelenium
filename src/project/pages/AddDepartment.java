package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.Commons;

public class AddDepartment {
	WebDriver driver;
	
	@FindBy(id="command") WebElement form;
	@FindBy(id="DepartmentLbl") WebElement dept;
	@FindBy(id="addDeptLbl") WebElement addnew;
	@FindBy(id="addDeptLbl") WebElement addDepartment;
	@FindBy(id="deptLbl") WebElement deptlab;
	@FindBy(id="name") WebElement deptname;
	@FindBy(id="deptHeadLbl") WebElement deptheadlab;
	@FindBy(name="manager.id") WebElement managerl;
	@FindBy(id="submit") WebElement submit;
	
	
	public void adddept(String Department,String manager) {
		Commons.checkEnabledAndDisplayed(deptlab,deptname,deptheadlab,submit);
		assertTrue(form.getAttribute("action").endsWith("deptCreate"));
		assertTrue(deptlab.getText().equals("Department Name:"));
		assertTrue(deptname.getAttribute("type").equals("text"));
		deptname.sendKeys(Department);
		assertTrue(deptheadlab.getText().equals("Department Head:"));
		assertTrue(managerl.getAttribute("name").equals("manager.id"));
		managerl.sendKeys(manager);
		assertTrue(submit.getAttribute("value").equals("Submit"));
		submit.click();
	}
	@FindBy(id="deptDetailsLbl") WebElement deptdetails;
	@FindBy(id="deptIdLbl") WebElement deptid;
	@FindBy(id="deptNameLbl") WebElement deptnamelab;
	@FindBy(id="deptHeadLbl") WebElement depthead;
	@FindBy(id="createdLbl") WebElement createdate;
	 
	public void afteradd(String deaprtmentid,String departmenthead,String departmrntname,String departmentdate) {
		Commons.checkEnabledAndDisplayed(deptdetails,deptid,deptnamelab,depthead,createdate);
		assertTrue(deptdetails.getText().equals("Department Details"));
		assertTrue(deptid.getText().equals("Department ID"));
		assertTrue(deptnamelab.getText().equals("Department Name"));
		assertTrue(depthead.getText().equals("Department Head"));
		assertTrue(createdate.getText().equals("Created Date"));
	}
	@FindBy(id="logoutLbl") WebElement logout;
	public void logout() {
		Commons.checkEnabledAndDisplayed(logout);
		assertTrue(logout.getText().equals("Logout"));
		logout.click();
	}
	

}