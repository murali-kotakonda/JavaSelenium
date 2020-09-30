package test3.param;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test4 {

String appUrl ="";

	@Parameters("url")
	@BeforeMethod
	public void before(String url) {
		appUrl = url;
		System.out.println(url);
	}

	@Test
	@Parameters(value = { "userName", "password" })
	public void test1(String myName, String password) {
		System.out.println("test1 url value is : " + appUrl);
		System.out.println("test1 username value is : " + myName);
		System.out.println("test1 password  value is : " + password);
	}

}
