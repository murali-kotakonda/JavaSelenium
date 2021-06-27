package test4.group;

import org.testng.annotations.Test;

/**
How to define the test group?
@Test(groups = { "login" })
@Test(groups = { "login","register" })
*/
public class Test1 {

	@Test(groups = { "login" })
	public void loginSuccess() {
		System.out.println("login2");
	}
	
	@Test(groups = { "login" })
	public void loginFailure() {
		System.out.println("login1");
	}
	
	@Test(groups = { "register" })
	public void registerSuccess() {
		System.out.println("registerSuccess");

	}
	
	@Test(groups = { "register" })
	public void registerFail() {
		System.out.println("register Failure");
	}
	
	@Test(groups = { "changepwd" })
	public void changepwd() {
		System.out.println("changepwd success");
	}
	
	@Test(groups = { "login","updateProfile" })
	public void updateProfile() {
		System.out.println("updateProfile success");
		B b = new B();
		((A)b).equals("");
	}
	
}

 