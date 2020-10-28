package testFb;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.BaseTest;
import util.Commons;

public class Test3MultiWindows extends BaseTest {

	@BeforeMethod
	public void setup() {
		super.setup();
		driver.get(Commons.BASE_URL + "window1.html");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 How to get the current window name?
	 String parentWindowHandle = driver.getWindowHandle();
	 
	 
	 How to get all window handles?
	 Set<String> allWindowHandles = driver.getWindowHandles();
	 
	 How to switch between the windows?
	 driver.switchTo().window("<window name>");
	 
	 */
	@Test
	public void testWindow() throws InterruptedException {
		assertEquals(driver.getTitle() , "In window1", "Invalid title");
		
		String parentWindowHandle = driver.getWindowHandle();
		WebElement clickElement = driver.findElement(By.id("gLink1"));
		clickElement.click();
		Thread.sleep(3000);

		String childWindowHandle = getchildWIndowName(driver, parentWindowHandle);
		driver.switchTo().window(childWindowHandle);
		
		//validate child title
	    assertEquals(driver.getTitle() , "Hello Python", "Invalid title");
		Thread.sleep(2000);
		
		driver.findElement(By.name("name")).sendKeys("user1");
		Thread.sleep(2000);
		
		driver.findElement(By.name("password")).sendKeys("user1");
		Thread.sleep(2000);
		
		driver.switchTo().window(parentWindowHandle);
		Thread.sleep(2000);
		assertEquals(driver.getTitle() , "In window1", "Invalid title");
		driver.findElement(By.name("uName")).sendKeys("kumar");
		
		Thread.sleep(3000);
	}

	private String getchildWIndowName(WebDriver driver, String parentWindowHandle) {
		String childWindowHandle = null;
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!parentWindowHandle.equals(handle)) {
				childWindowHandle = handle;
				break;
			}
		}
		return childWindowHandle;
	}
}