package old;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.BaseTest;

public class TestOpeartionsTour extends BaseTest{

	@Test
	public void test() throws InterruptedException {

		driver.get("http://www.newtours.demoaut.com/");

		Thread.sleep(3000);
		// REGISTER
		WebElement regLink = driver.findElement(By.linkText("REGISTER"));

		regLink.click();

		
		testVisibleAndEnable(
				"firstName","lastName","phone","userName","address1");
		
		WebElement fName = driver.findElement(By.name("firstName"));
		fName.sendKeys("krishna"); // enter values to field

		driver.findElement(By.name("lastName")).sendKeys("singamreddy");
		
		Thread.sleep(3000);
		driver.findElement(By.name("lastName")).clear();
		
		driver.findElement(By.name("lastName")).sendKeys("kumar sharnma");
		
		driver.findElement(By.name("phone")).sendKeys("87878787");
		driver.findElement(By.name("userName")).sendKeys("xyz@gmail.com");

		driver.findElement(By.name("address1")).sendKeys("sreeramnagar");

		driver.findElement(By.name("address2")).sendKeys("dorasanipalliroad");
		driver.findElement(By.name("city")).sendKeys("proddatur");

		driver.findElement(By.name("state")).sendKeys("andhrapradesh");

		driver.findElement(By.name("postalCode")).sendKeys("516360");

		driver.findElement(By.name("email")).sendKeys("xyz@gmail.com");

		driver.findElement(By.name("password")).sendKeys("test1234");

		driver.findElement(By.name("confirmPassword")).sendKeys("test1234");

		
		Select countryDropdown = new Select(driver.findElement(By.name("country")));
		//countryDropdown.selectByIndex(1);
		//countryDropdown.selectByValue("6");
		
		
		countryDropdown.selectByVisibleText("ANGOLA ");;
		
		
		
		Thread.sleep(3000);
		
		driver.findElement(By.name("register")).click();
		
		Thread.sleep(3000);
	}
	
	
	private void testVisibleAndEnable(String... names){
		for(String name: names){
			WebElement fName = driver.findElement(By.name(name));
			Assert.assertTrue(name+ " is expected for display", fName.isDisplayed());
			Assert.assertTrue(name +" to enable", fName.isEnabled());
	
		}
	}


}
