package testFb;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Commons;

public class Test4 {

	public static void main(String[] args) {
		WebDriver driver = Commons.getDriver();
		driver.get(Commons.URL);
		
		
		WebElement pan = driver.findElement(By.name("proof3"));
		if(!pan.isSelected()) {
			System.out.println("pan should selected");
		}
		//unchek pan
		pan.click();
		
		
		WebElement voter = driver.findElement(By.name("proof2"));
		//select voter
		voter.click();
		
		//size testing using xpath
		List<WebElement> checks = driver.findElements(By.name("proof"));
		int size = checks.size();        
		if(size!=3) {
			System.out.println("Invalid no of radios for gender");
		}
	
		//content test
		List<String> expectedChecks =Arrays.asList("voter","pan","aadhar");
		for(WebElement element :checks){
			String checkValue= element.getAttribute("value");
			if(!expectedChecks.contains(checkValue)) {
				System.out.println("invalid gender:" +checkValue);
			}
		}
 	}
}
