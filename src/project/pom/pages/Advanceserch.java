package pom.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.Commons;

public class Advanceserch {

	WebDriver driver;
	@FindBy(id="command") WebDriver form;
	@FindBy(id="advSearchLbl") WebElement advanceserch;
	@FindBy(id="fNameLbl") WebElement firstnamelab;
	@FindBy(name="fName") WebElement firstname;
		@FindBy(xpath="//*[@id=\"command\"]/table/tbody/tr[9]/td/input") WebElement submit;
	public void serch(String fname) {
		Commons.checkEnabledAndDisplayed(firstnamelab,firstname);
		assertTrue(advanceserch.getText().equals("Advance Search Form"));
		assertTrue(firstnamelab.getText().equals("First Name"));
		assertTrue(firstname.getAttribute("type").equals("text"));
		firstname.sendKeys(fname);
		assertTrue(submit.getAttribute("type").equals("submit"));
		submit.click();
	}
	@FindBy(name="lNameLbl") WebElement lastnamelab;
	@FindBy(name="lName") WebElement lastname;
		public void lastserch(String lname) {
			assertTrue(lastnamelab.getText().equals("Last Name"));
			assertTrue(lastname.getAttribute("type").equals("text"));
			lastname.sendKeys(lname);
			}
		@FindBy(id="deptNameLbl") WebElement deptname;
		@FindBy(name="deptId") WebElement dept;
		public void deptserch(String department) {
			assertTrue(deptname.getText().equals("Dept Name"));
			assertTrue(dept.getAttribute("type").equals("text"));
			dept.sendKeys(department);
		}
		@FindBy(id="searchCityLbl") WebElement serch;
		@FindBy(name="city") WebElement cityname;
        public void cityserch(String city) {
		assertTrue(serch.getText().equals("Search City"));
		assertTrue(cityname.getAttribute("type").equals("text"));
		cityname.sendKeys(city);
		assertTrue(submit.getAttribute("type").equals("submit"));
		submit.click();
		
	}
        @FindBy(id="logoutLbl") WebElement logout;
        public void logout() {
        assertTrue(logout.getText().equals("Logout"));
        logout.click();
        }

}
