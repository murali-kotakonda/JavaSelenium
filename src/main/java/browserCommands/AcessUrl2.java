package browserCommands;


import org.openqa.selenium.WebDriver;

import util.Commons;

public class AcessUrl2 {
public static void main(String[] args) {
	WebDriver driver = Commons.getDriver();
	driver.get("http://www.google.com");
	driver.close();
}
}
