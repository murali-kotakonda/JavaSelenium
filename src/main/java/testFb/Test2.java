package testFb;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.BaseTest;
import util.Commons;

public class Test2 extends BaseTest {

	@BeforeMethod
	public void setup() {
		super.setup();
		// driver.get("http://localhost:8081/myapp/form.html");
		driver.get(Commons.BASE_URL + "form.html");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	  Proofs:
		<input type="checkbox" name="proof1" value="passport">passport &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="checkbox" name="proof2" value="voter">voter &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="checkbox" name="proof3" value="pan" checked> pan<br>
		<br><br>
		
		How to get the web element based on attribute?
		------------------------------------------------
		List<WebElement> checks = driver.findElements(By.xpath("//input[@type='checkbox']"));  // fetch the weblement that has 'checkbox' as attribute for the input tag
		
		
		How to check/uncheck the checkbox?
		use click() method
	 */
	@Test
	public void testCheckBox1() throws InterruptedException {
		// fetch web elements based on attribute
		//validate no of check boxes
		List<WebElement> checks = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int size = checks.size();
		assertEquals(size, 3, "invalid no of check boxes");

		// content test
		List<String> expectedChecks = Arrays.asList("voter", "pan", "passport");
		for (WebElement element : checks) {
			String checkValue = element.getAttribute("value");
			assertTrue(expectedChecks.contains(checkValue));
		}

		WebElement passport = driver.findElement(By.name("proof1"));
		WebElement voter = driver.findElement(By.name("proof2"));
		WebElement pan = driver.findElement(By.name("proof3"));

		assertEquals(passport.getAttribute("type"), "checkbox");
		assertEquals(voter.getAttribute("type"), "checkbox");
		assertEquals(pan.getAttribute("type"), "checkbox");

		// checkEnabledAndDisplayed
		assertTrue(passport.isEnabled(), "passport should  enabled");
		assertTrue(voter.isEnabled(), "voter should  enabled");
		assertTrue(pan.isEnabled(), "pan should be enabled");

		assertFalse(passport.isSelected(), "passport is not selected.");
		assertFalse(voter.isSelected(), "voter is not selected.");
		assertTrue(pan.isSelected(), "pan is  selected.");

		// unchek pan
		pan.click();

		Thread.sleep(2000);
		
		// select voter
		voter.click();
		
		Thread.sleep(2000);
		// select pan
		pan.click();
		
		Thread.sleep(2000);
	}

	/**
	     How to know if the radio button is selected or not?
    		use element.isSelected() -> returns true/false
    
    	How to know if the web element is radio button?
     		element.getAttribute("type") should return "radio"
     
     	How to select a radio button
     		element.click()
	 * @throws InterruptedException 
     
	 */
	@Test
	public void testRadio() throws InterruptedException {
		// <input type="radio" name="gender" id="mRadio" value="male" checked> Male<br>
	   //  <input type="radio" name="gender" id="fRadio" value="female"> Female<br>
		// <input type="radio" name="gender" id="oRadio" value="other"> Other
		List<WebElement> radios = driver.findElements(By.name("gender"));
		int size = radios.size();
		assertEquals(size, 3, "Invalid no of radios for gender");

		// content test
		List<String> expectedGenerValues = Arrays.asList("male", "female", "other");
		for (WebElement element : radios) {
			String genderValue = element.getAttribute("value");
			assertTrue(expectedGenerValues.contains(genderValue));
		}
		
		//get specific
		WebElement mRadio = driver.findElement(By.id("mRadio"));
		WebElement fRadio = driver.findElement(By.id("fRadio"));
		WebElement oRadio = driver.findElement(By.id("oRadio"));
		
		assertEquals(mRadio.getAttribute("type"), "radio");
		assertEquals(fRadio.getAttribute("type"), "radio");
		assertEquals(oRadio.getAttribute("type"), "radio");

		// checkEnabledAndDisplayed
		assertTrue(mRadio.isEnabled() && mRadio.isDisplayed(), "mRadio should be enabled and displayed");
		assertTrue(fRadio.isEnabled() && fRadio.isDisplayed(), "fRadio should be enabled and displayed");
		assertTrue(oRadio.isEnabled() && oRadio.isDisplayed(), "oRadio should be enabled and displayed");
		

		assertTrue(mRadio.isSelected(), "mRadio is selected.");
		assertFalse(fRadio.isSelected(), "fRadio is not selected.");
		assertFalse(oRadio.isSelected(), "oRadio is not selected.");
		
		// how to select radio button
		oRadio.click();
		Thread.sleep(2000);
		
		// how to select radio button
		fRadio.click();
		Thread.sleep(2000);
		
		// how to select radio button
		mRadio.click();
		Thread.sleep(2000);
	}
	
	@Test
	public void upload() throws InterruptedException {
		//Upload image :<input type = "file" name = "fileupload" accept = "image/*" />
		WebElement uploadElement = driver.findElement(By.name("fileupload"));
		
		assertTrue(uploadElement.isEnabled() && uploadElement.isDisplayed(), "uploadElement should be enabled and displayed");
		assertEquals(uploadElement.getAttribute("type"), "file");
		assertEquals(uploadElement.getAttribute("accept"), "image/*");
		
		// enter the file path  
		uploadElement.sendKeys("C:\\test\\test1.txt");
		Thread.sleep(5000);
		// click the "UploadFile" button
		driver.findElement(By.name("submit")).submit();
		Thread.sleep(5000);
	}
}
