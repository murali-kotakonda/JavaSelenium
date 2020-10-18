package test1;

import org.testng.annotations.Test;

/**
How to skip the test case?
use @Test(enabled = false) before the test method
 */
public class Ex17Skip {

	@Test(enabled = false) 
	public void T1() {
		System.out.println("In T1");
	}

	@Test 
	public void T2() {
		System.out.println("In T2");
	}

	@Test 
	public void T3() {
		System.out.println("In T3");
	}
}