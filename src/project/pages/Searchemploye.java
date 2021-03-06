package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.Commons;

public class Searchemploye {
	WebDriver driver;
	
	@FindBy(id="EmployeeLbl") WebElement emp;
	@FindBy(id="searchEmpLbl") WebElement serch;
	@FindBy(id="searchEmpIdFormLbl") WebElement serchemp;
	@FindBy(id="searchEmployeeLbl") WebElement serchemplab;
	@FindBy(name="reqData") WebElement name;
	@FindBy(id="searchByNameLbl") WebElement byname;
	@FindBy(xpath="//*[@id=\"command\"]/table/tbody/tr[1]/td[2]/input") WebElement submit;
	
	public void serchname(String empname) {
		assertTrue(serchemp.getText().equals("Search Employee ID Form"));
		Commons.checkEnabledAndDisplayed(serchemplab,name,byname);
		assertTrue(serchemplab.getText().equals("Search Employee"));
		assertTrue(name.getAttribute("type").equals("text"));
		name.sendKeys(empname);
		assertTrue(byname.getText().equals("Search By Name"));
		byname.click();
		assertTrue(submit.getAttribute("type").equals("submit"));
		submit.click();
		}
	
	@FindBy(xpath="/html/body/font") WebElement notfound;
	public void invalid() {
		assertTrue(notfound.getText().equals("Employee Not found"));
	}
	@FindBy(id="logoutLbl") WebElement logout;
	public void logout() {
		assertTrue(logout.getText().equals("Logout"));
		logout.click();
	}
	@FindBy(xpath="//*[@id=\"deleteLbl\"]") WebElement deleteprofile;
	public void delete() {
		assertTrue(deleteprofile.getText().equals("Delete Profile"));
		deleteprofile.click();
	}
	
	@FindBy(xpath="/html/body/h3[2]") WebElement result;
	@FindBy(id="updateProfile") WebElement update;
	@FindBy(id="deleteLbl") WebElement delete;
	@FindBy(id="idLbl") WebElement id;
	@FindBy(id="desigLbl") WebElement designation;
	@FindBy(id="fNameLbl") WebElement fnamelabel;
	@FindBy(id="lNameLbl") WebElement lnamelabel;
	@FindBy(id="genderLbl") WebElement gendlabel;
	@FindBy(id="deptNameLbl") WebElement deptnamelabel;
	@FindBy(id="managerLbl") WebElement managerlabel1;
	@FindBy(id="loginNameLbl") WebElement loginlabel;
	@FindBy(id="dobLbl") WebElement dateblabel;
	@FindBy(id="dojLbl") WebElement dateofjlabel;
	@FindBy(id="mnoLbl") WebElement mobilelabel;
	@FindBy(id="maritalStatusLbl") WebElement maritalstatuslabel1;
	@FindBy(id="statusLbl") WebElement statuslabel1;

	public void valid() {
		assertTrue(result.getText().equals("Search Result"));
		assertTrue(update.getText().equals("Update Profile"));
		assertTrue(delete.getText().equals("Delete Profile"));
		assertTrue(id.getText().equals("ID"));
		assertTrue(designation.getText().equals("Designation"));
		assertTrue(fnamelabel.getText().equals("First Name"));
		assertTrue(lnamelabel.getText().equals("Last Name"));
		assertTrue(gendlabel.getText().equals("Gender"));
		assertTrue(deptnamelabel.getText().equals("Department Name:"));
		assertTrue(managerlabel1.getText().equals("Manager Name:"));
		assertTrue(loginlabel.getText().equals("Login Name"));
		assertTrue(dateblabel.getText().equals("Date of Birth"));
		assertTrue(dateofjlabel.getText().equals("Date Of Join"));
		assertTrue(mobilelabel.getText().equals("Mobile No:"));
		assertTrue(maritalstatuslabel1.getText().equals("Marital Status:"));
	    assertTrue(statuslabel1.getText().equals("Status:"));

	}

}
