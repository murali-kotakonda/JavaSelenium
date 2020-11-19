package testFb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.Commons;

public class Test0Facebook {
  private WebDriver driver;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	//ChromeDriverManager.getInstance().setup();
	driver = Commons.getChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testFacebookLogin() throws Exception {
    driver.get("https://www.facebook.com/");
    WebElement email = driver.findElement(By.id("email"));
	email.click();
    email.clear();
    email.sendKeys("murali");
    
    WebElement pass = driver.findElement(By.id("pass"));
    pass.clear();
    pass.sendKeys("dummy");
    pass.sendKeys(Keys.ENTER);
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    }
}
