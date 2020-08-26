package webelements;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Commons;

public class TestRadio {

	public static void main(String[] args) {
		WebDriver driver = Commons.getDriver();
		driver.get(Commons.URL);
		WebElement radio1 = driver.findElement(By.id("mRadio"));
		
		// Check whether the Check box is toggled on
		if (!radio1.isSelected()) {
			System.out.println("male should be selected");
		}  
		
		WebElement radio2 = driver.findElement(By.id("fRadio"));
		radio2.click();

		List<WebElement> radios = driver.findElements(By.name("gender"));
		int size = radios.size();
		if (size != 3) {
			System.out.println("Invalid no of radios for gender");
		}

		// content test
		List<String> expectedCities = Arrays.asList("male", "female", "other");
		for (WebElement element : radios) {
			String genderValue = element.getAttribute("value");
			if (!expectedCities.contains(genderValue)) {
				System.out.println("invalid gender:" + genderValue);
			}
		}
	}
}
