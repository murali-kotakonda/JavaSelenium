package testNg1.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestApplication {

	@Test
	public void test() {
		WebDriver driver = Commons.getDriver();

		driver.get("http://localhost:8011/EmpDemo/");
		driver.close();
	}
	
	@Test
	public void testLogin() throws InterruptedException {
		WebDriver driver = Commons.getDriver();
		driver.get("http://localhost:8011/EmpDemo/");

		WebElement userNameLbl = driver.findElement(By.id("userNameLbl"));
		String text = userNameLbl.getText();
		
		Assert.assertEquals("expected ", "User Name:",text);
		
		WebElement login = driver.findElement(By.name("loginName"));
		login.sendKeys("admin");
		
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");
		
		
		WebElement loginBtn = driver.findElement(By.name("login"));
		loginBtn.click();
		
		
		Thread.sleep(10000);
		WebElement logoutLink = driver.findElement(By.name("logoutLink"));
		logoutLink.click();

		//driver.close();
	}
	
	
	


}
