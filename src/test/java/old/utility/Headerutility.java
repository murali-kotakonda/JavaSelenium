package old.utility;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Headerutility {
	WebDriver driver;
	
	@FindBy(id="myProfileLbl") WebElement mylabel;
	@FindBy(id="EmployeeLbl") WebElement emplabel;
	@FindBy(id="addEmpLbl") WebElement addemp;
	@FindBy(id="mySubLbl") WebElement mysublab;
	@FindBy(id="DepartmentLbl") WebElement deptlab;
	@FindBy(id="logoutLbl") WebElement logoutlab;
	//@FindBy(tagName="h3") WebElement proflabel;
	
	public   void validatelables() throws Exception {
	Commonsutility.checkEnabledAndDisplayed(mylabel,emplabel,mysublab,deptlab,logoutlab);
	assertTrue(mylabel.getText().equals("My Profile"));
	assertTrue(emplabel.getText().equals("Employee"));
	assertTrue(addemp.getText().equals("Add New Employee"));
	assertTrue(mysublab.getText().equals("My Subordinates"));
	assertTrue(deptlab.getText().equals("Department"));
	assertTrue(logoutlab.getText().equals("Logout"));
	emplabel.click();
	addemp.click();
	//assertTrue(proflabel.getText().equals("My Profile"));
					
			
		}
		

	}

