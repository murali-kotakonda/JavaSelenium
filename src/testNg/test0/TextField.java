package test0;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Commons;

/**
 1.How to get the web element for the text field using name?
  <input type="text" id="myname" name="uName" />
   WebElement item = driver.findElement(By.name("uName"));  
 
 2.How to get the web element for the text field using name?
  <input type="text" id="myname" name="uName" />
   WebElement item = driver.findElement(By.id("myname"));  
 
 3.How to check if the  web element is displayed?
  item.isDisplayed()
  
 4.How to check if the  web element is enabled?
 item.isEnabled()
 
 5.How to enter the text to the text field?
 	item.sendKeys("kumar");
 	
 6.How to clear the text for the text field?
 item.clear();
 
 7.How to check if the web element is text box?
  item.getAttribute("type") value should be "text"
  
 */
public class TextField {
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