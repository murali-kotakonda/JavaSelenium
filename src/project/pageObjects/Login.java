package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import inheritanceByExtends.TestCases;

public class Login
{
	WebDriver driver;
	ReadProperties myProp;
	ReadXlData myXl;
	public Login(WebDriver driver)
	{
		this.driver = driver;
		//System.out.println("Login Session ID :" + driver.getWindowHandle());
		myProp = new ReadProperties("TestData/inputData.properties");
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		myXl = new ReadXlData();
	}
	@FindBy(name = "userName")      WebElement userNameObj;
	@FindBy(name = "password")      WebElement passWordObj;
	@FindBy(name = "login")         WebElement loginObj;
	@FindBy(linkText = "SIGN-OFF")  WebElement logoutObj;
	public boolean result;
	public boolean launchApplication()
	{
		System.out.println("RC : Launch Application");
		//driver.get(myProp.readValue("URL"));
		driver.get(myXl.getCellData(TestCases.env,0,1));
		if(driver.getTitle().equals("Welcome: Mercury Tours"))
		{
			result = true;
		}
		else
		{
			result = false;
		}
		return result;	
	}
	public boolean loginToApplication()
	{
		System.out.println("RC : Login Application");
		userNameObj.sendKeys(myXl.getCellData(TestCases.env,1,1));
		passWordObj.sendKeys(myXl.getCellData(TestCases.env,2,1));
		loginObj.click();
		/*userNameObj.sendKeys(myProp.readValue("UserName"));
		passWordObj.sendKeys(myProp.readValue("PassWord"));
		loginObj.click();*/
		/*driver.findElement(By.name("userName")).sendKeys(myProp.readValue("UserName"));
		driver.findElement(By.name("password")).sendKeys(myProp.readValue("PassWord"));
		driver.findElement(By.name("login")).click();*/
		return result;
	}
	public boolean logoutFromApplication()
	{
		System.out.println("RC : Logut From Application");
		logoutObj.click();
		return result;
	}
	
	public boolean closeApplication()
	{
		System.out.println("RC : Close Application");
		return result;
	}

}
