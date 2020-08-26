package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.Commons;

public class TestMouseHover_Click_Select {
	public static void main(String[] args) throws InterruptedException {
		String baseUrl = "http://localhost:8017/fb/welcome.jsp";
        WebDriver driver = Commons.getDriver();
        driver.get(baseUrl);           

        Thread.sleep(5000);
        WebElement link1 = driver.findElement(By.linkText("Click here"));
		Actions action1 = new Actions(driver);
        action1.moveToElement(link1);
        //action.click().build().perform();
        action1.build().perform();
        
        
        Thread.sleep(5000);
        WebElement link2 = driver.findElement(By.linkText("Click for Date"));
        Actions action2 = new Actions(driver);
        action2.moveToElement(link2);
        action2.build().perform();
        
        Thread.sleep(5000);
        
        WebElement link3 = driver.findElement(By.linkText("Send Data"));
        Actions action3 = new Actions(driver);
        action3.moveToElement(link3);
        action3.build().perform();
        
        
        WebElement link = driver.findElement(By.linkText("Click here"));
        Actions action = new Actions(driver);
        //action.moveToElement(link).click();
        action.moveToElement(link);
        action.click();
        action.build().perform();
       
        // or
        
       // new Actions(driver).moveToElement(link).click().build().perform();
       
	}
}
