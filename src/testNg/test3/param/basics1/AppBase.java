package test3.param.basics1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import util.Commons;

public class AppBase {
protected WebDriver driver;
	
	@BeforeTest
	@Parameters(value = {"url"})
	public void before(String url) {
		 driver = Commons.getChromeDriver();
		 driver.get(url);
		 sleep(3);
	}
	
	@AfterTest
	public void after() {
		driver.quit();
	}
	
	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public WebElement getTextFieldByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		Assert.assertEquals(element.getAttribute("type"), "text");
		return element;
	}
	
}
