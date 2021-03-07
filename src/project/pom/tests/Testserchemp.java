package pom.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom.pages.LoginPage;
import pom.pages.Searchemploye;
import util.Commons;

public class Testserchemp extends Headerutility{
	LoginPage login;
	Headerutility header;
	Searchemploye serch;
	
	@BeforeTest
	public void start() {
		driver = Commons.startApplication(driver, "Chrome");
		login=PageFactory.initElements(driver,LoginPage.class);
		serch=PageFactory.initElements(driver,Searchemploye.class);
		header=PageFactory.initElements(driver,Headerutility.class);
	}
	
	@BeforeMethod
	public void login() {
		login.login("admin", "admin");
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
}
