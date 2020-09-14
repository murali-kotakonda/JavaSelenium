package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateProfile {
	WebDriver driver;
	
	@FindBy(tagName="h3") WebElement profile;
	@FindBy(id="updateProfile") WebElement update;
	@FindBy(tagName="h3") WebElement updating;
	@FindBy(id="IdLbl") WebElement id;
	@FindBy(name="id") WebElement idno;
	@FindBy(id="desigLbl") WebElement desiglab;
	@FindBy(xpath="//*[@id=\"command\"]/table/tbody/tr[2]/td[2]") WebElement asso;
	@FindBy(id="fNameLbl") WebElement fname;
	@FindBy(id="fName") WebElement name;
	@FindBy(id="lNameLbl") WebElement lname;
	@FindBy(id="lName") WebElement last;
	@FindBy(id="dobLbl") WebElement dob;
	@FindBy(id="dateOfBirth") WebElement Dateofbirth;
	@FindBy(id="dojLbl") WebElement doj;
	@FindBy(id="joinDate") WebElement joindate;
	@FindBy(id="mnoLbl") WebElement mobile;
	@FindBy(id="mobileNo") WebElement mobileno;
	@FindBy(id="statusLbl") WebElement status; 
	@FindBy(id="login.status") WebElement active;
	@FindBy(id="mStatusLbl") WebElement mstatus;
	@FindBy(id="maritalStatus") WebElement marital;
	@FindBy(xpath="//*[@id=\"command\"]/table/tbody/tr[24]/td/input") WebElement submit;
	public void uppdate(String firstname,String lastname,String mno) {
		assertTrue(profile.getText().equals("My Profile"));
		assertTrue(update.getText().equals("Update Profile"));
		update.click();
		assertTrue(updating.getText().equals("Updating Profile Screen"));
		assertTrue(id.getText().equals("ID"));
		assertTrue(idno.getAttribute("type").equals("text"));
		idno.getText();
		assertTrue(desiglab.getText().equals("Designation"));
		assertTrue(asso.getText().equals("Associate Engineer"));
		assertTrue(fname.getText().equals("First Name"));
		assertTrue(name.getAttribute("type").equals("text"));
		name.clear();
		name.sendKeys(firstname);
		assertTrue(lname.getText().equals("Last Name"));
		assertTrue(last.getAttribute("type").equals("text"));
		last.clear();
		last.sendKeys(lastname);
		assertTrue(dob.getText().equals("Date of Birth"));
		assertTrue(Dateofbirth.getAttribute("type").equals("text"));
		Dateofbirth.getAttribute("04/09/1993");
		assertTrue(doj.getText().equals("Date Of Join"));
		assertTrue(joindate.getAttribute("type").equals("text"));
		joindate.getAttribute("2019-09-02");
		assertTrue(mobile.getText().equals("Mobile No:"));
		assertTrue(mobileno.getAttribute("type").equals("text"));
		mobileno.clear();
		mobileno.sendKeys(mno);
		assertTrue(status.getText().equals("Status:"));
		assertTrue(active.getAttribute("name").equals("login.status"));
		active.getAttribute("1");
		assertTrue(mstatus.getText().equals("Marital Status:"));
		assertTrue(marital.getAttribute("name").equals("maritalStatus"));
		marital.getAttribute("single");
		assertTrue(submit.getAttribute("value").equals("Update"));
		submit.click();
		
		
	}

}
