package windows;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Commons;

public class TestMultiWindows {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = Commons.getDriver();
		driver.get("http://localhost:8011/EmpDemo1/window1.html");
		System.out.println("page opened");
		System.out.println(driver.getTitle());
		String parentWindowHandle = driver.getWindowHandle();
		
		System.out.println("Parent window's handle -> " + parentWindowHandle);
		WebElement clickElement = driver.findElement(By.id("gLink1"));
		clickElement.click();
		Thread.sleep(3000);

		System.out.println("Ater click: ");
		System.out.println(driver.getTitle());
		
		String childWindowHandle = getchildWIndowName(driver, parentWindowHandle);
		System.out.println(parentWindowHandle);
		System.out.println(childWindowHandle);
		// Switch to the parent window
		driver.switchTo().window(childWindowHandle);
		System.out.println("Ater swith: ");
		System.out.println(driver.getTitle());
		// close the parent window
		driver.close();
		// at this point there is no focused window, we have to explicitly switch back
		// to some window.
	}

	private static String getchildWIndowName(WebDriver driver, String parentWindowHandle) {
		String childWindowHandle = null;
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			System.out.println("Switching to window - > " + handle);
			if (!parentWindowHandle.equals(handle)) {
				childWindowHandle = handle;
			}
		}
		return childWindowHandle;
	}
}
