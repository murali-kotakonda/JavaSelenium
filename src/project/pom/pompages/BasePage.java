package pom.pompages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Commons;

public class BasePage {
	
	public WebDriver driver;

	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void clickAddNewEmp() {
		// click on "Add New Employee" link
		WebElement emplabel = driver.findElement(By.id("EmployeeLbl"));
		assertTrue(emplabel.getText().equals("Employee"));
		emplabel.click();

		WebElement addemp = driver.findElement(By.id("addEmpLbl"));
		assertTrue(addemp.getText().equals("Add New Employee"));
		addemp.click();
	}
	
	public void logout() {
		//logout
		WebElement logout = driver.findElement(By.id("logoutLbl"));;
		Commons.checkEnabledAndDisplayed(logout);
		assertTrue(logout.getText().equals("Logout"));
		logout.click();
	}
	
}