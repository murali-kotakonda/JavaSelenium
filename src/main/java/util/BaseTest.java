package util;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.out.println("in setup");
		driver = Commons.getChromeDriver();
	}

	@AfterMethod
	public void close() {
		driver.quit();
		System.out.println("driver closed");
	}

	public WebElement getElement(String address, String type) {
		WebElement ele = driver.findElement(By.id(""));
		if (type.equalsIgnoreCase("xpath")) {
			ele = driver.findElement(By.xpath("'+address+'"));
		} else if (type.equalsIgnoreCase("id")) {
			ele = driver.findElement(By.id("'+address+'"));
		} else if (type.equalsIgnoreCase("name"))
			ele = driver.findElement(By.name("'+address+'"));
		return ele;
	}
	
	public  void checkEnabledAndDisplayed(WebElement... elements) {
		for (WebElement element : elements) {
		assertTrue(element.isDisplayed(), "element expeceted to display");
			assertTrue(element.isEnabled(), "element expected to enable");
		}
	}
	
	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);

		if(!DestFile.exists())
			DestFile.createNewFile();
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}
	
	public void testLinkWorking(WebElement it) {
		String url = it.getAttribute("href");
		HttpURLConnection huc = null;
		int respCode = 200;
		System.out.println(url);
		Assert.assertTrue("Link url is missing..", url != null && !url.isEmpty());
		Assert.assertTrue("Link domain is wrong is missing..", url.startsWith("https://"));
		try {
			huc = (HttpURLConnection) (new URL(url).openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();
			respCode = huc.getResponseCode();
			Assert.assertTrue("Link not working..", respCode == 200);
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
	}
}
