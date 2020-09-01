package testNg1.test7.log;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestLog {

@Test
public void t1() {
	Reporter.log("Application Lauched successfully | ");

    Reporter.log("Sign In Successful | " );

    Reporter.log("User is Logged out and Application is closed | ");
	
}
}
