package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.Commons;

public class TestUpload {
	public static void main(String[] args) {
		WebDriver driver = Commons.getDriver();
		driver.get(Commons.URL);
		WebElement uploadElement = driver.findElement(By.name("fileupload"));

		// enter the file path onto the file-selection input field
		uploadElement.sendKeys("C:\\newhtml.html");

		// click the "UploadFile" button
		driver.findElement(By.name("submit")).submit();
	}
}
