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

public class Test2 extends BaseTest{

	@BeforeMethod
	public void setup() {
		super.setup();
		//driver.get("http://localhost:8081/myapp/form.html");
		driver.get(Commons.BASE_URL+"form.html"); 
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCheckBox1() {
        // fetch web elements based on attribute
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
		
		assertEquals(passport.getAttribute("type"),"checkbox");
		assertEquals(voter.getAttribute("type"),"checkbox");
		assertEquals(pan.getAttribute("type"),"checkbox");
		
		//checkEnabledAndDisplayed
		assertTrue(passport.isEnabled(),"passport should  enabled");
		assertTrue(voter.isEnabled(),"voter should  enabled");
		assertTrue(pan.isEnabled(),"pan should be enabled");
		
		assertFalse(passport.isSelected(),"passport is not selected.");
		assertFalse(voter.isSelected(),"voter is not selected.");
		assertTrue(pan.isSelected(),"pan is  selected.");
		
		//unchek pan
		pan.click();
		
		//select voter
		voter.click();
 	}
}
