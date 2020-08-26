package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import util.Commons;

public class TestMouseHover {

	/*
	  <img onmouseover="bigImg(this)" src="test.jpeg" alt="Smiley">



<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("p").mouseover(function(){
    $("p").css("background-color", "yellow");
  });
  $("p").mouseout(function(){
    $("p").css("background-color", "lightgray");
  });
});
</script>
</head>
<body>

<p id="mylabel">Move the mouse pointer over this paragraph.</p>

</body>
</html> 
	 */
	public static void main(String[] args) throws InterruptedException {
		String baseUrl = "http://localhost:8011/EmpDemo1/hover.html";
		WebDriver driver = Commons.getDriver();

		driver.get(baseUrl);
		WebElement link_Home = driver.findElement(By.linkText("Click here"));

		Actions builder = new Actions(driver);
		Action mouseOverHome = builder.moveToElement(link_Home).build();

		String bgColor = link_Home.getCssValue("color");
		System.out.println("Before hover: " + bgColor);
		Thread.sleep(3000);

		mouseOverHome.perform();

		bgColor = link_Home.getCssValue("color");
		Thread.sleep(3000);
		System.out.println("After hover: " + bgColor);
		driver.close();
	}
}
