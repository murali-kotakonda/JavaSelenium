package test0;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 How to write the logs to the report.
 use Reporter.log() function
 
 
 */
public class Ex15{ 
	 
	@BeforeMethod
	public void before() {
		Reporter.log("Application Lauched successfully | ");
	}

	@AfterMethod
	public void after() {
		Reporter.log("Application closed successfully | ");
	}
	
	
	@Test
	public void t1() {

		Reporter.log("Sign In Successful | ");

		Reporter.log("User is Logged out  ");
	}

	@Test
	public void t2() {

		Reporter.log("Sign In Successful | ");

		Reporter.log("Visited account update page | ");

		Reporter.log("chanaged password | ");

		Reporter.log("User is Logged out ");
	}
	
}
