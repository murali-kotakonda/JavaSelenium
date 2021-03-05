package parameter;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestGoogle extends AppBase{

	@Test  
	public void test1() {
		//create action object
		Actions actions = new Actions(driver);
		WebElement textField = getTextFieldByName("q");
		textField.sendKeys("selenium");
		sleep(3);
		
		actions.moveToElement(textField).click().build().perform();
		sleep(3);
		
		actions.sendKeys(Keys.DOWN).build().perform();
		sleep(3);
		
		actions.sendKeys(Keys.DOWN).build().perform();
		sleep(3);
		
		actions.sendKeys( Keys.DOWN).build().perform();
		sleep(3);
		
		actions.sendKeys( Keys.ENTER).build().perform();
		sleep(3);
	}
	
	@Test  
	public void test2() {
		//create action object
		Actions actions = new Actions(driver);
		WebElement textField = getTextFieldByName("q");
		textField.sendKeys("java");
		sleep(3);
		
		actions.moveToElement(textField).click().build().perform();
		sleep(3);
		
		actions.sendKeys(Keys.DOWN).build().perform();
		sleep(3);
		
		actions.sendKeys(Keys.DOWN).build().perform();
		sleep(3);
		
		actions.sendKeys( Keys.DOWN).build().perform();
		sleep(3);
		
		actions.sendKeys( Keys.ENTER).build().perform();
		sleep(3);
	}
	
}
