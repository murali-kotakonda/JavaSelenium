package old.utility;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Commonsutility {
	public static void checkEnabledAndDisplayed(WebElement... elements) {
		for (WebElement element : elements) {
			assertTrue(element.isDisplayed(), "element expeceted to display");
			assertTrue(element.isEnabled(), "element expected to enable");
		}

	}
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
	public static void aftercreate() {
		
	}

}
