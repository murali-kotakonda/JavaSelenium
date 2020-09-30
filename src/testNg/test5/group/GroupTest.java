package  test5.group;

import org.testng.annotations.Test;

public class GroupTest {

	@Test(groups = { "login" })
	public void loginSuccess() {
		System.out.println("login2");
	}

	@Test(groups = { "login" })
	public void loginFailure() {
		System.out.println("login1");
	}

	@Test(groups = { "register" })
	public void register1() {
		System.out.println("register1");

	}

	@Test(groups = { "register" })
	public void register2() {
		System.out.println("register2");
	}

	@Test(groups = { "login", "other" })
	public void loginx() {
		System.out.println("loginx");
	}
	
	@Test(groups = { "changepwd" })
	public void changepwd() {
		System.out.println("changepwd");
	}
}