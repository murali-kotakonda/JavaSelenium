package pom.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
	WebDriver driver;
	public LogoutPage(WebDriver idriver) {
		this.driver=idriver;
		}
	@FindBy(id="logoutLbl") WebElement logout;
	public void click() {
		 assertTrue(driver.findElement(By.id("logoutLbl")).getText().equals("Logout"));
		logout.click();
	}
	}

