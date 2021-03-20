package A_Ex1_WithoutPom;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import util.BaseTest;

public class TestLoginBasic3 extends EmpBaseTest{
		
	// login with correct un and correct pwd
	@Test
	public void testLoginSuccess() throws InterruptedException {
		 login("admin","admin");
		Thread.sleep(5000);

		// logout
		WebElement logout = driver.findElement(By.id("logoutLbl"));
		assertTrue(logout.isDisplayed(), "element expeceted to display");
		assertTrue(logout.isEnabled(), "element expected to enable");
		assertTrue(logout.getText().equals("Logout"));
		logout.click();
		Thread.sleep(5000);
	}

	
	// login with correct un and wrong pwd
	@Test
	public void testLoginFailure() throws InterruptedException {
		login("admin", "admin2");
		Thread.sleep(5000);

		// validate the error message
		WebElement invalidlogin = driver.findElement(By.xpath("//font[@color='Red']"));
		assertTrue(invalidlogin.isDisplayed(), "element expeceted to display");
		assertTrue(invalidlogin.isEnabled(), "element expected to enable");
		assertTrue(invalidlogin.getText().equals("Invalid Login."));
	}
	
	 
}
