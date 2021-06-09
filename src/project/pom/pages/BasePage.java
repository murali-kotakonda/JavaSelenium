package pom.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	
	public WebDriver driver;

	public void clickAddNewEmp() {
		// click on "Add New Employee" link
		WebElement emplabel = driver.findElement(By.id("EmployeeLbl"));
		assertTrue(emplabel.getText().equals("Employee"));
		emplabel.click();

		WebElement addemp = driver.findElement(By.id("addEmpLbl"));
		assertTrue(addemp.getText().equals("Add New Employee"));
		addemp.click();
	}
	
}