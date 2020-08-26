package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.Commonsutility;
import utility.Headerutility;

public class AddEmp extends Headerutility {
	WebDriver driver;
		
	public AddEmp(WebDriver idriver)
	{
		this.driver=idriver;
		}
	
	@FindBy(id = "EmployeeLbl") WebElement emp;
	@FindBy(id = "addEmpLbl") WebElement add;
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
	
		
	public void addEmpolyee(String loginName,String password1,String FName,String LName,String birth,String salary,String cell) throws Exception
	{
		
	
		assertTrue(emp.getText().matches("Employee"));
		emp.click();
		assertTrue(add.getText().matches("Add New Employee"));
		add.click();
		Commonsutility.checkEnabledAndDisplayed(empdata,emploginlabel,logname,emppwdlabel,pass,empfnamelabel,fname,emplnanelabel,lname
				,designationlabel,design,genderlabel,sex,dateofbirthlabel,dob,statuslabel,status,departmentlabel,deptid,managerlabel
				,managerid,employesallabel,sal,mobilenolabel,cellNo,maritalstatuslabel,matrialstatus,acceptlabel,accept,submit);
		assertTrue(empdata.getText().equals("Add Employee Data"));
		assertTrue(emploginlabel.getText().equals("Employee login Name:"));
		logname.sendKeys(loginName);
		assertTrue(emppwdlabel.getText().equals("Employee Password:"));
		pass.sendKeys(password1);
		assertTrue(empfnamelabel.getText().equals("Employee First Name:"));
		fname.sendKeys(FName);
		assertTrue(emplnanelabel.getText().equals("Employee Last Name:"));
		lname.sendKeys(LName);
		assertTrue(designationlabel.getText().equals("Designation:"));
		Select s = new Select(design);
		s.selectByVisibleText("System Engineer");
		assertTrue(genderlabel.getText().equals("Gender:"));
		sex.click();
		assertTrue(dateofbirthlabel.getText().equals("Date of Birth:"));
		dob.sendKeys(birth);
		assertTrue( statuslabel.getText().equals("Status:"));
		Select s1 = new Select(status);
		s1.selectByValue("1");
		assertTrue( departmentlabel.getText().equals("Department:"));
		Select s2=new Select(deptid);
		s2.selectByValue("6001");
		assertTrue(managerlabel.getText().equals("Manager :"));
		Select s3=new Select(managerid);
		s3.selectByValue("113");
		assertTrue(employesallabel.getText().equals("Employee Salary:"));
		sal.sendKeys(salary);
		assertTrue(mobilenolabel.getText().equals("Mobile No:"));
		cellNo.sendKeys(cell);
		assertTrue( maritalstatuslabel.getText().equals("Marital Status:"));
		Select s4 = new Select(matrialstatus);
		s4.selectByVisibleText("Married");
		assertTrue(acceptlabel.getText().equals("I accept"));
		accept.click();
        submit.click();
	    
			}
	@FindBy(id="searchEmpIdFormLbl") WebElement serchidlabel;
	@FindBy(xpath="/html/body/font") WebElement empcreatelabel;
	@FindBy(xpath="/html/body/font") WebElement redlabel;
	@FindBy(id="searchEmployeeLbl") WebElement serchemplabel;
	@FindBy(id="searchByNameLbl") WebElement serchbynamelabel;
	@FindBy(id="searchByIdLbl") WebElement serchbyidlabel;
	@FindBy(tagName="h3") WebElement serchresultlabel;
	@FindBy(id="updateProfile") WebElement updateprofilelabel;
	@FindBy(id="deleteLbl") WebElement deleteprofilelabel;
	@FindBy(id="idLbl") WebElement idlabel;
	@FindBy(id="desigLbl") WebElement designationlabel1;
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

	public  void aftercreateemp() {
		Commonsutility.checkEnabledAndDisplayed();
		assertTrue(serchidlabel.getText().equals("Search Employee ID Form"));
		assertTrue(empcreatelabel.getText().equals("Employee Created!"));
		assertTrue(redlabel.getAttribute("color").equals("Red"));
		assertTrue(serchemplabel.getText().equals("Search Employee"));
		assertTrue(serchbynamelabel.getText().equals("Search By Name"));
		assertTrue(serchbyidlabel.getText().equals("Search By Id"));
		Assert.assertEquals("Search Result","Search Result");
		assertTrue(updateprofilelabel.getText().equals("Update Profile"));	
		assertTrue(deleteprofilelabel.getText().equals("Delete Profile"));
		assertTrue(idlabel.getText().equals("ID"));
		assertTrue(designationlabel1.getText().equals("Designation"));	
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
	@FindBy(xpath="/html/body/font") WebElement nameexits;
	public void invalid() {
		assertTrue(nameexits.getText().equals("Name already exists."));
		
	}
//	@FindBy(id="logoutLbl")  WebElement logout;
//	public void logout() {
//		assertTrue(logout.getText().equals("Logout"));
//		
//	}

}

		
		
      
		
	

