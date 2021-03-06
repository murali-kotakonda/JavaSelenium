package testFb;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.BaseTest;
import util.Commons;

public class Test2 extends BaseTest {

	@BeforeMethod
	public void	 setup() {
		super.setup();
		// driver.get("http://localhost:8081/myapp/form.html");
		driver.get(Commons.BASE_URL + "form.html");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void upload() throws InterruptedException {
		//Upload image :<input type = "file" name = "fileupload" accept = "image/*" />
		WebElement uploadElement = driver.findElement(By.name("fileupload"));
		
		assertTrue(uploadElement.isEnabled() && uploadElement.isDisplayed(), "uploadElement should be enabled and displayed");
		assertEquals(uploadElement.getAttribute("type"), "file");
		assertEquals(uploadElement.getAttribute("accept"), "image/*");
		
		// enter the file path  
		uploadElement.sendKeys("C:\\test\\test1.txt");
		Thread.sleep(5000);
		// click the "UploadFile" button
		driver.findElement(By.name("submit")).submit();
		Thread.sleep(5000);
	}
}
