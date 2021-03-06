package pages;

import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import testpom.Headerutility;
import util.BaseTest;

public class AddEmp extends Headerutility  {
	WebDriver driver;
	Headerutility header;
		
	public AddEmp(WebDriver idriver)
	{                                                         
		this.driver=idriver;
		
		long monthsBetween = ChronoUnit.MONTHS.between(
			     YearMonth.from(LocalDate.parse("2016-08-31")), 
			     YearMonth.from(LocalDate.parse("2016-11-30"))
			);
			System.out.println(monthsBetween); //3
		//DateTimeFormatter java.time.format.DateTimeFormatter.ISO_LOCAL_DATE
		}
	@FindBy(id="command") WebElement form;
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
		BaseTest.checkEnabledAndDisplayed(empdata, emploginlabel, logname, emppwdlabel, pass, empfnamelabel, fname,
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
	//@FindBy(tagName="td") WebElement id;
	@FindBy(id="desigLbl") WebElement designationlabel1;
	@FindBy(xpath="/html/body/table/tbody/tr[2]/td[2]") WebElement designation;
	@FindBy(id="fNameLbl") WebElement fnamelabel;
	@FindBy(xpath="/html/body/table/tbody/tr[3]/td[2]") WebElement finame;
	@FindBy(id="lNameLbl") WebElement lnamelabel;
	@FindBy(xpath="/html/body/table/tbody/tr[4]/td[2]") WebElement liname;
	@FindBy(id="genderLbl") WebElement gendlabel;
	@FindBy(xpath="/html/body/table/tbody/tr[5]/td[2]") WebElement gen;
	@FindBy(id="deptNameLbl") WebElement deptnamelabel;
	@FindBy(xpath="/html/body/table/tbody/tr[6]/td[2]") WebElement dept;
	@FindBy(id="managerLbl") WebElement managerlabel1;
	@FindBy(xpath="/html/body/table/tbody/tr[7]/td[2]") WebElement mana;
	@FindBy(id="loginNameLbl") WebElement loginlabel;
	@FindBy(xpath="/html/body/table/tbody/tr[8]/td[2]") WebElement loginame;
	@FindBy(id="dobLbl") WebElement dateblabel;
	@FindBy(xpath="/html/body/table/tbody/tr[9]/td[2]") WebElement date; 
	@FindBy(id="dojLbl") WebElement dateofjlabel;
	@FindBy(xpath="/html/body/table/tbody/tr[10]/td[2]") WebElement datej;
	@FindBy(id="mnoLbl") WebElement mobilelabel;
	@FindBy(xpath="/html/body/table/tbody/tr[11]/td[2]") WebElement mobile;
	@FindBy(id="maritalStatusLbl") WebElement maritalstatuslabel1;
	@FindBy(xpath="/html/body/table/tbody/tr[12]/td[2]") WebElement marital;
	@FindBy(id="statusLbl") WebElement statuslabel1;
	@FindBy(xpath="/html/body/table/tbody/tr[13]/td[2]") WebElement statu;

	public  void aftercreateemp(String loginName,String password1,String FName,String LName,String birth,String salary,String string) {
		BaseTest.checkEnabledAndDisplayed(serchidlabel,empcreatelabel,serchemplabel,serchbynamelabel,serchbyidlabel,serchresultlabel
				,updateprofilelabel,deleteprofilelabel,idlabel,designationlabel1,fnamelabel,lnamelabel,lnamelabel,deptnamelabel,managerlabel1
				,loginlabel,dateblabel,dateofjlabel,mobilelabel,maritalstatuslabel1,statuslabel1);
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
		assertTrue(designation.getText().equals("Analyst"));
		assertTrue(fnamelabel.getText().equals("First Name"));
		assertTrue(finame.getText().equals("thirupathi"));
		assertTrue(lnamelabel.getText().equals("Last Name"));
		assertTrue(liname.getText().equals("vaddempudi"));
		assertTrue(gendlabel.getText().equals("Gender"));
		assertTrue(gen.getText().equals("male"));
		assertTrue(deptnamelabel.getText().equals("Department Name:"));
		assertTrue(dept.getText().equals("IT"));
		assertTrue(managerlabel1.getText().equals("Manager Name:"));
		assertTrue(mana.getText().equals("SHYAM , reddy"));
		assertTrue(loginlabel.getText().equals("Login Name"));
		assertTrue(loginame.getText().equals("thirupathi"));
		assertTrue(dateblabel.getText().equals("Date of Birth"));
		assertTrue(date.getText().equals("03/31/1992"));
		assertTrue(dateofjlabel.getText().equals("Date Of Join"));
		assertTrue(datej.getText().equals("2019-09-12"));
		assertTrue(mobilelabel.getText().equals("Mobile No:"));
		assertTrue(mobile.getText().equals("8899445577"));
		assertTrue(maritalstatuslabel1.getText().equals("Marital Status:"));
		assertTrue(marital.getText().equals("single"));
	    assertTrue(statuslabel1.getText().equals("Status:"));
	    assertTrue(statu.getText().equals("Active"));
	    
		}
	
	@FindBy(xpath="/html/body/font") WebElement nameexits;
	@FindBy(id="empLoginLbl") WebElement login;
	@FindBy(id="loginName") WebElement loginName;
	@FindBy(id="empPwdLbl") WebElement pwd;
	@FindBy(id="password") WebElement password;
	@FindBy(id="empFnameLbl") WebElement firstnamelabel;
	@FindBy(id="fName") WebElement Firstname;
	@FindBy(id="empLnameLbl") WebElement lastnamelabel;
	@FindBy(id="lName") WebElement lastname;
	@FindBy(id="desigLbl") WebElement desiglabel;
	@FindBy(id="designation") WebElement desig;
	@FindBy(id="genderLbl") WebElement genlabel;
	@FindBy(id="mRadio") WebElement gender;
	@FindBy(id="dobLbl") WebElement doblabel;
	@FindBy(id="dateOfBirth") WebElement dateofbirth;
	@FindBy(id="statusLbl") WebElement Statuslabel;
	@FindBy(id="login.status") WebElement Status;
	@FindBy(id="deptLbl") WebElement Deptlabel;
	@FindBy(id="department.id") WebElement Department;
	@FindBy(id="managerLbl") WebElement Managerlabel;
	@FindBy(id="manager.id") WebElement Manager;
	@FindBy(id="empSalLbl") WebElement Salarylabel;
	@FindBy(id="salary") WebElement Salary;
	@FindBy(id="mnoLbl") WebElement Mobilelabel;
	@FindBy(id="mobileNo") WebElement Mobile;
	@FindBy(id="maritalStatusLbl") WebElement Maeitallabel;
	@FindBy(id="maritalStatus") WebElement Marital;
	public void invalid(String log,String pass,String fname,String lname,String birth,String sal,String mobileno) {
		assertTrue(nameexits.getText().equals("Name already exists."));
		
//		assertTrue(login.getText().equals("Employee login Name:"));
//		assertTrue(loginName.getAttribute("type").equals("text"));
//		assertTrue(pwd.getText().equals("Employee Password:"));
//		assertTrue(password.getAttribute("type").equals("password"));
//		assertTrue(firstnamelabel.getText().equals("Employee First Name:"));
//		assertTrue(Firstname.getAttribute("type").equals("text"));
//		assertTrue(lastnamelabel.getText().equals("Employee Last Name:"));
//		assertTrue(lastname.getAttribute("type").equals("text"));
//		assertTrue(desiglabel.getText().equals("Designation:"));
//		assertTrue(desig.getAttribute("value").equals("Analyst"));
//		assertTrue(genlabel.getText().equals("Gender:"));
//		assertTrue(gender.getAttribute("type").equals("radio"));
//		assertTrue(doblabel.getText().equals("Date of Birth:"));
//		assertTrue(dateofbirth.getAttribute("type").equals("text"));
//		assertTrue(Statuslabel.getText().equals("Status:"));
//		//Assert.assertEquals("Active",Status.getAttribute("value"));
//		assertTrue(Status.getAttribute("value").equals("1"));
//		assertTrue(Deptlabel.getText().equals("Department:"));
//		assertTrue(Department.getAttribute("value").equals("6001"));
//		assertTrue(Managerlabel.getText().equals("Manager :"));
//		assertTrue(Manager.getAttribute("value").equals("112"));
//		assertTrue(Salarylabel.getText().equals("Employee Salary:"));
//		assertTrue(Salary.getAttribute("type").equals("text"));
//		assertTrue(Mobilelabel.getText().equals("Mobile No:"));
//		assertTrue(Mobile.getAttribute("type").equals("text"));
//		assertTrue(Maeitallabel.getText().equals("Marital Status:"));
//		assertTrue(Marital.getAttribute("value").equals("single"));
//		
		
		
	}
	@FindBy(id="logoutLbl")  WebElement logout;
	public void logout() {
		assertTrue(logout.getText().equals("Logout"));
		logout.click();
		}
	@FindBy(id="deleteLbl") WebElement delete;
	public void Deleteprofile() {
		assertTrue(delete.getText().equals("Delete Profile"));
		delete.click();
		
	}
//	@FindBy(xpath="/html/body/table/tbody/tr[3]/td[10]/a[2]") WebElement del;
//	public void delete() {
//		assertTrue(del.getText().equals("Delete"));
//		del.click();
	//}

}
