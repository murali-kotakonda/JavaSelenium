package pom.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Deleteprofile {
	WebDriver driver;
	@FindBy(xpath="/html/body/h3") WebElement list;
	@FindBy(id="idlbl") WebElement id;
	@FindBy(xpath="/html/body/table/tbody/tr[4]/td[1]") WebElement idno;
	@FindBy(id="fNamelbl") WebElement fnamelabel;
	@FindBy(xpath="/html/body/table/tbody/tr[4]/td[2]") WebElement fname;
	@FindBy(id="lNamelbl") WebElement lnamelabel;
	@FindBy(xpath="/html/body/table/tbody/tr[4]/td[3]") WebElement lname;
	@FindBy(id="desinlbl") WebElement desig;
	@FindBy(xpath="/html/body/table/tbody/tr[4]/td[4]") WebElement designation;
	@FindBy(id="genderlbl") WebElement genderlab;
	@FindBy(xpath="/html/body/table/tbody/tr[4]/td[5]") WebElement gender;
	@FindBy(id="deptlbl") WebElement deptlab;
	@FindBy(xpath="/html/body/table/tbody/tr[4]/td[6]") WebElement dept;
	@FindBy(id="joinDatelbl") WebElement joinlab;
	@FindBy(xpath="/html/body/table/tbody/tr[4]/td[7]") WebElement join;
	@FindBy(id="mnolbl") WebElement moblab;
	@FindBy(xpath="/html/body/table/tbody/tr[4]/td[8]") WebElement mob;
	@FindBy(id="statuslbl") WebElement statuslab;
	@FindBy(xpath="/html/body/table/tbody/tr[4]/td[9]") WebElement status;
	@FindBy(xpath="/html/body/table/thead/tr/th[10]") WebElement actionlab;
	@FindBy(xpath="/html/body/table/tbody/tr[4]/td[10]/a[2]") WebElement delete;
	public void delete() {
		assertTrue(list.getText().equals("List of Employees"));
		assertTrue(id.getText().equals("ID"));
		//assertTrue(idno.getText().equals(" 402"));
		assertTrue(fnamelabel.getText().equals("First Name"));
		//assertTrue(fname.getText().equals(" venkatarao"));
		assertTrue(lnamelabel.getText().equals("Last Name"));
		//assertTrue(lname.getText().equals(" vaddempudi"));
		assertTrue(desig.getText().equals("Designation"));
		//assertTrue(designation.getText().equals(" Associate Engineer"));
		assertTrue(genderlab.getText().equals("Gender"));
		//assertTrue(gender.getText().equals(" male"));
		assertTrue(deptlab.getText().equals("Department"));
		//assertTrue(dept.getText().equals(" HR"));
		assertTrue(joinlab.getText().equals("Join Date"));
		//assertTrue(join.getText().equals(" 2019-09-02"));
		assertTrue(moblab.getText().equals("Mobile No"));
		//assertTrue(mob.getText().equals(" 9988774455"));
		assertTrue(statuslab.getText().equals("Staus"));
		//assertTrue(status.getText().equals(" Active"));
		assertTrue(actionlab.getText().equals("Action"));
		delete.click();
	}

}
