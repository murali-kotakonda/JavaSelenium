package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.Searchemploye;
import utility.BrowserFactory;
import utility.Headerutility;

public class Testserchemp {
	WebDriver driver;
	LoginPage login;
	Headerutility header;
	Searchemploye serch;
	
	public  Testserchemp() {
		driver=BrowserFactory.startApplication(driver,"Chrome");
		login=PageFactory.initElements(driver,LoginPage.class);
		serch=PageFactory.initElements(driver,Searchemploye.class);
		header=PageFactory.initElements(driver,Headerutility.class);
		
	}
	@BeforeMethod
	public void login() {
		login.loginToEmp("admin", "admin");
		header.serchemp();
		
	}
	@Test(priority=0)
	public void serchinavid() {
		serch.serchname("");
		serch.invalid();
		
	}
	@Test(priority=1)
	public void serch() {
		serch.serchname("venkatarao");
		serch.valid();
		//serch.delete();
	}
	@AfterMethod
	public void logout() {
		header.logout();
	}
	@AfterClass
	public void quit() {
		BrowserFactory.quitBrowser(driver);
	}
	
}
