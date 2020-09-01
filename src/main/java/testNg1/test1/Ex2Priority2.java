package testNg1.test1;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

// login, add new emp, search by id, serach by emp , logout
public class Ex2Priority2 {

	@Test(priority = 1)
	public void T1() {
		System.out.println("T1");
	}

	@Test(priority = 0)
	public void T2() {
		System.out.println("t2");
	}

	@Test(priority = 5)
	public void T3() {
		System.out.println("t3");
	}

	@Test(priority = 6)
	public void c_method() {
		System.out.println("I'm in method C");
	}

	@Test(priority = 9)
	public void b_method() {
		System.out.println("I'm in method B");
	}

	@Test(priority = 6)
	public void a_method() {
		System.out.println("I'm in method A");
	}
}
