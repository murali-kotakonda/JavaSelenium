package tests5;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Slider extends BaseTesst5 {

	@Test
	public void select() throws InterruptedException {
		driver.findElement(By.linkText("Selectable")).click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		WebElement e = driver.findElement(By.xpath("//li[text()='Item 1']"));

		Actions a = new Actions(driver);

		a.doubleClick(e).build().perform();
		Thread.sleep(5000);

	}
}