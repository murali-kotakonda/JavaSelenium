package test13.screenshotEx;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import util.Commons;

public class Test1 {

	@Test
	public void takeScreenShot() throws Exception {

		WebDriver driver;
		driver = Commons.getChromeDriver();
		// goto url

		driver.get("http://facebook.com");

		// Call take screenshot function

		this.takeSnapShot(driver, "C://test//test.png");

	}

	/**
	 * 
	 * This function will take screenshot
	 * 
	 * @param webdriver
	 * 
	 * @param fileWithPath
	 * 
	 * @throws Exception
	 * 
	 */

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

}