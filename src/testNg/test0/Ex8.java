package test0;

import org.testng.annotations.Test;
 
/**
 A test class :
- has some test methods has priority
- some test methods does not has priority

what is the order of execution?
solution?
1)1st preference is given to test method that does not have priority.
2)2nd  preference is given to test method that  has priority.

Explanation:
First preference: Non-prioritized methods:
Second preference: Prioritized methods

 */
public class Ex8 {
	
	@Test
	public void test3() {
		System.out.println("running test3");
	}
	
	@Test(priority = 2)
	public void test1() {
		System.out.println("running test1");
	}
	
	@Test(priority = 3)
	public void test2() {
		System.out.println("running test2");
	}
	
	@Test
	public void test0() {
		System.out.println("running test0");
	}
	
	@Test(priority = 1)
	public void abc() {
		System.out.println("running abc");
	}
}
