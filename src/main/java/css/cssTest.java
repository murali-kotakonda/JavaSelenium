package css;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Commons;

public class cssTest {
	public static void main(String[] args) {
		WebDriver driver = Commons.getChromeDriver();
		driver.get("http://localhost:8071/EmpApp/test.jsp");
		WebElement webElement = driver.findElement(By.cssSelector("a[title=\"Go to home page\"]"));
		webElement.click();
	}
}
