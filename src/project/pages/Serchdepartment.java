package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.Commons;

public class Serchdepartment {
	WebDriver driver;
	
	@FindBy(id="searchDeptFormLbl") WebElement dept;
	@FindBy(id="deptLbl") WebElement deptlabel;
	@FindBy(name="name") WebElement serchname;
	@FindBy(xpath="//*[@id=\"command\"]/table/tbody/tr/td[2]/input") WebElement submit;
	public void serchdept(String deptname) {
		assertTrue(dept.getText().equals("Search Department ID Form"));
		Commons.checkEnabledAndDisplayed(deptlabel,serchname);
		assertTrue(deptlabel.getText().equals("Search Department"));
		serchname.sendKeys(deptname);
		submit.click();
	}
	@FindBy(id="deptDetailsLbl") WebElement deptdetails;
	@FindBy(id="deptIdLbl") WebElement deptid;
	@FindBy(id="deptNameLbl") WebElement deptname;
	@FindBy(id="deptHeadLbl") WebElement depthead;
	@FindBy(id="createdLbl") WebElement create;
	public void afterserch() {
		assertTrue(deptdetails.getText().equals("Department Details"));
		assertTrue(deptid.getText().equals("Department ID"));
		assertTrue(deptname.getText().equals("Department Name"));
		assertTrue(depthead.getText().equals("Department Head"));
		assertTrue(create.getText().equals("Created Date"));
	}
	@FindBy(xpath="/html/body/font") WebElement notfound;
	public void invalid() {
		assertTrue(notfound.getText().equals("Department Not found"));
	}

}
