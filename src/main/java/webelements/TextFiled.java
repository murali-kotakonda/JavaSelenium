package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Commons;

public class TextFiled {
	public static void main(String[] args) {
		WebDriver driver = Commons.getDriver();
		driver.get(Commons.URL);

		// <input type="text" id="myname" name="uName" />
		// WebElement item = driver.findElement(By.id("myname"));
		WebElement item = driver.findElement(By.name("uName"));

		if (item.isDisplayed()) {
			System.out.println("item displayed");
		}

		if (item.isEnabled()) {
			System.out.println("item enabled");
		}

		String txt = item.getAttribute("value");
		System.out.println(txt);
		
		if(!txt.equals("")) {
			System.out.println("uname has to be empty.");
		}

		txt = item.getAttribute("id");
		System.out.println(txt);

		txt = item.getAttribute("type");
		System.out.println(txt);

		if(!item.equals("text")) {
			System.out.println("invalid type for uname..");
		}
		
		item.clear();
		
		item.sendKeys("kumar");

	}
}
